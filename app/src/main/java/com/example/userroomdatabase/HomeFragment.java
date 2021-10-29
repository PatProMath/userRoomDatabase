package com.example.userroomdatabase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener{
    Button add_user, query_users, edit_user, delete_user;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        // get the reference to the add_user btn_update
        add_user = view.findViewById(R.id.btn_add_user);
        query_users = view.findViewById(R.id.btn_view_users);
        edit_user = view.findViewById(R.id.btn_edit_user);
        delete_user = view.findViewById(R.id.btn_delete_user);

        // register each btn_update to listen to click even that may occur on them in this view

        add_user.setOnClickListener(this);
        query_users.setOnClickListener(this);
        edit_user.setOnClickListener(this);
        delete_user.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View view) {

        //if btn_update is clicked action is performed according to the switch method
        switch (view.getId())  {
            case R.id.btn_add_user:
                // start the fragment manager that is in the MainActivity in order to replace the fragment
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUsersFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_edit_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateUserFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment()).addToBackStack(null).commit();
                break;
        }
    }
}