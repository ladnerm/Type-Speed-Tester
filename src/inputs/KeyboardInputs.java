package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener{

    private GamePanel gamePanel;
    boolean isShiftDown = false;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q:
                gamePanel.changeWrd("q");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_W:
                gamePanel.changeWrd("w");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_E:
                gamePanel.changeWrd("e");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_R:
                gamePanel.changeWrd("r");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_T:
                gamePanel.changeWrd("t");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_Y:
                gamePanel.changeWrd("y");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_U:
                gamePanel.changeWrd("u");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_I:
                isShiftDown = e.isShiftDown();
                if(isShiftDown) {
                    gamePanel.changeWrd("I");
                } else {
                    gamePanel.changeWrd("i");
                }
                break;
            case KeyEvent.VK_O:
                gamePanel.changeWrd("o");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_P:
                gamePanel.changeWrd("p");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_A:
                gamePanel.changeWrd("a");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_S:
                gamePanel.changeWrd("s");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_D:
                gamePanel.changeWrd("d");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_F:
                gamePanel.changeWrd("f");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_G:
                gamePanel.changeWrd("g");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_H:
                gamePanel.changeWrd("h");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_J:
                gamePanel.changeWrd("j");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_K:
                gamePanel.changeWrd("k");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_L:
                gamePanel.changeWrd("l");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_Z:
                gamePanel.changeWrd("z");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_X:
                gamePanel.changeWrd("x");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_C:
                gamePanel.changeWrd("c");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_V:
                gamePanel.changeWrd("v");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_B:
                gamePanel.changeWrd("b");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_N:
                gamePanel.changeWrd("n");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_M:
                gamePanel.changeWrd("m");
                gamePanel.begin = true;
                break;
            case KeyEvent.VK_QUOTE:
                gamePanel.changeWrd("'");
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.correctCheck();
                gamePanel.resetWrd();
                break;
            case KeyEvent.VK_BACK_SPACE:
                gamePanel.changeWrd("");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
