package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.userroomdatabase.entities.UserEntity;

public class DeleteUserFragment extends Fragment {
    Button delBtn;
    EditText idEditText;


    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        delBtn = view.findViewById(R.id.btn_delete);
        idEditText = view.findViewById(R.id.userid);
//        name = view.findViewById(R.id.username);
//        email = view.findViewById(R.id.useremail);

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_id = idEditText.getText().toString();
                if (!TextUtils.isEmpty(string_id)) {  //TextUtils is a class
                    int id = Integer.parseInt(string_id);
                    int findId = MainActivity.userDatabase.userDao().getUserId(id); // If the data is not there, it will give a negative value!
                    if (findId == id) {
                        UserEntity user = new UserEntity();
                        user.setId(id);
                        MainActivity.userDatabase.userDao().deleteUser(user);
                        Toast.makeText(getContext(), "User with ID "+id+" deleted successfully!", Toast.LENGTH_LONG).show();
                        idEditText.setText("");
                    } else {
                        Toast.makeText(getContext(), "User not found!", Toast.LENGTH_SHORT).show();
                    }
                } else  {
                    Toast.makeText(getContext(), "Enter an ID for the user you want to delete.",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}  