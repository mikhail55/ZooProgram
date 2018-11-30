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
        for (ZooCell[] ZooSize : zooSize) {
            for (ZooCell aZooSize : ZooSize) {
                aZooSize.draw(g);
            }
        }
        for (ZooRoom createdRoom : createdRooms) {
            createdRoom.draw(g);
        }
        }

    public ArrayList<ZooRoom> getCreatedRooms() {
        return createdRooms;
    }
    public void addAnimal(Animal addedAnimal, int roomId){
        createdRooms.get(roomId).addAnimal(addedAnimal);
    }
    public boolean checkPlacementAvailability(Animal checkAnimal, int roomId){
        if (createdRooms.get(roomId).getAvailableSpace() < checkAnimal.getSpace()){
            return false;
        }
        createdRooms.get(roomId).setAvailableSpace(createdRooms.get(roomId).getAvailableSpace() - checkAnimal.getSpace());
        return true;
    }
}
