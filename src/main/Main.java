package main;

import approximation.GramMatrix;
import approximation.Info;
import approximation.Point;
import approximation.Polynom;
import graphics.DataWriter;

import static approximation.Info.pointsAmount;

public class Main {

    public static void main(String[] args) {
        Point[] points = new Point[pointsAmount];
        for(int i = 0; i < pointsAmount; i++){
            points[i] = new Point();
        }
        Info info = new Info(points);

        info.setPoints();
        GramMatrix gramMatrix = new GramMatrix(points);
        gramMatrix.setMatrix();
        gramMatrix.setFreeComponentOfEqut();
        gramMatrix.diagonolizeMatrix();
        gramMatrix.setIndefeniteScalars();
        double[] scalars = gramMatrix.getIndefiniteScalars();

        Polynom polynom = new Polynom();
        polynom.setValues(scalars);
        double[] value = polynom.getValue();

        DataWriter dataWriter = new DataWriter(points, value);
        dataWriter.points();
        dataWriter.pointsWithEps();
        dataWriter.scalars(scalars);
        dataWriter.polynom();

        double eps = polynom.getNormOfEps(points);
        double delta = polynom.standartDeviation(points, scalars);
        /*System.out.println("delta = " + delta);
        System.out.println("eps = " + eps);*/
        gramMatrix.print();


        /*gramMatrix.printMatrix();*/
    }

}
