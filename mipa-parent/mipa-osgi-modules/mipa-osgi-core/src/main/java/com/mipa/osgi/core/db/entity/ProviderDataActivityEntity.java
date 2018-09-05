package com.mipa.osgi.core.db.entity;

import java.time.OffsetDateTime;

import com.mipa.osgi.core.enums.JobStatus;

public class ProviderDataActivityEntity {
	
	private Long serialId;
	
	private Integer providerId;
	
	private OffsetDateTime runDateTime;
	
	private JobStatus jobStatus = JobStatus.SCHEDULED;

	public Long getSerialId() {
		return serialId;
	}

	public void setSerialId(Long serialId) {
		this.serialId = serialId;
	}
	

	public OffsetDateTime getRunDateTime() {
		return runDateTime;
	}

	public void setRunDateTime(OffsetDateTime runDateTime) {
		this.runDateTime = runDateTime;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public JobStatus getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}
	
}