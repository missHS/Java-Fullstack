package magic.facade;

import java.util.List;

import javax.ejb.Local;

import magic.entity.Member;
import magic.entity.ScheduledClass;

@Local
public interface MagicFacadeLocal {
	
	public Member findByMemberNumber(int memberNumber);
	public Member createMember(Member member);
	public Member updateMember(Member member);
	public void deleteMember(int memberNumber);
	public List<ScheduledClass> findAll();
	public ScheduledClass findScheduledClass(int scheduledClassID);
	public ScheduledClass createScheduledClass( ScheduledClass scheduledClass);
	public ScheduledClass updateScheduledClass(ScheduledClass scheduledClass);
	public void deleteScheduledClass(int scheduledClassID);
	public void removeMemberFromClass(ScheduledClass scheduledClass, Member member);
	public void addMemberOnClass(ScheduledClass scheduledClass, Member member);

}
