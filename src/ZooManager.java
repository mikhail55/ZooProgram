import java.awt.*;
import java.util.ArrayList;
/**
 * The ZooManager class represents the Zoo itself and performs most of the logic
 * of the zoo
 * It also serves as the middle-ground between the smallest Objects and the user/GamePanel
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */

public class ZooManager {

    /**
     * This is the space for the zoo
     */
    private ZooCell[][] zooSize;

    /**
     * This Object keeps track of all the rooms within the zoo
     */
    private ArrayList<ZooRoom> createdRooms;

    /**
     * Those variables are the dimensions of the zoo in ZooCells
     */
    public static final int height = 15;
    public static final int width = 10;

    public ZooManager() {
        /**
         * This is the game space
         */
        zooSize = new ZooCell[width][height];


        /**
         * Sets up coordinates for every cell/ Fills the array of ZooCells
         */
        for (int i =0; i < zooSize.length; i++){
            for (int j = 0; j<zooSize[i].length; j++){
                zooSize[i][j] = new ZooCell();
                zooSize[i][j].setX(j);
                zooSize[i][j].setY(i);
            }
        }
        createdRooms = new ArrayList<>();
    }

    /**
     * This method is used to add defined rooms into the List of Rooms in the zoo
     * @return Nothing
     * @param addedRoom this param is used to create the room in the exact coordinates
     */
    public void addRoom(ZooRoom addedRoom){

        createdRooms.add(addedRoom);

        /**
         * Sets the cells of the room to 'Taken' status
         */
        for (int i = 0; i < addedRoom.getWidth(); i++){
            for (int j = 0; j < addedRoom.getHeight(); j++){
                setCellTaken(addedRoom.getIndex().x + i, addedRoom.getIndex().y + j);
            }
        }
    }

    /**
     * This method checks all the cells within the room and if they were taken already
     * @param selectedRoom room to check
     * @return boolean returns if the room is allowed to be created
     */
    public boolean checkCreationAllowed(ZooRoom selectedRoom){
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

    /**
     * This method sets the cell in the particular coordinate in the zoo to 'Taken' status
     * @return Nothing
     * @param x int is the x - coordinate of the cell
     * @param y int is the y - coordinate of the cell
     */
    private void setCellTaken(int x, int y){ zooSize[x][y].setTaken(true); }

    /**
     * This method draws the whole zoo
     * @return Nothing
     * @param g Graphics object used for drawing
     */
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

    /**
     * This method checks if the space of the Animal is equal to or smaller than the space left in the room
     * @param checkAnimal this object is used to take the space of the Animal
     * @param roomId this object is used to check the space available in room
     * @return boolean is used to return if the placement is allowed or not
     */
    public boolean checkPlacementAvailability(Animal checkAnimal, int roomId){
        if (createdRooms.get(roomId).getAvailableSpace() < checkAnimal.getSpace()){
            return false;
        }
        createdRooms.get(roomId).setAvailableSpace(createdRooms.get(roomId).getAvailableSpace() - checkAnimal.getSpace());
        return true;
    }

    /**
     * This method checks all the Animals in the zoo and if they are hungry
     * @return returns the result of the check
     */
    public boolean checkIfHungry(){
        for (int i = 0; i < createdRooms.size(); i++){
            for (int j = 0; j < createdRooms.get(i).getAnimalsInRoom().size(); j++){
                if (createdRooms.get(i).getAnimalsInRoom().get(j).isHungry()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is keeping track if there are any hungry anymals
     * @return Nothing
     */
    public void checkHungry(){
        for (int i = 0; i < createdRooms.size(); i++){
            for (int j = 0; j < createdRooms.get(i).getAnimalsInRoom().size(); j++){
                createdRooms.get(i).getAnimalsInRoom().get(j).isHungry();
            }
        }
    }

    /**
     * This method is used to clear all dead Animals from the zoo
     * @return Nothing
     */
    public void clearDead(){
        for (int i = 0; i < createdRooms.size(); i++){
            for (int j = 0; j < createdRooms.get(i).getAnimalsInRoom().size(); j++){
                /**
                 * Checks if any of the anymals are dead
                 */
                if (createdRooms.get(i).getAnimalsInRoom().get(j).checkDead()){
                    /**
                     * If a dead animal is found it is removed from the room and the space is added back to the room
                     */
                    createdRooms.get(i).setAvailableSpace(createdRooms.get(i).getAvailableSpace() + createdRooms.get(i).getAnimalsInRoom().get(j).getSpace());
                    createdRooms.get(i).getAnimalsInRoom().remove(j);
                }
            }
        }
    }

    public ArrayList<ZooRoom> getCreatedRooms() { return createdRooms; }

    public void addAnimal(Animal addedAnimal, int roomId){ createdRooms.get(roomId).addAnimal(addedAnimal); }
}

