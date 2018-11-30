import java.awt.*;

/**
 * The ZooCell class is used to make up the zoo itself
 * It keeps track of its own location in the room and whether this cell was already taken for a Room
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */
public class ZooCell{
    /**
     * Indicates the location in the zoo
     */
    private int x,y;
    /**
     * Indicates if this cell is already used in a room
     */
    private boolean isTaken;
    /**
     * This value is used to convert from the x and y coordinates of the zoo to pixels
     */
    public static final int sideSize = 50;

    ZooCell(){
    }

    /**
     * This method is used to draw the cell on the screen
     * @return Nothing
     * @param g Graphics object that is used for drawing
     */
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(y * sideSize,x * sideSize,sideSize,sideSize);
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public boolean isTaken() { return isTaken; }

    public void setTaken(boolean taken) { isTaken = taken; }
}