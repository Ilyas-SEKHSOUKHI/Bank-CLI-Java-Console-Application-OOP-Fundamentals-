package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("BANK");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(420,420);
        frame.setVisible(true);

        ImageIcon icon = new ImageIcon("Images/banque.png");
        frame.setIconImage(icon.getImage());

        frame.getContentPane().setBackground(Color.pink);
    }
}
