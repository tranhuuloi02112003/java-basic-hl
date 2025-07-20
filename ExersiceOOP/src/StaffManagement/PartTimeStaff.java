package StaffManagement;

public class PartTimeStaff extends Staff {
    private int contractsPerMonth;

    public void setContractsPerMonth(int contractsPerMonth) {
        this.contractsPerMonth = contractsPerMonth;
    }

    public int getContractsPerMonth() {
        return contractsPerMonth;
    }

    @Override
    void displayInfo() {
        System.out.println("Part time staff - ID: " + getId()
                + ", Name: " + getName()
                + ", Base salary: " + getBaseSalary()
                + ", Coefficient: " + getExperienceCoefficient()
                + ", Contract per month: " + getContractsPerMonth());
    }
}
