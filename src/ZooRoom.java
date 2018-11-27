import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ZooRoom{
    private int width,height;             //width and height of the room in ZooCells
    private Point index;                  //location of the room in the zoo
    private ArrayList<Animal> animalsInRoom;
    private ArrayList<Food> availableFood;

    public ZooRoom(int width, int height, Point locationChosen) {
        this.width = width;
        this.height = height;
        index = locationChosen;

    }

    public ZooRoom() {
    }

    public void addFood(Food[] addedFood){
        Collections.addAll(availableFood, addedFood);

        for (Animal anAnimalsInRoom : animalsInRoom) {
            if (anAnimalsInRoom.checkHungry()) {
                anAnimalsInRoom.reactToFood();
            }
        }
    }

    public void draw(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.RED);
            g.drawRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.BLACK);
    }

    public void addAnimal(Animal addedAnimal){
        animalsInRoom.add(addedAnimal);
    }

    public Point getIndex() {
        return index;
    }

    public void setIndex(int x, int y) {
        index= new Point(x,y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
