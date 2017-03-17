package se;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Partner database table.
 * 
 */
@Entity
@NamedQuery(name="Partner.findAll", query="SELECT p FROM Partner p")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARTNER_COMPANYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARTNER_COMPANYID_GENERATOR")
	private int companyId;

	private String company;

	private String desc;

	private String email;

	private String tags;

	public Partner() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}