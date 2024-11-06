public abstract class Regression {
    protected DataStatistics stats;

    public Regression(DataSet dataSet) {
        this.stats = new DataStatistics(dataSet);
    }

    public abstract double predict(double x);


    public double calculateR2() {
        double sumSquaredError = 0;
        double sumTotalSquared = 0;
        double meanY = stats.meanY();

        for (DataPoint point : stats.getDataPoints()) {
            double prediction = predict(point.getX());
            sumSquaredError += Math.pow(prediction - point.getY(), 2);
            sumTotalSquared += Math.pow(point.getY() - meanY, 2);
        }

        return 1 - (sumSquaredError / sumTotalSquared);
    }

    //  calcular la correlación r
    public double getCorrelation() {
        int n = stats.count();
        double sumX = stats.sumX();
        double sumY = stats.sumY();
        double sumXY = stats.sumXY();
        double sumX2 = stats.sumX2();
        double sumY2 = stats.sumY2();

        double numerator = (n * sumXY - sumX * sumY);
        double denominator = Math.sqrt((n * sumX2 - Math.pow(sumX, 2)) * (n * sumY2 - Math.pow(sumY, 2)));

        return (denominator == 0) ? 0 : numerator / denominator;
    }

    //  error estándar de la pendiente (beta 1)
    public double getSESlope() {
        return Math.sqrt(calculateMSE() / (stats.count() * (stats.sumX2() - Math.pow(stats.sumX(), 2) / stats.count())));
    }

    //  error estándar del intercepto (beta 0)
    public double getSEIntercept(double slope) {
        return Math.sqrt(calculateMSE() * (1.0 / stats.count() +
                Math.pow(stats.sumX() / stats.count() - slope, 2) / stats.sumX2()));
    }

    //  error cuadrático medio (MSE)
    protected double calculateMSE() {
        double mse = 0;
        for (DataPoint point : stats.getDataPoints()) {
            double predicted = predict(point.getX());
            mse += Math.pow(predicted - point.getY(), 2);
        }
        return mse / stats.count();
    }
}

