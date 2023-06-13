package org.lessons.java.eventi;

import java.time.LocalDate;

public class Event {
    //VARIABLES

    // ATTRIBUTES
    private String title;
    private LocalDate date;
    protected final int TOTAL_SEATS;
    private int bookedSeats;

    // CONSTRUCTOR
    public Event(String title, LocalDate date, int TOTAL_SEATS) {
        if(title != null && !title.isBlank()){
            this.title = title;
        } else {
            throw new IllegalArgumentException("Invalid title. Please insert a valid string");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date. The event date must be after today's date.");
        } else {
            this.date = date;
        }

        if(TOTAL_SEATS > 0) {
            this.TOTAL_SEATS = TOTAL_SEATS;
        } else {
            throw new IllegalArgumentException();
        }

        this.bookedSeats = 0;
    }

    // GETTERS & SETTERS

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title != null && !title.isBlank()){
            this.title = title;
        } else {
            throw new IllegalArgumentException("Invalid title. Please insert a valid string");
        }
    }

    // date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid date. The event date must be after today's date.");
        } else {
            this.date = date;
        }
    }

    // totalSeats
    public int getTotalSeats() {
        return TOTAL_SEATS;
    }

    // bookedSeats
    public int getBookedSeats() {
        return bookedSeats;
    }

    // METHODS

    public void addReservation(int addedSeats) {

        // Controlla che l'evento non sia gia passato
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot add reservation. The event has already been performed.");
        }
        // Controlla se ci sono posti disponibili
        else if ((bookedSeats + addedSeats) > TOTAL_SEATS) {
            throw new IllegalStateException("Cannot add reservation. No available seats to this date, sorry.");
        } else {
            // Aggiunge prenotazione
            bookedSeats++;
        }
    }

    public void cancelReservation(int subtractedSeats) {
        // Controlla che l'evento non sia gia passato
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot cancel reservation. The event has already been performed.");
        }
        // Controlla che ci siano prenotazioni attive da poter disdire
        else if (bookedSeats - subtractedSeats < 0) {
            throw new IllegalStateException("Cannot cancel reservation. No reservations available.");
        } else
        // Cancella prenotazione
        bookedSeats--;
    }

    public int getAvailableSeats() {
        return TOTAL_SEATS - bookedSeats;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
