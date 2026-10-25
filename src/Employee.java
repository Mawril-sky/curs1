public class Employee {
    // Статический счётчик для генерации ID
    private static int idCounter = 1;

    // Поля класса
    private final int id;
    private final String fullName;
    private int department;
    private double salary;


    public Employee(String fullName, int department, double salary) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры (только для отдела и зарплаты)
    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 50 && salary <= 450) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата должна быть в интервале 50–450.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(this.salary, employee.salary) == 0;
    }

    @Override
    public int hashCode() {
        // Для согласованности с equals по зарплате
        return java.lang.Double.hashCode(salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ", зарплата: " + salary);
    }
}
