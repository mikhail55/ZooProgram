/*
* This class will manage the animals
* */
import java.awt.*;

public abstract class Animal {
    protected int health;
    protected int age;
    protected Color color;
    protected Point position;
    protected int size;
    protected int price;
    protected int income;
    protected int space;

    public Animal() {
        health = 100;
        age = 0;
    }

    public boolean checkHungry(){
        return health < 50;
    }

    public void reactToFood(){
    }

    public void eat(){
        health = 100;
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(position.x,position.y,size,size);
    }

    public void drawInfo(Graphics g){
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setPosition(int x, int y){
        position = new Point(x,y);
    }
    public Point getPosition(){
        return position;
    }
}

