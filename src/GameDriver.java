import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GameDriver class is used to start the game, as it
 * contains the main() method
 *
 * @author Mikhail Pyatakhin
 * @version 1.0
 * @since 2018-11-29
 */
public class GameDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Zoo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel driver = new GamePanel();
        frame.add(driver);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        int timeDelay = 30;

        ActionListener taskPerformer = e -> {

            for (int i = 0; i < driver.gameZoo.getCreatedRooms().size(); i++) {
                for (int j = 0; j < driver.gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().size(); j++) {
                    Animal selectedAnimal = driver.gameZoo.getCreatedRooms().get(i).getAnimalsInRoom().get(j);
                    if (selectedAnimal.getHealth() > 0) {
                        selectedAnimal.setHealth(selectedAnimal.getHealth() - 1);
                    }
                }
            }
            //drawing the panel itself
            driver.repaint();

        };

        Timer clock = new Timer(timeDelay, taskPerformer);
        clock.start();
    }
}
