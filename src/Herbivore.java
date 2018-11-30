import java.awt.*;
import java.util.Random;

/**
 * The Herbivore class extends the Animal class
 * Similar to Carnivore class, but features different Animals
 * This class is used to set the values for the variables from the Animal class, according to the type of Animal
 * It is also used to separate Animals in the zoo
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */
public class Herbivore extends Animal{

    /**
     * This enum describe the species of Animal
     */
     enum type{
        PANDA, HORSE, MONKEY
    }

    private type typeOfAnimal;

    /**
     * This is the basic constructor
     * It creates a basic animal of a certain type
     * @param typeOfAnimal this param is used to create the Animal of given species
     */
    public Herbivore(type typeOfAnimal){
        this.typeOfAnimal = typeOfAnimal;
        Random rand = new Random();
        /**
         * The variables are assigned, depending on which Animal is created
         */
        switch (typeOfAnimal){
            case PANDA:
                setColor(Color.LIGHT_GRAY);
                setSpace(9);
                setSize(35);
                setxSpeed(rand.nextInt(2) + 1);
                setySpeed(rand.nextInt(2) + 1);
                break;
            case HORSE:
                setColor(new Color(99,69,19));
                setSpace(12);
                setSize(45);
                setxSpeed(rand.nextInt(2) + 2);
                setySpeed(rand.nextInt(2) + 2);
                break;
            case MONKEY:
                setColor(Color.PINK);
                setSpace(1);
                setSize(15);
                setxSpeed(rand.nextInt(2) + 3);
                setySpeed(rand.nextInt(2) + 3);
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
            case PANDA: g.drawString("PANDA", position.x, position.y);
                break;
            case MONKEY: g.drawString("MONKEY", position.x, position.y);
                break;
            case HORSE: g.drawString("HORSE", position.x, position.y);
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
            setxSpeed(0);
            setySpeed(0);
            return true;
        } if (getHealth()==0){
            setColor(Color.RED);
            return false;
        } else return getHealth() < 250;
    }
    /**
     * This method restores the Animal's health if it is not dead
     * @return Nothing
     */
    @Override
    public void eat(){
        Random rand = new Random();
        if (isHungry() && getHealth() > 0){
            switch (typeOfAnimal){
                case PANDA:
                    setxSpeed(rand.nextInt(2) + 1);
                    setySpeed(rand.nextInt(2) + 1);
                    break;
                case HORSE:
                    setxSpeed(rand.nextInt(3) + 1);
                    setySpeed(rand.nextInt(3) + 1);
                    break;
                case MONKEY:
                    setxSpeed(rand.nextInt(3) + 2);
                    setySpeed(rand.nextInt(3) + 2);
                    break;
            }
        }
        setHealth(1000);
    }


    /**
     * This method is used to differentiate Carnivores from Herbivores
     * @return boolean this boolean indicates Type(true = Herbivore, false = Carnivore)
     */
    @Override
    public boolean getType() { return true; }
}
