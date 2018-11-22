import java.awt.*;

public class Carnivore extends Animal {

     enum type{
        LION, PANTHER, WOLF
    }

    private type typeOfAnimal;

    public Carnivore(type typeOfAnimal, String name) {
        this.typeOfAnimal = typeOfAnimal;
        setName(name);
        switch (typeOfAnimal){
            case LION:
                setColor(Color.YELLOW);
                break;
            case PANTHER:
                setColor(Color.BLACK);
                break;
            case WOLF:
                setColor(Color.GRAY);
                break;
        }
    }

    @Override
    protected void reactToFood(){

    }

    private void reactToPrey(Animal prey){

    }

}
