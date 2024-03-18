import java.util.ArrayList;
import java.util.Scanner;

//-----------employee class which store the detial of full time and part time employee detial--------
abstract class Employee{
//    ----use access specifier ---
    private String name;
    private int id;
//    ----- use constructer --
    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
// ----- use incapculation ---
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
//    ---- use abstract method ----
    public abstract double calculateSalary();

}


//------------- inheritence used(full time employee class )--------
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
//        -- using super class constracter values by super keyword ----
        super(name,id);
        this.monthlySalary = monthlySalary;
    }
//    ---- using override method from super class----
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

    @Override
    public String toString(){
        return "FullTime Employee [name = " +getName()+ ", id = " +getId()+ ", salary = " +calculateSalary() +"]";
    }
}


//-------- part time employee extended from employee class----------
class PartTimeSalary extends Employee{
    private int hoursWorked;
    private double hoursRate;
    public PartTimeSalary(String name, int id, int hoursWorked, double hoursRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hoursRate = hoursRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hoursRate;
    }

    @Override
    public String toString(){
        return "PartTime Employee [name = " +getName()+ ", id = " +getId()+ ", salary = " +calculateSalary() +"]";
    }

}

//-------PayrollSyatem class which perform some opration like---------
//1. add employee
//2. remove employee
//3. display employee
//4. calculate salary
class PayrollSystem{
    private ArrayList<Employee> employeesList;
    public PayrollSystem(){
        employeesList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeesList.add(employee);
    }
    public void removeEmployee(int id ){
        Employee employeeToRemove = null;
        for(Employee employee : employeesList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeesList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(Employee employee : employeesList){
            System.out.println(employee);
        }
    }
}
//---------------------main class which call all classes with their objects----------------------
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollSystem payroll = new PayrollSystem();

        System.out.println("enter full time employee detials: name, id and salary");
        String name = sc.nextLine();
        int id = sc.nextInt();
        double salary = sc.nextDouble();
        FullTimeEmployee emp1 = new FullTimeEmployee(name, id, salary);

        System.out.println("enter part time employee detials: name, id, hourWorked and hourRate ");
        String name1 = "" ;
        int hoursWorked = 0;
        int id2 = 0;
        double hoursRate = 0.0;

        try {
             name1 = sc.next();
             sc.nextLine();
            id2 = sc.nextInt();
             hoursWorked = sc.nextInt();
             hoursRate = sc.nextInt();
        } catch (Exception e) {
        }

        PartTimeSalary emp2 = new PartTimeSalary(name1, id2, hoursWorked, hoursRate);

        payroll.addEmployee(emp1);
        payroll.addEmployee(emp2);

        System.out.println("Employee detial: ");
        payroll.displayEmployee();

        System.out.println("which id you wat to remove");
        int removeId = sc.nextInt();
        payroll.removeEmployee(removeId);
        System.out.println("Remaing Employee detial: ");
        payroll.displayEmployee();
        
    }
}
