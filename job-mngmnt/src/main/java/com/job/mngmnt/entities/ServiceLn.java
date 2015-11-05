package com.job.mngmnt.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the service_ln database table.
 * 
 */
@Entity
@Table(name="service_ln")
public class ServiceLn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srvc_ln_id")
	private int srvcLnId;

	@Column(name="CREATE_DTS")
	private Timestamp createDts;

	@Column(name="CREATE_USR_ID")
	private String createUsrId;

	@Column(name="srvc_ln_nm")
	private String srvcLnNm;

	@Column(name="UPDT_DTS")
	private Timestamp updtDts;

	@Column(name="UPDT_USR_ID")
	private String updtUsrId;

	//bi-directional many-to-one association to ServiceLnCap
	@OneToMany(mappedBy="serviceLn")
	private List<ServiceLnCap> serviceLnCaps;

	public ServiceLn() {
	}

	public int getSrvcLnId() {
		return this.srvcLnId;
	}

	public void setSrvcLnId(int srvcLnId) {
		this.srvcLnId = srvcLnId;
	}

	public Timestamp getCreateDts() {
		return this.createDts;
	}

	public void setCreateDts(Timestamp createDts) {
		this.createDts = createDts;
	}

	public String getCreateUsrId() {
		return this.createUsrId;
	}

	public void setCreateUsrId(String createUsrId) {
		this.createUsrId = createUsrId;
	}

	public String getSrvcLnNm() {
		return this.srvcLnNm;
	}

	public void setSrvcLnNm(String srvcLnNm) {
		this.srvcLnNm = srvcLnNm;
	}

	public Timestamp getUpdtDts() {
		return this.updtDts;
	}

	public void setUpdtDts(Timestamp updtDts) {
		this.updtDts = updtDts;
	}

	public String getUpdtUsrId() {
		return this.updtUsrId;
	}

	public void setUpdtUsrId(String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public List<ServiceLnCap> getServiceLnCaps() {
		return this.serviceLnCaps;
	}

	public void setServiceLnCaps(List<ServiceLnCap> serviceLnCaps) {
		this.serviceLnCaps = serviceLnCaps;
	}

	public ServiceLnCap addServiceLnCap(ServiceLnCap serviceLnCap) {
		getServiceLnCaps().add(serviceLnCap);
		serviceLnCap.setServiceLn(this);

		return serviceLnCap;
	}

	public ServiceLnCap removeServiceLnCap(ServiceLnCap serviceLnCap) {
		getServiceLnCaps().remove(serviceLnCap);
		serviceLnCap.setServiceLn(null);

		return serviceLnCap;
	}

}