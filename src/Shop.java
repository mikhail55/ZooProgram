import java.awt.*;

public class Shop {

    enum currentScreen{
        MENU, ROOM, CARNIVORE, HERBIVORE
    }
    private currentScreen selectedScreen;

    private int balance;

    public Shop(){
        selectedScreen = currentScreen.MENU;
        balance = 500;
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

    public currentScreen getSelectedScreen() {
        return selectedScreen;
    }

    public void setSelectedScreen(currentScreen selectedScreen) {
        this.selectedScreen = selectedScreen;
    }
}
