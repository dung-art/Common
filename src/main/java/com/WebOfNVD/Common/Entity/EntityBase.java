package com.WebOfNVD.Common.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "Is_Delete")
	private Boolean isDelete = false;

	@Column(name = "User_Add")
	private String userAdd;

	@Column(name = "Date_Add")
	private LocalDateTime dateAdd;

	@Column(name = "Modified_Date")
	private LocalDateTime modifiedDate;

	@Column(name = "Modified_user")
	private String modifiedUser;

	@Column(name = "Modified_Action")
	private String modifiedAction;

	@PrePersist
	public void preInsert() {
		LocalDateTime nowDateTime = LocalDateTime.now();
		this.dateAdd = nowDateTime;
		this.modifiedDate = nowDateTime;
	}

	@PreUpdate
	public void preUpdate() {
		LocalDateTime nowDateTime = LocalDateTime.now();
		this.modifiedDate = nowDateTime;
	}
}
