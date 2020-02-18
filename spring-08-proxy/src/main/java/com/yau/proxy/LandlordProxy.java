package com.yau.proxy;

public class LandlordProxy implements Rent {
    private Landlord landlord;

    public LandlordProxy() {
    }

    public LandlordProxy(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public void rent() {
        landlord.rent();
    }
}
