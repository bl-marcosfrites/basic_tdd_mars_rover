using Microsoft.VisualBasic;

namespace mars_rovers_tdd_csharp.models;

public class MarsRover
{
    public int x;
    public int y;
    public string direction;
    
    public MarsRover(int x, int y, string direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    public int GetX()
    {
        return x;
    }
    
    public int GetY()
    {
        return y;
    }
    
    public string GetDirection()
    {
        return direction;
    }
    
    public bool ValidatePosition(int x, int y, string direction)
    {
        return this.x == x && this.y == y && this.direction == direction;
    }

    public void MovementOrders(string movementOrders)
    {
        var movements = movementOrders.Select(c => c.ToString()).ToArray();
        foreach (var movement in movements)
        {
            Move(movement);
        }
    }
    
    public void Move(string movement)
    {
        switch (movement.ToLower())
        {
            case "f":
                MoveForward(direction);
                break;
            case "b":
                MoveBackward(direction);
                break;
            case "l":
                TurnLeft(direction);
                break;
            case "r":
                TurnRight(direction);
                break;
            default:
                throw new ArgumentException($"Invalid movement: {movement}");
        }
    }
    
    public void TurnLeft(string direction)
    {
        switch (direction)
        {
            case "N":
                this.direction = "W";
                break;
            case "W":
                this.direction = "S";
                break;
            case "S":
                this.direction = "E";
                break;
            case "E":
                this.direction = "N";
                break;
            default:
                throw new ArgumentException($"Invalid direction: {direction}");
        }
    }
    
    public void TurnRight(string direction)
    {
        switch (direction)
        {
            case "N":
                this.direction = "E";
                break;
            case "E":
                this.direction = "S";
                break;
            case "S":
                this.direction = "W";
                break;
            case "W":
                this.direction = "N";
                break;
            default:
                throw new ArgumentException($"Invalid direction: {direction}");
        }
    }
    
    public void MoveForward(string direction)
    {
        switch (direction)
        {
            case "N":
                y++;
                break;
            case "E":
                x++;
                break;
            case "S":
                y--;
                break;
            case "W":
                x--;
                break;
            default:
                throw new ArgumentException($"Invalid direction: {direction}");
        }
    }
    
    public void MoveBackward(string direction)
    {
        switch (direction)
        {
            case "N":
                y--;
                break;
            case "E":
                x--;
                break;
            case "S":
                y++;
                break;
            case "W":
                x++;
                break;
            default:
                throw new ArgumentException($"Invalid direction: {direction}");
        }
    }
}