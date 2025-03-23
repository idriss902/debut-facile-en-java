package com.zerofiltre.parkingbot.model;

import java.util.Date;

public class Ticket {
    private String amount;
    private Vehicule vehicule;
    private Date enteringTime; //temps d'entré du vehicule dans le parking
    private Date exitTime; //temps de sortie du vehicule dans le parking

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getEnteringTime() {
        return enteringTime;
    }

    public void setEnteringTime(Date enteringTime) {
        this.enteringTime = enteringTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "amount='" + amount + '\'' +
                ", vehicule=" + vehicule +
                ", enteringTime=" + enteringTime +
                ", exitTime=" + exitTime +
                '}';
    }
}
