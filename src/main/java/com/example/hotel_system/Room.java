package com.example.hotel_system;

public abstract class Room implements Comparable<Room>{
    private final String roomNo;    // serial no., each room has a unique no. ex: 153, 156, 225,...
    private final double price;   //per night (price before applying any offers)
    private final String roomType;
    private boolean isAvailable; //booked or not

    public Room(String roomNo,double price, String roomType) {
        this.roomNo = roomNo;
        this.price = price;
        this.isAvailable = true;
        this.roomType = roomType;
    }

    public void setAvailable(boolean s){
        isAvailable = s;}
    public boolean getStatues(){return isAvailable;}
    public double getPrice(){return price;}
    public String getRoomNo(){return roomNo;}
    public String getRoomType(){return roomType;}

    @Override
    public int compareTo(Room other) {
        // Sort by availability first (available comes before booked)
        if (this.getStatues() != other.getStatues()) {
            return Boolean.compare(other.getStatues(), this.getStatues());
        }
        // If same availability, sort by room number
        return this.getRoomNo().compareTo(other.getRoomNo());
    }

}
