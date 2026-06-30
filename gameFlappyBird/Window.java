package gameFlappyBird;

import gameFlappyBird.accounts.SignIn;
import gameFlappyBird.objects.Bird;

// windows ... 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

// graphics ... 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

// colors ... 
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.RenderingHints;
import java.awt.BasicStroke;

// shapes ... 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.awt.geom.Arc2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

// key events
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Window extends JFrame {
    
    run start = new run(); 
    SignIn signIn = new SignIn();

    public Window(){

        // create the window frame 
        System.out.println("Window created");
        setTitle(run.version);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // create the bird object
        Bird bird = new Bird();        
        bird.setBounds(30, 30, 20, 20); // set the position and size of the Bird object

        // add flappy bird game to the Window frame
        FlappyBird game = new FlappyBird(); 
        add(game, BorderLayout.CENTER); 

        // add a nav bar to the top of the window frame 
        // this will be used to navigate to different pages
        // in the game
        JPanel navBar = new JPanel();
        navBar.setBackground(Color.gray);
        navBar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(navBar, BorderLayout.SOUTH);
        // have it have a menu button that will open a menu
        // that will have options to go to the home page,
        // the game page, the leaderboard page, and the
        // settings page
        JButton menuButton = new JButton("Menu");
        menuButton.setBackground(Color.white); 
        menuButton.setForeground(Color.black);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Menu button pressed");

                // have a clear menu like the home page
                
            }
        });
        navBar.add(menuButton);

        // game button that will open the game page
        JButton gameButton = new JButton("Game");
        gameButton.setBackground(Color.white); 
        gameButton.setForeground(Color.black);
        gameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game button pressed");

                game.setLayout(new GridLayout(1, 1)); // set the layout of the game to grid layout
                game.add(bird); // add Bird object to game
        
                setFocusable(true); // set the Window frame to be focused on
        
                game.start(); // start the game
        
                // Make the game visible after the bird has been added and the game has started
                setVisible(true);
            }
        });
        navBar.add(gameButton);

        // a leaderboard button that will open the leaderboard page
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setBackground(Color.white); 
        leaderboardButton.setForeground(Color.black);
        leaderboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Leaderboard button pressed");
                signIn.loginOrSignUp();
                leaderboardPage();
            }
        });
        navBar.add(leaderboardButton);

        // a settings button that will open the settings page
        JButton settingsButton = new JButton("Settings");
        settingsButton.setBackground(Color.white); 
        settingsButton.setForeground(Color.black);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Settings button pressed");
                JLabel label = new JLabel("Settings page");
                JOptionPane.showMessageDialog(null, label, "Settings", JOptionPane.PLAIN_MESSAGE);
            }
        });
        navBar.add(settingsButton);


        // make the window visible
        setVisible(true);
    }

    private void leaderboardPage () {
        System.out.println("Leaderboard page");

    }
}
