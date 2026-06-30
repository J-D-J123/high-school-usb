package gameFlappyBird.objects;

 // import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public class Bird extends JComponent {
    private int x;
    private int y;

    // start the bird in the middle of the screen
    private int width;
    private int height;
    private int startX;
    private int startY;

    public Bird() {
        // set the start and size of the bird
        setBounds(startX, startY, width, height);

        // make sure the bird can be seen
        setOpaque(false);

        // set the bird to be focusable so that it can be controlled
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            /// @Override
            public void keyPressed(KeyEvent e) {
                control(e);
            }
        });
    }

    // @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(0, 0, getWidth(), getHeight()); // Draws a red circle at (x, y) with a diameter of 30
    }

    public void control(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            y -= 5;
        } else if (key == KeyEvent.VK_S) {
            y += 5;
        } else if (key == KeyEvent.VK_A) {
            x -= 5;
        } else if (key == KeyEvent.VK_D) {
            x += 5;
        }
        setBounds(x, y, width, height);

        repaint();
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}