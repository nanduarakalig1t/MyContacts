package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mycontacts.data.DatabaseHandler;
import com.example.mycontacts.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        ArrayList<Contact> arrayList = new ArrayList<Contact>();


        Contact firstContact = new Contact();
        firstContact.setContactName("Contact One");
        firstContact.setContactPhoneNumber("CTPN1");

        //db.addContact(firstContact);

        Contact secondContact = new Contact();
        secondContact.setContactID(2);
        secondContact.setContactName("Contact Two");
        secondContact.setContactPhoneNumber("CTPN2");


        //int i = db.updateContact(secondContact);
        //Log.d("DBH", "Get by ID RC: " + i);

        //db.deleteContactbyID(secondContact);


        arrayList = db.getAllContacts();
        for (Contact contact: arrayList){
            Log.d("DBH", "Get all: " + contact.toString());
        }
        Log.d("DBH", "Get total count: " + db.getTableCount());
    }


}