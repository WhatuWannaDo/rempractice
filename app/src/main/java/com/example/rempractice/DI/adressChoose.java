package com.example.rempractice.DI;

import com.example.rempractice.project.Repos.Network.AddressAnalysis;

public class adressChoose {
    private static adressChoose instance = null;

    private adressChoose() {};

    public static adressChoose getInstance() {
        if (instance == null) {
            instance = new adressChoose();
        }
        return instance;
    }

    private AddressAnalysis mAnalysis;

    public AddressAnalysis getAnalysis() {
        if (mAnalysis == null) {
            mAnalysis = new AddressAnalysis();
        }
        return mAnalysis;
    }

}
