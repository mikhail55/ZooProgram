import java.awt.*;

/**
 * The Shop class is used to keep track of the portion on the right side of the panel
 * Its instance is created in GamePanel to keep track of the user input
 * This class allows the user to interact with the "zoo"(game board)
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */

public class Shop {

    /**
     * This enum is used to change and draw the different sections of the shop
     */
    enum currentScreen{
        MENU, ROOM, CARNIVORE, HERBIVORE, FOOD
    }
    private currentScreen selectedScreen;

    /**
     * Those arrays are used to demonstrate the animals to choose from
     */
    private Carnivore[] sampleCarnivores;
    private Herbivore[] sampleHerbivores;

    /**
     * This boolean indicates if a warning should be displayed
     */
    boolean warning;

    public Shop(){
        selectedScreen = currentScreen.MENU;

        sampleCarnivores = new Carnivore[3];
        /**
         * This code populates the arrays with sample animals in appropriate spots on the screen
         */
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
                    sampleHerbivores[i].setPosition(520, 250);
                    break;
                case 2:
                    sampleHerbivores[i] = new Herbivore(Herbivore.type.PANDA);
                    sampleHerbivores[i].setPosition(520, 350);
                    break;

            }
        }
    }

    /**
     * This method is used to draw the main menu section of the shop
     * @return Nothing
     * @param g This is the Graphics object used to draw
     */
    public void drawMenu(Graphics g){
        g.setColor(Color.BLACK);
        selectedScreen = currentScreen.MENU;
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.drawString("Buy a Room", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 350);
        g.drawString("Buy a Carnivore", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 380);
        g.drawString("Buy a Herbivore", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 410);
        g.drawString("Buy Food", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 440);
        g.drawString("Remove Dead Animals", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 470);
    }

    /**
     * This method is used to draw the room selection of the shop
     * @return Nothing
     * @param g This is the Graphics object used to draw
     */
    public void drawBuyRoom(Graphics g){
        g.setColor(Color.BLACK);
        selectedScreen = currentScreen.ROOM;
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.setColor(Color.GREEN);
        g.setFont(new Font("Header", Font.BOLD, 15));
        g.drawString("Select the left top corner", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 335);
        g.drawString("and the right bottom corner", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 355);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Header2", Font.BOLD, 20));
        g.drawString("One cell = 1 space", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 380);
        g.drawString("Cancel", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 410);
    }
    /**
     * This method is used to draw the Carnivore selection of the shop
     * @return Nothing
     * @param g This is the Graphics object used to draw
     * @param selectedAnimal This is the Animal that represents the current
     *                       selected animal of the player
     */
    public void drawBuyCarnivore(Graphics g, Animal selectedAnimal){
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.drawString("Current animal:", 515, 50);
        selectedAnimal.draw(g);
        for (Carnivore sampleCarnivore : sampleCarnivores) {
            sampleCarnivore.draw(g);
            sampleCarnivore.drawInfo(g);
        }
        g.drawString("Cancel", 520, 600);
    }
    /**
     * This method is used to draw the Herbivore selection of the shop
     * @return Nothing
     * @param g This is the Graphics object used to draw
     * @param selectedAnimal This is the Animal that represents the current
     *                       selected animal of the player
     */
    public void drawBuyHerbivore(Graphics g, Animal selectedAnimal){
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Current animal:", 515, 50);
        selectedAnimal.draw(g);
        for (Herbivore sampleHerbivore : sampleHerbivores) {
            sampleHerbivore.draw(g);
            sampleHerbivore.drawInfo(g);
        }
        g.drawString("Cancel", 520, 600);
    }

    /**
     * This method is used to draw the Carnivore selection of the shop
     * @return Nothing
     * @param g This is the Graphics object used to draw
     * @param selectedFood This is the parameter that shows the current
     *                     food type selected by the player
     */
    public void drawBuyFood(Graphics g, boolean selectedFood){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Header", Font.BOLD, 20));
        g.drawString("Current food:", 515, 50);
        if (selectedFood){
            g.drawString("Herbivore", 650, 50);
        } else {
            g.drawString("Carnivore", 650, 50);
        }
        g.drawString("Buy Herbivore food", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 350);
        g.drawString("Buy Carnivore food", ZooManager.width * ZooCell.sideSize + 10, ZooManager.height + 380);

    }
    /**
     * Draws the warning to the player if the animals are hungry
     * @param g Graphics object, used for drawing
     */
    public void drawWarning(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Header", Font.BOLD, 25));
        g.drawString("!One or more", 505, 650);
        g.drawString("animals are hungry", 505, 670);
    }

    public currentScreen getSelectedScreen() { return selectedScreen; }

    public void setSelectedScreen(currentScreen selectedScreen) {
        this.selectedScreen = selectedScreen;
    }
}
