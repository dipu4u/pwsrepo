package com.mipa.osgi.core.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="providerdataactivitymaster")
public class ProviderDataActivityEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="provider_data_activity_table_seq")
	@SequenceGenerator(name="provider_data_activity_table_seq", sequenceName="provider_data_activity_master_seq", initialValue=1)
	@Column(name="serialId", updatable=false, nullable=false)
	private Long serialId;
	
	@Column(name="providerId")
	private Integer providerId;
	
	@Column(name="runDateTime")
	private Long runDateTime;
	
	@Column(name="completed")
	private Boolean completed = Boolean.FALSE;

	public Long getSerialId() {
		return serialId;
	}

	public void setSerialId(Long serialId) {
		this.serialId = serialId;
	}
	

	public Long getRunDateTime() {
		return runDateTime;
	}

	public void setRunDateTime(Long runDateTime) {
		this.runDateTime = runDateTime;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}