import java.util.ArrayList;
import java.util.List;

interface IEmployeeWageComputation {
    void addCompanyEmpWage(String name, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
    void computeEmpWageForAllCompanies();
    int getTotalWageByCompanyName(String companyName);
}

public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        IEmployeeWageComputation wageBuilder = new EmpWageBuilder();
        wageBuilder.addCompanyEmpWage("CompanyA", 20, 10, 100);
        wageBuilder.addCompanyEmpWage("CompanyB", 25, 15, 120);
        wageBuilder.computeEmpWageForAllCompanies();

        System.out.println("Total Wage for CompanyA: " + wageBuilder.getTotalWageByCompanyName("CompanyA"));
        System.out.println("Total Wage for CompanyB: " + wageBuilder.getTotalWageByCompanyName("CompanyB"));
    }
}

class EmpWageBuilder implements IEmployeeWageComputation {
    private List<CompanyEmpWage> companies;

    public EmpWageBuilder() {
        companies = new ArrayList<>();
    }

    @Override
    public void addCompanyEmpWage(String name, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        CompanyEmpWage newCompany = new CompanyEmpWage(name, wagePerHour, maxWorkingDays, maxWorkingHours);
        companies.add(newCompany);
    }

    @Override
    public void computeEmpWageForAllCompanies() {
        for (CompanyEmpWage company : companies) {
            company.setTotalWage(this.computeEmpWage(company));
            System.out.println(company);
            System.out.println("Daily Wages: " + company.getDailyWages());
        }
    }

    @Override
    public int getTotalWageByCompanyName(String companyName) {
        for (CompanyEmpWage company : companies) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getTotalWage();
            }
        }
        return -1; 
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

            int dailyWage = calculateDailyWage(company.getWagePerHour(), hoursWorked);
            company.addDailyWage(dailyWage);
            totalWage += dailyWage;
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
    private List<Integer> dailyWages;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
    }

    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
    }

    public List<Integer> getDailyWages() {
        return dailyWages;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public int getTotalWage() {
        return totalWage;
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