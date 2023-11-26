import java.util.ArrayList;
import java.util.List;

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageBuilder wageBuilder = new EmpWageBuilder();
        wageBuilder.addCompanyEmpWage("CompanyA", 20, 10, 100);
        wageBuilder.addCompanyEmpWage("CompanyB", 25, 15, 120);
        wageBuilder.computeEmpWageForAllCompanies();
    }
}

class EmpWageBuilder {
    private List<CompanyEmpWage> companies;

    public EmpWageBuilder() {
        companies = new ArrayList<>();
    }

    public void addCompanyEmpWage(String name, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage newCompany = new CompanyEmpWage(name, wagePerHour, maxWorkingDays, maxWorkingHours);
        companies.add(newCompany);
    }

    public void computeEmpWageForAllCompanies() {
        for (CompanyEmpWage company : companies) {
            company.setTotalWage(this.computeEmpWage(company));
            System.out.println(company);
        }
    }

    private int computeEmpWage(CompanyEmpWage company) {
        int totalWage = 0;
        int totalWorkingHours = 0;
        int workingDays = 0;
        int day = 0;

        while (totalWorkingHours < company.getMaxWorkingHours() && workingDays < company.getMaxWorkingDays()) {
            int employeeType = getEmployeeType();
            int hoursWorked = 0;

            switch (employeeType) {
                case 0:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case 1:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    hoursWorked = 4;
                    break;
                case 2:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    hoursWorked = 8;
                    break;
            }

            totalWage += calculateDailyWage(company.getWagePerHour(), hoursWorked);
            totalWorkingHours += hoursWorked;
            if (employeeType != 0) {
                workingDays++;
            }

            if (totalWorkingHours > company.getMaxWorkingHours()) {
                totalWorkingHours = company.getMaxWorkingHours();
            }

            day++;
        }
        return totalWage;
    }

    private int getEmployeeType() {
        return (int) (Math.random() * 3);
    }

    private int calculateDailyWage(int wagePerHour, int hours) {
        return wagePerHour * hours;
    }
}

class CompanyEmpWage {
    private final String companyName;
    private final int wagePerHour;
    private final int maxWorkingDays;
    private final int maxWorkingHours;
    private int totalWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Total Wage for Company: " + companyName + " is " + totalWage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }
}