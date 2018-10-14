package com.example.muhammadfaiq.ormlite_integration.Database;

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

public interface IUserDataSource
{

    Flowable<User> getUserById(int userId);
    Flowable<User> getUserByName(String userName);
    Flowable<List<User>> getAllUsers();

    void insertUser(User... users);

    void updateUser(User... users);

    void deleteUser(User user);

    void deleteAllUsers();
}
