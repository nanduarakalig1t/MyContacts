package com.example.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mycontacts.adapters.RecyclerViewAdapter;
import com.example.mycontacts.data.DatabaseHandler;
import com.example.mycontacts.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private ListView listView;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvFrame);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        //ArrayList<Contact> arrayList = new ArrayList<Contact>();
        db.addContact(new Contact("Contact One","CTPHN1"));
        db.addContact(new Contact("Contact Two","CTPHN2"));
        db.addContact(new Contact("Contact Three","CTPHN3"));
        db.addContact(new Contact("Contact Four","CTPHN4"));
        db.addContact(new Contact("Contact Five","CTPHN5"));
        db.addContact(new Contact("Contact Six","CTPHN6"));
        db.addContact(new Contact("Contact Seven","CTPHN7"));
        db.addContact(new Contact("Contact Eight","CTPHN8"));
        db.addContact(new Contact("Contact Nine","CTPHN9"));
        db.addContact(new Contact("Contact Ten","CTPHN10"));
        db.addContact(new Contact("Contact Eleven","CTPHN11"));
        db.addContact(new Contact("Contact Twelve","CTPHN12"));

        contactList = db.getAllContacts();
        //for (Contact contact: contactList){
        //    Log.d("DBH", "Get all: " + contact.toString());
        //    contactList.add(contact);
        //}
        Log.d("DBH", "Get total count: " + db.getTableCount());

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactList);
        recyclerView.setAdapter(recyclerViewAdapter);
        //listView = findViewById(R.id.lvContacts);


        //Contact firstContact = new Contact();
        //firstContact.setContactName("Contact One");
        //firstContact.setContactPhoneNumber("CTPN1");

        //db.addContact(firstContact);

        //Contact secondContact = new Contact();
        //secondContact.setContactID(2);
        //secondContact.setContactName("Contact Two");
        //secondContact.setContactPhoneNumber("CTPN2");

        //db.addContact(secondContact);
        //db.addContact(new Contact("Contact One","CTPHN1"));
        //db.addContact(new Contact("Contact Two","CTPHN2"));
        //db.addContact(new Contact("Contact Three","CTPHN3"));
        //db.addContact(new Contact("Contact Four","CTPHN4"));
        //db.addContact(new Contact("Contact Five","CTPHN5"));
        //db.addContact(new Contact("Contact Six","CTPHN6"));
        //db.addContact(new Contact("Contact Seven","CTPHN7"));
        //db.addContact(new Contact("Contact Eight","CTPHN8"));
        //db.addContact(new Contact("Contact Nine","CTPHN9"));
        //db.addContact(new Contact("Contact Ten","CTPHN10"));
        //db.addContact(new Contact("Contact Eleven","CTPHN11"));
        //db.addContact(new Contact("Contact Twelve","CTPHN12"));

        //int i = db.updateContact(secondContact);
        //Log.d("DBH", "Get by ID RC: " + i);

        //db.deleteContactbyID(secondContact);



        //arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,contactList);
        //listView.setAdapter(arrayAdapter);
    }


}