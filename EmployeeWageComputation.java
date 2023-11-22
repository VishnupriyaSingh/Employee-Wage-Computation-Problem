public class EmployeeWageComputation {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int employeeType = getEmployeeType();

        switch (employeeType) {
            case ABSENT:
                System.out.println("Employee is Absent");
                System.out.println("Daily Employee Wage: 0");
                break;
            case PART_TIME:
                System.out.println("Employee is Part-time");
                System.out.println("Daily Employee Wage: " + calculateDailyWage(PART_TIME_HOUR));
                break;
            case FULL_TIME:
                System.out.println("Employee is Full-time");
                System.out.println("Daily Employee Wage: " + calculateDailyWage(FULL_DAY_HOUR));
                break;
            default:
                System.out.println("Invalid Employee Type");
                break;
        }
    }

    public static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.33)
            return ABSENT;
        else if (randomNumber < 0.66)
            return PART_TIME;
        else
            return FULL_TIME;
    }

    public static int calculateDailyWage(int hours) {
        return WAGE_PER_HOUR * hours;
    }
}