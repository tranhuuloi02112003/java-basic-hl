package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public class Management {

    public static boolean addProject(List<Project> projectList, Project newProject) {
        for (Project project : projectList) {
            if (project.getProjectId().equalsIgnoreCase(newProject.getProjectId())) {
                return false;
            }
        }
        projectList.add(newProject);
        return true;
    }

    public static Project findProjectWithMostWorkdays(List<Project> projects) {
        Project result = null;
        int maxWorkdays = 0;

        for (Project project : projects) {
            int sumWorkdays = 0;
            for (Member member : project.getMembers()) {
                sumWorkdays += member.getWorkingDays();
            }

            if (sumWorkdays > maxWorkdays) {
                maxWorkdays = sumWorkdays;
                result = project;
            }
        }
        return result;
    }

    public static void displayProjects(List<Project> projectList) {
        for (Project project : projectList) {
            project.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Project> projectList = new ArrayList<>();

        MobileAppProject mobileAppProject = new MobileAppProject();
        mobileAppProject.setProjectId("MAP01");
        mobileAppProject.setProjectName("Mobile banking app");
        mobileAppProject.setSupportEquipment("IOS, Android");
        try {
            mobileAppProject.setMembers(new ArrayList<>(
                    List.of(
                            new Member("M01", 22),
                            new Member("M02", 11),
                            new Member("M03", 13)
                    )
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        WebProject webProject = new WebProject();
        webProject.setProjectId("WP02");
        webProject.setProjectName("Order management website");
        webProject.setResponsiveSupport(true);
        try {
            webProject.setMembers(new ArrayList<>(
                    List.of(
                            new Member("M04", 30),
                            new Member("M05", 35)
                    )
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        addProject(projectList, mobileAppProject);
        addProject(projectList, webProject);

        Member memberM01 = new Member("M01", 22);
        Member memberM06 = new Member("M06", 17);

        System.out.println("\nTest duplicate member id:");
        try {
            mobileAppProject.setMembers(new ArrayList<>(List.of(memberM01)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAdd valid new members");
        try {
            mobileAppProject.setMembers(new ArrayList<>(List.of(memberM06)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nProject with highest total work days");
        Project project = findProjectWithMostWorkdays(projectList);
        if (project == null) {
            System.out.println("No projects");
        } else {
            project.displayInfo();
        }

        System.out.println("\nList projects:");
        displayProjects(projectList);
    }
}
