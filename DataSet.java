public class DataSet {
    private DataPoint[] dataPoints;

    public DataSet() {
        dataPoints = new DataPoint[] {
                new DataPoint(23, 651),
                new DataPoint(26, 762),
                new DataPoint(30, 856),
                new DataPoint(34, 1063),
                new DataPoint(43, 1190),
                new DataPoint(48, 1298),
                new DataPoint(52, 1421),
                new DataPoint(57, 1440),
                new DataPoint(58, 1518)
        };
    }

    public DataPoint[] getDataPoints() {
        return dataPoints;
    }

    public int getNumberOfVariables() {
        return 2;
    }
}
