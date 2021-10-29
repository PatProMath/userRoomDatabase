package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userroomdatabase.entities.UserEntity;


public class UpdateUserFragment extends Fragment {
    Button button;
    EditText user_id, user_name, user_email;


    public UpdateUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update_user, container, false);

        button = view.findViewById(R.id.btn_update);
        user_id = view.findViewById(R.id.userID);
        user_name = view.findViewById(R.id.userNAME);
        user_email = view.findViewById(R.id.userEMAIL);
        button.setEnabled(false);

        user_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                button.setEnabled(true);
                String string_id = user_id.getText().toString();
                int id = Integer.parseInt(string_id);
                int ID = MainActivity.userDatabase.userDao().getUserId(id);
                UserEntity user = new UserEntity();
                user.setId(ID);
                user_name.setText(user.getName());
                user_email.setText(user.getEmail());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(user_id.getText().toString());
                String userName = user_name.getText().toString();
                String userEmail = user_email.getText().toString();
                UserEntity user = new UserEntity(id,userName,userEmail);
                MainActivity.userDatabase.userDao().updateUser(user);
                Toast.makeText(getContext(),"User added successfully", Toast.LENGTH_LONG).show();
                user_id.setText("");
                user_name.setText("");
                user_email.setText("");
            }
        });
        return view;
    }
}