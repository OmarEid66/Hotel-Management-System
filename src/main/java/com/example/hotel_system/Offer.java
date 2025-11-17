package com.example.hotel_system;

import java.time.LocalDate;

public class Offer implements Discountable {
    private final String Title;
    private final double discountPercentage;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Offer(String Title, double discountPercentage,
                 LocalDate startDate, LocalDate endDate) {
        this.Title = Title;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - (discountPercentage / 100));
    }

    public boolean isValidForDate(LocalDate date) {
        return !date.isBefore(this.startDate) && !date.isAfter(this.endDate);
    }

    public String getTitle() { return Title; }
    public double getDiscountPercentage() { return discountPercentage; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    @Override
    public String toString() {
        return Title + "\n enjoy " + discountPercentage + " from " + startDate + " to " + endDate;
    }
}