public class LeastSquaresRegression {
    private DataSet dataSet;
    private double[] coefficients;


    public LeastSquaresRegression(DataSet dataSet) {
        this.dataSet = dataSet;
        this.coefficients = new double[2];
    }

    public void fit() {
        int n = dataSet.getDataPoints().length;

        // Matriz
        double[][] X = new double[n][2];
        double[] Y = new double[n];

        // matrices X e Y con los datos del conjunto.
        for (int i = 0; i < n; i++) {
            X[i][0] = 1; // Primer columna es 1 (término independiente).
            X[i][1] = dataSet.getDataPoints()[i].getX();
            Y[i] = dataSet.getDataPoints()[i].getY();
        }

        solve(X, Y);
    }
    public double predict(double x) {
        return coefficients[0] + coefficients[1] * x;
    }

    public String getEquation() {
        return String.format("y = %.2f + %.2fx", coefficients[0], coefficients[1]);
        // Formatea la ecuación como una cadena con dos decimales.
    }

    // resuelve el sistema de ecuaciones para encontrar los coeficientes.
    private void solve(double[][] X, double[] Y) {
        int n = Y.length;

        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;


        for (int i = 0; i < n; i++) {
            sumX += X[i][1];
            sumY += Y[i];
            sumXY += X[i][1] * Y[i];
            sumX2 += X[i][1] * X[i][1];
        }

        // Calcula pendiente (B1) con  mínimos cuadrados.
        coefficients[1] = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);

        // Calcula la intersección (B0) con derivada del promedio.
        coefficients[0] = (sumY - coefficients[1] * sumX) / n;
    }
}