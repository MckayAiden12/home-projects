import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {
    private int playerX = 100;
    private int playerY = 100;

    public Game() {
        setFocusable(true); // Ensure the JPanel can receive focus for key events
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        playerX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        playerX += 10;
                        break;
                    case KeyEvent.VK_UP:
                        playerY -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        playerY += 10;
                        break;
                }
                repaint(); // Trigger a repaint to update the player position
            }
        });
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        // Draw the player at its current position
        g.fillRect(playerX, playerY, 20, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arrow Key Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    
}