import java.awt.*;

public class Shop {

    enum currentScreen{
        MENU, ROOM, CARNIVORE, HERBIVORE
    }
    private currentScreen selectedScreen;

    private int balance;

    private Carnivore[] sampleCarnivores;
    private Herbivore[] sampleHerbivores;

    public Shop(){
        selectedScreen = currentScreen.MENU;
        balance = 500;
        sampleCarnivores = new Carnivore[3];
        for (int i = 0; i < sampleCarnivores.length; i++){
            switch (i){
                case 0:
                    sampleCarnivores[i] = new Carnivore(Carnivore.type.WOLF);
                    sampleCarnivores[i].setPosition(520, 150);
                    break;
                case 1:
                    sampleCarnivores[i] = new Carnivore(Carnivore.type.PANTHER);
                    sampleCarnivores[i].setPosition(520, 250);
                    break;
                case 2:
                    sampleCarnivores[i] = new Carnivore(Carnivore.type.LION);
                    sampleCarnivores[i].setPosition(520, 350);
                    break;
            }
        }
        sampleHerbivores = new Herbivore[3];
        for (int i = 0; i<sampleHerbivores.length; i++){
            switch (i){
                case 0:
                    sampleHerbivores[i] = new Herbivore(Herbivore.type.MONKEY);
                    sampleHerbivores[i].setPosition(520, 150);
                    break;
                case 1:
                    sampleHerbivores[i] = new Herbivore(Herbivore.type.HORSE);
                    sampleHerbivores[i].setPosition(520, 350);
                    break;
                case 2:
                    sampleHerbivores[i] = new Herbivore(Herbivore.type.PANDA);
                    sampleHerbivores[i].setPosition(520, 450);
                    break;

            }
        }
    }

    public void drawMenu(Graphics g){
        selectedScreen = currentScreen.MENU;
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.drawString("Your balance is: " + balance +"$", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 20);
        g.drawString("Buy a Room", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 350);
        g.drawString("Buy a Carnivore", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 380);
        g.drawString("Buy a Herbivore", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 410);
    }

    public void drawBuyRoom(Graphics g){
        selectedScreen = currentScreen.ROOM;
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.drawString("Your balance is: " + balance +"$", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 20);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Header", Font.BOLD, 15));
        g.drawString("Select the left top corner", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 335);
        g.drawString("and the right bottom corner", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 355);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Header2", Font.BOLD, 20));
        g.drawString("One cell = 10$", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 380);
        g.drawString("Cancel", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 410);
    }

    public void drawBuyCarnivore(Graphics g){
        g.setFont(new Font("Header", Font.BOLD, 20));
        for (Carnivore sampleCarnivore : sampleCarnivores) {
            sampleCarnivore.draw(g);
            sampleCarnivore.drawInfo(g);
        }
        g.drawString("Cancel", 520, 600);
    }

    public currentScreen getSelectedScreen() {
        return selectedScreen;
    }

    public void setSelectedScreen(currentScreen selectedScreen) {
        this.selectedScreen = selectedScreen;
    }
}
