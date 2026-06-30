package gameFlappyBird;

import java.awt.event.KeyEvent;

import gameFlappyBird.objects.Bird;

public class Controls {

        private int y;
        private int x;

        public void controlBird(Bird bird, KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_W) {
                bird.setY(bird.getY() - 5);
            } else if (key == KeyEvent.VK_S) {
                bird.setY(bird.getY() + 5);
            } else if (key == KeyEvent.VK_A) {
                bird.setX(bird.getX() - 5);
            } else if (key == KeyEvent.VK_D) {
                bird.setX(bird.getX() + 5);
            }
        }
    }
