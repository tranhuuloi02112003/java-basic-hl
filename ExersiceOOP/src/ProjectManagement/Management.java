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

    public static Project findProjectById(List<Project> projectList, String projectId) {
        for (Project project : projectList) {
            if (project.getProjectId().equalsIgnoreCase(projectId)) {
                return project;
            }
        }
        return null;
    }

    public static boolean addMemberToProject(List<Project> projectList, String projectID, Member newMember) {
        Project project = findProjectById(projectList, projectID);
        if (project == null) {
            System.out.println("Project not found!");
            return false;
        }

        for (Member member : project.getMemberList()) {
            if (member.getMemberID().equalsIgnoreCase(newMember.getMemberID())) {
                System.out.println("Member ID already exists in this project!");
                return false;
            }
        }

        project.getMemberList().add(newMember);
        System.out.println("Member added successfully");
        return true;
    }

    public static Project findProjectWithMostWorkdays(List<Project> projectList) {
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

    public static void sortProjectMembersByWorkingDays(List<Project> projectList) {
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

    public static void displayAllProjects(List<Project> projectList) {
        for (Project project : projectList) {
            project.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Project> projectList = new ArrayList<>();

        MobileAppProject map = new MobileAppProject();
        map.setProjectId("MAP01");
        map.setProjectName("Mobile banking app");
        map.setSupportEquipment("IOS, Android");
        map.setMemberList(new ArrayList<>());

        WebProject wp = new WebProject();
        wp.setProjectId("WP02");
        wp.setProjectName("Order management website");
        wp.setResponsiveSupport(true);
        wp.setMemberList(new ArrayList<>());

        addProject(projectList, map);
        addProject(projectList, wp);

        System.out.println("Add member in project:");
        Member m1 = new Member();
        m1.setMemberID("M01");
        m1.setWorkingDays(22);
        Member m2 = new Member();
        m2.setMemberID("M02");
        m2.setWorkingDays(11);
        Member m3 = new Member();
        m3.setMemberID("M03");
        m3.setWorkingDays(13);
        Member m4 = new Member();
        m4.setMemberID("M04");
        m4.setWorkingDays(28);
        Member m5 = new Member();
        m5.setMemberID("M05");
        m5.setWorkingDays(35);

        addMemberToProject(projectList, "MAP01", m1);
        addMemberToProject(projectList, "MAP01", m2);
        addMemberToProject(projectList, "MAP01", m3);
        addMemberToProject(projectList, "WP02", m4);
        addMemberToProject(projectList, "WP02", m5);

        System.out.println("\nTest duplicate member id:");
        addMemberToProject(projectList, "MAP01", m1);


        System.out.println("\nProject with highest total work days");
        Project project = findProjectWithMostWorkdays(projectList);
        if (project == null) {
            System.out.println("No projects");
        } else {
            project.displayInfo();
        }

        System.out.println("\nProject list before sort project members");
        displayAllProjects(projectList);

        System.out.println("\nProject list after sort project members");
        sortProjectMembersByWorkingDays(projectList);
        displayAllProjects(projectList);
    }
}
