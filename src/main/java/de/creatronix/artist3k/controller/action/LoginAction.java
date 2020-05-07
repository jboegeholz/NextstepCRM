package de.creatronix.artist3k.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import de.creatronix.artist3k.controller.form.LoginForm;
import de.creatronix.artist3k.model.ModelController;
import de.creatronix.artist3k.model.StageActManager;
import de.creatronix.artist3k.model.User;
import de.creatronix.artist3k.model.UserManager;

public class LoginAction extends Action {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("LoginAction");
		LoginForm myForm = (LoginForm) form; // get the form bean
		// and take the Username value

		UserManager userManager = ModelController.getInstance()
				.getUserManager();
		StageActManager stageActManager = ModelController.getInstance()
				.getStageActManager();

		// for test purpose only :-)
		userManager.testStoreUser();
		stageActManager.testStoreStageAct();
		User user = userManager.getUser(myForm.getUsername());

		boolean loginOkay = userManager.verifyUserLogin(myForm.getUsername(),
				myForm.getPassword(), user);

		if (loginOkay) {
			logger.info("login ok");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return mapping.findForward("success");

		} else {
			logger.error("Login failed");
			ActionErrors errors = new ActionErrors();
			ActionMessage msg = new ActionMessage("error.wrong.login");
			errors.add("user", msg);
			saveErrors(request, errors);

			return mapping.getInputForward();
		}
	}
}
