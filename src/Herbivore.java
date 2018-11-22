import java.awt.*;

public class Herbivore extends Animal{

     enum type{
        PANDA, HORSE, MONKEY
    }

    private type typeOfAnimal;

    public Herbivore(type typeOfAnimal, String name){
        this.typeOfAnimal = typeOfAnimal;

        switch (typeOfAnimal){
            case PANDA:
                setColor(Color.LIGHT_GRAY);
                break;
            case HORSE:
                setColor(Color.ORANGE);
                break;
            case MONKEY:
                setColor(Color.PINK);
                break;
        }
    }

    @Override
    protected void reactToFood(){

    }



}
