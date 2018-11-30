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
                setxSpeed(rand.nextInt(2) + 2);
                setySpeed(rand.nextInt(2) + 2);
                break;
            case HORSE:
                setColor(new Color(99,69,19));
                setPrice(500);
                setSpace(12);
                setIncome(randomNum * 25);
                setSize(45);
                setxSpeed(rand.nextInt(2) + 4);
                setySpeed(rand.nextInt(2) + 4);
                break;
            case MONKEY:
                setColor(Color.PINK);
                setPrice(100);
                setSpace(1);
                setIncome(randomNum * 3);
                setSize(15);
                setxSpeed(rand.nextInt(3) + 5);
                setySpeed(rand.nextInt(3) + 5);
                break;
        }
    }
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
        g.drawString("Space needed: " + space, position.x + size + 3, position.y + 20 );
        g.drawString( "Price: " + price + "$", position.x + size + 3, position.y + 40);
    }
}
