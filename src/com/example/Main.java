package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        task1();
        task2();
//        task3();
//        task4();
    }

    public static void task1(){
        System.out.println("Task 1: ");
        ArrayList<Double> data = FileController.loadData("in_1.txt");

        if (data.size() != 0){
            ArrayList<Double> concentrations = new ArrayList<>();
            System.out.println("Concentrations:");
            for (int i = 0; i < data.size() - 2; i += 3){
                Double tmp = Concentration.evaluate(data.get(i), data.get(i + 1), data.get(i + 2));
                concentrations.add(tmp);
                System.out.println(tmp);
            }
            System.out.println("Mean:");
            System.out.println(Concentration.meanConcentration(concentrations));
            FileController.saveData("out_1.txt", Concentration.meanConcentration(concentrations).toString());
        } else {
            FileController.saveData("out_1.txt", "Error occurred while reading file");
        }
    }

    public static void task2(){
        System.out.println("Task 2: ");
        ArrayList<Matrix> matrices = FileController.loadMatrices("in_2.txt");
        ArrayList<Double> range = FileController.loadData("in_2_parameters.txt");

        if (matrices == null) {
            FileController.saveData("out_2.txt", "Error occurred while reading data");
            return;
        }
        StringBuilder resStr = new StringBuilder();
        for (Matrix matrix : matrices){
            System.out.println(matrix);
            resStr.append(Arrays.toString(matrix.getSumAndAmount(range.get(0), range.get(1))));
            resStr.append('\n');
        }
        FileController.saveData("out_2.txt", resStr.toString());
    }

    public static void task3(){
//         load matrix from file
        Matrix matrix = FileController.loadMatrix("in_3.txt");

        if (matrix == null){
            FileController.saveData("out_3.txt", "Error occurred while reading file");
            return;
        }
        System.out.println(matrix);
        System.out.println(matrix.getRowSum(4));
        FileController.saveData("out_3.txt", matrix.getRowSum(4).toString());
    }

    public static void task4(){
//        double mDeg = MyMath.toDegrees(1);
//        double deg = Math.toDegrees(1);
//
//        System.out.printf("My deg: %f, Math deg: %f%n", mDeg, deg);
//        System.out.println("Cos:");
//        System.out.println(MyMath.cos(1));
//        System.out.println(Math.cos(1));
//        System.out.println("Sin");
//        System.out.println(MyMath.sin(1));
//        System.out.println(Math.sin(1));

        System.out.println("Task 4:");
        ArrayList<Double> data4 = new ArrayList<>();
//        дані (x1, y1, x2, x3, y3):
        data4 = FileController.loadDoubles("in_4.txt");
        System.out.println(data4);

        if (data4 == null){
            FileController.saveData("out_4.txt", "Error occurred while reading file");
            return;
        }

        double x1 = data4.get(0), y1 = data4.get(1);
        double tmp = MyMath.sqrt(
                MyMath.abs(
                        MyMath.f(x1) * MyMath.phi(x1, y1)
                )
        );
        double z1 = 1 - tmp;
        System.out.println(tmp);
        System.out.println(z1);

        double x2 = data4.get(2), x3 = data4.get(3), y2 = data4.get(4);
        double z2 = MyMath.f(0.258) + MyMath.phi(x2, y2) / MyMath.cos(x3);
        System.out.println(z2);
        FileController.saveData("out_4.txt", String.format("%f %f", z1, z2));
    }
}
