package com.example.mars_rover_tdd_java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MarsRoverTest {

    @Test
    public void test01_getPosition() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        assertEquals(1, marsRover.getX());
        assertEquals(1, marsRover.getY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    public void test02_getPosition() {
        MarsRover marsRover = new MarsRover(2,1,"N");
        assertEquals(2, marsRover.getX());
        assertEquals(1, marsRover.getY());
        assertEquals("N", marsRover.getDirection());
    }

    @Test
    public void test03_isValidPosition() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        assertTrue(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    public void test04_isNotValidPosition() {
        MarsRover marsRover = new MarsRover(2,1,"N");
        assertFalse(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    public void test05_isValidPositionWhenMoveForward() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("f");
        assertTrue(marsRover.validatePosition(1, 2, "N"));
    }

    @Test
    public void test06_IsValidPositionWhenMoveBackward() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("b");
        assertTrue(marsRover.validatePosition(1, 0, "N"));
    }

    @Test
    public void test07_IsValidPositionWhenTurnLeft() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("l");
        assertTrue(marsRover.validatePosition(1, 1, "W"));
    }

    @Test
    public void test08_IsValidPositionWhenTurnRight() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("r");
        assertTrue(marsRover.validatePosition(1, 1, "E"));
    }

    @Test
    public void test09_IsValidPositionWhenReceiveAnOrderWithCapitalLetter() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.move("F");
        assertTrue(marsRover.validatePosition(1, 2, "N"));
    }

    @Test
    public void test10_IsValidPositionWhenReceiveTwoOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("fb");
        assertTrue(marsRover.validatePosition(1, 1, "N"));
    }

    @Test
    public void test11_IsValidPositionWhenReceiveThreeOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("lfr");
        assertTrue(marsRover.validatePosition(0, 1, "N"));
    }

    @Test
    public void test12_IsValidPositionWhenReceiveTenOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("ffrfflfrff");
        assertTrue(marsRover.validatePosition(5, 4, "E"));
    }

    @Test
    public void test13_IsValidPositionWhenReceiveSixOrders() {
        MarsRover marsRover = new MarsRover(1,1,"N");
        marsRover.movementOrders("fbblrr");
        assertTrue(marsRover.validatePosition(1, 0, "E"));
    }
}
