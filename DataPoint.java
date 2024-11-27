public class DataPoint {
    private double advertising;
    private double sales;
    private int year;


    public DataPoint(double advertising, double sales, int year) {
        this.advertising = advertising;
        this.sales = sales;
        this.year = year;
    }

    public double getAdvertising() {
        return advertising;
    }

    public double getSales() {
        return sales;
    }

    public int getYear() {
        return year;
    }
}