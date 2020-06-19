package com.example.mycontacts.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontacts.R;
import com.example.mycontacts.model.Contact;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Contact> contactList;

    public RecyclerViewAdapter(Context context, ArrayList<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactrow, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.name.setText(contact.getContactName());
        holder.phone.setText(contact.getContactPhoneNumber());
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView name;
        public TextView phone;
        public ImageView callButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.tvName);
            phone = itemView.findViewById(R.id.tvPhone);
            callButton = itemView.findViewById(R.id.callButton);

            callButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Contact contact = contactList.get(position);
            Log.d("CLICK", "onClick: " + contact.getContactName());
            Intent intent = new Intent(context, DetailDisplay.class);
            intent.putExtra("name", contact.getContactName());
            intent.putExtra("phone", contact.getContactPhoneNumber());

            context.startActivity(intent);
        }
    }

}
