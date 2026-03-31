class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void display() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applied Role: " + jobRole.getRoleName());
        jobRole.screenResume();
    }

    public T getJobRole() {
        return jobRole;
    }
}
