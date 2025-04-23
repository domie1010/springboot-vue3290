package org.front;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("AdminAction")
public class AdminAction  extends ActionSupport {
	private static final long serialVersionUID = 73496542982658911L;

	@Override
	public String execute() throws Exception {
		return ActionSupport.SUCCESS;
	}
}
