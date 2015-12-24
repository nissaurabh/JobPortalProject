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
import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.jaxb.JobCandidate;
import com.capgemini.job.portal.service.JobCandidateService;
import com.capgemini.job.portal.webservice.JobCandidateWebservice;


/**
 * The Class performs add, update, remove Job candidate JobCandidateWebserviceImpl.
 * 
 * @author sbasired
 */
@CrossOriginResourceSharing(allowAllOrigins = true)
@Component("jobCandidateWebservice")
public class JobCandidateWebserviceImpl implements JobCandidateWebservice {

	
	/** Job details service. */
	@Autowired
	private JobCandidateService jobCandidateService;
	
	
	@POST
	@Path("/{job-id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response addJobCandidate(@PathParam("job-id") final String jobId,
			@Multipart("jobCandidate") String jobCndt,
			@Multipart(value="file", required = false) Attachment attachment) throws Exception{
		JobCandidate jobCandidate = convertJsontoPojo(jobCndt);
		DataHandler dataHandler1 =attachment.getDataHandler();
		InputStream fileStream = dataHandler1.getInputStream();
	    byte[] contents = IOUtils.toByteArray(fileStream);
		jobCandidateService.addJobCandidate(jobId, jobCandidate, contents);
		return Response.ok().build();
		
	}

	private JobCandidate convertJsontoPojo(String jobCndt) {
		if(StringUtils.isEmpty(jobCndt)){
			return null;
		} else {
			return (JobCandidate) fromJsonToObject(jobCndt);
		}
	}
	
	/**
	 * @param json
	 * @return
	 */
	private Object fromJsonToObject(final String json) {
		try{
			JobCandidate candidate = new ObjectMapper().readValue(json, JobCandidate.class);
			return candidate;
		} catch(Exception e){
			return null;
		}
	}


	@Override
	@PUT
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{job-id}/{candidate-id}")
	public Response updateJobCandidate(@PathParam("job-id") final String jobId,
			@PathParam("candidate-id") final String candidateId,
			@Multipart("jobCandidate") JobCandidate jobCandidate,
			@Multipart(value="file", required = false) Attachment attachment){
		String response = "400";
		try{
			if(attachment != null){
				DataHandler dataHandler1 =attachment.getDataHandler();
				InputStream fileStream = dataHandler1.getInputStream();
			    byte[] contents = IOUtils.toByteArray(fileStream);
			    response = jobCandidateService.updateJobCandidate(jobId,candidateId, jobCandidate, contents);
			} else {
				response = jobCandidateService.updateJobCandidate(jobId, candidateId, jobCandidate, null);
			}
			return Response.status(Integer.valueOf(response)).header("Access-Control-Allow-Origin", "/job-management-service/").build();
		} catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "/job-management-service/").build();
		}
	}

	@Override
	@DELETE
	@Consumes("application/json")
	@Path("/{job-id}/{candidate-id}")
	public Response deleteJobCandidate(@PathParam("job-id") String jobId,
			@PathParam("candidate-id") String candidateId)
			throws URISyntaxException {
		String response = jobCandidateService.deleteJob(jobId,candidateId);
		return Response.status(Integer.valueOf(response)).header("Access-Control-Allow-Origin", "/job-management-service/").build();
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
			file.deleteOnExit();
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
		File file = File.createTempFile(candidateName+"_Resume",".doc");
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytearray);
		fos.close();
		return file;
	}

	@Override
	public Response getCandidateDetails(int candidateId) {
		CandidateDetail detail = jobCandidateService.getCandidateDetailsById(candidateId);
		return buildResponse(detail);
	}

	
	/**
	 * @param detail
	 * @return
	 */
	private Response buildResponse(final CandidateDetail detail) {
		Response responseObj = null;
		if (null == detail) {
			responseObj = Response.status(Status.NOT_FOUND).build();
		} else {
			responseObj = Response.ok(detail).build();
		}
		return responseObj;
	}


}
