package ProjectManagement;

public class WebProject extends Project {
    private boolean responsiveSupport;

    public void setResponsiveSupport(boolean responsiveSupport) {
        this.responsiveSupport = responsiveSupport;
    }

    @Override
    void displayInfo() {
        System.out.println("Web project: - Project ID: " + getProjectId()
                + ", Project name: " + getProjectName()
                + ", Responsive: " + (responsiveSupport ? "Yes" : "No"));
        System.out.println("Member list:");
        for (Member member : getMembers()) {
            System.out.println("Member ID: " + member.getMemberId()
                    + ", Woking days: " + member.getWorkingDays());
        }
    }
}
