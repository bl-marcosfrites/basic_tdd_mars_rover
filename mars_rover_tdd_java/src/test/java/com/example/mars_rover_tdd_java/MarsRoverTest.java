package com.example.mars_rover_tdd_java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MarsRoverTest {

    @Test
    void test01_GetPosition() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        assertEquals(1, marsRover.getX());
        assertEquals(1, marsRover.getY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void test02_GetPosition() {
        MarsRover marsRover = new MarsRover(2,1,"N");
        assertEquals(2, marsRover.getX());
        assertEquals(1, marsRover.getY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    void test03_IsValidPosition() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        assertTrue(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    void test04_IsNotValidPosition() {
        MarsRover marsRover = new MarsRover(2,1,"N");
        assertFalse(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    void test05_IsValidPositionWhenMoveForward() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("f");
        assertTrue(marsRover.validatePosition(1, 2, "N"));
    }

    @Test
    void test06_IsValidPositionWhenMoveBackward() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("b");
        assertTrue(marsRover.validatePosition(1, 0, "N"));
    }

    @Test
    void test07_IsValidPositionWhenTurnLeft() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("l");
        assertTrue(marsRover.validatePosition(1, 1, "W"));
    }

    @Test
    void test08_IsValidPositionWhenTurnRight() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("r");
        assertTrue(marsRover.validatePosition(1, 1, "E"));
    }

    @Test
    void test09_IsValidPositionWhenReceiveAnOrderWithCapitalLetter() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("F");
        assertTrue(marsRover.validatePosition(1, 2, "N"));
    }

    @Test
    void test10_IsValidPositionWhenReceiveTwoOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("fb");
        assertTrue(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    void test11_IsValidPositionWhenReceiveThreeOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("lfr");
        assertTrue(marsRover.validatePosition(0, 1, "N"));
    }

    @Test
    void test12_IsValidPositionWhenReceiveTenOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("ffrfflfrff");
        assertTrue(marsRover.validatePosition(5, 4, "E"));
    }

    @Test
    void test13_IsValidPositionWhenReceiveSixOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("fbblrr");
        assertTrue(marsRover.validatePosition(1, 0, "E"));
    }
}
