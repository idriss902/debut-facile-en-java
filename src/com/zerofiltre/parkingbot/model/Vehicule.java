package com.zerofiltre.parkingbot.model;

public class Vehicule {
    private String registrationNumber; //numero de la plaque d'immatriculation
    private String category; //categorie du vehicule (camion,voiture,etc..)

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
