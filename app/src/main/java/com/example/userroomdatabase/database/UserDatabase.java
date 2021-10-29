package com.example.userroomdatabase.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.userroomdatabase.dao.UserDao;
import com.example.userroomdatabase.entities.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {



    // declare an abstract method for the dao call
    public abstract UserDao userDao();

}

