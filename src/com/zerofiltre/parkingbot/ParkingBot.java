package com.zerofiltre.parkingbot;

import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicule;
import com.zerofiltre.parkingbot.service.ParkingService;

public class ParkingBot {


  /**
   * Ceci est la méthode Main
   *
   * @param args : Tableau de données entrées lors du lancement de l'application
   */
  public static void main(String[] args) {
    processVehicules();

  }

  private static void processVehicules() {
    Vehicule vehicule = new Vehicule();
    vehicule.setRegistrationNumber("v0001");
    vehicule.setCategory("voiture");

    ParkingService parkingService = new ParkingService();
    Ticket ticket =parkingService.processIncommingVehicule(vehicule);
    System.out.print("votre ticket est " + ticket);
  }


}
