import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * TODO (78): Copy all code below public class Charmander and paste it below.
 *          You will make a few changes to the code to make it appropriate for
 *          Golem. These are listed in order from top to bottom:
 *              - Change the constructor to say Golem instead of Charmander
 *              - Golem has 950 points of health
 *              - Golem's type is Rock
 *              - In the constructor, add a line at the end to set the transparency
 *                of the image of the health bar to 0
 *              - Show text that Golem has fainted when its health bar's value is 
 *                less than or equal to 0
 *                  - When Golem faints, you should be checking if getNewOneCreature at 0
 *                    still has health first
 *                      - You should be switching to Creature 0 if this is the case
 *              - Golem's first attack should do 30 points of damage
 *              - Golem's second attack...
 *                  - if used against an electric type...
 *                      - Should do two times 75 points of damage (DON'T DO THE MATH! Write the math expression)
 *                      - Should display that the attack is super effective at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                  - otherwise, if used against a flying type...
 *                      - Should do 0 damage
 *                      - Should display that the attack has no effect at a location of
 *                        half the width of the world and half the height of the world plus 26
 *                      - Should delay the scenario by 30 act cycles
 *                  - otherwise...
 *                      - Should do 75 points of damage
 *              - In switchCreature...
 *                      - If idx is equal to 0...
 *                          - Change player one to Charmander
 *              
 */
public class Golem extends Creature
{
    /**
     * Constructor for objects of class Golem
     * 
     * @param w is a reference to the world that Golem gets added to
     * @return An object of type Golem
     */
    public Golem(World w)
    {
        super(950, 1, "Rock");
        getImage().scale(150, 100);
        w.addObject( getHealthBar() , 300, w.getHeight() - 50 );
        getImage().setTransparency(0);
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
     {
         CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
         if( getHealthBar().getCurrent() <= 0 )
         {
             getWorld().showText("Golem has fainted...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
             Greenfoot.delay(30);
                
            //TODO (68): If the current health of the health bar of the new one creature at index 1 in player world is greater than 0...
            if( playerWorld.getNewOneCreature(0).getHealthBar().getCurrent() > 0 )
            {
                //TODO (69): Call the switchCreature method using a value of 0 as the parameter
                switchCreature(0);     
                           
                //TODO (70): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);    
                            
                //TODO (71): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText(" ",  getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );    
                            
                //TODO (72): Remove this object from the world
                getWorld().removeObject(this);   
            }
               
            //TODO (73): Otherwise, if the current health of the health bar of the new one creature at index 2 in player world is greater than 0...
            else if( playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0 )
            {
                //TODO (74): Call the switchCreature method using a value of 2 as the parameter
                switchCreature(2);
                    
                //TODO (75): Set the turn number in player world to 1
                playerWorld.setTurnNumber(1);
                    
                //TODO (76): Clear the text (using an empty String, "") at the location that it stated Charmander had fainted
                getWorld().showText(" ", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26);
                    
                //TODO (77): Remove this object from the world
                getWorld().removeObject(this);  
            }            
        }
      }
  

      /**
       * attack takes away health from the enemy Creature using one of
       * two predefined attacks
       * 
       * @param idx is the index of the attack option selected
       * @return Nothing is returned
       */
        public void attack(int idx)
        {
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        Creature enemy = playerWorld.getPlayerTwo();
        String enemyType = enemy.getType();
        
        //TODO (39): Make a call to the attackAnimation method
        attackAnimation();

        if( idx == 0 )
        {
            enemy.getHealthBar().add( -30 );
        }
        
        else
        {
           //TODO (40): If the enemy type equals (ignoring case) Water...
           if ( enemyType == "Electric" )
            {
             //Should do two times 75 points of damage (DON'T DO THE MATH! Write the math expression)
             enemy.getHealthBar().add( -75*2 );
             
             /**
              * TODO (42): Show text that states the attack was not very effective at a x location of half the width of the world 
              * and a y location of half the height of the world plus 26 pixels
              */
             getWorld().showText(" This attack was not very effective ",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
             
             //TODO (43): Delay the scenario by 30 pixels
             Greenfoot.delay(30); 
            }
           //Otherwise, if used against a flying type
           else if ( enemyType == "Flying" )
           {
               //Should do 0 damage
               enemy.getHealthBar().add(0);
               
               /**
                * Should display that the attack has no effect at a location of 
                * half the width of the world and half the height of the world plus 26
                */
               
               getWorld().showText("This attack has no effect", getWorld().getWidth()/2,getWorld().getHeight()/2+26); 
               
               //Delay the scenario by 30 pixels
               Greenfoot.delay(30); 
           }
           //TODO (44): Otherwise...
           else 
           {
              //TODO (45): Take the line from below that takes away 75 points of health and place it inside this else
              enemy.getHealthBar().add( -75 );
           } 
        }

        playerWorld.setTurnNumber(2);
    }
    
    /**
     * TODO (33): Declare an attackAnimation method that has no
     *          parameters and no return type
     *          
     * TODO (34): Declare two local variables, originalX and originalY
     *          that are set to the current X and current Y locations
     *          
     * TODO (35): Declare a loop that will run 15 times
     * 
     *      TODO (36): Set the location to 1 more than the current X location
     *               and two less than the current y location (you shouldn't
     *               be using the variables that you created earlier)
     *               
     *      TODO (37): Delay the scenario 1 act cycle
     *      
     * TODO (38): Set the location back to the original x and y locations 
     */
    
    /**
     * attackAnimation is basically the animation used by this class to attack
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
      //Declare two local variables, originalX and originalY that are set to the current X and current Y locations  
      int originalX = getX();
      int originalY = getY();
      
      //Declare a loop that will run 15 times
      for( int i = 0; i < 15; i++ )
      {
         //Set the location to 1 more than the current X location and two less than the current y location 
         setLocation( getX()+1, getY()-2 );
         
         // Delay the scenario 1 act cycle
         Greenfoot.delay(1); 
      }
      
      //Set the location back to the original x and y locations 
       setLocation( originalX, originalY ); 
    }

    /**
     * TODO (46): Declare a switchCreature method that will be accessed
     *          by other classes, has no return type, and has a parameter
     *          called idx
     *          
     * TODO (47): Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
     * 
     * TODO (48): Declare a local Creature variable called switchCreature that is
     *          initialized to get a new player one creature using the idx parameter
     *          
     * TODO (49): If the current health of the health bar of the switchCreature is less than or equal to 0...
     * 
     *      TODO (50): Use JOptionPane to show a message dialog with null as the first parameter and a message that
     *               let's the player know that the Creature they have chosen to switch to has fainted and they must
     *               select a different option
     *               
     * TODO (51): Otherwise...
     * 
     *      TODO (52): Use a loop that will loop while the x location of this creature
     *               is greater than 0
     *               
     *          TODO (53): Inside this loop, set the location to 5 less than the current x location and the current y location
     *          
     *          TODO (54): Delay the scenario by 2 act cycles
     *          
     *      TODO (55): Set the transparency of the image of this object to 0
     *      
     *      TODO (56): Set the transparency of the image of the health bar to 0
     *      
     *      TODO (57): If idx is equal to 1...
     *      
     *          TODO (58): Change player one in playerWorld to Golem
     *          
     *      TODO (59): Otherwise...
     *      
     *          TODO (60): Change player one in playerWorld to Ivysaur
     *          
     *      TODO (61): Call the switchedIn method of switchCreature
     *      
     *      TODO (62): Set turn number in playerWorld to 2
     *          
     */
    
    /**
     * switchCreature indicates to the program that the user wants to change the creature which they are using
     * 
     * @param Has an integer parameter called idx which represents the index
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        //Declare a local CreatureWorld variable called playerWorld that stores a reference to the CreatureWorld
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        //Declare a local Creature variable called switchCreature that is initialized to get a new player one creature using the idx parameter
        Creature switchCreature = playerWorld.getNewOneCreature(idx);
        
        //If the current health of the health bar of the switchCreature is less than or equal to 0...
        if ( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
          //Use JOptionPane to show a message dialog with null as the first parameter and a message that let's the player know that the Creature they have chosen to switch to has fainted and they must select a different option
          JOptionPane.showMessageDialog( null, "This Creature has Fainted! Please Select a different creature. \nIf all creatures have fainted, proceed with the battle " );
        }
      
        //Otherwise
        else
        {
          //Use a loop that will loop while the x location of this creature is greater than 0
          while(getX() > 0 )
          {
              //Inside this loop, set the location to 5 less than the current x location and the current y location
              setLocation( getX()-5, getY() );
              
              //Delay the scenario by 2 act cycles
              Greenfoot.delay(2);
          }
          //Set the transparency of the image of this object to 0
          getImage().setTransparency(0);
           
          // Set the transparency of the image of the health bar to 0
          getHealthBar().getImage().setTransparency(0);
          
          //If idx is equal to 1...
          if( idx == 0)
          {
             //Change player one in playerWorld to Charmander
             playerWorld.changePlayerOne("Charmander"); 
          }
          
          //Otherwise...
          else
          {
             //Change player one in playerWorld to Ivysaur
             playerWorld.changePlayerOne("Ivysaur"); 
          }
          //Call the switchedIn method of switchCreature
          switchCreature.switchedIn();
             
          //Set turn number in playerWorld to 2
          (playerWorld).setTurnNumber(2);
          
        }
    }

    /**
     * TODO (63): Declare a method called switchedIn that will be accessed by
     *          other classes, has no return type, and no parameters
     *          
     * TODO (64): Set the transparency of the image of Charmander and the
     *          transparency of the image of the health bar to full
     *          
     * TODO (65): Declare a loop that will repeat while the x location of Charmander
     *          is less than half the width of the image of Charmander
     *          
     *      TODO (66): Set the location of Charmander to the current x location plus 5
     *               and the current y location
     *               
     *      TODO (67): Delay the scenario by two cycles
     */
    /**
     * switchedIn indicates to the program that the user has chosen this creature and instruct the scenario what to do
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
      //Set the transparency of the image of Charmander and the transparency of the image of the health bar to full
      getImage().setTransparency(100);
      
      //Declare a loop that will repeat while the x location of Charmander is less than half the width of the image of Charmander
      while(getX() < getX()/2 )
        {
           //Set the location of Charmander to the current x location plus 5 and the current y location
           setLocation( getX()+5, getY() );
           
           //Delay the scenario by two cycles
           Greenfoot.delay(2);
        }
    }
}
