package com.zerofiltre.parkingbot;

public class ParkingBot {

    /**
     * ceci est la fonction principale d'un programme java
     * @param args Represente les donneees passees comme parametre lors de l'execution d'un programme
     */
    public static void main(String[] args) {

        sayHello(args);
    }

    /**
     * Permet d'acceuillir et de presenter les services a l'utilisateur potentiel du parking
     * @param args Represente le nom de l'utilisateur potentiel
     *
     */
    private static void sayHello(String[] args) {
        String welcomeMessage = "Hello " + args[0] + ", bienvenue au Parking Zerofiltre";
        String services = "Nous offrons les services suivants: Gardinage, laverie ..";
        String warning = "Dépéchez-vous d'entrer car il n'y aura bientot plus de places";

        System.out.println(welcomeMessage);
        System.out.println(services);
        System.out.println(warning.toUpperCase());
    }
}
