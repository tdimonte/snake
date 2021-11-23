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
        int segments = 1;
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
                for(int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++){
                        g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
                        g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
                }

                g.setColor(Color.red);
                g.fillRect(pointX, pointY, UNIT_SIZE, UNIT_SIZE);

                for(int i = 0; i < segments; i++) {
                        // snake head
                        if (i == 0) {
                                g.setColor(Color.WHITE);
                                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                        }
                        // snake body
                        else {
                                g.setColor(Color.GRAY);
                                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                        }
                }

        }
        public void newPoint(){
                pointX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
                pointY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
        }
        public void move() {
                for(int i = segments; i > 0; i--) {
                        x[i] = x[i-1];
                        y[i] = y[i-1];
                }

                switch(direction) {
                        case 'u':
                                y[0] = y[0] - UNIT_SIZE;
                                break;
                        case 'd':
                                y[0] = y[0] + UNIT_SIZE;
                                break;
                        case 'r':
                                x[0] = x[0] + UNIT_SIZE;
                                break;
                        case 'l':
                                x[0] = x[0] - UNIT_SIZE;
                                break;
                        
                }

        }
        public void checkPoints() {

        }
        public void checkCollisions() {
                // if head collides with body
                for(int i = segments; i > 0; i--) {
                        if((x[0] == x[i]) && (y[0] == y[i])) {
                                running = false;
                        }
                }
                // if head collides with border
                // left
                if(x[0] < 0) {
                        running = false;
                }
                // right
                if(x[0] > SCREEN_WIDTH) {
                        running = false;
                }
                // top
                if(y[0] < 0) {
                        running = false;
                }
                // bottom
                if(y[0] > SCREEN_HEIGHT) {
                        running = false;
                }

                if(!running) {
                        timer.stop();
                }

        }
        public void gameOver(Graphics g) {

        }

        public void actionPerformed(ActionEvent e) {

                if(running) {
                        move();
                        checkPoints();
                        checkCollisions();
                }
                repaint();

        }

        // innerclass
        public class MyKeyAdapter extends KeyAdapter{
                @Override
                public void keyPressed(KeyEvent e){

                }
        }

}
