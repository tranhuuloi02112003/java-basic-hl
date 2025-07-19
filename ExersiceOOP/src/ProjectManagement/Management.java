package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public class Management {
    private static List<Project> projectList = new ArrayList<Project>();

    public static boolean addProject(Project newProject) {
        for (Project project : projectList) {
            if (project.getProjectId().equalsIgnoreCase(newProject.getProjectId())) {
                return false;
            }
        }
        projectList.add(newProject);
        return true;
    }

    public static Project findProjectByProjectId(String projectId) {
        for (Project project : projectList) {
            if (project.getProjectId().equalsIgnoreCase(projectId)) {
                return project;
            }
        }
        return null;
    }

    public static boolean addMember(String projectID, Member newMember) {
        Project project = findProjectByProjectId(projectID);
        if (project == null) {
            System.out.println("Project not found!");
            return false;
        }
        for (Member member : project.getMemberList()) {
            if (member.getMemberID().equalsIgnoreCase(newMember.getMemberID())) {
                System.out.println("Member id already exists in this project!");
                return false;
            }
        }
        project.getMemberList().add(newMember);
        System.out.println("Member added successfully");
        return true;
    }

    public static Project findProjectWithMostWorkdays() {
        Project result = null;
        int maxWorkdays = 0;
        for (Project project : projectList) {
            int sumWorkdays = 0;
            for (Member member : project.getMemberList()) {
                sumWorkdays += member.getWorkingDays();
            }
            if (sumWorkdays > maxWorkdays) {
                maxWorkdays = sumWorkdays;
                result = project;
            }
        }
        return result;
    }

    public static void sortMemberByWorkingDays() {
        for (Project project : projectList) {
            List<Member> memberList = project.getMemberList();
            for (int i = 0; i < memberList.size() - 1; i++) {
                for (int j = i + 1; j < memberList.size(); j++) {
                    if (memberList.get(i).getWorkingDays() < memberList.get(j).getWorkingDays()) {
                        Member temp = memberList.get(i);
                        memberList.set(i, memberList.get(j));
                        memberList.set(j, temp);
                    }
                }
            }
        }
    }

    public static void displayAllProjects() {
        for (Project project : projectList) {
            project.displayInfo();
        }
    }

    public static void main(String[] args) {
        projectList.add(new MobileAppProject("MAP01", "Mobile banking app", "IOS, Android"));
        projectList.add(new WebProject("WP02", "Order management website", true));

        System.out.println("Add member in project:");
        addMember("MAP01", new Member("M01", 22));
        addMember("MAP01", new Member("M02", 11));
        addMember("MAP01", new Member("M03", 13));
        addMember("WP02", new Member("M04", 28));
        addMember("WP02", new Member("M05", 35));

        System.out.println("\nTest duplicate member id:");
        addMember("MAP01", new Member("M02", 21));

        System.out.println("\nProject with highest total work days");
        Project project = findProjectWithMostWorkdays();
        if (project == null) {
            System.out.println("\nNo projects");
        } else {
            project.displayInfo();
        }

        System.out.println("\nProject list before sort project members");
        displayAllProjects();
        System.out.println("\nProject list after sort project members");
        sortMemberByWorkingDays();
        displayAllProjects();
    }
}
