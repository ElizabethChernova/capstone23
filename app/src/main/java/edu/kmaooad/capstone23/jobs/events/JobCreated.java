package edu.kmaooad.capstone23.jobs.events;

import org.bson.types.ObjectId;

public class JobCreated {
    private String jobId;
    public String getJobId() {
        return jobId;
    }

    public JobCreated(String jobId) {
        this.jobId = jobId;
    }
}
