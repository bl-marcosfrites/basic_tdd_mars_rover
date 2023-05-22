using mars_rovers_tdd_csharp.models;

namespace mars_rovers_tdd_csharp.test.models;

public class MarsRoverTest
{
    [Fact]
    public void Test01_GetPosition()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        Assert.Equal(1, marsRover.GetX());
        Assert.Equal(1, marsRover.GetY());
        Assert.Equal("N", marsRover.GetDirection());
    }
    
    [Fact]
    public void Test02_GetPosition()
    {
        MarsRover marsRover = new MarsRover(2, 1, "N");
        Assert.Equal(2, marsRover.GetX());
        Assert.Equal(1, marsRover.GetY());
        Assert.Equal("N", marsRover.GetDirection());
    }
    
    [Fact]
    public void Test03_IsValidPosition()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        Assert.True(marsRover.ValidatePosition(1, 1, "N"));
    }
    
    [Fact]
    public void Test04_IsNotValidPosition()
    {
        MarsRover marsRover = new MarsRover(2, 1, "N");
        Assert.False(marsRover.ValidatePosition(1, 1, "N"));
    }
    
    [Fact]
    public void Test05_IsValidPositionWhenMoveForward()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.Move("f");
        Assert.True(marsRover.ValidatePosition(1, 2, "N"));
    }
    
    [Fact]
    public void Test06_IsValidPositionWhenMoveBackward()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.Move("b");
        Assert.True(marsRover.ValidatePosition(1, 0, "N"));
    }
    
    [Fact]
    public void Test07_IsValidPositionWhenTurnLeft()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.Move("l");
        Assert.True(marsRover.ValidatePosition(1, 1, "W"));
    }
    
    [Fact]
    public void Test08_IsValidPositionWhenTurnRight()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.Move("r");
        Assert.True(marsRover.ValidatePosition(1, 1, "E"));
    }
    
    [Fact]
    public void Test09_IsValidPositionWhenReceiveAnOrderWithCapitalLetter()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.Move("F");
        Assert.True(marsRover.ValidatePosition(1, 2, "N"));
    }
    
    [Fact]
    public void Test10_IsValidPositionWhenReceiveTwoOrders()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.MovementOrders("fb");
        Assert.True(marsRover.ValidatePosition(1, 1, "N"));
    }
    
    [Fact]
    public void Test11_IsValidPositionWhenReceiveThreeOrders()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.MovementOrders("lfr");
        Assert.True(marsRover.ValidatePosition(0, 1, "N"));
    }
    
    [Fact]
    public void Test12_IsValidPositionWhenReceiveTenOrders()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.MovementOrders("ffrfflfrff");
        Assert.True(marsRover.ValidatePosition(5, 4, "E"));
    }

    [Fact]
    public void Test13_IsValidPositionWhenReceiveSixOrders()
    {
        MarsRover marsRover = new MarsRover(1, 1, "N");
        marsRover.MovementOrders("fbblrr");
        Assert.True(marsRover.ValidatePosition(1, 0, "E"));
    }
}