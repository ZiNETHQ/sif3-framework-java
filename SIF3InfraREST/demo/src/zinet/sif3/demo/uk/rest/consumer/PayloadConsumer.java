/*
 * Crown Copyright � Department for Education (UK) 2016
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package zinet.sif3.demo.uk.rest.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.ws.rs.core.MediaType;

import au.com.systemic.framework.utils.GUIDGenerator;
import sif.dd.conversion.DataModelMarshalFactory;
import sif.dd.uk20.model.LearnerPersonalType;
import sif.dd.uk20.model.NameType;
import sif.dd.uk20.model.PersonalInformationType;
import sif3.common.CommonConstants.PhaseState;
import sif3.common.conversion.ModelObjectInfo;
import sif3.common.model.PagingInfo;
import sif3.common.model.QueryCriteria;
import sif3.common.model.delayed.DelayedResponseReceipt;
import sif3.common.persist.model.SIF3Job;
import sif3.common.persist.model.SIF3PhaseState;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.ErrorDetails;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.common.ws.model.MultiOperationStatusList;
import sif3.infra.rest.consumer.AbstractFunctionalServiceConsumer;
import zinet.sif3.demo.uk.rest.PayloadConstants;

/**
 * SIF Functional Service (Payload) consumer demo
 * 
 * @author Dr Jon Nicholson (ZiNET Data Solutions Limited) on behalf of the Department for Education
 *         (UK)
 */
public class PayloadConsumer extends AbstractFunctionalServiceConsumer
{

