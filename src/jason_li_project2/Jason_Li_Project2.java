package jason_li_project2;

import jason_li_project2.model.CommissionEmployee;
import jason_li_project2.model.HourlyEmployee;
import jason_li_project2.model.SalaryEmployee;
import jason_li_project2.model.Employee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is going to create and display the reports of employee listing and payroll listing
 *
 * @author Jason Li
 */
public class Jason_Li_Project2 {

    /**
     * this method asks the user for the number of employees
     *
     * @param numberEmployees the number of employees
     * @return the number of employees
     */
    public static int numberOfEmployees(int numberEmployees) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                numberEmployees = input.nextInt();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (numberEmployees > 0) {
                    return numberEmployees;
                } else {
                    System.out.println("Please enter a valid number of employees. (Minimum: 1)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method asks the user for the employee's id
     *
     * @param id the id number
     * @return the id number
     */
    public static int employeeId(int id) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                id = input.nextInt();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (id > 0) {
                    return id;
                } else {
                    System.out.println("Please enter a valid id number. (Minimum: 1)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method asks the user to enter a number from the option (1, 2, or 3)
     *
     * @param option the number from the user input
     * @return the number of option (1, 2, or 3)
     */
    public static int optionInput(int option) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                option = input.nextInt();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (option == 1 || option == 2 || option == 3) {
                    return option;
                } else {
                    System.out.println("Please enter a valid number. (1, 2, or 3)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number of option.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method asks the user for the employee's name
     *
     * @param letters the name of the employee
     * @return the string with at least three letters and it contains no numbers
     */
    public static String moreThanTwoLetters(String letters) {
        Scanner input = new Scanner(System.in);
        do {
            int i; // this is for checking if all the characters are letters
            letters = input.nextLine();
            if (letters.length() > 2) {
                char[] arrChar = letters.toCharArray(); // method from tutorialspoint.com
                for (i = 0; i < arrChar.length; i++) {
                    // this shows that the user enter a full name
                    if (arrChar[i] == ' ') {
                    } // check if each character contains a number
                    else if (!Character.isLetter(arrChar[i])) { // method from tutorialspoint.com
                        System.out.println("Only letters are allowed, please try again.");
                        break;
                    }
                }
                // this shows that the string contains no numbers since it checked all the characters
                if (i == arrChar.length) {
                    return letters;
                }
            } else {
                System.out.println("Must be more than two characters, please try again.");
            }
        } while (true);
    }

    /**
     * this method asks the user for the number of hours, rate per hour, salary, or sales number
     *
     * @param number the number of hours, rate per hour, salary, or sales number
     * @return the number of hours, rate per hour, salary, or sales number
     */
    public static double decimalNumber(double number) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                number = input.nextDouble();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Please enter a valid number. (Minimum: 1)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method asks the user for the number of the rate percentage
     *
     * @param number the number of the rate percentage
     * @return the number of the rate percentage
     */
    public static double rateNumber(double number) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                number = input.nextDouble();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (number >= 0.5 && number <= 20) {
                    return number;
                } else {
                    System.out.println("Please enter a valid rate percentage between 0.5 and 20");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method displays a list of the employee's info
     *
     * @param employees the list of employees
     */
    public static void displayEmployeeInfo(ArrayList<Employee> employees) {
        for (Employee UniqueEmployee : employees) {

            System.out.print(UniqueEmployee.toString());

            if (UniqueEmployee instanceof SalaryEmployee) {
                System.out.printf("Salary: $%.2f\n", ((SalaryEmployee) UniqueEmployee).getSalary());
            } else if (UniqueEmployee instanceof HourlyEmployee) {
                System.out.printf("Hours: %.1f\n   Rate: $%.2f\n", ((HourlyEmployee) UniqueEmployee).getNumHours(), ((HourlyEmployee) UniqueEmployee).getHourlyRate());
            } else {
                System.out.printf("Commission Rate: %.1f\n   Sales: $%.2f\n", ((CommissionEmployee) UniqueEmployee).getRate(), ((CommissionEmployee) UniqueEmployee).getSales());
            }
        }
    }

    /**
     * this method displays a list of the employee's payroll
     *
     * @param employees the list of employees
     */
    public static void displayEmployeePayroll(ArrayList<Employee> employees) {
        for (Employee UniqueEmployee : employees) {

            String format = "Weekly pay for %s, %s employee id %d is $%.2f\n";

            if (UniqueEmployee instanceof SalaryEmployee) {
                System.out.printf(format, UniqueEmployee.getLastName(), UniqueEmployee.getFirstName(), UniqueEmployee.getId(), ((SalaryEmployee) UniqueEmployee).calculatePay());
            } else if (UniqueEmployee instanceof HourlyEmployee) {
                System.out.printf(format, UniqueEmployee.getLastName(), UniqueEmployee.getFirstName(), UniqueEmployee.getId(), ((HourlyEmployee) UniqueEmployee).calculatePay());
            } else {
                System.out.printf(format, UniqueEmployee.getLastName(), UniqueEmployee.getFirstName(), UniqueEmployee.getId(), ((CommissionEmployee) UniqueEmployee).calculatePay());
            }
        }
    }

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
        numberEmployees = numberOfEmployees(numberEmployees);

        // create a loop that will go for each element of the array list
        // creating an instance and adding to the array list.
        for (int i = 0; i < numberEmployees; i++) {

            System.out.printf("Employee data for employee %d of %d\n", i + 1, numberEmployees);

            System.out.print("Choose type of employee to add.\n1. Salaried\n2. Hourly\n3. Commission: ");

            int option = -1;
            // want to keep asking the user until they enter a valid number of option (1, 2, or 3)
            option = optionInput(option);

            System.out.print("Employee ID: ");
            int id = -1;
            // want to keep asking the user until they enter a valid number of employees
            id = employeeId(id);

            // want to keep asking the user until they enter an unique ID from the ID array list
            while (employeesId.contains(id)) {
                System.out.print("That id is already taken: Employee ID: ");
                id = employeeId(id);
            }
            // add the unique ID to the ID array list
            employeesId.add(id);

            System.out.print("First Name: ");
            String firstName = "";
            // want to keep asking the user until they enter at least three character and no numbers
            firstName = moreThanTwoLetters(firstName);

            System.out.print("Last Name: ");
            String lastName = "";
            // want to keep asking the user until they enter at least three character and no numbers
            lastName = moreThanTwoLetters(lastName);

            switch (option) {
                case 1: {
                    System.out.print("Salary: ");

                    double salary = -1;
                    // want to keep asking the user until they enter a valid number of salary
                    salary = decimalNumber(salary);

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
                    numHours = decimalNumber(numHours);

                    System.out.print("Hourly Rate: ");

                    double hourlyRate = -1;
                    // want to keep asking the user until they enter a valid number of the rate per hour
                    hourlyRate = decimalNumber(hourlyRate);

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
                    rate = rateNumber(rate);

                    System.out.print("Sales: ");

                    double sales = -1;
                    // want to keep asking the user until they enter a valid number of sales
                    sales = decimalNumber(sales);

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
            option2 = optionInput(option2);

            switch (option2) {
                case 1:
                    // display a list of the employee's info
                    displayEmployeeInfo(employees);
                    break;
                case 2:
                    // display a list of the employee's payroll
                    displayEmployeePayroll(employees);
                    break;
                default:
                    // exit the application
                    System.exit(0);
            }

        } while (true);

    }

}
