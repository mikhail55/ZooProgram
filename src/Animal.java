/*
* This class will manage the animals
* */
import java.awt.*;

public abstract class Animal {
    protected int health;
    protected int age;
    private Color color;
    protected Point position;
    private int size;
    protected int price;
    private int income;
    int space;
    private int xSpeed, ySpeed;

    public Animal() {
        health = 100;
        age = 0;
    }

    public void eat(){
        health = 100;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(position.x,position.y,size,size);
    }

    public void update(){
        position.x += xSpeed;
        position.y += ySpeed;
    }

    public void drawInfo(Graphics g){}

    public int getSize() { return size; }

    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getSpace() { return space; }

    public void setSpace(int space) { this.space = space; }

    public int getIncome() { return income; }

    public void setIncome(int income) { this.income = income; }

    public void setSize(int size) { this.size = size; }

    public void setPosition(int x, int y){ position = new Point(x,y); }

    public Point getPosition(){ return position; }

    public int getxSpeed() { return xSpeed; }

    public void setxSpeed(int xSpeed) { this.xSpeed = xSpeed; }

    public int getySpeed() { return ySpeed; }

    public void setySpeed(int ySpeed) { this.ySpeed = ySpeed; }
}

