import java.awt.*;
import java.util.Random;

public class Herbivore extends Animal{

     enum type{
        PANDA, HORSE, MONKEY
    }

    private type typeOfAnimal;

    public Herbivore(type typeOfAnimal){
        this.typeOfAnimal = typeOfAnimal;
        Random rand = new Random();
        int randomNum = rand.nextInt(4)+1;
        switch (typeOfAnimal){
            case PANDA:
                setColor(Color.LIGHT_GRAY);
                setPrice(700);
                setSpace(9);
                setIncome(randomNum * 25);
                setSize(35);
                break;
            case HORSE:
                setColor(Color.ORANGE);
                setPrice(500);
                setSpace(12);
                setIncome(randomNum * 25);
                setSize(45);
                break;
            case MONKEY:
                setColor(Color.PINK);
                setPrice(100);
                setSpace(1);
                setIncome(randomNum * 3);
                setSize(15);
                break;
        }
    }

    @Override
    public void reactToFood(){

    }



}
