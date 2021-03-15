package jason_li_project2.model;

/**
 * This class represents the commission employee and it extends the employee class
 *
 * @author Jason Li
 */
public class CommissionEmployee extends Employee {

    // Create private data fields
    private double rate;
    private double sales;

    /**
     * this is a constructor of commission employee
     *
     * @param id the id number of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param rate the rate percentage
     * @param sales the total sales
     */
    public CommissionEmployee(int id, String firstName, String lastName, double rate, double sales) {
        super(id, firstName, lastName);
        setRate(rate);
        setSales(sales);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) throws IllegalArgumentException {
        if (rate >= 0.5 && rate <= 20) {
            this.rate = rate;
        } else {
            throw new IllegalArgumentException("Invalid rate");
        }
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        if (sales > 0) {
            this.sales = sales;
        } else {
            System.out.print("sales needs to be greater than 0");
        }
    }

    /**
     * this method calculates the payroll for commission employees
     *
     * @return the payroll
     */
    @Override
    public double calculatePay() {
        return sales * rate / 100;
    }

}
