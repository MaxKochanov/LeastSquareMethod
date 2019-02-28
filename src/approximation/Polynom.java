package approximation;

import static approximation.Info.pointsAmount;
import static approximation.Info.scalarsAmount;

public class Polynom {

    private static final int nodesAmount = 700;

    private double[] value = new double[nodesAmount];

    public double[] getValue() {
        return value;
    }

    private double calcDiscretValue(double argument, double[] scalars){
        double sum = 0;
        for(int i = 0; i < scalarsAmount; i++){
            sum += scalars[i] * Math.pow(argument, i);
        }
        return sum;
    }

    public void setValues(double[] scalars) {
        double argument = 0;
        for (int j = 0; j < nodesAmount; j++) {
            for (int i = 0; i < scalarsAmount; i++) {
                value[j] += scalars[i] * Math.pow(argument, i);
            }
            argument += 0.01;
        }
    }

    public double standartDeviation(Point[] points, double[] scalars) {
        double deltaSum = 0;
        for (int i = 0; i < pointsAmount; i++) {
            double y = points[i].getY();
            double x = points[i].getX();
            double value = calcDiscretValue(x, scalars);
            deltaSum += Math.pow((value - y), 2) / (double) pointsAmount; // исправь, где value выдает неправильное значение(аргумент не point.x)
        }
        return Math.pow(deltaSum, 0.5);
    }

    public double getNormOfEps(Point[] points){
        double sum = 0;
        for (int i = 0; i < pointsAmount; i++){
            double eps = points[i].getEps();
            sum += Math.pow(eps, 2);
        }
        return Math.pow(sum, 0.5);
    }

}
