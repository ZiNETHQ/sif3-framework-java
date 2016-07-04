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

package zinet.sif3.demo.uk.rest.provider;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import sif3.common.conversion.ModelObjectInfo;
import sif3.infra.common.model.JobType;
import sif3.infra.common.utils.ServiceUtils;
import sif3.infra.rest.provider.BaseFunctionalServiceProvider;
import sif3.infra.common.utils.SIFRights;
import zinet.sif3.demo.uk.rest.PayloadConstants;
import zinet.sif3.demo.uk.rest.provider.actions.DefaultActions;
import zinet.sif3.demo.uk.rest.provider.actions.JsonActions;
import zinet.sif3.demo.uk.rest.provider.actions.XmlActions;

public class PayloadProvider extends BaseFunctionalServiceProvider
{
    public PayloadProvider()
    {
        super("Payloads");

        phaseActions.put("default", new DefaultActions(this));
        phaseActions.put("xml", new XmlActions(this));
        phaseActions.put("json", new JsonActions(this));
    }

    @Override
    protected void configure(JobType job)
    {
        DatatypeFactory f;
        try
        {
            f = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            logger.error("Failed to configure job due to error: " + e.getMessage(), e);
            return;
        }

        ServiceUtils.addPhase(job, "default", true,
                new SIFRights().create().query().update().getRights(),
                new SIFRights().create().getRights());
        ServiceUtils.addPhase(job, "xml", true,
                new SIFRights().create().query().update().getRights(),
                new SIFRights().create().getRights());
        ServiceUtils.addPhase(job, "json", true,
                new SIFRights().create().query().update().getRights(),
                new SIFRights().create().getRights());

        job.setTimeout(f.newDuration(true, 0, 0, 0, 0, 0, 30));
    }

    @Override
    protected void shutdownJob(JobType job)
    {
    }

    /*
     * (non-Javadoc) @see sif3.infra.rest.provider.BaseProvider#shutdown()
     */
    public void shutdown()
    {
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
}