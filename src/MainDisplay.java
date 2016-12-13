import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Z on 12/11/2016.
 */
public class MainDisplay extends JPanel implements KeyListener  {
    ArrayList<ArrayList<Brick>> bricksArray;
    Ball ballsOnScreen;
    ArrayList<Paddle> paddles;
    Paddle paddle;


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());


        for (int bbb = 0; bbb < 1; bbb++) {
            g.fillOval(ballsOnScreen.getX(), ballsOnScreen.getY(), ballsOnScreen.getDiameter(), ballsOnScreen.getDiameter());
        }

        for (int aaa = 0; aaa < bricksArray.size(); aaa++) {
            for (int bbb = 0; bbb < bricksArray.get(aaa).size(); bbb++) {
                g.fillRect(bricksArray.get(aaa).get(bbb).getX(), bricksArray.get(aaa).get(bbb).getY(), bricksArray.get(aaa).get(bbb).getHeight(), bricksArray.get(aaa).get(bbb).getWidth());
            }
        }
    }

    public void animate() {
        boolean immortal = true;
        for (int i = 0; i > 5; i++) {
            if (ballsOnScreen.getX() + ballsOnScreen.getDX() >= (getWidth() - 20) || ballsOnScreen.getX() + ballsOnScreen.getDX() <= 0) {
                ballsOnScreen.bounceX();
            } else {
                if (ballsOnScreen.getY() + ballsOnScreen.getDY() >= (getHeight() - 20) || immortal && ballsOnScreen.getY() + ballsOnScreen.getDY() <= 0) {
                    ballsOnScreen.bounceY();
                }
            }
            ballsOnScreen.move();
        }

        for (int i = 0; i < bricksArray.size(); i++) {
            for (int j = 0; j < bricksArray.get(i).size(); j++) {
                if (ballsOnScreen.getX() >= bricksArray.get(i).get(j).getBrickX() &&
                        ballsOnScreen.getX() <= bricksArray.get(i).get(j).getWidth() +
                                bricksArray.get(i).get(j).getBrickX() &&
                        ballsOnScreen.getY() >= bricksArray.get(i).get(j).getBrickY() &&
                        ballsOnScreen.getY() <= bricksArray.get(i).get(j).getBrickY() + bricksArray.get(i).get(j).getHeight(); {
                    ballsOnScreen.bounceY();
                    bricksArray.get(i).remove(j);
                }
            }

        }
    }

    public MainDisplay() {
        super();

        paddle = new Paddle(200,400);

        ballsOnScreen= new Ball(250,250);


        bricksArray = new ArrayList<ArrayList<Brick>>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Brick> currentRow = new ArrayList<>();
            for (int j = 0; j < 16; j++) {
                currentRow.add(new Brick(j * 32, i * 30 + 56, 30, 25));
                System.out.println("Brick(" + j * 32 + " , " + i * 30 + ", 30, 25)");
            }
            bricksArray.add(currentRow);
        }
    }


    public static void main(String[] args) throws Exception {
        JFrame theApp = new JFrame();
        MainDisplay theDisplay = new MainDisplay();

        theApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theApp.setSize(530, 450);                // creates window with width=500 and height=500
        theApp.add(theDisplay);
        theApp.setVisible(true);

        // loop forever (well, until the application is closed anyway)

        while (true) {
            theDisplay.animate();    // originally forgot to invoke this method lol
            theApp.repaint();        // trigger the JPanel paintComponent() method to be called
            Thread.sleep(50);        // go to sleep for 20 milliseconds

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                paddle.rightPressed = true;
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.moveRight();
        }
    }



            /* go to this website to find out what you need to do for the panel.... it actually looks easier than the
             bricks in all honesty https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
             */

    @Override
    public void keyReleased(KeyEvent e) {

    }
}