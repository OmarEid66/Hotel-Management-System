package com.example.hotel_system;

import java.time.LocalDate;

public class Booking  {
    private final Guest guest;
    private final Room room;
    private  Offer offer = null;
    private final double deposit;
    private final LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isCancelled = false;

    public Booking(Guest guest, Room room, double deposit, LocalDate checkInDate) {
        this.guest = guest;
        this.room = room;
        this.deposit = deposit;
        this.checkInDate = checkInDate;
        this.room.setAvailable(false); //booked
    }

    public Booking(Guest guest, Room room, double deposit, LocalDate checkInDate, Offer offer) {
        this.guest = guest;
        this.room = room;
        this.deposit = deposit;
        this.checkInDate = checkInDate;
        this.offer = offer;
        this.room.setAvailable(false); // booked
    }

    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public Offer getOffer(){ return offer; }
    public double getDeposit(){ return deposit;}
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public boolean getStatues() { return isCancelled; }

    public void setCheckOutDate(LocalDate date) {
        this.checkOutDate = date; // Free the room
    }

    public void cancelBooking() {
        this.isCancelled = true;
        this.room.setAvailable(true); // Free the room
    }

    public boolean isBooked() {
        return !isCancelled &&
                (checkOutDate == null) && (checkInDate != null);
    }

    public double calculateTotalPayment() {
        int days = 0;
        LocalDate date = checkInDate;

        while (date.isBefore(checkOutDate)) {
            days++;
            date = date.plusDays(1);
        }
        double totalBeforeOffer = days * room.getPrice();
        return (offer != null)? offer.applyDiscount(totalBeforeOffer) - deposit : totalBeforeOffer - deposit;
    }
}