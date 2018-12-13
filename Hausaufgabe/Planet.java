import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Planet extends World
{
    private static int zellenGroesse = 50;

    /**
     * Erschaffe eine Welt mit 15 * 12 Zellen.
     */
    public Planet()
    {
        super(16, 12, zellenGroesse);
        setBackground("images/boden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(20); 

        prepare();
    }

    
    /**
     * Bereite die Welt für den Programmstart vor. Das heißt: Erzeuge die Anfangs-
     * Objekte und füge sie der Welt hinzu.
     */
    private void prepare()
    {
        Huegel huegel = new Huegel();
        addObject(huegel, 5, 5);
        Huegel huegel2 = new Huegel();
        addObject(huegel2, 7, 5);
        Huegel huegel3 = new Huegel();
        addObject(huegel3, 8, 5);
        Huegel huegel4 = new Huegel();
        addObject(huegel4, 9, 5);
        Huegel huegel5 = new Huegel();
        addObject(huegel5, 11, 5);
        Gestein gestein = new Gestein();
        addObject(gestein, 5, 6);
        Gestein gestein2 = new Gestein();
        addObject(gestein2, 6, 6);
        Gestein gestein3 = new Gestein();
        addObject(gestein3, 7, 6);
        Gestein gestein4 = new Gestein();
        addObject(gestein4, 10, 6);
        Gestein gestein5 = new Gestein();
        addObject(gestein5, 11, 6);
        Marke marke = new Marke();
        addObject(marke, 13, 6);
        Marke marke2 = new Marke();
        addObject(marke2, 13, 7);
        Marke marke3 = new Marke();
        addObject(marke3, 13, 8);
        Marke marke4 = new Marke();
        addObject(marke4, 13, 9);
        Marke marke5 = new Marke();
        addObject(marke5, 13, 10);
        Marke marke6 = new Marke();
        addObject(marke6, 12, 10);
        Marke marke7 = new Marke();
        addObject(marke7, 11, 10);
        Marke marke8 = new Marke();
        addObject(marke8, 10, 10);
        Marke marke9 = new Marke();
        addObject(marke9, 9, 10);
        Marke marke10 = new Marke();
        addObject(marke10, 8, 10);
        Marke marke11 = new Marke();
        addObject(marke11, 7, 10);
        Marke marke12 = new Marke();
        addObject(marke12, 13, 5);
        Marke marke13 = new Marke();
        addObject(marke13, 13, 4);
        Huegel huegel6 = new Huegel();
        addObject(huegel6, 14, 10);
        Rover rover = new Rover("Rove", 'B' , 5);
        addObject(rover, 3, 2);
        removeObject(rover);
        Rover rover2 = new Rover("Lukas", 'b', 8.7);
        addObject(rover2, 3, 2);
    }
}