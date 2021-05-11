package magic.session;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import magic.entity.Member;

/**
 * Session Bean implementation class Member
 */
@Stateless
@LocalBean
public class MemberEAOImpl implements MemberEAOLocal {

	@PersistenceContext(unitName = "LabEJBSql")
	private EntityManager em;

	public Member findByMemberNumber(int memberNumber) {
		return em.find(Member.class, memberNumber);
	}

	public Member createMember(Member member) {
		em.persist(member);
		return member;
	}

	public Member updateMember(Member member) {
		em.merge(member);
		return member;
	}

	public void deleteMember(int memberNumber) {
		Member m = this.findByMemberNumber(memberNumber);
		if (m != null) {
			em.remove(m);
		}

	}

	public MemberEAOImpl() {

	}

}
