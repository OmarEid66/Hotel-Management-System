package com.example.hotel_system;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OfferTest {
    Offer test = new Offer("trial_offer",
            10.0,
            LocalDate.of(2025, 10, 1),
            LocalDate.of(2025, 10, 31));

    @Test
    public void testApplyDiscountOne(){
        assertEquals(90.0, test.applyDiscount(100));
    }

    @Test
    public void testApplyDiscountTwo(){
        assertEquals(180.0, test.applyDiscount(200));
    }

    @Test
    public void testIsValidForDate(){
        assertTrue(test.isValidForDate(LocalDate.of(2025, 10, 15)));
    }

    @Test
    public void testToString(){
        assertEquals("trial_offer" +
                        "\n enjoy " + 10.0 + " from "
                + LocalDate.of(2025, 10, 1) +
                " to " + LocalDate.of(2025, 10, 31),
                test.toString());
    }
}