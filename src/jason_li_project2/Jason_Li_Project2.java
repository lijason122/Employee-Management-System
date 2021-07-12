package jason_li_project2;

import jason_li_project2.model.CommissionEmployee;
import jason_li_project2.model.HourlyEmployee;
import jason_li_project2.model.SalaryEmployee;
import jason_li_project2.model.Employee;
import jason_li_project2.model.ManagementMethods;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates and displays the reports of employee listing and payroll listing
 *
 * @author Jason Li
 */
public class Jason_Li_Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        ArrayList<Integer> employeesId = new ArrayList<>();

        System.out.print("How many employees to create? ");

        int numberEmployees = -1;

        // want to keep asking the user until they enter a valid number of employees
        numberEmployees = ManagementMethods.numberOfEmployees(numberEmployees);

        // create a loop that will go for each element of the array list
        // creating an instance and adding to the array list.
        for (int i = 0; i < numberEmployees; i++) {

            System.out.printf("Employee data for employee %d of %d\n", i + 1, numberEmployees);

            System.out.print("Choose type of employee to add.\n1. Salaried\n2. Hourly\n3. Commission: ");

            int option = -1;
            // want to keep asking the user until they enter a valid number of option (1, 2, or 3)
            option = ManagementMethods.optionInput(option);

            System.out.print("Employee ID: ");
            int id = -1;
            // want to keep asking the user until they enter a valid number of employees
            id = ManagementMethods.employeeId(id);

            // want to keep asking the user until they enter an unique ID from the ID array list
            while (employeesId.contains(id)) {
                System.out.print("That id is already taken: Employee ID: ");
                id = ManagementMethods.employeeId(id);
            }
            // add the unique ID to the ID array list
            employeesId.add(id);

            System.out.print("First Name: ");
            String firstName = "";
            // want to keep asking the user until they enter at least three character and no numbers
            firstName = ManagementMethods.moreThanTwoLetters(firstName);

            System.out.print("Last Name: ");
            String lastName = "";
            // want to keep asking the user until they enter at least three character and no numbers
            lastName = ManagementMethods.moreThanTwoLetters(lastName);

            switch (option) {
                case 1: {
                    System.out.print("Salary: ");

                    double salary = -1;
                    // want to keep asking the user until they enter a valid number of salary
                    salary = ManagementMethods.decimalNumber(salary);

                    System.out.println();
                    // now that we have the requirements, we can create an instance of salaried employee
                    Employee employee = new SalaryEmployee(id, firstName, lastName, salary);
                    // now add it to the array list
                    employees.add(employee);
                    break;
                }
                case 2: {
                    System.out.print("Hours Worked: ");

                    double numHours = -1;
                    // want to keep asking the user until they enter a valid number of hours
                    numHours = ManagementMethods.decimalNumber(numHours);

                    System.out.print("Hourly Rate: ");

                    double hourlyRate = -1;
                    // want to keep asking the user until they enter a valid number of the rate per hour
                    hourlyRate = ManagementMethods.decimalNumber(hourlyRate);

                    System.out.println();
                    // now that we have the requirements, we can create an instance of hourly employee
                    Employee employee = new HourlyEmployee(id, firstName, lastName, numHours, hourlyRate);
                    // now add it to the array list
                    employees.add(employee);
                    break;
                }
                default: {
                    System.out.print("Commission Rate: ");

                    double rate = -1;
                    // want to keep asking the user until they enter a valid number of the rate percentage
                    rate = ManagementMethods.rateNumber(rate);

                    System.out.print("Sales: ");

                    double sales = -1;
                    // want to keep asking the user until they enter a valid number of sales
                    sales = ManagementMethods.decimalNumber(sales);

                    System.out.println();
                    // now that we have the requirements, we can create an instance of commission employee
                    Employee employee = new CommissionEmployee(id, firstName, lastName, rate, sales);
                    // now add it to the array list
                    employees.add(employee);
                    break;
                }
            }

        }

        do {
            System.out.println("\nChoose a Report.");

            System.out.print("1. Employee listing\n2. Payroll listing\n3. Exit: ");

            int option2 = -1;
            // want to keep asking the user until they enter a valid number of option (1, 2, or 3)
            option2 = ManagementMethods.optionInput(option2);

            switch (option2) {
                case 1:
                    // display a list of the employee's info
                    ManagementMethods.displayEmployeeInfo(employees);
                    break;
                case 2:
                    // display a list of the employee's payroll
                    ManagementMethods.displayEmployeePayroll(employees);
                    break;
                default:
                    // exit the application
                    System.exit(0);
            }

        } while (true);

    }

}
