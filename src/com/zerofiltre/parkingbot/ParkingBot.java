package com.zerofiltre.parkingbot;


import com.zerofiltre.parkingbot.model.Parking;
import com.zerofiltre.parkingbot.model.ParkingTypeEnum;
import com.zerofiltre.parkingbot.model.Vehicle;
import com.zerofiltre.parkingbot.service.ParkingService;

import java.util.List;

public class ParkingBot {

    static ParkingService parkingService = new ParkingService();

    /**
     * Ceci est la méthode Main
     *
     * @param args : Tableau de données entrées lors du lancement de l'application
     */
    public static void main(String[] args) {
        Parking parking = parkingService.initPacking();
        listCars(parking);
    }

    static void listCars(Parking parking) {

        if (ParkingTypeEnum.SPOT.equals(parking.getType())) {
            Vehicle vehicle = parking.getVehicle();
            System.out.println("Vehicule d'immatriculation "
                    + vehicle.getRegistrationNumber()
                    + " situer a la place " + vehicle.getParkingSpotNumber());
        } else {
            List<Parking> subParkings = parking.getSubParkings();

            for (Parking subParking : subParkings) {
                listCars(subParking);
            }
        }

    }


}
