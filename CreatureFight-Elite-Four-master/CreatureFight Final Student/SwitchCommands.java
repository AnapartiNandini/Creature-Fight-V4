import greenfoot.*;

/**
 * Write a description of class PlayerCommands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwitchCommands implements MenuCommands
{
    /**
     * execute executes the appropriate action based on which kind 
     * of menu is being used, which option is selected, and for which creature
     * the option is selected
     * 
     * @param idx is the index of the option chosen
     * @param c is the creature that is currently in play
     * @return Nothing is returned
     */
    public void execute(int idx, Creature c)
    {
        //If c is an instance of Charmander or c is an instance of Pikachu (use the instanceof operator)...
        if(c instanceof Charmander || c instanceof Pikachu)
        {
             //Call the switchCreature method of c using a parameter of idx+1
             c.switchCreature(idx + 1);
        }
        //Otherwise, if c is an instance of Golem ot c is an instance of Lapras (use the instanceof operator)...
        else if(c instanceof Golem || c instanceof Lapras)
        {
            //If idx is 1...
            if(idx == 1)
            {
                //Call the switchCreature method of c using a parameter of idx+1
                c.switchCreature(idx + 1);
            }
            //Otherwise...
            else
            {
                //Call the switchCreature method of c using a parameter of idx
                c.switchCreature(idx);
            }
        }
        //Otherwise...
        else
        {
                //Call the switchCreature method of c using a parameter of idx
                c.switchCreature(idx);
        }
    }
}   

