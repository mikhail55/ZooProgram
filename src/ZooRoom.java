import java.awt.*;
import java.util.ArrayList;

public class ZooRoom{
    private int width,height;             //width and height of the room in ZooCells
    private int availableSpace;
    private Point index;                  //location of the room in the zoo
    private ArrayList<Animal> animalsInRoom;
    private int xBoundary, yBoundary;

    ZooRoom(int width, int height, Point locationChosen) {
        this.width = width;
        this.height = height;
        index = locationChosen;
        animalsInRoom = new ArrayList<>();
        availableSpace = width * height;
        xBoundary = index.x * ZooCell.sideSize;
        yBoundary = index.y * ZooCell.sideSize;

    }

    public ZooRoom() {
    }

    public void draw(Graphics g){
            g.setColor(Color.GREEN);
            g.fillRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.RED);
            g.drawRect(index.x * ZooCell.sideSize, index.y * ZooCell.sideSize, width * ZooCell.sideSize, height* ZooCell.sideSize);
            g.setColor(Color.BLACK);
            drawAnimals(g);
    }

    public void addAnimal(Animal addedAnimal){
        addedAnimal.setPosition((index.x * ZooCell.sideSize), (index.y * ZooCell.sideSize));
        System.out.println(addedAnimal.getPosition().x);
        System.out.println(addedAnimal.getPosition().y);
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

    public int getHeight() {
        return height;
    }

    public int getAvailableSpace() { return availableSpace; }

    public void setAvailableSpace(int availableSpace) { this.availableSpace = availableSpace; }

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
}
