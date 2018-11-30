import java.awt.*;
/**
 * The Animal abstract class is used to represent the Animals in the zoo
 * It keeps track of all the variables related to the Animal
 * Such as position on the screen, how much space it takes and
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */

public abstract class Animal {
    /**
     * Those variables are used to keep track of the health of the animal
     */
    private int health;
    /**
     * Those variables are used to keep track of the position on the screen
     */
    private Color color;
    protected Point position;
    private int size;
    private int xSpeed, ySpeed;
    /**
     * This variable indicates how much space an Animal takes in room
     */
    private int space;


    public Animal() {
        health = 1000;
    }

    /**
     * This method restores the Animal's health
     * @return Nothing
     */
    public void eat(){ }

    /**
     * This method checks if the Animal is hungry
     * @return boolean returns the result of the check
     */
    public boolean isHungry(){
        return false;
    }
    /**
     * Checks if the animal is dead
     * @return returns boolean as the result
     */
    public boolean checkDead(){
        if (getHealth()==0){
            return true;
        }
        return false;
    }

    /**
     * This method draws the Animal
     * @return Nothing
     * @param g Graphics object that is used for drawing
     */
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(position.x,position.y,size,size);
    }

    /**
     * This method is used to update the Animal's position on the screen
     * @return Nothing
     */
    public void update(){
        position.x += xSpeed;
        position.y += ySpeed;
    }

    public void drawInfo(Graphics g){}

    public int getSize() { return size; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public void setColor(Color color) { this.color = color; }

    public int getSpace() { return space; }

    public void setSpace(int space) { this.space = space; }

    public void setSize(int size) { this.size = size; }

    public void setPosition(int x, int y){ position = new Point(x,y); }

    public Point getPosition(){ return position; }

    public int getxSpeed() { return xSpeed; }

    public void setxSpeed(int xSpeed) { this.xSpeed = xSpeed; }

    public int getySpeed() { return ySpeed; }

    public void setySpeed(int ySpeed) { this.ySpeed = ySpeed; }

    public boolean getType(){ return false; }
}

