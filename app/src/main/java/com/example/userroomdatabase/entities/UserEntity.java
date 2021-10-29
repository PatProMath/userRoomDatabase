package com.example.userroomdatabase.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name="user_email")
    private String email;

    // create the constructor
    public UserEntity(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //  Empty Constructor
    public UserEntity() {
    }

    // create the getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

