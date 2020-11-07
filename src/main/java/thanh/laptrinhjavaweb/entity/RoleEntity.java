package thanh.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // khai bao entity
@Table(name = "role") // map voi database
public class RoleEntity extends BaseEntity {
	@Column // renarate ra column trong table
	private String code;

	@Column
	private String name;

	@ManyToMany(mappedBy = "roles")// map voi user (private List<RoleEntity> roles = new ArrayList<>();)
	private List<UserEntity> users = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
