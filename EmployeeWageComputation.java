public class EmployeeWageComputation {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        if (isEmployeePresent()) {
            System.out.println("Employee is Present");
            int dailyWage = calculateDailyWage();
            System.out.println("Daily Employee Wage: " + dailyWage);
        } else {
            System.out.println("Employee is Absent");
            System.out.println("Daily Employee Wage: 0");
        }
    }

    public static boolean isEmployeePresent() {
        return Math.random() > 0.5;
    }

    public static int calculateDailyWage() {
        return WAGE_PER_HOUR * FULL_DAY_HOUR;
    }
}