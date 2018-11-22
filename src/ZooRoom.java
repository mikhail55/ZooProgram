import java.awt.*;

public class ZooRoom{
    private int width,height;           //width and height of the room in ZooCells
    ZooCell[][] takenCells;                  //location of the room in the zoo
    Animal[] animalsInRoom;

    public ZooRoom(int width, int height) {
        this.width = width;
        this.height = height;

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
