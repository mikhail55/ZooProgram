public class ZooCell{
    private int x,y;
    private int sideSize;
    private boolean isTaken;

    public ZooCell(){
        sideSize = 50;
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

    public int getSideSize() {
        return sideSize;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}