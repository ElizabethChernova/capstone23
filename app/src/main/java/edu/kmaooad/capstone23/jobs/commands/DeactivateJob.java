package edu.kmaooad.capstone23.jobs.commands;

import org.bson.types.ObjectId;

import java.util.Objects;
public class DeactivateJob {
    private ObjectId jobId;

    public DeactivateJob(final ObjectId jobId) {
        this.jobId = jobId;
    }

    public void setJobId(final ObjectId jobId) {
        // TODO validate ObjectId
        this.jobId = jobId;
    }

    public ObjectId getJobId() {
        return this.jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeactivateJob deactivateJob = (DeactivateJob) o;
        return jobId.equals(deactivateJob.jobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }

}