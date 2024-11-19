public class LinearRegression extends Regression {
    private double slope;
    private double intercept;

    public LinearRegression(DataSet dataSet) {
        super(dataSet);
    }

    @Override
    public void fit() {
        int n = stats.count();
        if (n < 2) {
            throw new IllegalArgumentException("No hay suficientes datos para calcular la regresión.");
        }

        double sumX = stats.sumX();
        double sumY = stats.sumY();
        double sumXY = stats.sumXY();
        double sumX2 = stats.sumX2();

        // Cálculo de la pendiente (slope)
        slope = (n * sumXY - sumX * sumY) / (n * sumX2 - Math.pow(sumX, 2));

        // Cálculo del intercepto
        intercept = (sumY - slope * sumX) / n;
    }

    @Override
    public double predict(double x) {
        return intercept + slope * x;
    }

    @Override
    public String getEquation() {
        return String.format("y = %.2f + %.2f * x", intercept, slope);
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }

    // Método para calcular el error estándar de la pendiente
    public double getSESlope() {
        return Math.sqrt(calculateMSE() / (stats.count() * (stats.sumX2() - Math.pow(stats.sumX(), 2) / stats.count())));
    }

    // Método para calcular el error estándar del intercepto
    public double getSEIntercept(double slope) {
        return Math.sqrt(calculateMSE() * (1.0 / stats.count() +
                Math.pow(stats.sumX() / stats.count() - slope, 2) / stats.sumX2()));
    }
}