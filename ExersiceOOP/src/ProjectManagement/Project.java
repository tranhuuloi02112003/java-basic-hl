package ProjectManagement;

import java.util.ArrayList;
import java.util.List;

public abstract class Project {
    private String projectId;
    private String projectName;
    private List<Member> members;

    public void setMembers(List<Member> newMembers) throws Exception {
        if (this.members == null) {
            this.members = new ArrayList<>();
        }

        if (!containsDuplicateIdMembers(newMembers)) {
            this.members.addAll(newMembers);
            System.out.println("Add valid new members.");
            sortMembersByWorkingDaysDec(this.members);
        } else {
            throw new Exception("Duplicate member IDs detected in the new list.");
        }
    }

    private void sortMembersByWorkingDaysDec(List<Member> memberList) {
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

    private boolean containsDuplicateIdMembers(List<Member> newMembers) {
        for (Member newMember : newMembers) {
            for (Member existingMember : this.members) {
                if (existingMember.getMemberId().equalsIgnoreCase(newMember.getMemberId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Member> getMembers() {
        List<Member> list = new ArrayList<>(members);
        return list;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    abstract void displayInfo();
}
