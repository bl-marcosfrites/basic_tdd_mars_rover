package com.example.mars_rover_tdd_java;

public class MarsRover {

    public int x;
    public int y;
    public String direction;

    public MarsRover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean validatePosition(int x, int y, String direction) {
        return ((this.x == x) && (this.y == y)  && (this.direction.equals(direction)));
    }

    public void movementOrders(String movementOrders) {
        String[] movements = movementOrders.split("");
        for (String movement : movements) {
            move(movement);
        }
    }

    public void move(String movement) {
        switch (movement.toLowerCase()) {
            case "f" -> moveForward(this.direction);
            case "b" -> moveBackward(this.direction);
            case "l" -> turnLeft(this.direction);
            case "r" -> turnRight(this.direction);
            default -> throw new IllegalStateException("Unexpected value: " + movement);
        }
    }

    public void turnLeft(String direction) {
        switch (direction) {
            case "N" -> this.direction = "W";
            case "W" -> this.direction = "S";
            case "S" -> this.direction = "E";
            case "E" -> this.direction = "N";
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void turnRight(String direction) {
        switch (direction) {
            case "N" -> this.direction = "E";
            case "E" -> this.direction = "S";
            case "S" -> this.direction = "W";
            case "W" -> this.direction = "N";
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void moveForward(String direction) {
        switch (direction) {
            case "N" -> this.y += 1;
            case "S" -> this.y -= 1;
            case "E" -> this.x += 1;
            case "W" -> this.x -= 1;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public void moveBackward(String direction) {
        switch (direction) {
            case "N" -> this.y -= 1;
            case "S" -> this.y += 1;
            case "E" -> this.x -= 1;
            case "W" -> this.x += 1;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
}
