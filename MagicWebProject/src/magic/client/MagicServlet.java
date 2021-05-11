package magic.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magic.entity.Member;
import magic.entity.ScheduledClass;
import magic.facade.MagicFacadeLocal;

/**
 * Servlet implementation class MagicServlet
 */
@WebServlet("/MagicServlet")
public class MagicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	MagicFacadeLocal facade;
	Member memberSession;

	public MagicServlet() {
		super();
	}

	// retrieves data from database
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String action = request.getParameter("action");

		try {

			// Opens up startPage when running program
			if (action == null || "startPage".equals(action)) {

				List<ScheduledClass> scheduledClasses = facade.findAll();

				request.setAttribute("scheduledClassList", scheduledClasses);
				url = "/startPage.jsp";
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
				dispatcher.forward(request, response);

				// opens book class page and prints out all the scheduled classes
			} else if (action.equals("bookClass")) {
				if (memberSession != null) {
					List<ScheduledClass> scheduledClasses = facade.findAll();

					request.setAttribute("bookingClassList", scheduledClasses);

					url = "/book.jsp";

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
					dispatcher.forward(request, response);

					// opens login page
				} else {
					url = "/login.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
					dispatcher.forward(request, response);

				}
			}

			// opens up my page
			else if (action.equals("myPage")) {

				if (memberSession != null) {

					// Database connection for updated Member object
					int memberNumber = memberSession.getMemberNumber();
					Member member = facade.findByMemberNumber(memberNumber);

					List<ScheduledClass> memberClassesList = new ArrayList<ScheduledClass>();
					Set<ScheduledClass> memberClassesSet = member.getScheduledClasses();

					memberClassesList.addAll(memberClassesSet);
					request.setAttribute("memberList", memberClassesList);

					url = "/myPage.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
					dispatcher.forward(request, response);

					// opens log in page
				} else {
					url = "/login.jsp";
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
					dispatcher.forward(request, response);

				}
			}
		} catch (Exception e) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something went wrong, please call the reception at +46090009900. //The Magic Training Team ");
		}

	}

	// sends data
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		String operation = request.getParameter("operation");

		try {

			// retrieves request from users input in textfield on login page
			if (operation.equals("memberLogIn")) {

				String memberNumber = request.getParameter("txtMemberNbr");
				String memberSsn = request.getParameter("txtMemberSSN");
				Member member = facade.findByMemberNumber(Integer.parseInt(memberNumber));

				if (member != null) {
					memberSession = member;
					String ssn = member.getSsn();
					if (ssn.equals(memberSsn)) {
						request.setAttribute("member", member);
						url = "/login.jsp";
					}

				}
			}

			// retrieves input to book member on class
			else if (operation.equals("bookMemberOnClass")) {

				String memberNumber = request.getParameter("bookMemberNbr");
				String scheduledClassId = request.getParameter("bookClassID");

				memberSession = facade.findByMemberNumber(Integer.parseInt(memberNumber));
				ScheduledClass scheduledClass = facade.findScheduledClass(Integer.parseInt(scheduledClassId));

				if (memberSession != null && scheduledClass != null) {
					if (memberSession.getScheduledClasses().contains(scheduledClass)) {
						url = "/book.jsp";
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					} else {
						facade.addMemberOnClass(scheduledClass, memberSession);
						memberSession.getScheduledClasses().add(scheduledClass);
						url = "/book.jsp";
						response.flushBuffer();
					}
				}
				// retrieves input and removes member from class
			} else if (operation.equals("unbookMemberOnClass")) {

				String memberNumber = request.getParameter("bookedMemberNbr");
				String scheduledClassId = request.getParameter("bookedClassID");

				memberSession = facade.findByMemberNumber(Integer.parseInt(memberNumber));
				ScheduledClass scheduledClass = facade.findScheduledClass(Integer.parseInt(scheduledClassId));

				if (memberSession != null && scheduledClass != null) {
					if (memberSession.getScheduledClasses().contains(scheduledClass)) {
						facade.removeMemberFromClass(scheduledClass, memberSession);
						memberSession.getScheduledClasses().remove(scheduledClass);
						url = "/myPage.jsp";
						response.flushBuffer();

						// members that does not have any booked classes
					} else {
						url = "/myPage.jsp";
						response.sendError(HttpServletResponse.SC_BAD_REQUEST);
					}
				}
			}

			else {
				url = "/login.jsp";
			}

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);

		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something went wrong, please call the reception at +46090009900. //The Magic Training Team ");
		}
	}
}
