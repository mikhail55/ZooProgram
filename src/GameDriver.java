import javax.swing.*;

public class GameDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Zoo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel driver = new GamePanel();
        frame.add(driver);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        driver.repaint();
    }
}
