package main;

import javax.swing.*;
import java.awt.*;
import inputs.KeyboardInputs;

public class IntroScreenPanel extends JPanel{



    public IntroScreenPanel() {
        setPanelSize();
        setBackground(Color.lightGray);

        //addKeyListener(new KeyboardInputs(this));
    }

    private void setPanelSize() {
        Dimension introScreenSize = new Dimension(1080, 720);

        setMinimumSize(introScreenSize);
        setMaximumSize(introScreenSize);
        setPreferredSize(introScreenSize);
    }
}
