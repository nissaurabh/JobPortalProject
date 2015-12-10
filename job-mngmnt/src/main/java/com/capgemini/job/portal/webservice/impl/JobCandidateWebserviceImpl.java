/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.webservice.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.activation.DataHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.entities.JobCndt;
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
	
	
	@POST
	@Path("/{job-id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response addJobCandidate(@PathParam("job-id") final String jobId,
			@Multipart("jobCandidate") JobCandidate jobCandidate,
			@Multipart("file") Attachment attachment) throws Exception{
	
		DataHandler dataHandler1 =attachment.getDataHandler();
		 InputStream fileStream = dataHandler1.getInputStream();
	        //int expected = fileStream.available();
		     byte[] contents = IOUtils.toByteArray(fileStream);
		     
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
	
	
	
	@Override
	public Response downloadCandidateResume(final int candidateId) {
		ResponseBuilder responseBuilder =  null;
		try{
			JobCndt candidate = jobCandidateService.getJobCndtByJobCndtId(candidateId);
			File file = byteArrayToFile(candidate.getCndtRsm(),candidate.getCndtNm());
			responseBuilder = Response.ok((Object) file);
			responseBuilder.header("Content-Disposition", "attachment; filename="+candidate.getCndtNm()+"_Resume.doc");
		} catch(Exception e) {
			responseBuilder = Response.status(Status.NOT_FOUND);
		}
        return responseBuilder.build();
        
	}
	
	/**
	 * @param bytearray
	 * @param candidateName
	 * @return
	 * @throws IOException
	 */
	public File byteArrayToFile(byte[] bytearray, String candidateName) throws IOException {
		File file = new File(candidateName+"_Resume.doc");
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytearray);
		fos.close();
		return file;
	}

}
