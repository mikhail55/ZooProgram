/**
 * The AnimalFactory class is used to create Animals of different Classes
 * with one object
 * This class also helps to not use 'new' in the code and is used to perform
 * dependency injection in GamePanel class
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */
public class AnimalFactory {
    public AnimalFactory() {
    }

    /**
     * Different method is written for each type of Animal(Herbivores and Carnivores)
     * @return Animal this is the Animal that was created
     */
    public Animal createLion(){ return new Carnivore(Carnivore.type.LION); }

    public Animal createPanther(){
        return new Carnivore(Carnivore.type.PANTHER);
    }

    public Animal createWolf(){
        return new Carnivore(Carnivore.type.WOLF);
    }

    public Animal createPanda(){ return new Herbivore(Herbivore.type.PANDA); }

    public Animal createHorse(){
        return new Herbivore(Herbivore.type.HORSE);
    }

    public Animal createMonkey(){
        return new Herbivore(Herbivore.type.MONKEY);
    }
}
