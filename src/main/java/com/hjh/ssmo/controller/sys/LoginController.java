package com.hjh.ssmo.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	 * 判断用户是否登录
	 * 
	 * @param currUser
	 * @return
	 */
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public @ResponseBody
	Result isLogin(Manager currUser) {
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(currUser.getUserName(), currUser.getPassword());
		token.setRememberMe(true);
		try {
			user.login(token);
			return new Result("success", Constant.LOGIN_SUCCESS);
		} catch (AuthenticationException e) {
			logger.error("登录失败错误信息:" + e);
			token.clear();
			return new Result("fail", Constant.LOGIN_FAIL);
		}
	}

	/**
	 * 跳转首页
	 */
	@RequestMapping("/login")
	public String redirectLogin(HttpSession session) throws Exception {
		// 检查session中用户是否已登录 如果已经登录 则直接跳转后台
		Subject user = SecurityUtils.getSubject();
		if (user.isAuthenticated()) {
			// 跳转后台 home
			return "redirect:/admin/article/list";
		}
		return "/admin/login";
	}

	/**
	 * 跳转首页
	 */
	@RequestMapping("/admin/home")
	public String home(HttpSession session, ModelMap map) {

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
     * 用户登出 
     */  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
         SecurityUtils.getSubject().logout();  
         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";  
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
