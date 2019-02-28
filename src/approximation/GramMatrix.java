package approximation;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import static approximation.Info.pointsAmount;
import static approximation.Info.scalarsAmount;
import static java.lang.Math.E;

public class GramMatrix {

    private Point[] points;
    private double[][] matrix = new double[scalarsAmount][scalarsAmount];
    private double[] indefiniteScalars = new double[scalarsAmount];
    private double[] freeComponentOfEquat = new double[scalarsAmount]; // scalarMultWithFunc;

    public GramMatrix(Point[] points) {
        this.points = points;
    }

    private double scalarMult(int deg1, int deg2) {
        double sum = 0;
        for (int i = 0; i < pointsAmount; i++) {
            double x = points[i].getX();
            double eps = points[i].getEps();
            if (eps == 0) sum += 2500 * Math.pow(x, deg1 + deg2);
            else sum += Math.pow(eps, -2) * Math.pow(x, deg1 + deg2);
        }
        return sum;
    }

    private double scalarMultWithFunc(int deg) {
        double sum = 0;
        for (int i = 0; i < pointsAmount; i++) {
            double x = points[i].getX();
            double y = points[i].getyWithEps();
            double eps = points[i].getEps();
            if (eps == 0) sum += 2500 * Math.pow(x, deg) * y;
            else sum += Math.pow(eps, -2) * Math.pow(x, deg) * y;
        }
        return sum;
    }

    public void setMatrix() {
        for (int i = 0; i < scalarsAmount; i++) {
          //  matrix[i] = new double[scalarsAmount];
            for (int j = 0; j < scalarsAmount; j++) {
                matrix[i][j] = scalarMult(i, j);
            }
        }
    }

    public void setFreeComponentOfEqut() {
        for (int i = 0; i < scalarsAmount; i++) {
            freeComponentOfEquat[i] = scalarMultWithFunc(i);
        }
    }

    private void topTriangularView() {
        for (int i = 0; i < scalarsAmount - 1; i++) {
            for (int j = i + 1; j < scalarsAmount; j++) {
                double koef = matrix[j][i] / matrix[i][i];
                freeComponentOfEquat[j] -= freeComponentOfEquat[i] * koef;
                for (int k = i; k < scalarsAmount; k++)
                    matrix[j][k] -= matrix[i][k] * koef;
            }
        }
    }

    private void botTriangularView() {
        for (int i = scalarsAmount - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double koef = matrix[j][i] / matrix[i][i];
                freeComponentOfEquat[j] -= freeComponentOfEquat[i] * koef;
                for (int k = i; k >= 0; k--)
                    matrix[j][k] -= matrix[i][k] * koef;
            }
        }
    }

    public void diagonolizeMatrix() {
        topTriangularView();
        botTriangularView();
    }

    public void setIndefeniteScalars() {
        for (int i = 0; i < scalarsAmount; i++) {
            indefiniteScalars[i] = freeComponentOfEquat[i] / matrix[i][i];
        }
    }

    public double[] getIndefiniteScalars() {
        return indefiniteScalars;
    }

    public void printMatrix() {
        for (int i = 0; i < scalarsAmount; i++) {
            for (int j = 0; j < scalarsAmount; j++) {
                System.out.print(String.format("%.6f    ", matrix[i][j]));
            }
            System.out.println(" ");
        }
    }

    public void print() {
        double[][] matrixData = {{1, 2, 3}, {2, 5, 3}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

}

}
