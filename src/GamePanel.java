import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * This class is used to create an actual JPanel on which the game is drawn
 * Also used to keep track of the user input(mouse)
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */

public class GamePanel extends JPanel{
    /**
     * This Object is representing the zoo itself
     */
  ZooManager gameZoo;

    /**
     * This Object is used to control the side panel
     */
 private Shop gameShop;

    /**
     * Those Objects are used to keep track of player
     * selections and where/when to put them
     */
 private Point selectedFirstPoint, selectedSecondPoint;

 private Animal selectedAnimal;

 private boolean selectedFood;

    /**
     * This Object is used to create Animals in the panel
     */
 private AnimalFactory animalCreator;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    GamePanel() {
        gameZoo = new ZooManager();
        gameShop = new Shop();
        animalCreator = new AnimalFactory();
        /**
         * This code sets the dimensions of the panel on the screen, according
         * to the size of the zoo in ZooCells, using the converter number
         */
        Dimension preferredDimension = new Dimension(ZooCell.sideSize * gameZoo.width + 255, ZooCell.sideSize * gameZoo.height);
        setPreferredSize(preferredDimension);
        /**
         * Keeps track of user's input
         */
        addMouseListener(new MouseTracker());
    }


    /**
     * This method is used for drawing the zoo + side panel
     * @param g Graphics object used for drawing
     */
    public void paintComponent(Graphics g){
        gameZoo.draw(g);

        gameZoo.checkHungry();
        if (gameZoo.checkIfHungry()){
            gameShop.drawWarning(g);
        }
        /**
         * Draws the elements of the side panel, according to
         * the screen that the user selected in the shop
         */
        switch (gameShop.getSelectedScreen()){
            case MENU:
                gameShop.drawMenu(g);
                break;
            case ROOM:
                gameShop.drawBuyRoom(g);
                break;
            case CARNIVORE:
                if (selectedAnimal == null){
                    selectedAnimal = animalCreator.createWolf();
                }
                selectedAnimal.setPosition(515,55);
                gameShop.drawBuyCarnivore(g, selectedAnimal);
                break;
            case HERBIVORE:
                if (selectedAnimal == null){
                    selectedAnimal = animalCreator.createMonkey();
                }
                selectedAnimal.setPosition(515,55);
                gameShop.drawBuyHerbivore(g,selectedAnimal);
                break;
            case FOOD:
                gameShop.drawBuyFood(g, selectedFood);
                break;
        }
    }

