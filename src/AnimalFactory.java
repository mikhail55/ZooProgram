public class AnimalFactory {

    public AnimalFactory() {
    }

    public Animal createLion(){ return new Carnivore(Carnivore.type.LION); }

    public Animal createPanther(){
        return new Carnivore(Carnivore.type.PANTHER);
    }

    public Animal createWolf(){
        return new Carnivore(Carnivore.type.WOLF);
    }

    public Animal createPanda(){
        return new Herbivore(Herbivore.type.PANDA);
    }

    public Animal createHorse(){
        return new Herbivore(Herbivore.type.HORSE);
    }

    public Animal createMonkey(){
        return new Herbivore(Herbivore.type.MONKEY);
    }
}
