public class EmployeeWageComputation {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int employeeType = getEmployeeType();

        switch (employeeType) {
            case 0:
                System.out.println("Employee is Absent");
                System.out.println("Daily Employee Wage: 0");
                break;
            case 1:
                System.out.println("Employee is Part-time");
                int partTimeWage = calculateDailyWage(PART_TIME_HOUR);
                System.out.println("Daily Employee Wage: " + partTimeWage);
                break;
            case 2:
                System.out.println("Employee is Full-time");
                int fullTimeWage = calculateDailyWage(FULL_DAY_HOUR);
                System.out.println("Daily Employee Wage: " + fullTimeWage);
                break;
        }
    }

    public static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.33)
            return 0;
        else if (randomNumber < 0.66)
            return 1;
        else
            return 2;
    }

    public static int calculateDailyWage(int hours) {
        return WAGE_PER_HOUR * hours;
    }
}