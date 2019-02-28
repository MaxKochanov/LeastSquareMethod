package approximation;

public class Point {

    private double x;
    private double yWithEps;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private double y;
    private double eps;

    public double getEps() {
        return eps;
    }

    public void setEps(double eps) {
        this.eps = eps;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public double getyWithEps() {
        return yWithEps;
    }

    public void setyWithEps(double yWithEps) {
        this.yWithEps = yWithEps;
    }


}
