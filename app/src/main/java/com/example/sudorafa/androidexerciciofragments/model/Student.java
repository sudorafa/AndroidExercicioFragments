package com.example.sudorafa.androidexerciciofragments.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by sudorafa on 07/11/17.
 */

@Parcel
public class Student {

    String name;
    String email;
    String phone;

    @ParcelConstructor
    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Student(){

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name;
    }
}
