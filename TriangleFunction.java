package ru.geekbrainsQA.DZ4;

public class TriangleFunction {
    public static double areaOfATriangle(double a, double b, double c) throws NotTriangleException, NegativeSideOfTriangleException {
        if (a < 0 || b < 0 || c < 0) throw new NegativeSideOfTriangleException();
        if ((a + b > c) && (a + c > b) && (b + c > a)) {
            double halfP = (a + b + c) / 2;
            double result = Math.sqrt(halfP * (halfP - a) * (halfP - b) * (halfP - c));
            return result;
        } else {
            throw new NotTriangleException();
        }
    }
}
