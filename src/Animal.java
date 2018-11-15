/*
* This class will manage the animals
* */
import java.awt.*;

public abstract class Animal {
    private String name;
    private int health;
    private int age;
    private Color color;

    public Animal() {
        health = 100;
        age = 0;
    }

    private boolean checkHungry(){
        if (health < 50){
            return true;
        } else {
            return false;
        }
    }

    protected void reactToFood(){
    }

    public void eat(){
        health = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
