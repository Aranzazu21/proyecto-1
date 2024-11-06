public class DataStatistics {
    private final DataPoint[] dataPoints;

    public DataStatistics(DataSet dataSet) {
        this.dataPoints = dataSet.getDataPoints();
    }

    public double sumX() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX();
        }
        return sum;
    }

    public double sumY() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getY();
        }
        return sum;
    }

    public double sumXY() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX() * point.getY();
        }
        return sum;
    }

    public double sumX2() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX() * point.getX();
        }
        return sum;
    }

    public double sumY2() { // Suma de cuadrados de Y
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getY() * point.getY();
        }
        return sum;
    }
    public int count() {
        return dataPoints.length;
    }

    public DataPoint[] getDataPoints() {
        return dataPoints;
    }

    public double meanY() {
        return sumY() / count();
    }
}
