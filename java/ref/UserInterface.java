package ref;

import java.util.Scanner;

public class UserInterface {

    public static void func(String[] args) {

        try {

            EmployeeServices services = new EmployeeServices();

            while(true){
            System.out.println("Please select one of the following options: \n 1- List all employees \n 2- List all employees in a specific department \n 3- List all employeess whose salary is higher than a specific amount \n 4- Raise all employees salaries in a department    \n 5- Print the sum of salaries in a department \n 6- Delete an employee \n 7- Exit");
            int userInput = Integer.parseInt(getUserInput(null));

            if (userInput == 1) {
                services.printAllEmployees();

            } else if (userInput == 2) {
                int deptId = Integer.parseInt(getUserInput("Which Department ID?"));
                services.printEmployeesByDepartment(deptId);

            }

            else if (userInput == 3) {
                int salary = Integer.parseInt(getUserInput("Salary value?"));
                services.printEmployeesWithSalaryGreaterThanLimit(salary);

            }
            else if (userInput == 4) {
                int deptId = Integer.parseInt(getUserInput(" Which department?"));
                int percentage = Integer.parseInt(getUserInput(" What raise percentage?"));
                services.raiseEmployeesSalariesInDept(deptId, percentage);

            }
            else if (userInput == 5) {
                int deptId = Integer.parseInt(getUserInput(" Which department?"));
                services.sumEmployeesSalariesByDept(deptId);

            }
            else if (userInput == 6) {
                int empId = Integer.parseInt(getUserInput(" Which Employee?"));
                services.deleteEmployee(empId);

            }





            else if (userInput == 7) {

                System.exit(0);
            }


        }


        } catch (Exception e) {

            e.printStackTrace();
        }





    }







    public static String getUserInput(String msg) {
        Scanner myObj = new Scanner(System.in);
        if (msg != null)
            System.out.println(msg);

        String input = myObj.nextLine();
        return input;


    }

}
