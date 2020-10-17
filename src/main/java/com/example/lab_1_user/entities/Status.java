package com.example.lab_1_user.entities;

public class Status {
    private int availableThreads;

    public Status(int availableThreads) {
        this.availableThreads = availableThreads;
    }

    public int getAvailableThreads() {
        return availableThreads;
    }

    public void setAvailableThreads(int availableThreads) {
        this.availableThreads = availableThreads;
    }
}
