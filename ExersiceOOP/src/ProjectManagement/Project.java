package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public abstract class Project {
    private String projectId;
    private String projectName;
    private List<Member> memberList;

    public Project(String projectId, String projectName, List<Member> memberList) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.memberList = memberList;
    }

    public Project(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.memberList = new ArrayList<>();
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    abstract void displayInfo();
}
