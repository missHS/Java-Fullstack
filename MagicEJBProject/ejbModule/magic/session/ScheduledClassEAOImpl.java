package magic.session;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import magic.entity.Member;
import magic.entity.ScheduledClass;

/**
 * Session Bean implementation class ScheduledClassSession
 */
@Stateless
@LocalBean
public class ScheduledClassEAOImpl implements ScheduledClassEAOLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

	public ScheduledClass findScheduledClass(int scheduledClassID) {
		return em.find(ScheduledClass.class, scheduledClassID);
	}

	public ScheduledClass createScheduledClass(ScheduledClass scheduledClass) {
		em.persist(scheduledClass);
		return scheduledClass;
	}

	public ScheduledClass updateScheduledClass(ScheduledClass scheduledClass) {
		em.merge(scheduledClass);

		return scheduledClass;
	}

	public void deleteScheduledClass(int scheduledClassID) {
		ScheduledClass scheduledClass = this.findScheduledClass(scheduledClassID);
		if (scheduledClass != null) {
			em.remove(scheduledClass);
		}
	}

	public List<ScheduledClass> findAll() {
		TypedQuery<ScheduledClass> query = em.createNamedQuery("ScheduledClass.findAll", ScheduledClass.class);

		List<ScheduledClass> scheduledClassesList = query.getResultList();
		return scheduledClassesList;
	}

	public void removeMemberFromClass(ScheduledClass scheduledClass, Member member) {

		if (scheduledClass != null && member != null) {
			scheduledClass.getMemberList().remove(member);
			this.updateScheduledClass(scheduledClass);
		}

	}

	public void addMemberOnClass(ScheduledClass scheduledClass, Member member) {

		if (scheduledClass != null && member != null) {
			scheduledClass.getMemberList().add(member);
			member.getScheduledClasses().add(scheduledClass);
			this.updateScheduledClass(scheduledClass);

		}
	}

	public ScheduledClassEAOImpl() {

	}

}
