package ProjectManagement;

public class MobileAppProject extends Project {
    private String supportEquipment;

    public void setSupportEquipment(String supportEquipment) {
        this.supportEquipment = supportEquipment;
    }

    public String getSupportEquipment() {
        return supportEquipment;
    }

    @Override
    void displayInfo() {
        System.out.println("Mobile app project: - Project ID: " + getProjectId()
                + ", Project name: " + getProjectName()
                + ", Support equipment: " + getSupportEquipment());
        System.out.println("Member list:");
        for (Member member : getMemberList()) {
            System.out.println("Member ID: " + member.getMemberID()
                    + ", Woking days: " + member.getWorkingDays());
        }
    }
}
