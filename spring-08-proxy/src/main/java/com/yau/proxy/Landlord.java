package com.yau.proxy;

public class Landlord implements Rent{

    @Override
    public void rent() {
        System.out.println("Landlord wanna loan his house.");
    }
}
