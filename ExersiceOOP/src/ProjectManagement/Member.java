package ProjectManagement;

public class Member {
    private String memberId;
    private int workingDays;

    public Member(String memberId, int workingDays) {
        this.memberId = memberId;
        this.workingDays = workingDays;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getWorkingDays() {
        return workingDays;
    }
}
