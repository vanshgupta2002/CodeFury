package com.mycomapny.business;

public class Admin extends User {
    public Admin(String name, String email, String phone) {
        super(name, email, phone, UserRole.ADMIN);
    }
}
