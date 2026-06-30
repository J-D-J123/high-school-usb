package gameFlappyBird.accounts;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class SignIn {
    public void loginOrSignUp() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String[] options = {"Login", "Sign Up"};
        int choice = JOptionPane.showOptionDialog(frame, "Choose an option", "Login or Sign Up",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        String username = JOptionPane.showInputDialog(frame, "Enter username:");
        String password = JOptionPane.showInputDialog(frame, "Enter password:");

        if (choice == 1) {
            try (PrintWriter out = new PrintWriter(new File("data.txt"))) {
                out.println(username);
                out.println(password);
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Login functionality is not implemented yet.");
        }

        frame.dispose();
    }
}