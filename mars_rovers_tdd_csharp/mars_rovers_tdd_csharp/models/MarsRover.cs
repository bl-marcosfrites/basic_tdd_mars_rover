namespace mars_rovers_tdd_csharp.models;

public class MarsRover
{
    private int _coordinateX;
    private int _coordinateY;
    private string _direction;
    
    public MarsRover(int coordinateX, int coordinateY, string direction)
    {
        this._coordinateX = coordinateX;
        this._coordinateY = coordinateY;
        this._direction = direction;
    }
    
    public int GetX()
    {
        return _coordinateX;
    }
    
    public int GetY()
    {
        return _coordinateY;
    }
    
    public string GetDirection()
    {
        return _direction;
    }
    
    public bool ValidatePosition(int x, int y, string direction)
    {
        return this._coordinateX == x && this._coordinateY == y && this._direction == direction;
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
                MoveForward(_direction);
                break;
            case "b":
                MoveBackward(_direction);
                break;
            case "l":
                TurnLeft(_direction);
                break;
            case "r":
                TurnRight(_direction);
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
                this._direction = "W";
                break;
            case "W":
                this._direction = "S";
                break;
            case "S":
                this._direction = "E";
                break;
            case "E":
                this._direction = "N";
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
                this._direction = "E";
                break;
            case "E":
                this._direction = "S";
                break;
            case "S":
                this._direction = "W";
                break;
            case "W":
                this._direction = "N";
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
                _coordinateY++;
                break;
            case "E":
                _coordinateX++;
                break;
            case "S":
                _coordinateY--;
                break;
            case "W":
                _coordinateX--;
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
                _coordinateY--;
                break;
            case "E":
                _coordinateX--;
                break;
            case "S":
                _coordinateY++;
                break;
            case "W":
                _coordinateX++;
                break;
            default:
                throw new ArgumentException($"Invalid direction: {direction}");
        }
    }
}