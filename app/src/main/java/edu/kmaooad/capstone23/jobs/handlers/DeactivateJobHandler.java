package edu.kmaooad.capstone23.jobs.handlers;

import edu.kmaooad.capstone23.common.CommandHandler;
import edu.kmaooad.capstone23.common.ErrorCode;
import edu.kmaooad.capstone23.common.Result;
import edu.kmaooad.capstone23.jobs.commands.CreateJob;
import edu.kmaooad.capstone23.jobs.commands.*;
import edu.kmaooad.capstone23.jobs.dal.Job;
import edu.kmaooad.capstone23.jobs.dal.JobRepository;
import edu.kmaooad.capstone23.jobs.events.JobCreated;
import edu.kmaooad.capstone23.jobs.events.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@RequestScoped
public class DeactivateJobHandler implements CommandHandler<DeactivateJob, JobDeactivated> {

    @Inject
    private JobRepository repository;
    @Override
    public Result<JobDeactivated> handle(DeactivateJob commandDel) {

        Optional<Job> job = repository.findByIdOptional(commandDel.getJobId());
        if(job.isEmpty())
            return new Result<>(ErrorCode.VALIDATION_FAILED, "This job do not existe");

        Job j = job.get();

        repository.deactivateJob(j);

        return new Result<>(new JobDeactivated(commandDel.getJobId()));
    }
}