public class Lab3
{
    public static void testLightCandles1()
    {
        Robot.load("candles1.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles2()
    {
        Robot.load("candles2.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void lightCandles()
    {
        //before: Robot is still and hasn't lighted any of the candles
        //after: Robot has lighted all of the candles
        for (int i = 11; i < 21; i++)
        {
            checkForCandle();
            returnToStartPosition();
        }
    }

    public static void checkForCandle()
    {
        //before: Robot is on the bottom most block to the left of the candle
        //after: Robot has lighted the candle and is on the bottom most block to the right of the candle
        if (Robot.frontIsClear())
        {
            Robot.move();
            Robot.makeDark();
            Robot.move();
        }
        else
        {            
            Robot.turnLeft();
            Robot.move();
            turnRight();
            //before:
            //after: Robot has checked to see how tall it is. If it is one block tall it lights it in the first part of the statement, but if the robot is two blocks tall it moves up two blocks and lights the candle
            if (Robot.frontIsClear())
            {
                Robot.move();
                Robot.makeDark();
                Robot.move();           
            }
            else
            {
                Robot.turnLeft();
                Robot.move();
                turnRight();
                Robot.move();
                Robot.makeDark();
                Robot.move();
            }
        }
    }

    public static void returnToStartPosition()
    {
        //before: Robot is on the the top of the candle and has just lighted it
        //after: Robot ends up on the left side of the next candle it needs to light
        turnRight();
        if (!Robot.frontIsClear())
        {
            Robot.turnLeft();
        }
        else
        {
            Robot.move();
            if (Robot.frontIsClear())
            {
                Robot.move();
                Robot.turnLeft();

            }

            else
            { 
                Robot.turnLeft();
            }
        }
    }

    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void testCompleteRoom1()
    {
        Robot.load("room1.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testCompleteRoom2()
    {
        Robot.load("room2.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void completeRoom()
    {
        //before: All of the rooms haven't been filled in that need to be filled in
        //after: All the rooms that need to be filled are filled in
        checkMoveRight();
        checkMoveRight();
        checkMoveRight();
        checkMoveRight();        

    }

    public static void checkMoveRight()
    {
        //before: All of the rooms to the left of the robot aren't filled in and the robot needs to check if it should fill it in
        //after: The rooms are filld and the robot has turned right
        checkAndMove();
        checkAndMove();
        checkAndMove();
        checkAndMove();
        checkEachWall();
        turnRight();
    }

    public static void checkAndMove()
    {
        checkEachWall();
        Robot.move(); 
    }

    public static void checkEachWall()
    {
        //before: Robot needs to know if it can go forward and if so if it can fill in that block
        //after: Robot has checked the block to see if it can more forward and if it can it has checked to see if it should fill that block in. If it can't move forward in the begining it moves on to the next block and if the room is already filled it goes on to the next block
        Robot.turnLeft();
        if (Robot.frontIsClear())
        {
            Robot.move();
            if (Robot.onDark())
            {
                turnAround();
                Robot.move();
                Robot.turnLeft();
            }
            else
            {
                Robot.makeDark();
                turnAround();
                Robot.move();
                Robot.turnLeft();
            }
        }
        else
        {
            turnRight();
        }
    }

    public static void turnAround()
    {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void testSwapAll1()
    {
        Robot.load("swap1.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    public static void testSwapAll2()
    {
        Robot.load("swap2.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    public static void swapAll()
    {
        //before: the blocks haven't been swapped
        //after: the blocks have been swapped
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        swapEachRow();
        turnRight();
        Robot.move();
        testingBlocks();
    }

    public static void swapEachRow()
    {
        //before: the row hasn't been swapped
        //after: the row has been swapped
        turnRight();
        Robot.move();
        testingBlocks();
        Robot.move();
    }

    public static void testingBlocks()
    {
        //Don't really know how to do this one with before and after so i'm just gonna describe it
        //First the robot checks to see if it is on a dark, if it is then it goes to the block on the opposite side and sees if it is not dark. If the dark is not dark is darkens it and goes back to the orginal block and makes it light
        //Then it goes back to the center. If the block is dark it doesn't make any changes and goes back to the center. Now, if the orginal block is not dark it does a simlar thing.
        //The robot moves over to the opposite block on the other side and checks to see if that is dark. If it is the robot makes it light and then goes back to the original block and makes it dark. If both of the block are light the robot goes back into the center of the two columns

        if (Robot.onDark())
        {
            turnAround();
            Robot.move();
            Robot.move();
            if (!Robot.onDark())
            {
                Robot.makeDark();
                turnAround();
                Robot.move();
                Robot.move();
                Robot.makeLight();
                turnAround();
                Robot.move();
                turnRight();
            }
            else
            {
                turnAround();
                Robot.move();
                Robot.turnLeft();
            }        
        }
        else
        {
            turnAround();
            Robot.move();
            Robot.move();
            if (Robot.onDark())
            {
                Robot.makeLight();
                turnAround();
                Robot.move();
                Robot.move();
                Robot.makeDark();
                turnAround();
                Robot.move();
                turnRight();
            }
            else
            {
                turnAround();
                Robot.move();
                Robot.turnLeft();
            }
        }

    }

    public static void testLightCandles3()
    {
        Robot.load("candles3.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testLightCandles4()
    {
        Robot.load("candles4.txt");
        Robot.setDelay(0.05);
        lightCandles();
    }

    public static void testCompleteRoom3()
    {
        Robot.load("room3.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testCompleteRoom4()
    {
        Robot.load("room4.txt");
        Robot.setDelay(0.05);
        completeRoom();
    }

    public static void testSwapAll3()
    {
        Robot.load("swap3.txt");
        Robot.setDelay(0.05);
        swapAll();
    }

    public static void testSwapAll4()
    {
        Robot.load("swap4.txt");
        Robot.setDelay(0.05);
        swapAll();
    }
}