    private class MouseTracker implements MouseListener{
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e mouse event of the action happening
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            /**
             * If the player is in the main menu screen
             * moves him to other screens , in accordance with the button
             * that the player pressed
             */
            if (gameShop.getSelectedScreen() == Shop.currentScreen.MENU){
                if (clickedButton1(e)){
                    gameShop.setSelectedScreen(Shop.currentScreen.ROOM);
                } else if (clickedButton2(e)){
                    gameShop.setSelectedScreen(Shop.currentScreen.CARNIVORE);
                } else if (clickedButton3(e)){
                    gameShop.setSelectedScreen(Shop.currentScreen.HERBIVORE);
                } else if (clickedFood(e)){
                    gameShop.setSelectedScreen(Shop.currentScreen.FOOD);
                } else if (clickedClear(e)){
                    gameZoo.clearDead();
                }
            }
            /**
             * If the player chose to select the room, shows him the appropriate
             * screen for that
             */
            else if (gameShop.getSelectedScreen() == Shop.currentScreen.ROOM){
                 if (clickedWithinGameBoard(e)){
                     /**
                      * If the player clicked within the zoo cells
                      * and the player did not choose the point beforehand
                      * sets the first coordinate for the room inside the zoo
                      */
                     if (selectedFirstPoint == null) {
                         selectedFirstPoint = new Point();
                         selectedFirstPoint.setLocation(e.getX() / ZooCell.sideSize, e.getY() / ZooCell.sideSize);
                     }
                     /**
                      * if the player already has the first point
                      * selected, chooses the second coordinate
                      * for the room inside the zoo
                      */
                     else if (selectedSecondPoint == null){
                         selectedSecondPoint = new Point();
                         selectedSecondPoint.setLocation(e.getX() / ZooCell.sideSize, e.getY() / ZooCell.sideSize);
                         /**
                          * The player is only allowed to select the top left corner as the first coordinate
                          * and the bottom right corner as the second coordinate, so if the two points selected do
                          * not follow those rules, resets the side bar, giving error message into console
                          */
                         if(selectedSecondPoint.x < selectedFirstPoint.x){
                             System.out.println("Unallowed point location");
                             resetScreen();
                             return;
                         } else if (selectedSecondPoint.y < selectedFirstPoint.y){
                             System.out.println("Unallowed point location");
                             resetScreen();
                             return;
                         }
                         /**
                          * If the two points follow the rules, saves the room into selection
                          */
                         ZooRoom selectedRoom = new ZooRoom(selectedSecondPoint.x - selectedFirstPoint.x+1 , selectedSecondPoint.y - selectedFirstPoint.y+1, selectedFirstPoint);

                         /**
                          * After checking if the room is allowed to be created
                          * (does not have any cells that were previously taken by
                          * another room) adds the room to the zoo
                          */
                         if (gameZoo.checkCreationAllowed(selectedRoom)){
                             gameZoo.addRoom(selectedRoom);
                             resetScreen();

                         }
                         /**
                          * If the cells were indeed used by other room, resets the side bar,
                          * printing an error message into the console
                          */
                         else {
                             System.out.println("Unallowed location");
                             resetScreen();
                         }
                     }
                }
                /**
                 * If the player clicked on "cancel" button, goes back to menu
                 */
                if (clickedButton3(e)){
                    gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                }
            }
            /**
             * If the player chose to select a Carnivore for a room,
             * takes him to the appropriate screen
             */
            else if (gameShop.getSelectedScreen() == Shop.currentScreen.CARNIVORE){
                /**
                 * Marks the top most Animal as the selection
                 */
                if (clickedAnimal1(e)){
                    selectedAnimal = animalCreator.createWolf();
                }
                /**
                 * Marks the middle Animal as the selection
                 */
                else if (clickedAnimal2(e)){
                    selectedAnimal = animalCreator.createPanther();
                }
                /**
                 * Marks the bottom Animal as the selection
                 */
                else if (clickedAnimal3(e)){
                    selectedAnimal = animalCreator.createLion();
                }
                /**
                 * If the player clicked on "cancel" button, goes back to menu
                 */
                else if (clickedCancelAnimal(e)){
                    resetScreen();
                }
                /**
                 * Checks if the player clicked onto a room with his selection
                 */
                else if(clickedWithinGameBoard(e)){
                    for (int i = 0; i <gameZoo.getCreatedRooms().size(); i++){
                        /**
                         * If the player did click on the room and it has space for the Animal,
                         * adds it to the room
                         */
                        if (checkHitRoom(i, e.getX(), e.getY()) && gameZoo.checkPlacementAvailability(selectedAnimal,i)){
                            gameZoo.addAnimal(selectedAnimal, i);
                            resetScreen();
                        }
                    }
                }
            }
            /**
             * Same as for Carnivore, but different Animals
             */
            else if (gameShop.getSelectedScreen() == Shop.currentScreen.HERBIVORE){
                if (clickedAnimal1(e)){
                    selectedAnimal = animalCreator.createMonkey();
                } else if (clickedAnimal2(e)){
                    selectedAnimal = animalCreator.createHorse();
                } else if (clickedAnimal3(e)){
                    selectedAnimal = animalCreator.createPanda();
                } else if (clickedCancelAnimal(e)){
                    resetScreen();
                } else if(clickedWithinGameBoard(e)){
                    for (int i = 0; i <gameZoo.getCreatedRooms().size(); i++){
                        if (checkHitRoom(i, e.getX(), e.getY()) && gameZoo.checkPlacementAvailability(selectedAnimal,i)){
                            gameZoo.addAnimal(selectedAnimal, i);
                            resetScreen();
                        }
                    }
                }
            }
            /**
             * If the player clicked on the food selection, takes him to the appropriate screen
             */
            else if (gameShop.getSelectedScreen() == Shop.currentScreen.FOOD){
                /**
                 * If the player clicked top button, sets the choice to Herbivore
                 */
                if (clickedButton1(e)){
                    selectedFood = true;
                }
                /**
                 * If the player clicked bottom button, sets the choice to Carnivore
                 */
                else if (clickedButton2(e)){
                    selectedFood = false;
                }
                /**
                 * If the player clicked on "cancel" button, goes back to menu
                 */
                else if (clickedButton3(e)){
                    resetScreen();
                }
                /**
                 * If the player clicked onto a room, feeds the appropriate Animals
                 * with the food selected(Carnivores - Carnivore food, Herbivores - Herbivore food)
                 */
                else if (clickedWithinGameBoard(e)){
                    for (int i = 0; i <gameZoo.getCreatedRooms().size(); i++){
                        if (checkHitRoom(i, e.getX(), e.getY())){
                           for (int j = 0; j < gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().size(); j++){
                               if (gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().get(j).getType() && selectedFood){
                                   gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().get(j).eat();
                               } else if (!gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().get(j).getType() && !selectedFood){
                                   gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().get(j).eat();
                               }
                           }
                            resetScreen();
                        }
                    }
                }
            }
        }

