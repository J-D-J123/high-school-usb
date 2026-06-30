package gameFlappyBird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlappyBird extends JPanel {


    public FlappyBird() {
        // set the layout of the window
        setLayout(null);

        // set the size of the window
        setSize(500, 500);

        // set the background color of the window
        // getContentPane().setBackground(Color.BLUE);

        // set the window to be visible
        setVisible(true);

        // Create a JPanel to ensure that key events are received
        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    pauseGame();
                }
            }
        });

        // Add the panel to the JFrame
        add(panel);
    }

    public void pauseGame() {
        // Code to display pause menu goes here
        System.out.println("Game paused");
    }

    /**
     * the start method will have a timer that counts down from 3 and then starts the game
     */
    public void start(){
        // timer for 3 second countdown
        // display the number of seconds left as a number over the game
        int delay = 1000; //milliseconds
        int[] count = {3}; // countdown starts at 3
    
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (count[0] > 0) {
                    System.out.println(count[0]--);
                } else {
                    ((Timer)evt.getSource()).stop();
                    playGame();
                }
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    /**
     * the playGame method will start the game
     */
    public void playGame(){
        // start the game
        System.out.println("Game started");
    }
}