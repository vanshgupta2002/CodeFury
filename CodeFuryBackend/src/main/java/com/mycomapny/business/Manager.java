package com.mycomapny.business;

import com.mycomapny.exceptions.InsufficientCreditsException;

public class Manager extends User {
    private int credits;

    public Manager(String name, String email, String phone) {
        super(name, email, phone, UserRole.MANAGER);
        this.credits = 2000; // initial credits for managers
    }

    public int getCredits() {
        return credits;
    }

    public void deductCredits(int cost) throws InsufficientCreditsException {
        if (cost > credits) {
            throw new InsufficientCreditsException("Not enough credits to book the room.");
        }
        credits -= cost;
    }

    public void resetCredits() {
        credits = 2000; // reset credits
    }
}