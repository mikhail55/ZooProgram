import java.awt.*;

public class ZooManager {

    private ZooCell[][] zooSize;

    private ZooRoom[] createdRooms;

    public ZooManager() {
        zooSize = new ZooCell[20][15];      //creating the "game board"
    }

    public void addRoom(ZooRoom addedRoom, Point selectedPoint1, Point selectedPoint2){

        ZooRoom[] newArray = new ZooRoom[createdRooms.length + 1];

        for (int i = 0; i < newArray.length; i++){
            if (i == newArray.length - 1){
                newArray[i] = addedRoom;
            } else {
                newArray[i] = createdRooms[i];
                createdRooms[i].setWidth(selectedPoint2.x - selectedPoint1.x);
                createdRooms[i].setHeight(selectedPoint2.y - selectedPoint1.y);
            }
        }
    }

    private boolean checkTaken(int x, int y, int width, int height){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if(zooSize[x][y].isTaken()){
                    return true;
                }
            }
        }
        return false;
    }

    private void setCellTaken(int x, int y){
        zooSize[x][y].setTaken(true);
    }


}
