public class PolynomialRegression extends Regression {
    private double[] coefficients;
    private int degree;

    public PolynomialRegression(DataSet dataSet, int degree) {
        super(dataSet);
        this.degree = degree;
        coefficients = new double[degree + 1];
    }

    public int getDegree() {
        return degree;
    }

    public void fit() {

        int n = stats.count();
        double[] sumPowers = new double[2 * degree + 1];
        double[] sumPowersY = new double[degree + 1];

        for (DataPoint point : stats.getDataPoints()) {
            double x = point.getX();
            double y = point.getY();
            for (int i = 0; i <= 2 * degree; i++) {
                sumPowers[i] += Math.pow(x, i);
            }
            for (int i = 0; i <= degree; i++) {
                sumPowersY[i] += y * Math.pow(x, i);
            }
        }

        double[][] matrix = new double[degree + 1][degree + 1];
        double[] results = new double[degree + 1];

        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= degree; j++) {
                matrix[i][j] = sumPowers[i + j];
            }
            results[i] = sumPowersY[i];
        }

        coefficients = solveSystem(matrix, results);
    }

    private double[] solveSystem(double[][] matrix, double[] results) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double ratio = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] -= ratio * matrix[i][k];
                }
                results[j] -= ratio * results[i];
            }
        }

        double[] coefficients = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            coefficients[i] = results[i];
            for (int j = i + 1; j < n; j++) {
                coefficients[i] -= matrix[i][j] * coefficients[j];
            }
            coefficients[i] /= matrix[i][i];
        }
        return coefficients;
    }

    @Override
    public double predict(double x) {
        double y = 0;
        for (int i = 0; i <= degree; i++) {
            y += coefficients[i] * Math.pow(x, i);
        }
        return y;
    }

    public String getEquation() {
        StringBuilder equation = new StringBuilder("y = ");
        for (int i = 0; i <= degree; i++) {
            equation.append(String.format("%.2f", coefficients[i]));
            if (i > 0) {
                equation.append(" * x^").append(i);
            }
            if (i < degree) {
                equation.append(" + ");
            }
        }
        return equation.toString();
    }
}
