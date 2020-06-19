package com.example.mycontacts.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mycontacts.model.Contact;
import com.example.mycontacts.util.Util;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY, "
                + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
        Log.d("DBH", "onCreate: DB Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS";
        db.execSQL(DROP_TABLE, new String[]{Util.TABLE_NAME});
        Log.d("DBH", "onUpgrade");
        onCreate(db);
    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getContactName());
        values.put(Util.KEY_PHONE, contact.getContactPhoneNumber());

        db.insert(Util.TABLE_NAME,null,values);
        db.close();
        Log.d("DBH", "addContact");

    }

    public Contact getContactByID(int id) {
        Contact contact = new Contact();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            contact.setContactID(Integer.parseInt(cursor.getString(0)));
            contact.setContactName(cursor.getString(1));
            contact.setContactPhoneNumber((cursor.getString(2)));
            Log.d("DBH", "getContactByID: " + contact.toString());
        }
        return contact;
    }

    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);
        if (cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setContactID(Integer.parseInt(cursor.getString(0)));
                contact.setContactName(cursor.getString(1));
                contact.setContactPhoneNumber((cursor.getString(2)));
                contactArrayList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactArrayList;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase()  ;

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getContactName());
        values.put(Util.KEY_PHONE, contact.getContactPhoneNumber());

        return db.update(Util.TABLE_NAME,values,Util.KEY_ID + "=?", new String[]{String.valueOf(contact.getContactID())});
    }

    public void deleteContactbyID(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase()  ;
        db.delete(Util.TABLE_NAME,Util.KEY_ID + "=?", new String[]{String.valueOf(contact.getContactID())});
        db.close();
    }

    public int getTableCount(){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll,null);

        return cursor.getCount();

    }
}
