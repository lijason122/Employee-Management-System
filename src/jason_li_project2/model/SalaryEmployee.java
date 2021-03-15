package jason_li_project2.model;

/**
 * This class represents the salaried employee and it extends the employee class
 *
 * @author Jason Li
 */
public class SalaryEmployee extends Employee {

    // Create private data fields
    private double salary;

    /**
     * this is a constructor of salaried employee
     *
     * @param id the id number of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param salary the yearly salary
     */
    public SalaryEmployee(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IllegalArgumentException {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("salary needs to be greater than 0");
        }
    }

    /**
     * this method calculates the payroll for salaried employees
     *
     * @return the payroll
     */
    @Override
    public double calculatePay() {
        return salary / 52;
    }

}
