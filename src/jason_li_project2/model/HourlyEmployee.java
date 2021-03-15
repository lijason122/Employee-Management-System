package jason_li_project2.model;

/**
 * This class represents the hourly employee and it extends the employee class
 *
 * @author Jason Li
 */
public class HourlyEmployee extends Employee {

    // Create private data fields
    private double numHours;
    private double hourlyRate;

    /**
     * this is a constructor of hourly employee
     *
     * @param id the id number of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param numHours the number of hours
     * @param hourlyRate the rate per hour
     */
    public HourlyEmployee(int id, String firstName, String lastName, double numHours, double hourlyRate) {
        super(id, firstName, lastName);
        setNumHours(numHours);
        setHourlyRate(hourlyRate);
    }

    public double getNumHours() {
        return numHours;
    }

    public void setNumHours(double numHours) throws IllegalArgumentException {
        if (numHours > 0) {
            this.numHours = numHours;
        } else {
            throw new IllegalArgumentException("number of hours needs to be greater than 0");
        }
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.print("rate per hour needs to be greater than 0");
        }
    }

    /**
     * this method calculates the payroll for hourly employees
     *
     * @return the payroll
     */
    @Override
    public double calculatePay() {
        return numHours * hourlyRate;
    }

}
