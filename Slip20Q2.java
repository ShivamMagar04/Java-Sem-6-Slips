import javax.swing.*;
import java.awt.*;

public class Slip20Q2 extends JFrame {

    public TemplePanel templePanel;

    public Slip20Q2() {
        setTitle("Temple Drawing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        templePanel = new TemplePanel();
        add(templePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Slip20Q2 templeDrawing = new Slip20Q2();
            templeDrawing.setVisible(true);

            // Start multiple threads for drawing different parts of the temple
            new Thread(new TowerDrawer(50, 100, 100, 200, templeDrawing.templePanel)).start();
            new Thread(new TowerDrawer(450, 100, 100, 200, templeDrawing.templePanel)).start();
            new Thread(new MainBuildingDrawer(150, 150, 300, 200, templeDrawing.templePanel)).start();
        });
    }
}

class TemplePanel extends JPanel {

    private int leftTowerX, leftTowerY, leftTowerWidth, leftTowerHeight;
    private int rightTowerX, rightTowerY, rightTowerWidth, rightTowerHeight;
    private int mainBuildingX, mainBuildingY, mainBuildingWidth, mainBuildingHeight;

    public TemplePanel() {
        // Initialize coordinates and dimensions
        leftTowerX = 50;
        leftTowerY = 100;
        leftTowerWidth = 100;
        leftTowerHeight = 200;

        rightTowerX = 450;
        rightTowerY = 100;
        rightTowerWidth = 100;
        rightTowerHeight = 200;

        mainBuildingX = 150;
        mainBuildingY = 150;
        mainBuildingWidth = 300;
        mainBuildingHeight = 200;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the temple components
        g.setColor(Color.RED);
        g.fillRect(leftTowerX, leftTowerY, leftTowerWidth, leftTowerHeight); // Left tower
        g.fillRect(rightTowerX, rightTowerY, rightTowerWidth, rightTowerHeight); // Right tower
        g.setColor(Color.BLUE);
        g.fillRect(mainBuildingX, mainBuildingY, mainBuildingWidth, mainBuildingHeight); // Main building
    }
}

class TowerDrawer implements Runnable {

    private int x, y, width, height;
    private TemplePanel templePanel;

    public TowerDrawer(int x, int y, int width, int height, TemplePanel templePanel) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.templePanel = templePanel;
    }

    @Override
    public void run() {
        // Update temple panel with tower dimensions
        templePanel.setLeftTower(x, y, width, height);
        templePanel.repaint();
    }
}

class MainBuildingDrawer implements Runnable {

    private int x, y, width, height;
    private TemplePanel templePanel;

    public MainBuildingDrawer(int x, int y, int width, int height, TemplePanel templePanel) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.templePanel = templePanel;
    }

    @Override
    public void run() {
        // Update temple panel with main building dimensions
        templePanel.setMainBuilding(x, y, width, height);
        templePanel.repaint();
    }
}
