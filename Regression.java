public abstract class Regression {
    protected final DataStatistics stats;

    public Regression(DataSet dataSet) {
        this.stats = new DataStatistics(dataSet);
    }

    public abstract double predict(double advertising);

    public abstract void fit();

    public abstract String getEquation();


    public double calculateR2() {
        double sumSquaredError = 0;
        double sumTotalSquared = 0;
        double meanSales = stats.meanSales();

        for (DataPoint point : stats.getDataPoints()) {
            double prediction = predict(point.getAdvertising());
            sumSquaredError += Math.pow(prediction - point.getSales(), 2);
            sumTotalSquared += Math.pow(point.getSales() - meanSales, 2);
        }

        return (sumTotalSquared == 0) ? 0 : 1 - (sumSquaredError / sumTotalSquared);
    }


    public double getCorrelation() {
        int n = stats.count();
        if (n == 0) return 0;

        double sumAdvertising = stats.sumAdvertising();
        double sumSales = stats.sumSales();
        double sumAdvertisingSales = stats.sumAdvertisingSales();
        double sumAdvertisingSquared = stats.sumAdvertisingSquared();
        double sumSalesSquared = stats.sumSalesSquared();

        double numerator = (n * sumAdvertisingSales - sumAdvertising * sumSales);
        double denominator = Math.sqrt((n * sumAdvertisingSquared - Math.pow(sumAdvertising, 2)) *
                (n * sumSalesSquared - Math.pow(sumSales, 2)));

        return (denominator == 0) ? 0 : numerator / denominator;
    }


    public double getSESlope() {
        int n = stats.count();
        double meanAdvertising = stats.sumAdvertising() / n;
        double sumSquaredDifferences = stats.sumAdvertisingSquared() - Math.pow(stats.sumAdvertising(), 2) / n;

        return Math.sqrt(calculateMSE() / sumSquaredDifferences);
    }


    public double getSEIntercept(double slope) {
        int n = stats.count();
        double meanAdvertising = stats.sumAdvertising() / n;

        double term = (1.0 / n) + (Math.pow(meanAdvertising, 2) /
                (stats.sumAdvertisingSquared() - Math.pow(stats.sumAdvertising(), 2) / n));

        return Math.sqrt(calculateMSE() * term);
    }


    protected double calculateMSE() {
        double mse = 0;
        for (DataPoint point : stats.getDataPoints()) {
            double predicted = predict(point.getAdvertising());
            mse += Math.pow(predicted - point.getSales(), 2);
        }
        return mse / stats.count();
    }
}
