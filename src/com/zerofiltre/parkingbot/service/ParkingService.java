package com.zerofiltre.parkingbot.service;

import com.zerofiltre.parkingbot.model.Parking;
import com.zerofiltre.parkingbot.model.ParkingTypeEnum;
import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicle;

import java.security.SecureRandom;
import java.util.Date;

public class ParkingService {

    public Ticket processIncomingVehicle(Vehicle vehicle) {
        Ticket ticket = new Ticket();
        Date now = new Date();
        ticket.setEnteringTime(now);
        ticket.setVehicle(vehicle);
        return ticket;
    }

    public Ticket processExitingVehicle(Ticket ticket) {
        long now = new Date().getTime();
        now += 60 * 60 * 1000;

        Date exitTime = new Date(now);
        ticket.setExitTime(exitTime);

        Vehicle vehicle = ticket.getVehicle();
        String category = vehicle.getCategory();

        double pricePerMinForCitadine = 0.08;
        double pricePerMinFor2Roues = 0.02;
        double defaultPricePerMin = 0.05;
        long durationInMinutes = (ticket.getExitTime().getTime() - ticket.getEnteringTime().getTime()) / (60 * 1000);

        double finalPrice = 0;

        if ("CITADINE".equals(category)) {
            finalPrice = durationInMinutes * pricePerMinForCitadine;
        } else if ("2 ROUES".equals(category)) {
            finalPrice = durationInMinutes * pricePerMinFor2Roues;
        } else {
            finalPrice = durationInMinutes * defaultPricePerMin;
        }
        ticket.setAmount(finalPrice);

        return ticket;

    }

    public Parking initPacking() {
        //initialisation du parking Building
        Parking building = new Parking();
        building.setType(ParkingTypeEnum.BUILDING); //defini le type d'enumeration
        building.setNumber(1);

        //initialisation des parking de type FLOOR(etages) et creation de 50 etages
        for (int i = 0; i < 50; i++) {
            Parking floor = new Parking(); //initialise l'etage dans un building
            floor.setType(ParkingTypeEnum.FLOW);
            floor.setNumber(i);
            //initialisation des parking de type HALL(salles) et creation de 30 salles de parking
            for (int j = 0; j < 30; j++) {
                Parking hall = new Parking(); //initialise l'etage dans un building
                hall.setType(ParkingTypeEnum.HALL);
                hall.setNumber(j);
                floor.getSubParkings().add(hall);
                //initialisation des parking de type SPOT(places de stationnement) et creation de 20 places de stationnement
                for (int k = 0; k < 20; k++) {
                    Parking spot = new Parking(); //initialise l'etage dans un building
                    spot.setType(ParkingTypeEnum.SPOT);
                    spot.setNumber(k);
                    //il faudrait creer des vehicules au niveau des places de stationnemnt
                    Vehicle vehicle = new Vehicle();
                    //generation d'un numero d'immatriculation
                    vehicle.setRegistrationNumber(String.valueOf(new SecureRandom().nextInt(10000))); //jusqu'au nombre inferieur a 10000
                    //generer un un numero de place de stationnement a partir de l'immeuble 1, floor, hall et spot
                    vehicle.setParkingSpotNumber("1- " + i + " - " + j + " - " + k);
                    //ajouter les vehicules aux places de stationnment
                    spot.setVehicle(vehicle);
                    hall.getSubParkings().add(spot);
                }
            }
            building.getSubParkings().add(floor);
        }


        return building;
    }


}
