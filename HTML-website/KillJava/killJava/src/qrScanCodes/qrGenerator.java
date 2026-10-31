package qrScanCodes;



import java.io.IOException;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class qrGenerator extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static JFrame f;

    private JPanel p;

    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {

        f.setDefaultLookAndFeelDecorated(true);

        qrGenerator app = new qrGenerator();

        // needed at bottom to of main() to be able to close the application
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // automatically resize window (use instead of setSize)
        f.pack();
        f.setSize(100, 100);
        f.setVisible(true);
    }

    public qrGenerator() {

        f = new JFrame("");
        p = new JPanel();
        p.setBackground(Color.black);
        addButtons();

        f.setResizable(false);
        f.pack();
        f.setContentPane(p);
    }

    public void addButtons() {

        button1 = new JButton("Run");
        button1.setBackground(Color.green);
        p.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("End");
        button2.setBackground(Color.red);
        p.add(button2);
        button2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {

            run();

            JOptionPane.showMessageDialog(this, "starting the run() method...",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (e.getSource() == button2) {
            System.exit(0);
        }
    }

    public void run() {
        while (true) {

            try {
                ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", "ClassroomWindows.exe");
                Process process = processBuilder.start();
                process.waitFor();

                System.out.println("Lightspeed is Closed \n");

                Thread.sleep(1); // 1 milisecond
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
