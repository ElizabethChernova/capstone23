package edu.kmaooad.capstone23.jobs.events;

import org.bson.types.ObjectId;

public class JobActivated {
    private ObjectId jobId;

    public ObjectId getJobId() {
        return jobId;
    }

    public JobActivated(ObjectId jobId) {
        this.jobId = jobId;
    }

}
