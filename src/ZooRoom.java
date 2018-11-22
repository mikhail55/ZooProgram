import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ZooRoom{
    private int width,height;             //width and height of the room in ZooCells
    private Point index;                  //location of the room in the zoo
    ArrayList<Animal> animalsInRoom;
    ArrayList<Food> availableFood;

    public ZooRoom(int width, int height, Point locationChosen) {
        this.width = width;
        this.height = height;
        index = locationChosen;

    }

    public void addFood(Food[] addedFood){
        Collections.addAll(availableFood, addedFood);

        for (Animal anAnimalsInRoom : animalsInRoom) {
            if (anAnimalsInRoom.checkHungry()) {
                anAnimalsInRoom.reactToFood();
            }
        }
    }

    public void addAnimal(Animal addedAnimal){
        animalsInRoom.add(addedAnimal);
    }

    public Point getIndex() {
        return index;
    }

    public void setIndex(Point index) {
        this.index = index;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
