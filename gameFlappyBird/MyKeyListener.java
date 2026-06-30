package gameFlappyBird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameFlappyBird.objects.Bird;


// Create a new class that implements KeyListener
class MyKeyListener implements KeyListener {

    private int speed = 5;

    private Bird bird;

    public MyKeyListener(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            bird.setY(bird.getY() - speed);
        } else if (key == KeyEvent.VK_S) {
            bird.setY(bird.getY() + speed);
        } else if (key == KeyEvent.VK_A) {
            bird.setX(bird.getX() - speed);
        } else if (key == KeyEvent.VK_D) {
            bird.setX(bird.getX() + speed);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            new Thread(() -> {
                try {
                    for (int i = 0; i < 10; i++) {
                        bird.setY(bird.getY() + 1);
                        Thread.sleep(100); // Sleep for 100 milliseconds
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
