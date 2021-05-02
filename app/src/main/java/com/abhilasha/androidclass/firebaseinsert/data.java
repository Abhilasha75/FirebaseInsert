package com.abhilasha.androidclass.firebaseinsert;

public class data {

    String name,email,phn,password;

    public data(String name, String email, String phn, String password) {
        this.name = name;
        this.email = email;
        this.phn = phn;
        this.password = password;
    }

    public data() {
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

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
