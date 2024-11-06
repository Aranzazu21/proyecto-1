public class LinearRegression extends Regression {
    private double slope;
    private double intercept;

    public LinearRegression(DataSet dataSet) {
        super(dataSet);
    }

    public void fit() {
        int n = stats.count();
        slope = (n * stats.sumXY() - stats.sumX() * stats.sumY()) / (n * stats.sumX2() - Math.pow(stats.sumX(), 2));
        intercept = (stats.sumY() - slope * stats.sumX()) / n;
    }

    @Override
    public double predict(double x) {

        return intercept + slope * x;
    }

    public String getEquation() {

        return String.format("y = %.2f + %.2f * x", intercept, slope);
    }


    public double getIntercept() {

        return intercept;
    }


    public double getSlope() {

        return slope;
    }


    public double getSEIntercept() {

        return getSEIntercept(slope);
    }


    public double getSESlope() {

        return super.getSESlope();
    }


}

