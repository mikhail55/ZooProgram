import java.awt.*;
import java.util.ArrayList;

public class ZooManager {

    private ZooCell[][] zooSize;

    private ArrayList<ZooRoom> createdRooms;

    public ZooManager() {
        zooSize = new ZooCell[20][15];      //creating the game space
    }

    public void addRoom(ZooRoom addedRoom){

        createdRooms.add(addedRoom);       //adding the room

        for (int i = 0; i < addedRoom.getWidth(); i++){
            for (int j = 0; j < addedRoom.getHeight(); j++){
                setCellTaken(addedRoom.getIndex().x, addedRoom.getIndex().y);
            }
        }
    }

    //Check if the room is allowed to be created
    private boolean checkAllowed(ZooRoom selectedRoom){
        for (int i = 0; i<selectedRoom.getWidth(); i++){
            for (int j = 0; j<selectedRoom.getHeight(); j++){
                if (zooSize[selectedRoom.getIndex().x][selectedRoom.getIndex().y].isTaken()){
                    return false;
                }
            }
        }
        return true;
    }

    private void setCellTaken(int x, int y){
        zooSize[x][y].setTaken(true);
    }


}
