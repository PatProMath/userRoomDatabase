package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userroomdatabase.entities.UserEntity;


public class AddUserFragment extends Fragment {

    // create references to all the views in the fragment
        Button button;
        EditText user_id, user_name, user_email;

    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        // get ids for all the views in this layout
        button = view.findViewById(R.id.btn_update);
        user_id = view.findViewById(R.id.userID);
        user_name = view.findViewById(R.id.userNAME);
        user_email = view.findViewById(R.id.userEMAIL);

        // create an click event listener on the Button object
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // collect data from the edit text fields
                int id = Integer.parseInt(user_id.getText().toString());
                String userName = user_name.getText().toString();
                String email = user_email.getText().toString();

                // create an object of the UserEntity class
                UserEntity user = new UserEntity(id,userName,email);

                //insert the user object into the Room database using the userDao method in the database class object created
                // in the MainActivity
                MainActivity.userDatabase.userDao().addUser(user);
                // create a Toast that informs us that user has been inserted
                // then clear all the fields
                Toast.makeText(getContext(),"User added successfully", Toast.LENGTH_LONG).show();
                user_id.setText("");
                user_name.setText("");
                user_email.setText("");
            }
        });
        return  view;
    }
}