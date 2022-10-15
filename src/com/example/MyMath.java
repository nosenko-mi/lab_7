package com.example;

public class MyMath {
    private MyMath(){}

    public static final double PI = 3.1415;

    public static double abs(double a) {
        return (a <= 0.0) ? 0.0 - a : a;
    }

    public static double pow(double base, double exp) {
        double result = base;
        if (exp == 0.0){
            return 1.0;
        }
        else if(exp == 0.5){
            return sqrt(base);
        }
        for (int i = 1; i < exp; i++){
            result *= base;
        }
        return result;
    }

    public static double sqrt(double num) {
//        sqrtn+1=(sqrtn+(num/sqrtn))/2.0
        double t;
        double sqrtRoot=num/2;
        do
        {
            t=sqrtRoot;
            sqrtRoot=(t+(num/t))/2;
        }
        while((t-sqrtRoot)!= 0);
        return sqrtRoot;
    }

    public static double cos(double x)
    {
        double cos = 1;
        for(int i=2,j=1;i<20;i=i+2,j++)
        {
            cos+=pow(-1,j) * pow(x,i) / factorial(i);
        }
        return cos;
    }

    public static double sin(double x)
    {
        double sin = 0;
        for(int i=0, j=0; i<20; i=i+2, j++)
        {
            sin += pow(-1,j) * pow(x,i+1) /factorial(i+1);
        }
        return sin;
    }

    public static double toRadians(double x)
    {
        return x * PI / 180;
    }

    public static double toDegrees(double x){
        return x * 180 / PI;
    }

    public static double factorial(double x){
        if (x == 0)
            return 1;
        else
            return(x * factorial(x-1));
    }

    public static double f(double x){
        return pow(x, 2) * cos((PI/3 - toRadians(x)));
    }

    public static double phi(double x, double y){
        double X = pow(x, 3);
        X = toRadians(X);
        return sin(X) + y;
    }

}
