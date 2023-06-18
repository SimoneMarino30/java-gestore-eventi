package org.lessons.java.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Scanner per richiesta all' utente
        Scanner scan = new Scanner(System.in);

        // inserisci titolo
        System.out.println("Which event would you like to attend?");
        String myTitle = scan.nextLine();

        LocalDate myDate = null;
        do {
            // inserisci la data
            System.out.println("When is the event? (Please, use yyyy-MM-dd format): ");
            String dateString = scan.nextLine();
            try {
                myDate = LocalDate.parse(dateString);
            } catch (Exception e) {
                System.out.println("Invalid date format");;
            }
        } while (myDate == null);

        // chiedo quanti posti ha l'evento
        System.out.println("How many seats does the event has? ");
        int mySeats = Integer.parseInt(scan.nextLine());
        // Creazione evento
        Event myEvent = null;
        try {
            // Creo l'evento
            myEvent = new Event(myTitle, myDate, mySeats);
            // Stampo l' evento
            System.out.println("YOUR EVENT: " + myEvent.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong, unable to create an event");
            System.out.println(e.getMessage());;
        }

        scan.close();


        /*do {
            // inserisci titolo
            System.out.println("Which event would you like to attend?");

            try {
                myTitle = scan.nextLine();
            } catch (IllegalArgumentException e) {
                //messaggio che punta alla gestione dell'exception in setTitle
                System.out.println("Invalid input: " + e.getMessage());
            }

            // inserisci la data
            System.out.println("When is the event? (Please, use yyyy-MM-dd format): ");
            LocalDate myDate = null;
            try {
                myDate = LocalDate.parse(scan.next());
            } catch (Exception e) {
                //messaggio che punta alla gestione dell'exception in setDate
                System.out.println("Invalid input: " + e.getMessage());
            }

            // consuma lo spazio lasciato da nextInt che impedisce di richiedere il TITLE in caso di eccezione
            scan.nextLine();

            try {
                myEvent = new Event(myTitle, myDate, 10);
                isValid = true;
            } catch(IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        } while (!isValid);



        // stampo il mio evento
        System.out.println(myEvent);
        System.out.println("Total seats available: " + myEvent.getTotalSeats());



        isValid = false;

        // inserisci posti da prenotare
         do {
            System.out.println("How many seats would you like to reserve? ");
            addedSeats = Integer.parseInt(scan.nextLine());

            try {
                for (int i = 1; i < addedSeats+1; i++) {
                    myEvent.addReservation(addedSeats);
                    // System.out.println("Seeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    isValid = true;
                }
                isValid = true;
            } catch (IllegalStateException e) {
                System.out.println("Invalid input for total seats: " + e.getMessage());
            }
        }while (!isValid);

        System.out.println("You've booked  " + addedSeats + " seats");
        System.out.println("There are " + myEvent.getAvailableSeats() + " seats still available");

        isValid = false;
        // disdici posti prenotati
        do {
            System.out.println("How many seats would you like to cancel? ");
            subtractedSeats = Integer.parseInt(scan.nextLine());

            try {
                for (int i = 0; i < subtractedSeats; i++) {
                    myEvent.cancelReservation(subtractedSeats);
                    // System.out.println("Yeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                }
                isValid = true;
            } catch (IllegalStateException e) {
                System.out.println("Invalid input for total seats: " + e.getMessage());
            }
        }while (!isValid);

        System.out.println("You've cancelled  " + subtractedSeats + " seats");
        System.out.println("There are " + myEvent.getAvailableSeats() + " seats still available");
        System.out.println(myEvent);
        scan.close();*/
    }
}
