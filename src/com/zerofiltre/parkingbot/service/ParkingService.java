package com.zerofiltre.parkingbot.service;

import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicle;
import com.zerofiltre.parkingbot.model.VehicleModelEnum;

import java.util.Date;

public class ParkingService {

  public Ticket processIncomingVehicle(Vehicle vehicle) {
    Ticket ticket = new Ticket();
    Date now = new Date();
    ticket.setEnteringTime(now);
    ticket.setVehicle(vehicle);
    return ticket;
  }
  /*
  * methode permettant de retourne un ticket a la sortie du parking
  * */
  public Ticket processExistingVehicule(Ticket ticket){
    long now = new Date().getTime();  //nombre de milliseconde
    now += 60 * 60 * 1000;  //pour convertir now en heure

    //mettre a jour la date de sortie du parking
    Date exitTime = new Date(now);
    ticket.setExitTime(exitTime);

    //recuperation des infos du vehicule concernant un ticket et sa categorie
    Vehicle vehicle = ticket.getVehicle();
    VehicleModelEnum category = vehicle.getCategory();

    //definir les taux du parking
    // prix par minute pour les voiture de type citadine
    double pricePerMinForCitadine = 0.08;
    double pricePerMinFor2Roues = 0.02;
    double defaultPricePerMin = 0.05;

    //declare le delai mis en minutes dans le parking et on utilise getTime pour des valeurs en millisecondes
    long durationInMinutes = (ticket.getExitTime().getTime() - ticket.getEnteringTime().getTime()) / (60 * 1000);
    double finalPrice =0;

//    if (category.equals("CITADINE")){
//      finalPrice = durationInMinutes * pricePerMinForCitadine;
//    } else if (category.equals("2 ROUES")) {
//      finalPrice = durationInMinutes * pricePerMinFor2Roues;
//    }else {
//      finalPrice = durationInMinutes * defaultPricePerMin;
//    }
    switch (category){
      case CITADINE:
        finalPrice = durationInMinutes * pricePerMinForCitadine;
        break;
      case DEUXROUES:
        finalPrice = durationInMinutes * pricePerMinFor2Roues;
      default:
        finalPrice = durationInMinutes * defaultPricePerMin;

    }
    ticket.setAmount(finalPrice);
    return ticket;
  }


}
