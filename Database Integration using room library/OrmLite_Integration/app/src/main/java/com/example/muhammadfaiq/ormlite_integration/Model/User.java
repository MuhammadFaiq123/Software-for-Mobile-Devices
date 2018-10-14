package com.example.muhammadfaiq.ormlite_integration.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

/**
 * Created by Muhammad Faiq on 10/14/2018.
 */

@Entity(tableName = "users")
public class User
{
    public User() {

    }

    @NonNull
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name ="id")
  private int id;

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "Password")
  private String Password;

    @Ignore
    public User(String name, String Password)
    {
        this.name = name;
        this.Password = Password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return new StringBuilder(name).append("\n").append(Password).toString();

    }
}
