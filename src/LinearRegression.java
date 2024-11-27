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
            throw new IllegalArgumentException("NO TIENES SUFICIENTES DATOS.");
        }

        double sumAdvertising = stats.sumAdvertising();
        double sumSales = stats.sumSales();
        double sumAdvertisingSales = stats.sumAdvertisingSales();
        double sumAdvertisingSquared = stats.sumAdvertisingSquared();


        slope = (n * sumAdvertisingSales - sumAdvertising * sumSales) / (n * sumAdvertisingSquared - Math.pow(sumAdvertising, 2));


        intercept = (sumSales - slope * sumAdvertising) / n;
    }
    public void fitWithParameters(double[] parameters) {
        this.intercept = parameters[0];
        this.slope = parameters[1];
    }
    @Override
    public double predict(double advertising) {
        return intercept + slope * advertising;
    }

    @Override
    public String getEquation() {
        return String.format("sales = %.2f + %.2f * advertising", intercept, slope);
    }

    public double getIntercept() {
        return intercept;
    }

    public double getSlope() {
        return slope;
    }


    public double getSESlope() {
        return Math.sqrt(calculateMSE() / (stats.count() * (stats.sumAdvertisingSquared() - Math.pow(stats.sumAdvertising(), 2) / stats.count())));
    }


    public double getSEIntercept(double slope) {
        return Math.sqrt(calculateMSE() * (1.0 / stats.count() +
                Math.pow(stats.sumAdvertising() / stats.count() - slope, 2) / stats.sumAdvertisingSquared()));
    }
}
