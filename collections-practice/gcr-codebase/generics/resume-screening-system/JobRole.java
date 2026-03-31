abstract class JobRole {
    protected String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public abstract void screenResume();

    public String getRoleName() {
        return roleName;
    }
}