    public PayloadConsumer()
    {
        super();

        // Emulate an external actor issuing consumer actions
        new Timer().schedule(new TimerTask()
        {

            public void run()
            {
                SIF3Job job = null;
                SIF3PhaseState state = null;
                List<Response> responses;
                Response r;

                try
                {
                    // Create a job
                    logger.info(makeHeading("Creating Payload job"));
                    job = new SIF3Job();
                    job.setName("Payload");
                    job.setDescription("testing");
                    responses = createSingle(job, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    // logger.debug(r.toString());
                    job = (SIF3Job) getDataObject(r);
                    logger.info(makeResult("Job created and given ID " + job.getId()));

                    // Get a job
                    logger.info(makeHeading("Fetching job " + job.getId()));
                    responses = retrieveByPrimaryKey(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    job = (SIF3Job) getDataObject(r);
                    logger.info(makeResult("Fetched " + job.getName() + " (" + job.getId() + ")"));

                    // Create message to phase default
                    logger.info(makeHeading("Create message to phase 'default'."));
                    responses = createToPhase(job.getId(), "default", "Sending CREATE",
                            MediaType.TEXT_PLAIN_TYPE, MediaType.TEXT_PLAIN_TYPE, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    logger.info(makeResult("Phase responded with data with mime type: "
                            + r.getMediaType() + " and data:\n" + getDataObject(r)));

                    // Query phase "default", expecting INPROGRESS
                    logger.info(
                            makeHeading("Check state of phase 'default', expecting INPROGRESS."));
                    responses = retrieveByPrimaryKey(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    job = (SIF3Job) getDataObject(r);
                    state = job.getLastPhaseState("default");
                    if (state == null)
                    {
                        logger.info(makeResult("Got UNEXPECTED result, no state object!"));
                    }
                    else
                    {
                        if (state.getType().equals(PhaseState.INPROGRESS))
                        {
                            logger.info(makeResult("Got EXPECTED result, last modified at "
                                    + state.getLastModified().getTime()));
                        }
                        else
                        {
                            logger.info(makeResult("Got UNEXPECTED result " + state.getType()
                                    + ", last modified at " + state.getLastModified().getTime()));
                        }
                    }

                    // Execute UPDATE to phase "default".
                    logger.info(makeHeading("Executing UPDATE to phase 'default'."));
                    responses = updateToPhase(job.getId(), "default", "Sending UPDATE",
                            MediaType.TEXT_PLAIN_TYPE, MediaType.TEXT_PLAIN_TYPE, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    logger.info(makeResult("Phase responded with data with mime type: "
                            + r.getMediaType() + " and data:\n" + getDataObject(r)));

                    // Query phase "default", expecting COMPLETED
                    logger.info(
                            makeHeading("Check state of phase 'default', expecting COMPLETED."));
                    responses = retrieveByPrimaryKey(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    job = (SIF3Job) getDataObject(r);
                    state = job.getLastPhaseState("default");
                    if (state == null)
                    {
                        logger.info(makeResult("Got UNEXPECTED result, no state object!"));
                    }
                    else
                    {
                        if (state.getType().equals(PhaseState.COMPLETED))
                        {
                            logger.info(makeResult("Got EXPECTED result, last modified at "
                                    + state.getLastModified().getTime()));
                        }
                        else
                        {
                            logger.info(makeResult("Got UNEXPECTED result " + state.getType()
                                    + ", last modified at " + state.getLastModified().getTime()));
                        }
                    }

                    // Execute DELETE to phase "default".
                    logger.info(makeHeading("Executing DELETE to phase 'default'."));
                    responses = deleteToPhase(job.getId(), "default", "Sending DELETE",
                            MediaType.TEXT_PLAIN_TYPE, MediaType.TEXT_PLAIN_TYPE, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    expectError(r);

                    // Execute UPDATE to phase "xml".
                    logger.info(makeHeading("Executing UPDATE to phase 'xml'."));
                    String xml = new DataModelMarshalFactory(sif.dd.uk20.model.ObjectFactory.class)
                            .marshalToXML(getBruceWayne());
                    responses = updateToPhase(job.getId(), "xml", xml,
                            MediaType.APPLICATION_XML_TYPE, MediaType.TEXT_PLAIN_TYPE, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    logger.info(makeResult("Phase responded with data with mime type: "
                            + r.getMediaType() + " and data:\n" + getDataObject(r)));

                    // Execute UPDATE to phase "json".
                    logger.info(makeHeading("Executing UPDATE to phase 'json'."));
                    String json = new DataModelMarshalFactory(sif.dd.uk20.model.ObjectFactory.class)
                            .marshalToJSON(getBruceWayne());
                    responses = updateToPhase(job.getId(), "json", json,
                            MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    logger.info(makeResult("Phase responded with data with mime type: "
                            + r.getMediaType() + " and data:\n" + getDataObject(r)));

                    // Change state of phase "json".
                    logger.info(makeHeading("Executing CREATE to the state of phase 'json'."));
                    SIF3PhaseState failed = new SIF3PhaseState();
                    failed.setType(PhaseState.FAILED);
                    failed.setDescription("Because I want it to");
                    responses = createToState(job.getId(), "json", failed, null, null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    state = (SIF3PhaseState) getDataObject(r);
                    if (state == null)
                    {
                        logger.info(makeResult("Got UNEXPECTED result, no state object!"));
                        if (r.hasError())
                        {
                            logger.info("State object being turned into an error object? : "
                                    + r.getError().getDescription());
                        }

                        logger.info(r.getError().getScope());
                    }
                    else
                    {
                        if (state.getType().equals(PhaseState.FAILED))
                        {
                            logger.info(makeResult("Got EXPECTED result, last modified at "
                                    + state.getLastModified().getTime()));
                        }
                        else
                        {
                            logger.info(makeResult("Got UNEXPECTED result " + state.getType()
                                    + ", last modified at " + state.getLastModified().getTime()));
                        }
                    }

                    // Query phase "json", expecting FAILED
                    logger.info(makeHeading("Check state of phase 'json', expecting FAILED."));
                    responses = retrieveByPrimaryKey(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    job = (SIF3Job) getDataObject(r);
                    state = job.getLastPhaseState("json");
                    if (state == null)
                    {
                        logger.info(makeResult("Got UNEXPECTED result, no state object!"));
                    }
                    else
                    {
                        if (state.getType().equals(PhaseState.FAILED))
                        {
                            logger.info(makeResult("Got EXPECTED result, last modified at "
                                    + state.getLastModified().getTime()));
                        }
                        else
                        {
                            logger.info(makeResult("Got UNEXPECTED result " + state.getType()
                                    + ", last modified at " + state.getLastModified().getTime()));
                        }
                    }

                    // Delete a job
                    logger.info(makeHeading("Deleting created job with ID " + job.getId()));
                    responses = deleteSingle(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    if (r == null)
                    {
                        logger.error("Didn't get a response when deleting a job");
                    }
                    responses = retrieveByPrimaryKey(job.getId(), null);
                    r = responses.isEmpty() ? null : responses.get(0);
                    job = (SIF3Job) getDataObject(r);
                    if (job == null)
                    {
                        logger.info(makeResult("Job deleted successfully"));
                    }
                    else
                    {
                        logger.info(makeResult("FAILED TO DELETE JOB"));
                    }

                    // Create many jobs
                    logger.info(makeHeading("Creating many jobs"));
                    ArrayList<SIF3Job> jobs = new ArrayList<SIF3Job>();
                    for (int i = 0; i < 5; i++)
                    {
                        SIF3Job j = new SIF3Job();
                        j.setName("Payload");
                        jobs.add(j);
                    }

                    List<BulkOperationResponse<CreateOperationStatus>> creates = createMany(jobs,
                            null, null);

                    logger.info("Processing multiple job creation:");
                    List<String> ids = new ArrayList<String>();
                    for (BulkOperationResponse<CreateOperationStatus> op : creates)
                    {
                        if (op.hasError())
                        {
                            logger.error("Error creating jobs: " + op.getError().getMessage() + "("
                                    + op.getError().getErrorCode() + ")");
                        }
                        else
                        {
                            for (CreateOperationStatus status : op.getOperationStatuses())
                            {
                                if (status.getStatus() >= 200 && status.getStatus() < 300)
                                {
                                    logger.info("++ " + status.getResourceID() + " created ("
                                            + status.getStatus() + ")");
                                    ids.add(status.getResourceID());
                                }
                                else
                                {
                                    ErrorDetails e = status.getError();
                                    logger.error(
                                            "-- " + e.getMessage() + "(" + e.getErrorCode() + ")");
                                }
                            }
                        }
                    }

                    // Delete many jobs
                    logger.info(makeHeading("Deleting many jobs"));
                    // Change a random job's id, which will result in:
                    // 1) The missing job will be removed by the timeout
                    // 2) We expect a single job to have an error when being removed
                    ids.set(new Random().nextInt(ids.size()), GUIDGenerator.getRandomGUID());

                    logger.info("Processing multiple job deletion:");
                    List<BulkOperationResponse<OperationStatus>> deletes = deleteMany(ids, null,
                            null);
                    for (BulkOperationResponse<OperationStatus> op : deletes)
                    {
                        if (op.hasError())
                        {
                            logger.error("Error deleting jobs: " + op.getError().getMessage() + "("
                                    + op.getError().getErrorCode() + ")");
                        }
                        else
                        {
                            for (OperationStatus status : op.getOperationStatuses())
                            {
                                if (status.getStatus() >= 200 && status.getStatus() < 300)
                                {
                                    logger.info("++ " + status.getResourceID() + " deleted ("
                                            + status.getStatus() + ")");
                                    ids.add(status.getResourceID());
                                }
                                else
                                {
                                    ErrorDetails e = status.getError();
                                    logger.error(
                                            "-- " + e.getMessage() + "(" + e.getErrorCode() + ")");
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    logger.error(e.getMessage(), e);
                }
            }
        }, 5000);
    }

    private String makeHeading(String message)
    {
        return "\n\n*** " + message + "\n";
    }

    private String makeResult(String message)
    {
        return "\n\n+++ " + message + "\n";
    }

    private LearnerPersonalType getBruceWayne()
    {
        sif.dd.uk20.model.ObjectFactory factory = new sif.dd.uk20.model.ObjectFactory();
        LearnerPersonalType bruce = factory.createLearnerPersonalType();
        bruce.setLocalId(factory.createLocalId("555"));

        PersonalInformationType pi = factory.createPersonalInformationType();
        NameType bname = factory.createNameType();
        bname.setType("C");
        bname.setFamilyName(factory.createNameTypeFamilyName("Wayne"));
        bname.setGivenName(factory.createNameTypeGivenName("Bruce"));
        pi.setName(bname);
        bruce.setPersonalInformation(pi);
        return bruce;
    }

    private Object getDataObject(Response r)
    {
        if (r == null)
        {
            throw new RuntimeException("No response");
        }
        if (r.hasError())
        {
            logger.error(r.getError().getMessage() + ". HTTP " + r.getStatus() + " ("
                    + r.getError().getErrorCode() + ")");
            return null;
        }
        return r.getDataObject();
    }

    private void expectError(Response r)
    {
        if (r == null)
        {
            logger.error("Didn't get a response when calling delete on a phase");
        }
        if (r.hasError())
        {
            logger.info(makeResult("EXPECTED error obtained (HTTP:" + r.getStatus()
                    + "), provider responded with:\nCode: " + r.getError().getErrorCode()
                    + "\nMessage: " + r.getError().getMessage() + "\nDescription: "
                    + r.getError().getDescription()));
        }
        else
        {
            logger.info(makeResult("UNEXPECTED - no error obtained!"));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.DataModelLink#getSingleObjectClassInfo()
     */
    @Override
    public ModelObjectInfo getSingleObjectClassInfo()
    {
        return PayloadConstants.PAYLOAD;
    }

    /*
     * (non-Javadoc)
     * 
     * @see sif3.common.interfaces.DataModelLink#getMultiObjectClassInfo()
     */
    @Override
    public ModelObjectInfo getMultiObjectClassInfo()
    {
        return PayloadConstants.PAYLOADS;
    }

    /*----------------------------------------------------------------------------*/
    /*-- Abstract Consumer Methods: Dummy Implementation - Just log the values. --*/
    /*----------------------------------------------------------------------------*/

    @Override
    public void processDelayedCreateMany(MultiOperationStatusList<CreateOperationStatus> statusList,
            DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED CREATE Response:\n" + statusList
                + "\nDelayed Receipt Details:\n" + receipt);
    }

    @Override
    public void processDelayedUpdateMany(MultiOperationStatusList<OperationStatus> statusList,
            DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED UPDATE Response:\n" + statusList
                + "\nDelayed Receipt Details:\n" + receipt);
    }

    @Override
    public void processDelayedDeleteMany(MultiOperationStatusList<OperationStatus> statusList,
            DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED DELETE Response:\n" + statusList
                + "\nDelayed Receipt Details:\n" + receipt);
    }

    @Override
    public void processDelayedQuery(Object dataObject, PagingInfo pagingInfo,
            DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED QUERY Response:\n" + dataObject + "\nPagingInfo:\n"
                + pagingInfo + "\nDelayed Receipt Details:\n" + receipt);
    }

    @Override
    public void processDelayedServicePath(Object dataObject, QueryCriteria queryCriteria,
            PagingInfo pagingInfo, DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED SERVICEPATH Response:\n" + dataObject + "\nQuery Criteria:\n"
                + queryCriteria + "\nPagingInfo:\n" + pagingInfo + "\nDelayed Receipt Details:\n"
                + receipt);
    }

    @Override
    public void processDelayedError(ErrorDetails error, DelayedResponseReceipt receipt)
    {
        logger.debug("Received DELAYED ERROR Response:\n" + error + "\nDelayed Receipt Details:\n"
                + receipt);
    }
}
