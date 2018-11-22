public class AnimalFactory {

    public AnimalFactory() {
    }

    private Animal createLion(String name){
        return new Carnivore(Carnivore.type.LION, name);
    }

    private Animal createPanther(String name){
        return new Carnivore(Carnivore.type.PANTHER, name);
    }

    private Animal createWolf(String name){
        return new Carnivore(Carnivore.type.WOLF, name);
    }

    private Animal createPanda(String name){
        return new Herbivore(Herbivore.type.PANDA, name);
    }

    private Animal createHorse(String name){
        return new Herbivore(Herbivore.type.HORSE, name);
    }

    private Animal createMonkey(String name){
        return new Herbivore(Herbivore.type.MONKEY, name);
    }
}
