package com.hjh.ssmo.controller.sys;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ssmo.model.sys.Manager;
import com.hjh.ssmo.model.view.Result;
import com.hjh.ssmo.service.sys.LoginService;
import com.hjh.ssmo.util.Constant;

@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private LoginService loginService;

	/**
	 * 跳转首页
	 */
	@RequestMapping("/login")
	public String redirectLogin(HttpSession session) throws Exception {
		// 检查session中用户是否已登录 如果已经登录 则直接跳转后台
		Manager manager = (Manager) session.getAttribute(Constant.USERINFO);
		if (null != manager) {
			// 跳转后台 home
			// return "redirect:/admin/home";
			return "redirect:/admin/article/list";
		}
		return "/admin/login";
	}

	/**
	 * 登录校验
	 */
	@RequestMapping("/admin/login")
	public @ResponseBody
	Result login(Manager manager, HttpSession session) {
		// 校验用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(manager.getUserName(), manager.getPassword());
		token.setRememberMe(true);
		// 获取当前的Subject
		Subject subject = SecurityUtils.getSubject();
//		subject.login(token);
		try {
			subject.login(token);
			System.out.println("sessionTimeout===>" + subject.getSession().getTimeout());
		} catch (UnknownSessionException use) {
			subject = new Subject.Builder().buildSubject();
			subject.login(token);
			logger.error(Constant.UNKNOWN_SESSION_EXCEPTION);
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.UNKNOWN_SESSION_EXCEPTION);
		} catch (UnknownAccountException ex) {
			logger.error(Constant.UNKNOWN_ACCOUNT_EXCEPTION);
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.UNKNOWN_ACCOUNT_EXCEPTION);
		} catch (IncorrectCredentialsException ice) {
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.INCORRECT_CREDENTIALS_EXCEPTION);
		} catch (LockedAccountException lae) {
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.LOCKED_ACCOUNT_EXCEPTION);
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.AUTHENTICATION_EXCEPTION);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result("fail", Constant.LOGIN_FAIL);
			// json.setMessage(Constants.UNKNOWN_EXCEPTION);
		}
		// if (loginService.validateManager(manager)) {
		// // 存放用户信息在session中 有效时间60分钟
		// manager = loginService.getManagerInfo(manager);
		// session.setAttribute(Constant.USERINFO, manager);
		// String sessionTime =
		// CompositeFactory.getString(Constant.SESSION_INVALID_TIME);
		// session.setMaxInactiveInterval(Integer.parseInt(sessionTime));
		// return new Result("success", Constant.LOGIN_SUCCESS);
		// } else {
		// return new Result("fail", Constant.LOGIN_FAIL);
		// }
		return new Result("success", Constant.LOGIN_SUCCESS);
	}

	/**
	 * 跳转首页
	 */
	@RequestMapping("/admin/home")
	public String home(HttpSession session, ModelMap map) {
		Manager manager = (Manager) session.getAttribute(Constant.USERINFO);
		map.put("manager", manager);
		// return "/admin/home";
		return "redirect:/admin/article/list";
	}

	/**
	 * 登出
	 */
	@RequestMapping("/out")
	public String loginout(HttpSession session) {
		// 清除会话session
		session.removeAttribute(Constant.USERINFO);
		session.invalidate();
		// 跳转登录页
		return "redirect:/login";
	}

	/**
	 * 404
	 */
	@RequestMapping("/404")
	public String fourTofour() {
		return "/admin/404";
	}

	/**
	 * 500
	 */
	@RequestMapping("/500")
	public String five() {
		return "/admin/500";
	}

}
