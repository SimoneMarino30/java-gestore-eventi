package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
    // ATTRIBUTES
    private BigDecimal price;
    private LocalTime time;

    // CONSTRUCTORS
    public Concert(String title, LocalDate date, int TOTAL_SEATS, BigDecimal price,LocalTime time) {
        super(title, date, TOTAL_SEATS);
        this.price = price;
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
