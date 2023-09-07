package edu.kmaooad.capstone23.jobs.events;
public class JobDeactivated {
    private String jobId;
    public String getJobId() {
        return jobId;
    }

    public JobDeactivated(String jobId) {
        this.jobId = jobId;
    }
}
