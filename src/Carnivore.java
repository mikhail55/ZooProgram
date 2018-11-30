import java.awt.*;
import java.util.Random;

public class Carnivore extends Animal {

     enum type{
        LION, PANTHER, WOLF
    }

    private type typeOfAnimal;

    public Carnivore(type typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
        Random rand = new Random();
        int randomNum = rand.nextInt(4)+1;
        switch (typeOfAnimal){
            case LION:
                setColor(Color.YELLOW);
                setPrice(1000);
                setSpace(25);
                setIncome(randomNum * 50);
                setSize(50);
                setxSpeed(rand.nextInt(2) + 3);
                setySpeed(rand.nextInt(2) + 3);
                break;
            case PANTHER:
                setColor(Color.BLACK);
                setPrice(600);
                setSpace(9);
                setIncome(randomNum * 15);
                setSize(35);
                setxSpeed(rand.nextInt(4) + 4);
                setySpeed(rand.nextInt(4) + 4);
                break;
            case WOLF:
                setColor(Color.GRAY);
                setPrice(400);
                setSpace(6);
                setIncome(randomNum * 10);
                setSize(30);
                setxSpeed(rand.nextInt(2) + 4);
                setySpeed(rand.nextInt(2) + 4);
                break;
        }
    }

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
        g.drawString("Space needed: " + space, position.x + size + 3, position.y + 20 );
        g.drawString( "Price: " + price + "$", position.x + size + 3, position.y + 40);
    }
}
