package magic.test;

import javax.naming.Context;
import javax.naming.InitialContext;

import junit.framework.TestCase;
import magic.entity.Member;
import magic.facade.MagicFacadeLocal;

public class FacadeTest extends TestCase {

	MagicFacadeLocal facade;
	Member member;

	int expectedMemberNumber;
	String expectedSsn;
	String expectedName;
	String expectedPhoneNumber;
	String expectedEmail;

	public FacadeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();

		expectedSsn = "5609789898";
		expectedName = "Mats";
		expectedPhoneNumber = "0704563278";
		expectedEmail = "mats@mats.se";

		Context context = new InitialContext();
		facade = (MagicFacadeLocal) context
				.lookup("java:app/MagicEJBProject/MagicFacade!magic.facade.MagicFacadeLocal");

	}

	// Create, read and update member
	public void testMember() {
		member = new Member(expectedName, expectedSsn, expectedPhoneNumber, expectedEmail);

		facade.createMember(member);
		assertNotNull(member);

		expectedMemberNumber = member.getMemberNumber();

		assertEquals(member.getName(), expectedName);
		assertEquals(member.getSsn(), expectedSsn);
		assertEquals(member.getEmail(), expectedEmail);
		assertEquals(member.getPhoneNumber(), expectedPhoneNumber);

		member = facade.findByMemberNumber(expectedMemberNumber);
		assertNotNull(member);

		assertEquals(member.getName(), expectedName);
		assertEquals(member.getSsn(), expectedSsn);
		assertEquals(member.getEmail(), expectedEmail);
		assertEquals(member.getPhoneNumber(), expectedPhoneNumber);

		member.setName("Malin");
		member.setPhoneNumber("0708889832");
		member.setEmail("malin@malin.se");
		facade.updateMember(member);
		
		assertEquals(member.getName(), "Malin");
		assertEquals(member.getEmail(), "malin@malin.se");
		assertEquals(member.getPhoneNumber(), "0708889832");

	}

//Delete member 
	protected void tearDown() throws Exception {
		super.tearDown();
		facade.deleteMember(expectedMemberNumber);

		facade = null;
	}

}
