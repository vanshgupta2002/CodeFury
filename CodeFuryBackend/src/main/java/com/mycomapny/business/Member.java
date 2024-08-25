package com.mycomapny.business;

public class Member extends User {
    public Member(String name, String email, String phone) {
        super(name, email, phone, UserRole.MEMBER);
    }
}
