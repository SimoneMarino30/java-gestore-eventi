package org.lessons.java.eventi;

import java.time.LocalDate;

public class Event {
    //VARIABLES

    // ATTRIBUTES
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int bookedSeats;

    // CONSTRUCTOR
    public Event(String title, LocalDate date, int totalSeats) {
        if(title != null && !title.isBlank()){
            this.title = title;
        } else {
            throw new IllegalArgumentException("Invalid title. Please insert a valid string");
        }

        if (date.isAfter(LocalDate.now())) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("Invalid date. The event date must be after today's date.");
        }

        if(totalSeats > 0) {
            this.totalSeats = totalSeats;
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
        this.title = title;
    }

    // date
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // totalSeats
    public int getTotalSeats() {
        return totalSeats;
    }

    // bookedSeats
    public int getBookedSeats() {
        return bookedSeats;
    }

    // METHODS
    public void AddReservation() {
        // Controlla che l'evento non sia gia passato
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot add reservation. The event has already been performed.");
        }
        // Controlla se ci sono posti disponibili
        if (bookedSeats >= totalSeats) {
            throw new IllegalStateException("Cannot add reservation. No available seats to this date, sorry.");
        }
        // Aggiunge prenotazione
        bookedSeats++;
    }

    public void cancelReservation() {
        // Controlla che l'evento non sia gia passato
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot cancel reservation. The event has already been performed.");
        }
        // Controlla che ci siano prenotazioni attive da poter disdire
        if (bookedSeats <= 0) {
            throw new IllegalStateException("Cannot cancel reservation. No reservations available.");
        }
        // Cancella prenotazione
        bookedSeats--;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", totalSeats=" + totalSeats +
                ", bookedSeats=" + bookedSeats +
                '}';
    }
}
