public class DataStatistics {
    private final DataPoint[] dataPoints;

    public DataStatistics(DataSet dataSet) {
        this.dataPoints = dataSet.getDataPoints();
    }

    public double sumAdvertising() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getAdvertising();
        }
        return sum;
    }

    public double sumSales() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getSales();
        }
        return sum;
    }

    public double sumAdvertisingSales() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getAdvertising() * point.getSales();
        }
        return sum;
    }

    public double sumAdvertisingSquared() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getAdvertising() * point.getAdvertising();
        }
        return sum;
    }

    public double sumSalesSquared() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getSales() * point.getSales();
        }
        return sum;
    }

    public int count() {
        return dataPoints.length;
    }

    public DataPoint[] getDataPoints() {
        return dataPoints;
    }

    public double meanSales() {
        return sumSales() / count();
    }
}