public class EmployeeWageComputation {
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        computeEmployeeWage("CompanyA", 20, 10, 100);
        computeEmployeeWage("CompanyB", 25, 15, 120);
    }

    private static void computeEmployeeWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        System.out.println("Wage computation for " + companyName);

        int totalWage = 0;
        int totalWorkingHours = 0;
        int workingDays = 0;
        int day = 0;

        while (totalWorkingHours < maxWorkingHours && workingDays < maxWorkingDays) {
            int employeeType = getEmployeeType();
            int hoursWorked = 0;
            
            switch (employeeType) {
                case ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    hoursWorked = PART_TIME_HOUR;
                    break;
                case FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    hoursWorked = FULL_DAY_HOUR;
                    break;
            }

            totalWage += calculateDailyWage(wagePerHour, hoursWorked);
            totalWorkingHours += hoursWorked;
            if (employeeType != ABSENT) {
                workingDays++;
            }

            if (totalWorkingHours > maxWorkingHours) {
                totalWorkingHours = maxWorkingHours;
            }

            day++;
        }

        System.out.println("Total Wage for " + companyName + ": " + totalWage);
        System.out.println("Total Working Hours: " + totalWorkingHours);
        System.out.println("Total Working Days: " + workingDays);
        System.out.println();
    }

    private static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.33) return ABSENT;
        else if (randomNumber < 0.66) return PART_TIME;
        else return FULL_TIME;
    }

    private static int calculateDailyWage(int wagePerHour, int hours) {
        return wagePerHour * hours;
    }
}