package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public abstract class Project {
    private String projectId;
    private String projectName;
    private List<Member> memberList;

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
