package org.front;


import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 5965351519599564486L;

	/*
	 * 验证是否已登录 LOGIN_TYPE = 1 :已登录 LOGIN_TYPE = 0 :未登录
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 Map<String, Object> sessionMap= invocation.getInvocationContext().getSession();
		if (sessionMap == null) {
			return Action.LOGIN;
		}
		int LOGIN_TYPE = sessionMap.get("LOGIN_TYPE") == null ? 0 : (Integer) sessionMap.get("LOGIN_TYPE");
		if (LOGIN_TYPE != 1) {
			return Action.LOGIN;
		} else {
			return invocation.invoke();
		}
	}
}
