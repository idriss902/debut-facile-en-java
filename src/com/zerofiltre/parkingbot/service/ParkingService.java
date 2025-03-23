package com.zerofiltre.parkingbot.service;

import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicule;

import java.util.Date;

/*
traiter l'entre d'un vehicule
 */
public class ParkingService {

    public Ticket processIncommingVehicule(Vehicule vehicule){
        Ticket ticket = new Ticket();
        Date now = new Date(); //date courante ou actuelle
        ticket.setEnteringTime(now);
        ticket.setVehicule(vehicule);

        return ticket;
    }
}
