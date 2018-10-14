package com.example.muhammadfaiq.ormlite_integration.Database;

import com.example.muhammadfaiq.ormlite_integration.Model.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Muhammad Faiq on 10/14/2018.
 */

public class UserRepository implements IUserDataSource {

    private IUserDataSource mLocalDatabaseSource;
    private static UserRepository mInstance;


    public UserRepository(IUserDataSource mLocalDatabaseSource)
    {
        this.mLocalDatabaseSource = mLocalDatabaseSource;
    }

    public static UserRepository getInstance(IUserDataSource mLocalDatabaseSource)
    {
        if (mInstance == null)
        {
            mInstance = new UserRepository(mLocalDatabaseSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<User> getUserById(int userId) {
        return mLocalDatabaseSource.getUserById(userId);
    }

    @Override
    public Flowable<User> getUserByName(String userName) {
        return mLocalDatabaseSource.getUserByName(userName);
    }

    @Override
    public Flowable<List<User>> getAllUsers() {
        return mLocalDatabaseSource.getAllUsers();
    }

    @Override
    public void insertUser(User... users) {
       mLocalDatabaseSource.insertUser(users);
    }

    @Override
    public void updateUser(User... users) {
      mLocalDatabaseSource.updateUser(users);
    }

    @Override
    public void deleteUser(User user) {
        mLocalDatabaseSource.deleteUser(user);
    }

    @Override
    public void deleteAllUsers() {
     mLocalDatabaseSource.deleteAllUsers();
    }
}
