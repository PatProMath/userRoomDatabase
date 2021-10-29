package com.example.userroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.userroomdatabase.entities.UserEntity;
import java.util.List;

@Dao
public interface UserDao {

    //define the possible methods for CRUD applications
    @Insert()
    public void addUser(UserEntity user);

    @Query("select id from user where id =:user_id")
    public int getUserId(int user_id);

    @Query("select * from user")
    public List<UserEntity> getUsers();

    @Update
    public void updateUser(UserEntity user);

    @Delete
    public void deleteUser(UserEntity user);

}
