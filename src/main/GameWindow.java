package main;

import javax.swing.*;

public class GameWindow {

    public static JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame("Max's Typing Test");

        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
