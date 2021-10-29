package com.example.userroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.example.userroomdatabase.database.UserDatabase;

public class MainActivity extends AppCompatActivity {
    // get a reference to the FragmentManager
    public static FragmentManager fragmentManager;

    //create a static reference to the database class created
    public static UserDatabase userDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an object of the database in memory using Room.databaseBuilder(context, databaseName.class,databaseName).build();
        fragmentManager = getSupportFragmentManager();
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "userdb").allowMainThreadQueries().build();

        //instantiate the fragment Manager

        if (savedInstanceState != null) {
            return;
        }

        // set the  default view for the MainActivity to the Home Fragment
        fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();

    }
}