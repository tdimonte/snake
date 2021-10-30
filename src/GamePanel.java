import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.DelayQueue;


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
        boolean running = false;
        Timer timer;
        Random random;


        // contructor -----------------------------------------
        GamePanel() { 
                random = new Random();
                this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
                this.setBackground(Color.BLACK);
                this.setFocusable(true);
                this.addKeyListener(new MyKeyAdapter());
                startGame();
        }

        // methods --------------------------------------------
        public void startGame() {
                newPoint();
                running = true;
                timer = new Timer(DELAY, this);
                timer.start();
        }
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                draw(g);

        }
        public void draw(Graphics g) {

                //***SHOW UNIT_SIZE GRID***
                // for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
                //         g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                //         g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
                // }

        }
        public void newPoint(){

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
