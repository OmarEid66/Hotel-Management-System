package com.example.hotel_system;

public class Single extends Room {
    public Single(String roomNumber, double p) {
        super(roomNumber, p, "Single");
    }

    @Override
    public String getRoomType(){
        return "Single";
    }
}
