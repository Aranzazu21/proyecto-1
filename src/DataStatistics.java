public class DataStatistics {
    private final DataPoint[] dataPoints;

    public DataStatistics(DataSet dataSet) {
        this.dataPoints = dataSet.getDataPoints(); // Obtiene los puntos de datos del conjunto
    }

    public double sumX() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX(); // Suma todos los valores de X (publicidad)
        }
        return sum; // Devuelve la suma total de X
    }

    public double sumY() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getY(); // Suma todos los valores de Y (ventas)
        }
        return sum; // Devuelve la suma total de Y
    }

    public int count() {
        return dataPoints.length; // Devuelve el número total de puntos de datos
    }

    public double sumXY() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX() * point.getY(); // Suma del producto XY
        }
        return sum; // Devuelve la suma total del producto XY
    }

    public double sumX2() {
        double sum = 0;
        for (DataPoint point : dataPoints) {
            sum += point.getX() * point.getX(); // Suma de los cuadrados de X
        }
        return sum; // Devuelve la suma total de X^2
    }

    public DataPoint[] getDataPoints() { //
        return dataPoints; // Devuelve todos los puntos de datos
    }
}