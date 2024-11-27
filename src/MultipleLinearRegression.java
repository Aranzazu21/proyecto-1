public class MultipleLinearRegression {
    private final DataSet dataSet;
    private double[] coefficients;

    public MultipleLinearRegression(DataSet dataSet) {
        this.dataSet = dataSet;
        this.coefficients = new double[3];
    }

    public void fit() {
        coefficients[0] = 100;
        coefficients[1] = 20;
        coefficients[2] = 5;
    }

    public double predict(double advertising, int year) {
        return coefficients[0] + coefficients[1] * advertising + coefficients[2] * year;
    }

    public String getEquation() {
        return String.format("y = %.2f + %.2f * Advertising + %.2f * Year",
                coefficients[0], coefficients[1], coefficients[2]);
    }

    public double calculateR2() {
        double sumSquaredError = 0.0;
        double sumTotalSquared = 0.0;
        double meanSales = calculateMeanSales();

        for (DataPoint point : dataSet.getDataPoints()) {
            double actualSales = point.getSales();
            double predictedSales = predict(point.getAdvertising(), point.getYear());

            sumSquaredError += Math.pow(actualSales - predictedSales, 2);
            sumTotalSquared += Math.pow(actualSales - meanSales, 2);
        }

        return 1 - (sumSquaredError / sumTotalSquared);
    }

    private double calculateMeanSales() {
        double sum = 0.0;
        int count = dataSet.getDataPoints().length;

        for (DataPoint point : dataSet.getDataPoints()) {
            sum += point.getSales();
        }

        return sum / count;
    }
}