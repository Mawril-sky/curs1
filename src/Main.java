public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        // Создаём 11 сотрудников и пытаемся добавить их
        for (int i = 1; i <= 11; i++) {
            String name = "Сотрудник_" + i;
            int department = (i % 5) + 1;
            double salary = 50 + (i * 20);
            if (salary > 450) salary = 450;

            Employee emp = new Employee(name, department, salary);
            boolean added = book.addEmployee(emp);
            System.out.println("Попытка добавить сотрудника " + name + ": " + (added ? "успешно" : "не удалось (нет места)"));
        }

        System.out.println("\n--- Все сотрудники ---");
        book.printAllEmployees();

        System.out.println("\n--- Средняя зарплата ---");
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        System.out.println("\n--- Налоги (PROPORTIONAL) ---");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n--- Налоги (PROGRESSIVE) ---");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n--- Индексация отдела 3 на 10% ---");
        book.indexSalariesInDepartment(3, 10.0);

        System.out.println("\n--- Первый сотрудник отдела 2 с зарплатой > 200 ---");
        book.findFirstEmployeeAboveWage(2, 200);

        System.out.println("\n--- Первые 3 сотрудника с зарплатой < 300 ---");
        book.printFirstEmployeesBelowWage(300, 3);

        System.out.println("\n--- Проверка наличия сотрудника по зарплате (бухгалтерский учёт) ---");
        Employee sample = new Employee("Тест", 1, 250);
        System.out.println("Есть ли сотрудник с такой же зарплатой (250)? " + book.containsEmployeeByAccounting(sample));

        System.out.println("\n--- Поиск сотрудника по ID ---");
        Employee found = book.getEmployeeById(5);
        if (found != null) {
            found.printShortInfo();
        } else {
            System.out.println("Сотрудник с ID=5 не найден");
        }
    }
}
