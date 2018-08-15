package com.mipa.core.user.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mipa.core.data.enums.UserType;

@Entity
@Table(name="adminusermaster")
public class AdminUserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_user_table_seq")
	@SequenceGenerator(name="admin_user_table_seq", sequenceName="admin_user_master_seq", initialValue=1)
	@Column(name="userId", updatable=false, nullable=false)
	private Integer userId;
	
	@Column(name="userEmail", unique=true)
	private String userEmail;
	
	@Column(name="fullName")
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="userType")
	private UserType userType;
	
	@Column(name="createdDate")
	private OffsetDateTime createdDate;
	
	@Column(name="modifiedDate")
	private OffsetDateTime modifiedDate;
	
	@Column(name="createdUserId")
	private Integer createdUserId;
	
	@Column(name="modifiedUserId")
	private Integer modifiedUserId;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="deleted")
	private boolean deleted;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public OffsetDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(OffsetDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Integer getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(Integer modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}