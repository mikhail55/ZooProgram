import java.awt.*;
import java.util.Random;
/**
 * The Carnivore class extends the Animal class
 * Similar to Herbivore class, but features different Animals
 * This class is used to set the values for the variables from the Animal class, according to the type of Animal
 * It is also used to separate Animals in the zoo
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */

public class Carnivore extends Animal {

    /**
     * This enum describe the species of Animal
     */
     enum type{
        LION, PANTHER, WOLF
    }

    private type typeOfAnimal;

    /**
     * This is the basic constructor
     * It creates a basic animal of a certain type
     * @param typeOfAnimal this param is used to create the Animal of given species
     */
    public Carnivore(type typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
        Random rand = new Random();
        /**
         * The variables are assigned, depending on which Animal is created
         */
        switch (typeOfAnimal){
            case LION:
                setColor(Color.YELLOW);
                setSpace(25);
                setSize(50);
                setxSpeed(rand.nextInt(1) + 5);
                setySpeed(rand.nextInt(1) + 5);
                break;
            case PANTHER:
                setColor(Color.BLACK);
                setSpace(9);
                setSize(35);
                setxSpeed(rand.nextInt(2) + 5);
                setySpeed(rand.nextInt(2) + 5);
                break;
            case WOLF:
                setColor(Color.GRAY);
                setSpace(6);
                setSize(30);
                setxSpeed(rand.nextInt(2) + 4);
                setySpeed(rand.nextInt(2) + 4);
                break;
        }
    }

    /**
     * This method is used to draw the information about the animal on the screen
     * @return Nothing
     * @param g Graphics object that is used for drawing
     */
    @Override
    public void drawInfo(Graphics g){
        g.setColor(Color.BLACK);
        switch(typeOfAnimal){
            case LION: g.drawString("LION", position.x, position.y);
            break;
            case WOLF: g.drawString("WOLF", position.x, position.y);
            break;
            case PANTHER: g.drawString("PANTHER", position.x, position.y);
            break;
        }
        g.drawString("Space needed: " + getSpace(), position.x + getSize() + 3, position.y + 20 );
    }

    /**
     * This method checks if the Animal is hungry
     * If it is, changes its behaviour
     * @return boolean returns the state of hunger
     */
    @Override
    public boolean isHungry(){
        if (getHealth()==250){
            setxSpeed(10);
            setySpeed(10);
            return true;
        }
        if (getHealth()==0){
            setColor(Color.RED);
            setxSpeed(0);
            setySpeed(0);
            return false;
        }
        return getHealth() < 250;
    }
    /**
     * This method restores the Animal's health
     * @return Nothing
     */
    @Override
    public void eat(){
        Random rand = new Random();
        if (isHungry() && getHealth() > 0){
            switch (typeOfAnimal){
                case LION:
                    setxSpeed(rand.nextInt(1) + 5);
                    setySpeed(rand.nextInt(1) + 5);
                    break;
                case PANTHER:
                    setxSpeed(rand.nextInt(2) + 5);
                    setySpeed(rand.nextInt(2) + 5);
                    break;
                case WOLF:
                    setxSpeed(rand.nextInt(2) + 4);
                    setySpeed(rand.nextInt(2) + 4);
                    break;
            }
            setHealth(1000);
        }
    }
}
