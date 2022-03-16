package actionvo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public interface Action {

	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
