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
        addObject(new Rover(),1,5);
        addObject(new Gestein(),10,4);
        addObject(new Gestein(),7,8);
        addObject(new Gestein(),5,4);
        addObject(new Gestein(),3,9);
        addObject(new Huegel(),7,5);
        addObject(new Huegel(),12,8);
        addObject(new Huegel(),14,4);
    }

  
}