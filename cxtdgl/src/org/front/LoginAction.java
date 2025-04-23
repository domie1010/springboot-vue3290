package org.front;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.dao.LogDao;
import org.dao.UserDao;
import org.entity.Log;
import org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("LoginAction")
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -3787034050787520578L;

	private String username;
	private String password;
	private String checkcode;
	private User user = new User();
	private Map<String, Object> dataMap = new HashMap<String, Object>();
	@Autowired
	private UserDao userDao;
	@Autowired
	private LogDao logDao;
	public String regedit() {
		ActionContext context = ActionContext.getContext();
		try {

			dataMap.clear();

			if (userDao.countListByUserName(user) <= 0) {
				userDao.update(user);
				context.put("message", "注册成功,请登录！");
				dataMap.put("status", true);
				context.put("message", "注册成功,请登录！");
				context.put("status", true);
			} else {
				dataMap.put("message", "用户已经存在，请更换用户名再试！");
				dataMap.put("status", false);

				context.put("message", "用户已经存在，请更换用户名再试！");
				context.put("status", false);
				return "regeditpage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "系统错误，请联系系统管理员！");
			dataMap.put("status", false);

			context.put("message", "系统错误，请联系系统管理员！");
			context.put("status", false);
			return "regeditpage";
		}
		return "regeditsuccess";
	}

	public String regeditpage() {
		return "regeditpage";
	}

	public String jsonCheck() {
		dataMap.clear();
		try {
			ActionContext context = ActionContext.getContext();
			Map<String, Object> session = context.getSession();
			if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
				User user = new User();
				user.setUsername(username);
				user = userDao.findByUserName(user);
				if (user != null && user.getPassword().equals(password) && (StringUtils.isEmpty(user.getIsenable()) || user.getIsenable().equals("1"))) {
					session.put("userEntity", user);
					session.put("LOGIN_TYPE", 1);
					context.setSession(session);
					dataMap.put("user", user);
					dataMap.put("message", "登陆成功！");
					dataMap.put("status", true);
					Log log = new Log();
					log.setMessage("登录成功！");
					log.setUserid(user.getId());
					log.setUsername(user.getUsername());
					log.setOpip(getIpAddr(ServletActionContext.getRequest()));
					logDao.update(log);
				} else if (user != null && StringUtils.isNotEmpty(user.getIsenable()) && user.getIsenable().equals("0")) {
					dataMap.put("message", "该用户被禁用！");
					dataMap.put("status", false);
					context.getSession().put("LOGIN_TYPE", 0);
				} else {
					dataMap.put("message", "用户名或者密码错误！");
					dataMap.put("status", false);
					context.getSession().put("LOGIN_TYPE", 0);
				}
			} else {
				dataMap.put("message", "用户名或者密码不能为空！");
				dataMap.put("status", false);
				context.getSession().put("LOGIN_TYPE", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "系统错误，请联系系统管理员！");
			dataMap.put("status", false);
		}
		return "success";
	}

	public String check() {
		dataMap.clear();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		if (StringUtils.isNotEmpty(username)) {
			User userEntity = new User();
			userEntity.setUsername(username);
			userEntity = userDao.findByUserName(userEntity);
			if (userEntity != null && userEntity.getPassword().equals(password) && StringUtils.isNotEmpty(userEntity.getIsenable()) && userEntity.getIsenable().equals("1")) {
				session.put("userEntity", userEntity);
				session.put("LOGIN_TYPE", 1);
				context.setSession(session);
				Log log = new Log();
				log.setMessage("登录成功！");
				log.setUserid(userEntity.getId());
				log.setUsername(userEntity.getUsername());
				log.setOpip(getIpAddr(ServletActionContext.getRequest()));
				logDao.update(log);
				return "success";
			} else if (userEntity != null && StringUtils.isNotEmpty(userEntity.getIsenable()) && userEntity.getIsenable().equals("0")) {
				context.put("message", "该用户被禁用！");
				context.getSession().put("LOGIN_TYPE", 0);
				return "loginPage";
			}
			context.put("message", "用户名或者密码错误！");
			context.getSession().put("LOGIN_TYPE", 0);
			return "loginPage";

		} else {
			context.put("message", "用户名或者密码不能为空！");
			context.getSession().put("LOGIN_TYPE", 0);

			return "loginPage";
		}
	}
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public String loginout() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.remove("userEntity");
		context.setSession(session);
		return "loginPage";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
