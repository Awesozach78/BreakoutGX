public class Ball {
    private int x, y;     // (x,y) position of the top left corner of the ball
    private int diameter;
    private int dx, dy;
    // direction & amount to change when moving, dx for x-axis and dy for y-axis


    public Ball(int startingX, int startingY) {
        x = startingX;
        y = startingY;
        diameter = 20;
        dx = 1;
        dy = 3;

    }

    // return the current x-axis coordinate of the top left corner of the ball
    public int getX() {
        return x;
    }

    // return the current y-axis coordinate of the top left corner of the ball
    public int getY() {
        return y;
    }

    // return the diameter of the ball
    public int getDiameter() {
        return diameter;
    }


    public void bounceX() {
        dx = -dx;

    }

    public void bounceY() {
        dy = -dy;

    }

    public int getDX() {
        return dx;
    }

    public int getDY() {
        return dy;
    }

    public void move() {
        x += dx;
        y += dy;

    }
}
