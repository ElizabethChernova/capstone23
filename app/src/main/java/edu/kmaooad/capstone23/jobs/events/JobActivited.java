package edu.kmaooad.capstone23.jobs.events;
public class JobActivited {
    private String jobId;
    public String getJobId() {
        return jobId;
    }

    public JobActivited(String jobId) {
        this.jobId = jobId;
    }
}
