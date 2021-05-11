package magic.session;

import javax.ejb.Local;

import magic.entity.Member;

@Local
public interface MemberEAOLocal {

    
	public Member findByMemberNumber(int memberNumber);
	public Member createMember(Member member);
	public Member updateMember(Member member);
	public void deleteMember(int memberNumber);
}
