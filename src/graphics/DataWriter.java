package graphics;

import approximation.Point;

import java.io.FileWriter;

import static approximation.Info.pointsAmount;
import static approximation.Info.scalarsAmount;

public class DataWriter {

    private Point[] points;
    private double[] value;

    public DataWriter(Point[] points, double[] value) {
        this.points = points;
        this.value = value;
    }

    public void pointsWithEps() {
        try {
            FileWriter file = new FileWriter("E:\\Java_projects\\lab4.1\\src\\graphics\\dataPointsWithEps");
            for (int i = 0; i < pointsAmount; i++) {
                file.write(points[i].getX() + "                           " + points[i].getyWithEps() + "\n");
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void points() {
        try {
            FileWriter file = new FileWriter("E:\\Java_projects\\lab4.1\\src\\graphics\\dataPoints");
            for (int i = 0; i < pointsAmount; i++) {
                file.write(points[i].getX() + "                           " + points[i].getY() + "\n");
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void polynom() {
        try {
            FileWriter file = new FileWriter("E:\\Java_projects\\lab4.1\\src\\graphics\\dataPolynom");
            double argument = 0;
            for (double i : value) {
                file.write(argument + "   " + i + "\n");
                file.flush();
                argument += 0.01;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scalars(double[] scalars) {
        try {
            FileWriter file = new FileWriter("E:\\Java_projects\\lab4.1\\src\\graphics\\dataScalars");
            for (int i = 0; i < scalarsAmount; i++) {
                file.write("scalar[" + i + "] = " + scalars[i] + "\n");
                file.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