        /**
         * This method is used to check if the player hit the room with a click
         * @param roomIndex this param is used to determine the room index
         * @param x this param is used to determine the x - coordinate of the click
         * @param y this param is used to determine the y - coordinate of the click
         * @return boolean is returned, indicating whether the boundaries of the room were hit
         */
        private boolean checkHitRoom(int roomIndex, int x, int y){
            return gameZoo.getCreatedRooms().get(roomIndex).getIndex().x * ZooCell.sideSize < x && (gameZoo.getCreatedRooms().get(roomIndex).getIndex().x + gameZoo.getCreatedRooms().get(roomIndex).getWidth()) * ZooCell.sideSize > x && gameZoo.getCreatedRooms().get(roomIndex).getIndex().y * ZooCell.sideSize < y && (gameZoo.getCreatedRooms().get(roomIndex).getIndex().y + gameZoo.getCreatedRooms().get(roomIndex).getHeight()) * ZooCell.sideSize > y;
        }

        /**
         * Checks if the player clicked a specific area of the screen
         * @param e Mouse event that triggered
         * @return boolean is returned, whether the boundaries of location were hit
         */
        private boolean clickedButton1(MouseEvent e){
           return e.getX() >= 509 && e.getX() < 680 && e.getY() > 350 && e.getY()<370;
        }

        private boolean clickedButton2(MouseEvent e){
            return e.getX() >= 509 && e.getX() < 680 && e.getY() > 372 && e.getY()<410;
        }

        private boolean clickedButton3(MouseEvent e){
            return e.getX() >= 509 && e.getX() < 680 && e.getY() > 410 && e.getY()<440;
        }

        private boolean clickedAnimal1(MouseEvent e){
            return e.getX() > 515 && e.getX() < 745 && e.getY() > 130 && e.getY() < 205;
        }
        private boolean clickedAnimal2(MouseEvent e){
            return e.getX() > 515 && e.getX() < 745 && e.getY() > 220 && e.getY() < 305;
        }
        private boolean clickedAnimal3(MouseEvent e){
            return e.getX() > 515 && e.getX() < 745 && e.getY() > 320 && e.getY()  < 425;
        }

        private boolean clickedCancelAnimal(MouseEvent e){
            return e.getX() > 515 && e.getX() < 745 && e.getY() > 580 && e.getY() < 630;
        }

        private boolean clickedWithinGameBoard(MouseEvent e){
            return e.getX() > 0 && e.getX() < ZooCell.sideSize * gameZoo.width && e.getY() > 0 && e.getY() < ZooCell.sideSize * gameZoo.height;
        }

        private boolean clickedFood(MouseEvent e){
            return e.getX() >= 509 && e.getX() < 680 && e.getY() > 440 && e.getY()<470;
        }
        private boolean clickedClear(MouseEvent e){
            return e.getX() >= 509 && e.getX() < 680 && e.getY() > 470 && e.getY()<500;
        }


        /**
         * This method, depending on which screen it is resets it back to main menu screen
         */
        private void resetScreen(){
            switch (gameShop.getSelectedScreen()) {
                case ROOM:
                selectedFirstPoint = null;
                selectedSecondPoint = null;
                gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                repaint();
                break;
                case CARNIVORE:
                    selectedAnimal = null;
                    gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                    repaint();
                    break;
                case HERBIVORE:
                    selectedAnimal = null;
                    gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                    repaint();
                    break;
                case FOOD:
                    gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                    repaint();
                    break;
            }
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e Mouse event that triggered
         */
        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e Mouse event that triggered
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e Mouse event that triggered
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e Mouse event that triggered
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
