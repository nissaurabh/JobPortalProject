/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice.impl;

import java.io.InputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.List;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.jaxb.JobCandidate;
import com.capgemini.job.portal.service.JobCandidateService;
import com.capgemini.job.portal.webservice.JobCandidateWebservice;


/**
 * The Class performs add, update, remove Job candidate JobCandidateWebserviceImpl.
 * 
 * @author sbasired
 */
@Component("jobCandidateWebservice")
public class JobCandidateWebserviceImpl implements JobCandidateWebservice {

	
	/** Job details service. */
	@Autowired
	private JobCandidateService jobCandidateService;
	
	@Override
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}")
	//public Response addJobCandidate(@PathParam("job-id") final String jobId, JobCandidate jobCandidate,	List<Attachment> attachments) throws URISyntaxException,Exception {
	public Response addJobCandidate(@PathParam("job-id") final String jobId,
			/*@Multipart(value="jobCandidate") JobCandidate jobCandidate,*/
			List<Attachment> attachments, String body)
			throws URISyntaxException, Exception {
		//JobCandidate jobCandidate = null;
		System.out.println(body);
		/*String sr = bean.getBuLeadApproval();

	     int expected = pictureStream.available();
	     byte[] contents = new byte[expected];
	     int length = pictureStream.read(contents);*/
		Attachment attch = attachments.get(0);//body.getAttachmentObject("file", Attachment.class);
		DataHandler dataHandler1 =attch.getDataHandler();
		 InputStream fileStream = dataHandler1.getInputStream();
	        int expected = fileStream.available();
		     byte[] contents = new byte[expected];
		     int length = fileStream.read(contents);
		     
		     //JobCandidate  jobCandidate = body.getAttachmentObject("jobCandidate", JobCandidate.class);
		     
		/*for (int i = 0; i < attachments.size(); i++) {
			DataHandler dataHandler = attachments.get(i).getDataHandler();
			if ("jobCandidate".equals(dataHandler.getDataSource().getName())) {
				
				jobCandidate = getProjectFromInputStream(dataHandler.getInputStream());
			}
			Object obj = attachments.get(i).getObject();
		}*/
       /* DataHandler dataHandler2 = attachments.get(1).getDataHandler();
        JobCandidate jobCandidate = getProjectFromInputStream(dataHandler2.getInputStream());
       */
	    
		     //JobCandidate jobCandidate = attachments.get(1).getObject(JobCandidate.class);
	     /*for (Attachment attachment : attachments) {
	    	 jobCandidate = attachment.getObject(JobCandidate.class);
	    	 jobCandidate = attachment.getObject(JobCandidate.class);
	    	 jobCandidate.getActualJoiningDate();
	     }  */
		     JobCandidate jobCandidate = convertStringToJaxbObject(body);
	     
	     jobCandidateService.addJobCandidate(jobId, jobCandidate, contents);
		return Response.ok().build();
	}

	@Override
	@PUT
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}/{candidate-id}")
	public Response updateJobCandidate(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId,
			final MultipartBody multipartBody) throws URISyntaxException {
		// TODO Auto-generated method stub
		return Response.ok().build();
	}

	@Override
	@DELETE
	@Consumes("application/json")
	@Path("/{job-id}/{candidate-id}")
	public Response deleteJobCandidate(@PathParam("job-id") String jobId,
			@PathParam("candidate-id") String candidateId)
			throws URISyntaxException {
		// TODO Auto-generated method stub
		return Response.ok().build();
	}
	
	public static JobCandidate getProjectFromInputStream(InputStream is) throws Exception {
        JAXBContext c = JAXBContext.newInstance(new Class[]{JobCandidate.class});
        Unmarshaller u = c.createUnmarshaller();
        JobCandidate jobCandidate = (JobCandidate) u.unmarshal(is);

        return jobCandidate;
    }
	
	public JobCandidate convertStringToJaxbObject(String jsonString) throws Exception{
		        JAXBContext jc = JAXBContext.newInstance(JobCandidate.class);
		        Unmarshaller unmarshaller = jc.createUnmarshaller();
		        unmarshaller.setProperty(JAXBContextProperties.MEDIA_TYPE,
		                "application/json");
		        unmarshaller.setProperty(JAXBContextProperties.JSON_INCLUDE_ROOT, false);

		        //unmarshaller.setProperty(UnmarshallerProperties.JAXB_FORMATTED_OUTPUT, true);
		        StringReader json = new StringReader(jsonString);
		        JobCandidate jobCandidate = (JobCandidate) unmarshaller.unmarshal(json);

		        return jobCandidate;
	}

}
