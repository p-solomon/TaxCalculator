package data.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 7299264265184515893L;

	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "success";

	}

}
