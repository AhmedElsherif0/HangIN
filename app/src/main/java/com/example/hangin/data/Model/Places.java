package com.example.hangin.data.Model;


public class Places {

    private String Address;

    private String Name;

    private String WorkShop;


    public Places() {
    }

    public Places(String address, String name, String workshop) {
        Address = address;
        Name = name;
        WorkShop = workshop;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWorkShop() {
        return WorkShop;
    }

    public void setWorkShop(String workShop) {
        WorkShop = workShop;
    }

}
