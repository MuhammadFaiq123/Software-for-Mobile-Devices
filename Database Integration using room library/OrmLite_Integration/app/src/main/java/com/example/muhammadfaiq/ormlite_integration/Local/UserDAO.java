package com.example.muhammadfaiq.ormlite_integration.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.muhammadfaiq.ormlite_integration.Model.User;

import java.util.List;

import io.reactivex.Flowable;


/**
 * Created by Muhammad Faiq on 10/14/2018.
 */
@Dao
public interface UserDAO
{
    @Query("SELECT * FROM users WHERE id=:userId")
    Flowable<User> getUserById(int userId);

    @Query("SELECT * FROM users WHERE name=:userName")
    Flowable<User> getUserByName(String userName);

    @Query("SELECT * FROM users")
    Flowable<List<User>> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User users);

    @Query("DELETE FROM users")
    void deleteAllUsers();




}
