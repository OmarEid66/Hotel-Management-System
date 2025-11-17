package com.example.hotel_system;

public class Triple extends Room {
    public Triple(String roomNumber, double p) {
        super(roomNumber, p, "Triple");
    }

    @Override
    public String getRoomType(){
        return "Triple";
    }
}
