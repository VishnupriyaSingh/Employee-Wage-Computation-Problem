public class EmployeeWageComputation {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int totalWage = 0;
        for (int day = 0; day < WORKING_DAYS_PER_MONTH; day++) {
            int employeeType = getEmployeeType();
            switch (employeeType) {
                case ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    totalWage += calculateDailyWage(PART_TIME_HOUR);
                    break;
                case FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    totalWage += calculateDailyWage(FULL_DAY_HOUR);
                    break;
            }
        }
        System.out.println("Total Wage for the Month: " + totalWage);
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