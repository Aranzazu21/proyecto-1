public class PolynomialRegression {
    private double[] coefficients;
    private DataStatistics stats;

    public PolynomialRegression(DataSet dataSet) {
        stats = new DataStatistics(dataSet);
    }

    public void fit() {
        int n = stats.count();

        coefficients = new double[3];

        for (DataPoint point : stats.getDataPoints()) {
            double x = point.getX();
            coefficients[0] += point.getY();
            coefficients[1] += point.getY() * x;
            coefficients[2] += point.getY() * Math.pow(x, 2);
        }

        // Promedia los coeficientes dividiendo por el número total de puntos.
        coefficients[0] /= n; //  constante.
        coefficients[1] /= n; //  lineal.
        coefficients[2] /= n; //  cuadrático.
    }

    // para predecir el valor de y dado un valor de x
    public double predict(double x) {
        return coefficients[0] + coefficients[1] * x + coefficients[2] * Math.pow(x, 2);
        // Calcula con formula polinomio: y = a + b*x + c*x^2
    }

    public String getEquation() {
        return String.format("y = %.2f + %.2f * x + %.2f * x^2",
                coefficients[0], coefficients[1], coefficients[2]);

    }
}