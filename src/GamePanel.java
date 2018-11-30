import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel{
 private ZooManager gameZoo;

 private Shop gameShop;

 private Point selectedFirstPoint, selectedSecondPoint;

 private Animal selectedAnimal;

 private AnimalFactory animalCreator;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    GamePanel() {
        gameZoo = new ZooManager();
        gameShop = new Shop();
        animalCreator = new AnimalFactory();
        Dimension preferredDimension = new Dimension(ZooCell.sideSize * gameZoo.width + 255, ZooCell.sideSize * gameZoo.height);
        setPreferredSize(preferredDimension);
        addMouseListener(new MouseTracker());
    }


    public void paintComponent(Graphics g){
        gameZoo.draw(g);
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
        }
    }

    private class MouseTracker implements MouseListener{
        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         *
         * @param e
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            repaint();
            if (gameShop.getSelectedScreen() == Shop.currentScreen.MENU){
                if (e.getX() >= 509 && e.getX() < 680 && e.getY() > 350 && e.getY()<370){
                    gameShop.setSelectedScreen(Shop.currentScreen.ROOM);
                    repaint();
                } else if (e.getX() >= 509 && e.getX() < 680 && e.getY() > 372 && e.getY()<410){
                    gameShop.setSelectedScreen(Shop.currentScreen.CARNIVORE);
                } else if (e.getX() >= 509 && e.getX() < 680 && e.getY() > 410 && e.getY()<440){
                    gameShop.setSelectedScreen(Shop.currentScreen.HERBIVORE);
                }
            } else if (gameShop.getSelectedScreen() == Shop.currentScreen.ROOM){
                 if (e.getX() > 0 && e.getX() < ZooCell.sideSize * gameZoo.width && e.getY() > 0 && e.getY() < ZooCell.sideSize * gameZoo.height){
                     if (selectedFirstPoint == null) {
                         selectedFirstPoint = new Point();
                         selectedFirstPoint.setLocation(e.getX() / ZooCell.sideSize, e.getY() / ZooCell.sideSize);
                     } else
                         if (selectedSecondPoint == null){
                         selectedSecondPoint = new Point();
                         selectedSecondPoint.setLocation(e.getX() / ZooCell.sideSize, e.getY() / ZooCell.sideSize);
                         if(selectedSecondPoint.x < selectedFirstPoint.x){
                             System.out.println("Unallowed point location");
                             resetScreen();
                             return;
                         } else if (selectedSecondPoint.y < selectedFirstPoint.y){
                             System.out.println("Unallowed point location");
                             resetScreen();
                             return;
                         }
                         ZooRoom selectedRoom = new ZooRoom(selectedSecondPoint.x - selectedFirstPoint.x+1 , selectedSecondPoint.y - selectedFirstPoint.y+1, selectedFirstPoint);

                         if (gameZoo.checkAllowed(selectedRoom)){
                             gameZoo.addRoom(selectedRoom);
                             resetScreen();

                         } else {
                             System.out.println("Unallowed location");
                             resetScreen();
                         }
                     }
                }
                if (e.getX() >= 509 && e.getX() < 680 && e.getY() > 410 && e.getY()<440){
                    gameShop.setSelectedScreen(Shop.currentScreen.MENU);
                    repaint();
                }
            } else if (gameShop.getSelectedScreen() == Shop.currentScreen.CARNIVORE){
//                selectedAnimal = new Carnivore(Carnivore.type.WOLF);
                //repaint();
                if (e.getX() > 515 && e.getX() < 745 && e.getY() > 130 && e.getY() < 205){
                    selectedAnimal = animalCreator.createWolf();
                    System.out.println("Wolf");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 220 && e.getY() < 305){
                    selectedAnimal = animalCreator.createPanther();
                    System.out.println("Panther");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 320 && e.getY()  < 425){
                    selectedAnimal = animalCreator.createLion();
                    System.out.println("Lion");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 580 && e.getY() < 630){
                    resetScreen();
                } else if(e.getX() > 0 && e.getX() < ZooCell.sideSize * gameZoo.width && e.getY() > 0 && e.getY() < ZooCell.sideSize * gameZoo.height){
                    for (int i = 0; i <gameZoo.getCreatedRooms().size(); i++){
                        if (checkHitRoom(i, e.getX(), e.getY()) && gameZoo.checkPlacementAvailability(selectedAnimal,i)){
                            gameZoo.addAnimal(selectedAnimal, i);
                            System.out.println("added");
                            resetScreen();
                        }
                    }
                }
            } else if (gameShop.getSelectedScreen() == Shop.currentScreen.HERBIVORE){
                if (e.getX() > 515 && e.getX() < 745 && e.getY() > 130 && e.getY() < 205){
                    selectedAnimal = animalCreator.createMonkey();
                    System.out.println("Monkey");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 220 && e.getY() < 305){
                    selectedAnimal = animalCreator.createHorse();
                    System.out.println("Horse");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 320 && e.getY()  < 425){
                    selectedAnimal = animalCreator.createPanda();
                    System.out.println("Panda");
                    repaint();
                } else if (e.getX() > 515 && e.getX() < 745 && e.getY() > 580 && e.getY() < 630){
                    resetScreen();
                } else if(e.getX() > 0 && e.getX() < ZooCell.sideSize * gameZoo.width && e.getY() > 0 && e.getY() < ZooCell.sideSize * gameZoo.height){
                    for (int i = 0; i <gameZoo.getCreatedRooms().size(); i++){
                        if (checkHitRoom(i, e.getX(), e.getY()) && gameZoo.checkPlacementAvailability(selectedAnimal,i)){
                            gameZoo.addAnimal(selectedAnimal, i);
                            System.out.println("added");
                            resetScreen();
                        }
                    }
                }
            }
            System.out.println("x: " + e.getX());
            System.out.println("y: " + e.getY());
        }

        private boolean checkHitRoom(int roomIndex, int x, int y){
            return gameZoo.getCreatedRooms().get(roomIndex).getIndex().x * ZooCell.sideSize < x && (gameZoo.getCreatedRooms().get(roomIndex).getIndex().x + gameZoo.getCreatedRooms().get(roomIndex).getWidth()) * ZooCell.sideSize > x && gameZoo.getCreatedRooms().get(roomIndex).getIndex().y * ZooCell.sideSize < y && (gameZoo.getCreatedRooms().get(roomIndex).getIndex().y + gameZoo.getCreatedRooms().get(roomIndex).getHeight()) * ZooCell.sideSize > y;
        }

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
            }
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
