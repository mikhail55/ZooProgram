public class Food {
    enum type{
        CARNIVORE, HERBIVORE
    }
    private type typeOfFood;

    public Food(type typeOfFood){
        this.typeOfFood = typeOfFood;
    }

    public type getTypeOfFood() {
        return typeOfFood;
    }
}
