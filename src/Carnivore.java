import java.awt.*;
import java.util.Random;

public class Carnivore extends Animal {

     enum type{
        LION, PANTHER, WOLF
    }

    private type typeOfAnimal;

    public Carnivore(type typeOfAnimal, String name) {
        this.typeOfAnimal = typeOfAnimal;
        setName(name);
        Random rand = new Random();
        int randomNum = rand.nextInt(4)+1;
        switch (typeOfAnimal){
            case LION:
                setColor(Color.YELLOW);
                setPrice(1000);
                setSpace(25);
                setIncome(randomNum * 50);
                setSize(50);
                break;
            case PANTHER:
                setColor(Color.BLACK);
                setPrice(600);
                setSpace(9);
                setIncome(randomNum * 15);
                setSize(35);
                break;
            case WOLF:
                setColor(Color.GRAY);
                setPrice(400);
                setSpace(6);
                setIncome(randomNum * 10);
                setSize(30);
                break;
        }
    }

    @Override
    public void reactToFood(){

    }

    private void reactToPrey(Animal prey){

    }

}
