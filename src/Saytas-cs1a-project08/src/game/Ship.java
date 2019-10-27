package game;

/**
 * Provides functionality for keeping track of the ship state.
 */
public class Ship
{
    private int numberOfHits; // The number of incorrect guesses
    private boolean isAlive;
    private int maxHitsAllowed;
    private String[] shipArr2;

    // An array of strings - drawing a ship
    // It is constant does not change and no need multiple copies static one copy
    private static final String[] SHIP_ARR =
    {
            "                                    )___(\n",
            "                             _______/__/_\n",
            "                    ___     /===========|   ___\n",
            "   ____       __   [\\\\\\]___/____________|__[///]   __\n",
            "   \\   \\_____[\\\\]__/___________________________\\__[//]___\n",
            "~~~ \\SS                                                  |~~~\n",
            "~~~  \\                                                   /~~~\n",
    };

    private static final String[] WATER_ARR =
    {
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n",
            "^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\t^^^^\n",
            "     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^   ^^^^     ^^^^\n"
    };

    public Ship(int maximumHeightOfTheShip) throws ArrayIndexOutOfBoundsException
    {
        maxHitsAllowed = maximumHeightOfTheShip;
        numberOfHits = 0;

        // Initializes the ASCII representation of the ship
        shipArr2 = new String[maximumHeightOfTheShip];
        for(int i = 0; i < maximumHeightOfTheShip; i++)
        {
            if(i > 6)
            {
                shipArr2[i] = "~~~  \\                                                   /~~~\n";
            }
            else
            {
                shipArr2[i] = SHIP_ARR[i];
            }
        }
    }

    public void addHits()
    {
        numberOfHits++;
    }

    // Accessor/getter method
    public boolean getIsAlive()
    {
        if(numberOfHits > maxHitsAllowed) // returns false if the number of hits has exceeded the maximum allowable hits.
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // draw() public method draws the ASCII representation of the ship
    public void draw()
    {
        for(int s = 0; s < (shipArr2.length + 1) - numberOfHits; s++) // (maximumHeightOfTheShip + 1)- numberOfHits;
        {
            System.out.print(shipArr2[s]);
        }
        System.out.println(WATER_ARR[0] + WATER_ARR[1] + WATER_ARR[2]);
    }

    public void draw2()
    {
        for(int i = 0; i < SHIP_ARR.length; i++)
        {
            System.out.print(SHIP_ARR[i]);
        }
        for(int i = 0; i < WATER_ARR.length; i++)
        {
            System.out.print(WATER_ARR[i]);
        }
    }

    public void drawWater()
    {
        for(int i = 0; i < WATER_ARR.length; i++)
        {
            System.out.print(WATER_ARR[i]);
        }
    }
}
