package org.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dao.UserDao;
import org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.util.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("UserAction")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -9167213418951271794L;

	private int pageSize = 10; // 每页显示数量
	private int currentPage = 1; // 当前页码
	private User entity = new User();

	private Map<String, Object> dataMap = new HashMap<String, Object>();

	@Autowired
	private UserDao entityDao;

	@SuppressWarnings("unchecked")
	public String list() {
		ActionContext context = ActionContext.getContext();
		try {
			dataMap.clear();
			int listCount = entityDao.countList(entity);
			PageUtil pageUtil = new PageUtil();
			if (listCount > 0) {
				pageUtil.setPageSize(pageSize);// 每页显示的记录数量
				pageUtil.setTotalRecord(listCount);// 总记录数
				pageUtil.setCurrentPage(currentPage);// 当前页码
				List<User> entityList = (ArrayList<User>) entityDao.findList(entity, pageUtil.getStart(), pageUtil.getPageSize());
				dataMap.put("list", entityList);
				context.put("list", entityList);
			} else {
				pageUtil.setPageSize(pageSize);// 每页显示的记录数量
				pageUtil.setTotalRecord(0);// 总记录数
				pageUtil.setCurrentPage(currentPage);// 当前页码
			}
			dataMap.put("message", "查询成功！");
			context.put("message", "查询成功！");
			dataMap.put("status", true);
			context.put("status", true);
			dataMap.put("pageUtil", pageUtil);
			context.put("pageUtil", pageUtil);
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "查询失败！");
			context.put("status",  "查询失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
		return "list";
	}

	public String edit() {
		entity = entityDao.findById(entity.getId());
		return "edit";
	}
	
	public String updatepage() {
		entity = entityDao.findById(entity.getId());
		return "update";
	}
	
	public String update() {
		saveUpdate();
		return "update";
	}

	public String byxz() {
		return "byxz";
	}
	
	public String gllc() {
		return "gllc";
	}
	
	public String add() {
		return "edit";
	}
	
	public String regedit() {
		return "regedit";
	}

	public String saveUpdate() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			entityDao.update(entity);
			dataMap.put("message", "修改成功！");
			dataMap.put("status", true);
			context.put("message", "修改成功！");
			context.put("status", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "修改失败！");
			dataMap.put("status", false);
			context.put("message", "修改失败！");
			context.put("status", false);
		}
		return "success";
	}

	public String delete() {
		entityDao.delete(entity.getId());
		return "success";
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public User getEntity() {
		return entity;
	}

	public void setEntity(User entity) {
		this.entity = entity;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
