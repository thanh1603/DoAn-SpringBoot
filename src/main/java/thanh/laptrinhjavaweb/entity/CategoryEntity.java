package thanh.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // khai bao entity
@Table(name = "category") // map voi database
public class CategoryEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category")//map voi new (private CategoryEntity category;)
	private List<NewEntity> news = new ArrayList<>();

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
	
	

}
