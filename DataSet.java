public class DataSet {
    protected DataPoint[] dataPoints;

    public DataSet() {
        dataPoints = new DataPoint[]{
                new DataPoint(1, 8, 1),
                new DataPoint(2, 16, 2),
                new DataPoint(3, 24, 3),
                new DataPoint(4, 32, 4),
                new DataPoint(5, 40, 5),
                new DataPoint(6, 48, 6),
                new DataPoint(7, 56, 7),
                new DataPoint(8, 64, 8),
                new DataPoint(9, 72, 9)
        };
    }

    public DataPoint[] getDataPoints() {
        return dataPoints;
    }

    public double getTotalSumOfSquares() {
        double meanSales = calculateMeanSales();
        double totalSumOfSquares = 0.0;

        for (DataPoint point : dataPoints) {
            totalSumOfSquares += Math.pow(point.getSales() - meanSales, 2);
        }

        return totalSumOfSquares;
    }

    private double calculateMeanSales() {
        double sum = 0.0;
        for (DataPoint point : dataPoints) {
            sum += point.getSales();
        }
        return sum / dataPoints.length;
    }
}
/* cubica
                new DataPoint(23, 651, 1),
                new DataPoint(26, 762, 2),
                new DataPoint(30, 856, 3),
                new DataPoint(34, 1063, 4),
                new DataPoint(43, 1190, 5),
                new DataPoint(48, 1298, 6),
                new DataPoint(52, 1421, 7),
                new DataPoint(57, 1440, 8),
                new DataPoint(58, 1518, 9)
*/
/* lineal
                new DataPoint(10, 200, 1),
                new DataPoint(20, 400, 2),
                new DataPoint(30, 600, 3),
                new DataPoint(40, 800, 4),
                new DataPoint(50, 1000, 5),
                new DataPoint(60, 1200, 6),
                new DataPoint(70, 1400, 7),
                new DataPoint(80, 1600, 8),
                new DataPoint(90, 1800, 9)
*/
/* cuadratica
                new DataPoint(1, 1, 1),
                new DataPoint(2, 4, 2),
                new DataPoint(3, 9, 3),
                new DataPoint(4, 16, 4),
                new DataPoint(5, 25, 5),
                new DataPoint(6, 36, 6),
                new DataPoint(7, 49, 7),
                new DataPoint(8, 64, 8),
                new DataPoint(9, 81, 9)
*/
