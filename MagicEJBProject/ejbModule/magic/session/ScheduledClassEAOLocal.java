package magic.session;

import java.util.List;

import javax.ejb.Local;

import magic.entity.Member;
import magic.entity.ScheduledClass;

@Local
public interface ScheduledClassEAOLocal {
	public ScheduledClass findScheduledClass(int scheduledClassID);
	public ScheduledClass createScheduledClass(ScheduledClass scheduledClass);
	public ScheduledClass updateScheduledClass(ScheduledClass scheduledClass);
	public void deleteScheduledClass(int scheduledClassID);
	public List<ScheduledClass> findAll();
	public void removeMemberFromClass(ScheduledClass scheduledClass, Member member);
	public void addMemberOnClass(ScheduledClass scheduledClass, Member member);
}
