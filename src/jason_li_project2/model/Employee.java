package jason_li_project2.model;

/**
 * This class represents the employee
 *
 * @author Jason Li
 */
public abstract class Employee {

    // Create private data fields
    private int id;
    private String firstName;
    private String lastName;

    /**
     * This is a constructor of employee
     *
     * @param id the id number of the employee
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     */
    public Employee(int id, String firstName, String lastName) {
        setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IllegalArgumentException {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("id needs to be greater than 0");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * this method calculates the payroll for employees
     *
     * @return the payroll
     */
    abstract double calculatePay();

    /**
     * this method represents the employee's id information
     *
     * @return the employee's id information
     */
    @Override
    public String toString() {
        String format = "Employee %d: %s, %s\n   ";
        return String.format(format, getId(), getLastName(), getFirstName());
    }

}
