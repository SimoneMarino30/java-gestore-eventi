package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
    //VARIABLES

    // ATTRIBUTES
    private String title;
    private LocalDate date;
    private int total_seats;
    protected int bookedSeats;

    // CONSTRUCTOR
    public Event(String title, LocalDate date, int total_seats) throws IllegalArgumentException{

        validateTitle(title);

        validateDate(date);

        if(total_seats <= 0) {
            throw new IllegalArgumentException("Seats must be a positive number different to 0");
        }
        // Se tutto va a buon fine, istanzio il mio evento
        this.title = title;
        this.date = date;
        this.total_seats = total_seats;
        this.bookedSeats = 0;
    }

    // GETTERS & SETTERS

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    // date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
       validateDate(date);
       this.date = date;

    }

    // totalSeats
    public int getTotalSeats() {
        return total_seats;
    }

    // bookedSeats
    public int getBookedSeats() {
        return bookedSeats;
    }

    // metodo che mi permette di tenere traccia dei posti disponibili, sempre aggiornata e in ogni parte del codice (public)
    public int getSeatsStillAvailable() {
        return total_seats - bookedSeats;
    }
    // Metodo per formattare la data in formato ITA
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.date.format(formatter);
    }

    // METHODS

    public void addReservation() throws RuntimeException{ // metodo public per poter interagire dall' esterno, void per modificare lo stato interno della mia classe

        // Controlla che l'evento non sia gia passato
        if (this.date.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot add reservation. The event has already been performed.");
        }
        // Controlla se ci sono posti disponibili
        if (getSeatsStillAvailable() == 0)   {
            throw new RuntimeException("Sorry, there are no available seats at the moment");
        }
        // Aggiunge una prenotazione
        bookedSeats++;
    }

    public void cancelReservation() throws RuntimeException{
        // Controlla che l'evento non sia gia passato
        if (this.date.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot add reservation. The event has already been performed.");
        }
        // Controlla se ci sono prenotazioni attive
        if (getSeatsStillAvailable() > 0)   {
            throw new RuntimeException("You have't book any seat yet");
        }
        // Cancella prenotazione
        bookedSeats--;
    }

    // VALIDATE METHODS
    private void validateTitle(String t) throws IllegalArgumentException{ // t è il title che mi arriva dall' esterno ma il metodo vale anche nel costruttore
        if(t == null || t.isBlank()){
            throw new IllegalArgumentException("Invalid title. Please insert a valid string");
        }
    }

    private void validateDate(LocalDate d) throws IllegalArgumentException{
        if (d == null || d.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date. The event date must be after today's date.");
        }
    }
    // OVERRIDE TO STRING
    @Override
    public String toString() {
        return  getFormattedDate() + getTitle();
    }
}
