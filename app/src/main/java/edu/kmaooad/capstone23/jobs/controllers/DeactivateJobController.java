package edu.kmaooad.capstone23.jobs.controllers;

import edu.kmaooad.capstone23.common.CommandHandler;
import edu.kmaooad.capstone23.common.HandlingError;
import edu.kmaooad.capstone23.common.Result;
import edu.kmaooad.capstone23.common.TypicalController;
import edu.kmaooad.capstone23.jobs.commands.DeactivateJob;
import edu.kmaooad.capstone23.jobs.events.JobDeactivated;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/jobs/activate")
public class DeactivateJobController  extends TypicalController<DeactivateJob, JobDeactivated> {
    @Inject
    CommandHandler<DeactivateJob, JobDeactivated> deactivateJobHandler;
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JobDeactivated.class)) }),
            @APIResponse(responseCode = "400", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = HandlingError.class)) }),
            @APIResponse(responseCode = "500")
    })
    public Response deactivateJob(DeactivateJob command) {
        try {
            Result<JobActivated> result = deactivateJobHandler.handle(command);

            if (!result.isSuccess()) {
                return Response.status(400).entity(result.toError()).build();
            }

            return Response.ok(result.getValue(), MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }
}