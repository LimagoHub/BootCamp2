package de.limago.jpademo.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	public BaseEntity() {
		id = 0;
		createDate = updateDate = null;
	}
	@PrePersist
	public void prePersist() {
		createDate = updateDate = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		updateDate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	

}
