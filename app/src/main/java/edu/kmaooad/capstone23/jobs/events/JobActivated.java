package edu.kmaooad.capstone23.jobs.events;
public class JobActivated {
    private String jobId;
    public String getJobId() {
        return jobId;
    }

    public JobActivated(String jobId) {
        this.jobId = jobId;
    }
}
