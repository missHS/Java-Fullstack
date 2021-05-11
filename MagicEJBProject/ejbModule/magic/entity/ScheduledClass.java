package magic.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@NamedQueries({ @NamedQuery(name = "ScheduledClass.findAll", query = "SELECT s FROM ScheduledClass s ORDER BY s.classDate") })
@Table(name = "ScheduledClass")
public class ScheduledClass implements Serializable {

	private int scheduledClassID;
	private String className;
	private String classDate;
	private String classTime;
	private String roomName;
	private String instructorName;
	private Set<Member> memberList;
	

	@Id
	@Column(name = "scheduledClassID")
	public int getScheduledClassID() {
		return scheduledClassID;
	}

	public void setScheduledClassID(int scheduledClassID) {
		this.scheduledClassID = scheduledClassID;
	}

	@Column(name = "className")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "classDate")
	public String getClassDate() {
		
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate.substring(0, 10);
	}

	@Column(name = "classTime")
	public String getClassTime() {
		return classTime;
	}

	public void setClassTime(String classTime) {
		this.classTime = classTime.substring(0, 5);
	}

	@Column(name = "roomName")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "instructorName")
	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "BookingClass", joinColumns = @JoinColumn(name = "scheduledClassID", referencedColumnName = "scheduledClassID"), inverseJoinColumns = @JoinColumn(name = "memberNumber", referencedColumnName = "memberNumber"))
	public Set<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(Set<Member> memberList) {
		this.memberList = memberList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		String id = String.valueOf(scheduledClassID);
		if (id != null) {
			hash += id.hashCode();
			return hash;
		} else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ScheduledClass)) {
			return false;
		}
		ScheduledClass other = (ScheduledClass) object;
		if (this.getScheduledClassID() == other.getScheduledClassID()) {
			return true;
		}
		return false;
	}

}
