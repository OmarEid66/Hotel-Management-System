package com.example.hotel_system;

public class Double extends Room {
    public Double(String roomNumber, double p) {
        super(roomNumber, p, "Double");
    }

    @Override
    public String getRoomType(){
        return "Double";
    }
}
