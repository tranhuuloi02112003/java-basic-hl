package ProjectManagement;

public class WebProject extends Project {
    private boolean responsiveSupport;

    public void setResponsiveSupport(boolean responsiveSupport) {
        this.responsiveSupport = responsiveSupport;
    }

    public boolean isResponsiveSupport() {
        return responsiveSupport;
    }

    @Override
    void displayInfo() {
        System.out.println("Web project: - Project ID: " + getProjectId()
                + ", Project name: " + getProjectName()
                + ", Responsive: " + (responsiveSupport ? "Yes" : "No"));
        System.out.println("Member list:");
        for (Member member : getMemberList()) {
            System.out.println("Member ID: " + member.getMemberID()
                    + ", Woking days: " + member.getWorkingDays());
        }
    }
}
