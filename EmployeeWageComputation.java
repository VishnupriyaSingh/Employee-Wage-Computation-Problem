public class EmployeeWageComputation {
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int MAX_WORKING_HOURS = 100;
    private static final int MAX_WORKING_DAYS = 20;

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int totalWage = 0;
        int totalWorkingHours = 0;
        int workingDays = 0;
        int day = 0;

        while (totalWorkingHours < MAX_WORKING_HOURS && workingDays < MAX_WORKING_DAYS) {
            int employeeType = getEmployeeType();
            switch (employeeType) {
                case ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    System.out.println("Hours worked: 0");
                    break;
                case PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    System.out.println("Hours worked: " + PART_TIME_HOUR);
                    totalWage += calculateDailyWage(PART_TIME_HOUR);
                    totalWorkingHours += PART_TIME_HOUR;
                    break;
                case FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    System.out.println("Hours worked: " + FULL_DAY_HOUR);
                    totalWage += calculateDailyWage(FULL_DAY_HOUR);
                    totalWorkingHours += FULL_DAY_HOUR;
                    break;
            }

            if (employeeType != ABSENT) {
                workingDays++;
            }

            if (totalWorkingHours > MAX_WORKING_HOURS) {
                totalWorkingHours = MAX_WORKING_HOURS;
            }

            day++;
        }

        System.out.println("Total Wage for the Month: " + totalWage);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Working Days: " + workingDays);
    }

    public static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.33) return ABSENT;
        else if (randomNumber < 0.66) return PART_TIME;
        else return FULL_TIME;
    }

    public static int calculateDailyWage(int hours) {
        return WAGE_PER_HOUR * hours;
    }
}