package main;

import inputs.KeyboardInputs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePanel extends JPanel{

    public String wrd = "";

    private String[] line = {"", "", "", "", ""};
    private int[] lineValues = {1, 1, 1, 1, 1};

    private String[] bottomLine = {"", "", "", "", ""};

    private String totalWords = "";
    private int currentWordIndex = 0;

    public boolean begin = false;

    private JLabel counterLabel = new JLabel("");
    private int seconds = 60;
    private Timer timer;

    public GamePanel() {
        setPanelSize();
        setBackground(Color.lightGray);

        addKeyListener(new KeyboardInputs(this));

        theTimer();
        Font counterFont = new Font("Ariel", Font.BOLD, 90);
        counterLabel.setFont(counterFont);
        counterLabel.setVisible(true);

        randomLine("first");
    }

    private void setPanelSize() {

        Dimension size = new Dimension(1080, 720);
        Dimension maxSize = new Dimension(2560, 1600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(maxSize);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        counterLabel.setBounds((getWidth()/2)-75, 550, 200, 100);

        add(counterLabel);

        if(begin) {
            timer.start();
        }

        if (seconds > 0) {

            if (lineValues[0] != 0 && lineValues[1] != 0 && lineValues[2] != 0 && lineValues[3] != 0 && lineValues[4] != 0) {
                randomLine("");
            }

            theLines(g);
            drawUserComponents(g);

        } else {
            drawScore(g);
        }
    }

    private void theTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seconds>0)
                    seconds--;

                counterLabel.setText(Integer.toString(seconds));
            }
        });
    }

    private void drawUserComponents(Graphics g) {
        Font currentWordFont = new Font("Arial", Font.BOLD, 100);

        g.setFont(currentWordFont);
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(this.wrd, (getWidth() - metrics.stringWidth(wrd))/2, 100);
    }

    private void drawScore(Graphics g) {
        Font userScoreFont = new Font("Comic Sans", Font.BOLD, 100);
        g.setFont(userScoreFont);
        FontMetrics metrics = g.getFontMetrics();
        g.drawString(this.totalWords.length()/5 + " WPM", (getWidth()-metrics.stringWidth("00 WPM"))/2, getHeight()/2);
    }

    private void theLines(Graphics g) {
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);
        for(int i = 1; i<6; i++) {
            if(this.lineValues[i-1] == 0) {
                g.setColor(Color.BLACK);
                g.drawString(this.line[i-1], wrdCords(i-1, g)[0], wrdCords(i-1, g)[1]);
            } else if(this.lineValues[i-1] == 1){
                g.setColor(Color.decode("#009200"));
                g.drawString(this.line[i-1], wrdCords(i-1, g)[0], wrdCords(i-1, g)[1]);
            } else if(this.lineValues[i-1] == 2){
                g.setColor(Color.RED);
                g.drawString(this.line[i-1], wrdCords(i-1, g)[0], wrdCords(i-1, g)[1]);
            }
            g.setColor(Color.BLACK);
            g.drawString(this.bottomLine[i-1], bottomWrdCords(i-1, g)[0], 440);
        }
    }

    private int[] bottomWrdCords(int num, Graphics g) {
        int[] bottomCords = new int[2];
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();

        int y = (getHeight() - metrics.getHeight())/2 + metrics.getAscent();;
        int bottomX = getWidth()*(num+1)/6 - metrics.stringWidth(bottomLine[num])/2;

        bottomCords[0] = bottomX;
        bottomCords[1] = y;

        return bottomCords;
    }

    private int[] wrdCords(int num, Graphics g) {
        int[] cords = new int[2];
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics();

        int x = getWidth()*(num+1)/6 - metrics.stringWidth(line[num])/2;
        int y = (getHeight() - metrics.getHeight())/2 + metrics.getAscent();;

        cords[0] = x;
        cords[1] = y;

        return cords;
    }

    public void changeWrd(String s) {
        wrd = wrd + s;
        if(s.equals("") && wrd.length() > 0) {
            wrd = wrd.substring(0, wrd.length()-1);
        }
    }

    public void resetWrd() {
        this.wrd = "";
    }

    public void correctCheck() {
        if (this.wrd.equals(this.line[this.currentWordIndex])) {
            totalWords = totalWords + this.line[this.currentWordIndex];
            this.lineValues[currentWordIndex] = 1;

        } else {

            this.lineValues[this.currentWordIndex] = 2;

        }
        if (this.currentWordIndex==4) {
            this.currentWordIndex = 0;
        }else{
            this.currentWordIndex++;

        }
    }

    private void randomLine(String input){
        Random random = new Random();

        String[] commonWords = {
                "it", "you", "the", "a", "he", "was", "for", "on", "are", "with", "as", "I",
                "his", "they", "be", "at", "one", "have", "this", "from", "or", "had", "by",
                "not", "word", "but", "what", "some", "we", "can", "out", "other", "were",
                "all", "there", "when", "up", "use", "your", "how", "said", "an", "each",
                "she", "which", "do", "their", "time", "if", "will",

                "way", "about", "many",
                "then", "them", "write", "would", "like", "so", "these", "her", "long",
                "make", "thing", "see", "him", "two", "has", "look", "more", "day", "could",
                "go", "come", "did", "number", "sound", "no", "most", "people", "my", "over",
                "know", "water", "than", "call", "first", "who", "may", "down", "side",
                "been", "now", "find",

                "any", "new", "work", "part", "take", "get", "place",
                "made", "live", "where", "after", "back", "little", "only", "round", "man",
                "year", "came", "show", "every", "good", "me", "give", "our", "under",
                "name", "very", "through", "just", "form", "sentence", "great", "think",
                "say", "help", "low", "line", "differ", "turn", "cause", "much", "mean",
                "before", "move", "right", "boy", "old", "too", "same", "tell", "does",
                "set", "three", "want", "air", "well", "also", "play", "small", "end",
                "put", "home", "read", "hand", "port", "large", "spell", "add", "even",
                "land", "here", "must", "big", "high", "such",

                "follow", "act", "why",
                "ask", "men", "change", "went", "light", "kind", "off", "need", "house",
                "picture", "try", "us", "again", "animal", "point", "mother", "world",
                "near", "build", "self", "earth", "father", "head", "stand", "own", "page",
                "should", "country", "found", "answer", "school", "grow", "study", "still",
                "learn", "plant", "cover", "food",

                "sun", "four", "between", "state",
                "keep", "eye", "never", "last", "let", "thought", "city", "tree", "cross",
                "farm", "hard", "start", "might", "story", "saw", "far", "sea", "draw",
                "left", "late", "run", "don't", "while", "press", "close", "night", "real",
                "life", "few", "north", "open", "seem", "together", "next", "white",
                "children", "begin", "got"
        };
        if(input.equals("first")){
            for(int i = 0; i<5; i++) {
                this.bottomLine[i] = commonWords[random.nextInt(0, 252)];
                this.line[i] = commonWords[random.nextInt(0, 252)];
                this.lineValues[i] = 0;
            }
        } else {
            for(int i = 0; i<5; i++) {
                this.line[i] = bottomLine[i];
                bottomLine[i] = commonWords[random.nextInt(0, 140)];
                this.lineValues[i] = 0;
            }
        }
    }
}
