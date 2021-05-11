package magic.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
@SequenceGenerator(name = "ID_SEQUENCE", allocationSize = 1)
public class Member implements Serializable {

	private int memberNumber;
	private String ssn;
	private String name;
	private String phoneNumber;
	private String email;
	private Set<ScheduledClass> scheduledClassList;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "memberNumber")
	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	@Column(name = "ssn")
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Column(name = "memberName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "memberPhoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "memberEmail")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(mappedBy = "memberList", fetch = FetchType.EAGER)
	public Set<ScheduledClass> getScheduledClasses() {
		return scheduledClassList;
	}

	public void setScheduledClasses(Set<ScheduledClass> scheduledClasses) {
		this.scheduledClassList = scheduledClasses;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		String id = String.valueOf(memberNumber);
		
		if (id != null) {
			hash += id.hashCode();
			return hash;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Member)) {
			return false;
		}
		Member other = (Member) object;
		if (this.getMemberNumber() == other.getMemberNumber()) {
			return true;
		}
		return false;
	}

	public Member() {

	}

	public Member(String name, String ssn, String phoneNumber, String email) {
		this.name = name;
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

}
