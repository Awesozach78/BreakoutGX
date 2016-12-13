
public class Paddle {
    private int xPosition = 440;
    private int yPosition = 400;
    int dx = 5;
    int minx = 0;
    private int PaddleHeight = 20;
    private int PaddleWidth = 100;
    public boolean leftPressed = false;
    public boolean rightPressed = false;

    // dx is the distance to travel each time in pixels
    public Paddle(int startx, int starty) {
        xPosition = startx;
        yPosition = starty;
    }


    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public int getHeight() {
        return PaddleHeight;
    }

    public int getWidth() {
        return PaddleWidth;
    }

    public void moveLeft() {dx = -4;}

    public void moveRight() {dx = 4 ;}

    // painting the paddle to the screen


    // when the moveLeft method is called by the keyPressed method, the paddle should move to the left
  /* public void moveLeft() {
        if (xPosition - dx > minx) {
            xPosition -= dx;
        } else {
            xPosition = minx;
        }
    }

    // when the moveRight method is called by the keyPressed method, the paddle should move to the left
    public void moveRight() {
        if (xPosition - dx > minx) {
            xPosition += dx;
        } else {
            xPosition = minx;
        }
    }
    public void setLocation(int i, int j) {
        xPosition = i;
        yPosition = j;
    }

    public int getLength() {
        return PaddleWidth;
*/
    }