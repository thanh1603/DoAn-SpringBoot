package thanh.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass // để có thể các entity có thể kế thừa các fill va generate ra table
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id // trở thành PRIMARY KEY va not noll
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tu dong tang id
	private Long id;

	@Column
	@CreatedBy
	private String createdBy;// lấy data của user

	@Column
	@CreatedDate
	private Date createdDate; // lấy ngyaf của hệ thống

	@Column
	@LastModifiedBy
	private String modifiedBy;// lấy data của user

	@Column
	@LastModifiedDate // lấy ngyaf của hệ thống
	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
