import java.awt.*;
import java.util.ArrayList;

public class ZooManager {

    private ZooCell[][] zooSize;

    private ArrayList<ZooRoom> createdRooms;

    public static final int height = 15;
    public static final int width = 10;

    public ZooManager() {
        zooSize = new ZooCell[width][height];      //creating the game space


        //setting up the coordinates for every cell
        for (int i =0; i < zooSize.length; i++){
            for (int j = 0; j<zooSize[i].length; j++){
                zooSize[i][j] = new ZooCell();
                zooSize[i][j].setX(j);
                zooSize[i][j].setY(i);
            }
        }
        createdRooms = new ArrayList<>();
    }

    public void addRoom(ZooRoom addedRoom){

        if (addedRoom.getWidth() < 0){
            addedRoom.setWidth(-addedRoom.getWidth());
            addedRoom.setIndex(addedRoom.getIndex().x - addedRoom.getWidth(), addedRoom.getIndex().y);
        }
        if (addedRoom.getHeight() < 0){
            addedRoom.setHeight(-addedRoom.getHeight());
            addedRoom.setIndex(addedRoom.getIndex().x, addedRoom.getIndex().y-addedRoom.getHeight());
        }

        createdRooms.add(addedRoom);       //adding a room

        for (int i = 0; i < addedRoom.getWidth(); i++){
            for (int j = 0; j < addedRoom.getHeight(); j++){
                setCellTaken(addedRoom.getIndex().x + i, addedRoom.getIndex().y + j);
            }
        }
    }

    //Check if the room is allowed to be created
    public boolean checkAllowed(ZooRoom selectedRoom){
        for (int i = 0; i<selectedRoom.getWidth(); i++){
            for (int j = 0; j<selectedRoom.getHeight(); j++){
                System.out.println(zooSize[selectedRoom.getIndex().x+i][selectedRoom.getIndex().y+j].isTaken());
                if (zooSize[selectedRoom.getIndex().x+i][selectedRoom.getIndex().y+j].isTaken()){
                    return false;
                }
            }
        }
        return true;
    }

    private void setCellTaken(int x, int y){
        zooSize[x][y].setTaken(true);
    }

    public void draw(Graphics g){
        for (ZooCell[] aZooSize : zooSize) {
            for (int j = 0; j < aZooSize.length; j++) {
                aZooSize[j].draw(g);
            }
        }
        for (ZooRoom createdRoom : createdRooms) {
            createdRoom.draw(g);
        }
        }
}
