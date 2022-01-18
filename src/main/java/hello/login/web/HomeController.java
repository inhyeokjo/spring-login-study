package hello.login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hello.login.domain.member.Member;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final SessionManager sessionManager;

	// @GetMapping("/")
	// public String home() {
	// 	return "home";
	// }

	@GetMapping("/")
	public String homeLogin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "home";
		}

		Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

		if (loginMember == null) {
			return "home";
		}

		model.addAttribute("member", loginMember);
		return "loginHome";
	}
}
