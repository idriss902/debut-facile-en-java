package com.zerofiltre.parkingbot;

import com.zerofiltre.parkingbot.model.Bicycle;
import com.zerofiltre.parkingbot.model.Car;
import com.zerofiltre.parkingbot.model.Ticket;
import com.zerofiltre.parkingbot.model.Vehicle;
import com.zerofiltre.parkingbot.service.ParkingService;

import java.util.*;

public class ParkingBot {

  static ParkingService parkingService = new ParkingService();

  /**
   * Ceci est la méthode Main
   *
   * @param args : Tableau de données entrées lors du lancement de l'application
   */
  public static void main(String[] args) {
    processVehicles();
  }

  private static void processVehicles() {

    Vehicle vehicle = new Vehicle();
    vehicle.setRegistrationNumber("LS-324-PM");
    Ticket vehicleTicket = parkingService.processIncomingVehicle(vehicle);
    System.out.println(vehicleTicket);

    Vehicle bicycle = new Bicycle();
    bicycle.setRegistrationNumber("PM-254-OP");
    Ticket bicycleTicket = parkingService.processIncomingVehicle(bicycle);
    System.out.println(bicycleTicket);

    Vehicle car = new Car();
    bicycle.setRegistrationNumber("BX-256-QX");
    Ticket carTicket = parkingService.processIncomingVehicle(car);
    System.out.println(carTicket);

    //tableaux
//    Ticket[] tickets = new Ticket[3];
//    tickets[0] = vehicleTicket;
//    tickets[1] = bicycleTicket;
//    tickets[2] = carTicket;
    //listes ordonnees
//    List<Ticket> tickets = new ArrayList<Ticket>();
//    tickets.add(vehicleTicket);
//    tickets.add(bicycleTicket);
//    tickets.add(carTicket);
//    listes non ordonnees
    Set<Ticket> tickets = new HashSet<Ticket>();
    tickets.add(vehicleTicket);
    tickets.add(bicycleTicket);
    tickets.add(carTicket);

    //dictionnaires(Map)
    Map<Integer,Ticket> exitOrder = new HashMap<>();



    System.out.println("Traitement de sortie par lot");
    int position = 0;
    for(Ticket ticket: tickets){
      exitOrder.put(position,ticket);
      position++;
      System.out.println(parkingService.processExitingVehicle(ticket));
    }

    Set<Integer> keySet = exitOrder.keySet();

    for(int key: keySet){
      System.out.println("Position dans la liste: " +key+ ":"+ exitOrder.get(key).getVehicle().getCategory());
    }
//    for(Ticket ticket: tickets){
//      System.out.println(parkingService.processExitingVehicle(ticket));
//    }

    /*for (int i = 0; i < myList.size(); i++) {
      System.out.println(parkingService.processExitingVehicle(myList.get(i)));
    }*/
  }


}
