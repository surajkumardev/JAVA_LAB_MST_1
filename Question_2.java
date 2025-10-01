import java.util.HashMap;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

class EmployeeDirectory {
    private HashMap<Integer, String> employees = new HashMap<>();

    // 1. Add employees
    public void addEmployee(int id, String name) {
        employees.put(id, name);
    }

    // 2. Retrieve employee by ID
    public String getEmployee(int id) throws EmployeeNotFoundException {
        if (!employees.containsKey(id)) {
            throw new EmployeeNotFoundException("Error: Employee ID not found!");
        }
        return employees.get(id);
    }

    // 3. Display all employees
    public void displayEmployees() {
        System.out.println("Employee Map: " + employees);
    }
}

public class HashMapExample {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        System.out.println("Adding employees...");
        directory.addEmployee(101, "John");
        directory.addEmployee(102, "Jane");
        directory.addEmployee(103, "Mike");

        directory.displayEmployees();

        try {
            System.out.println("Name for ID 102: " + directory.getEmployee(102));
            System.out.println("Name for ID 999: " + directory.getEmployee(999)); 
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}





