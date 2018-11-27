import java.awt.*;

public class ZooCell{
    private int x,y;
    private boolean isTaken;
    public static final int sideSize = 50;

    protected ZooCell(){
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(y * sideSize,x * sideSize,sideSize,sideSize);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}