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
public class ActivateJobHandler implements CommandHandler<ActivateJob, JobActivated> {
    @Inject
    private JobRepository repository;
    @Override
    public Result<JobActivated> handle(ActivateJob commandDel) {

        Optional<Job> job = repository.findByIdOptional(commandDel.getJobId());
        if(job.isEmpty())
            return new Result<>(ErrorCode.VALIDATION_FAILED, "This job never existed");

        Job j = job.get();
        j.active =true;


        JobActivated result = new JobActivated(j.id);

        return new Result<JobActivated>(result);
    }
}