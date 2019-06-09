package ru.nbdev.popularlibs.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String surname;

    public int age;
}
