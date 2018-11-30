import java.awt.*;
import java.util.ArrayList;
/**
 * The ZooRoom class is used to manage and create rooms inside the zoo
 * It also keeps track of the room position within the zoo and on the screen
 * This class is also used to place animals into different rooms in the zoo
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */
public class ZooRoom{
    /**
     * width and height of the room in ZooCells
     */
    private int width,height;
    /**
     * max space for animals in the room
     */
    private int availableSpace;
    /**
     * location of the room in the zoo
     */
    private Point index;
    /**
     * List of all Animals in the room
     */
    private ArrayList<Animal> animalsInRoom;
    /**
     * Boundary of the room on the screen
     */
    private int xBoundary, yBoundary;

    /**
     * Basic constructor
     * @param width width of the room in ZooCells
     * @param height height of the room in ZooCells
     * @param locationChosen location of the room in the zoo
     */
    ZooRoom(int width, int height, Point locationChosen) {
        this.width = width;
        this.height = height;
        index = locationChosen;
        animalsInRoom = new ArrayList<>();
        availableSpace = width * height;
        xBoundary = index.x * ZooCell.sideSize;
        yBoundary = index.y * ZooCell.sideSize;

    }

    /**
     * This method is used for drawing the room on the screen
     * @return Nothing
     * @param g Graphics object that is used for drawing
     */
    public void draw(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.RED);
            g.drawRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.BLACK);
            drawAnimals(g);
    }

    /**
     * This method is used for adding a selected Animal into the room
     * @return Nothing
     * @param addedAnimal this Animal is added into the room
     */
    public void addAnimal(Animal addedAnimal){
        addedAnimal.setPosition((index.x * ZooCell.sideSize) + 7, (index.y * ZooCell.sideSize) + 5);
        System.out.println(addedAnimal.getPosition().x);
        System.out.println(addedAnimal.getPosition().y);
        animalsInRoom.add(addedAnimal);

    }

    /**
     * This method is used to draw and update all Animals in the room
     * @return Nothing
     * @param g Graphics object that is used for drawing
     */
    private void drawAnimals(Graphics g){
        for (int i = 0; i < animalsInRoom.size(); i++){
            if (animalsInRoom.get(i).position.x + animalsInRoom.get(i).getxSpeed() < xBoundary||animalsInRoom.get(i).position.x + animalsInRoom.get(i).getxSpeed() + animalsInRoom.get(i).getSize() > xBoundary + (width * ZooCell.sideSize)){
                animalsInRoom.get(i).setxSpeed(-animalsInRoom.get(i).getxSpeed());
            }
            if (animalsInRoom.get(i).position.y + animalsInRoom.get(i).getySpeed() < yBoundary||animalsInRoom.get(i).position.y + animalsInRoom.get(i).getySpeed() + animalsInRoom.get(i).getSize() > yBoundary + (height * ZooCell.sideSize)){
                animalsInRoom.get(i).setySpeed(-animalsInRoom.get(i).getySpeed());
            }
            animalsInRoom.get(i).update();
            animalsInRoom.get(i).draw(g);
        }
    }

    public Point getIndex() { return index; }

    public ArrayList<Animal> getAnimalsInRoom() { return animalsInRoom; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public int getAvailableSpace() { return availableSpace; }

    public void setAvailableSpace(int availableSpace) { this.availableSpace = availableSpace; }
}
