package ProjectManagement;

public class Member {
    private String memberID;
    private int workingDays;

    public Member(String memberID, int workingDays) {
        this.memberID = memberID;
        this.workingDays = workingDays;
    }

    public String getMemberID() {
        return memberID;
    }

    public int getWorkingDays() {
        return workingDays;
    }
}
