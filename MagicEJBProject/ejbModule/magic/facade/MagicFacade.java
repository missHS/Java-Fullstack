package magic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import magic.entity.Member;
import magic.entity.ScheduledClass;
import magic.session.MemberEAOLocal;
import magic.session.ScheduledClassEAOLocal;

/**
 * Session Bean implementation class MagicFacade
 */
@Stateless
public class MagicFacade implements MagicFacadeLocal {

	@EJB
	private MemberEAOLocal memberEAO;

	@EJB
	private ScheduledClassEAOLocal scheduledClassEAO;

	public Member findByMemberNumber(int memberNumber) {
		return memberEAO.findByMemberNumber(memberNumber);
	}

	public Member createMember(Member member) {
		return memberEAO.createMember(member);

	}

	public Member updateMember(Member member) {
		return memberEAO.updateMember(member);
	}

	public void deleteMember(int memberNumber) {
		memberEAO.deleteMember(memberNumber);

	}

	public List<ScheduledClass> findAll() {
		return scheduledClassEAO.findAll();
	}

	public ScheduledClass findScheduledClass(int scheduledClassID) {
		return scheduledClassEAO.findScheduledClass(scheduledClassID);
	}

	public ScheduledClass createScheduledClass(ScheduledClass scheduledClass) {
		return scheduledClassEAO.createScheduledClass(scheduledClass);
	}

	public ScheduledClass updateScheduledClass(ScheduledClass scheduledClass) {
		return scheduledClassEAO.updateScheduledClass(scheduledClass);
	}

	public void deleteScheduledClass(int scheduledClassID) {
		scheduledClassEAO.deleteScheduledClass(scheduledClassID);
	}

	public void removeMemberFromClass(ScheduledClass scheduledClass, Member member) {
		scheduledClassEAO.removeMemberFromClass(scheduledClass, member);
		this.updateMember(member);
	}

	public void addMemberOnClass(ScheduledClass scheduledClass, Member member) {
		scheduledClassEAO.addMemberOnClass(scheduledClass, member);
		this.updateMember(member);
	}

	public MagicFacade() {

	}

}
