public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }


    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }


    public double calculateAverageSalary() {
        double sum = 0;
        int count = 0;

        for (Employee e : employees) {
            if (e == null) {
                break; // останавливаемся на первом null
            }
            sum += e.getSalary();
            count++;
        }

        return count == 0 ? 0 : sum / count;
    }


    public void printTaxes(String taxType) {
        for (Employee e : employees) {
            if (e == null) break;
            double tax = calculateTaxForEmployee(e.getSalary(), taxType);
            System.out.println("Сотрудник: " + e.getFullName() +
                    ", зарплата: " + e.getSalary() +
                    ", налог: " + tax);
        }
    }

    private double calculateTaxForEmployee(double salary, String taxType) {
        switch (taxType) {
            case "PROPORTIONAL":
                return salary * 0.13;
            case "PROGRESSIVE":
                if (salary <= 150) {
                    return salary * 0.13;
                } else if (salary <= 350) {
                    return salary * 0.17;
                } else {
                    return salary * 0.21;
                }
            default:
                throw new IllegalArgumentException("Неизвестный тип налога: " + taxType);
        }
    }

    public void indexSalariesInDepartment(int department, double percent) {
        for (Employee e : employees) {
            if (e == null) break;

            if (e.getDepartment() != department) {
                continue;
            }

            double increase = e.getSalary() * (percent / 100.0);
            double newSalary = e.getSalary() + increase;

            e.setSalary(newSalary);
        }
    }

    public void findFirstEmployeeAboveWage(int department, double wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) break;

            if (e.getDepartment() == department && e.getSalary() > wage) {
                System.out.println("Найден сотрудник (порядковый номер в списке: " + (i + 1) + "):");
                e.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }


    public void printFirstEmployeesBelowWage(double wage, int employeeNumber) {
        int count = 0;
        int index = 0;

        while (index < employees.length) {
            Employee e = employees[index];
            if (e == null) break;

            if (e.getSalary() < wage) {
                e.printShortInfo();
                count++;
                if (count >= employeeNumber) {
                    break;
                }
            }
            index++;
        }
    }

    public boolean containsEmployeeByAccounting(Employee employee) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.equals(employee)) {
                return true;
            }
        }
        return false;
    }


    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
