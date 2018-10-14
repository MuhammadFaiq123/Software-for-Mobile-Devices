package com.example.muhammadfaiq.ormlite_integration.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.muhammadfaiq.ormlite_integration.Model.User;

import static com.example.muhammadfaiq.ormlite_integration.Local.UserDatabase.DATABASE_VERSION;

/**
 * Created by Muhammad Faiq on 10/14/2018.
 */

@Database(entities = User.class, version = DATABASE_VERSION)
public abstract class UserDatabase extends RoomDatabase
{
    public static final int DATABASE_VERSION=2;
    public static final String DATABASE_NAME = "EDMT-Database-Room";

    public abstract UserDAO userDAO();
    private static UserDatabase mInstance;

    public static UserDatabase getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = Room.databaseBuilder(context,UserDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }


}
