import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener{
    
        static final int SCREEN_WIDTH = 600;
        static final int SCREEN_HEIGHT = 600;
        static final int UNIT_SIZE = 25;
        static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
        static final int DELAY = 50;
        final int x[] = new int[GAME_UNITS];
        final int y[] = new int[GAME_UNITS];
        int segments = 5;
        int points;
        int pointX;
        int pointY;
        char direction = 'r';



        // contructor -----------------------------------------
        GamePanel() { 

        }

        // methods --------------------------------------------
        public void startGame() {

        }
        public void paintComponent(Graphics g) {

        }
        public void draw(Graphics g) {

        }
        public void move() {

        }
        public void checkPoints() {

        }
        public void checkCollisions() {

        }
        public void gameOver(Graphics g) {

        }

        public void actionPerformed(ActionEvent e) {

        }

        // innerclass
        public class MyKeyAdapter extends KeyAdapter{
                @Override
                public void keyPressed(KeyEvent e){

                }
        }

}
