package approximation;

import java.util.Random;

public class Info {

    public static int scalarsAmount = 4; // best values are 3, 4, 5
    public static int pointsAmount = 20;
    private Point[] points;

    public Info(Point[] points) {
        this.points = points;
    }

    private static double func(double x) {
        return Math.sin(x);
    }

    public void setPoints() {
        Random random = new Random();
        double node;
        for (int i = 0; i < pointsAmount; i++) {
            double eps =  random.nextInt(9) / (double) 50;
            boolean sign = random.nextBoolean();
            if (!sign) eps *= -1;
            node = (3 * i / (double) 11);
            points[i].setX(node);
            points[i].setEps(eps);
            points[i].setY(func(node));
            points[i].setyWithEps(func(node) + eps);
        }
    }

}
