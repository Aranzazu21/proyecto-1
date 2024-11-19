public class DataSet {
    protected DataPoint[] dataPoints;

    public DataSet() {
        dataPoints = new DataPoint[]{
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


}
/*Datos cubica
                new DataPoint(23, 651),
                new DataPoint(26, 762),
                new DataPoint(30, 856),
                new DataPoint(34, 1063),
                new DataPoint(43, 1190),
                new DataPoint(48, 1298),
                new DataPoint(52, 1421),
                new DataPoint(57, 1440),
                new DataPoint(58, 1518)*/

/*Datos lineal
                new DataPoint(23, 47),
                new DataPoint(26, 53),
                new DataPoint(30, 61),
                new DataPoint(34, 69),
                new DataPoint(43, 87),
                new DataPoint(48, 97),
                new DataPoint(52, 105),
                new DataPoint(57, 115),
                new DataPoint(58, 117)   */

/*Datos cuadratica
                new DataPoint(1, 1),
                new DataPoint(2, 4),
                new DataPoint(3, 9),
                new DataPoint(4, 16),
                new DataPoint(5, 25),
                new DataPoint(6, 36),
                new DataPoint(7, 49),
                new DataPoint(8, 64),
                new DataPoint(9, 81)*/