package com.recipeapp.recipeapp.models;

import java.util.ArrayList;

public class WinePairing {
    ArrayList<String> pairedWines;
    private String pairingText;
    ArrayList<ProductMatch> productMatches = new ArrayList<>();


    // Getter Methods

    public String getPairingText() {
        return pairingText;
    }

    // Setter Methods

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }
}
