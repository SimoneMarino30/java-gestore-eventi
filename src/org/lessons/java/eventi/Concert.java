package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{
    // ATTRIBUTES
    private BigDecimal price;
    private LocalTime time;

    // CONSTRUCTORS
    public Concert(String title, LocalDate date, int total_seats, BigDecimal price,LocalTime time) throws IllegalArgumentException{
        // ogni concert è un nuovo Event, passo il costruttore con params (super)
        super(title, date, total_seats);
        // controllo che il prezzo non sia negativo
        validatePricePositive(price);
        this.price = price;
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws IllegalArgumentException{
        validatePricePositive(price);
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    // METHODS

    public String getFormattedDateAndTime() {
        // getFormattedDate() metodo public dell' Event
        String dateFormatted = this.getFormattedDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:MM");
        String timeFormatted = time.format(formatter);
        return dateFormatted + " " + timeFormatted;
    }

    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("##.##€");
        return df.format(this.price);
    }
    private void validatePricePositive(BigDecimal p) {
        if (p.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException("Price must be a positive number");
        }
    }

    // OVERRIDE TOSTRING
    @Override
    public String toString() {
        return getFormattedDateAndTime() + "-" + getTitle() + "-" + getFormattedPrice();
    }
}


