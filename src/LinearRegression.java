public class LinearRegression {
    private double slope; //(B1)
    private double intercept; //(B0)
    private DataStatistics stats;

    public LinearRegression(DataSet dataSet) {
        stats = new DataStatistics(dataSet);
    }

    public void fit() {
        int n = stats.count();
        double sumX = stats.sumX();
        double sumY = stats.sumY();
        double sumXY = stats.sumXY();
        double sumX2 = stats.sumX2();

        slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX); // Calcula la pendiente.
        intercept = (sumY - slope * sumX) / n;
    }

    public double predict(double x) {
        return intercept + slope * x;
    }

    public String getEquation() {
        return String.format("y = %.2f + %.2f * x", intercept, slope);
    }
}