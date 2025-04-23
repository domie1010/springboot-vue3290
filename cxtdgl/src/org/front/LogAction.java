package org.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dao.LogDao;
import org.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.util.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Scope("prototype")
@Component("LogAction")
public class LogAction extends ActionSupport {
	private static final long serialVersionUID = -9167213418951271794L;

	private int pageSize = 10;
	private int currentPage = 1;
	private Log entity = new Log();

	private Map<String, Object> dataMap = new HashMap<String, Object>();

	@Autowired
	private LogDao entityDao;
	
	public String list() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			int listCount = entityDao.countList(entity);
			PageUtil pageUtil = new PageUtil();
			if (listCount > 0) {
				pageUtil.setPageSize(pageSize);// 每页显示的记录数量
				pageUtil.setTotalRecord(listCount);// 总记录数
				pageUtil.setCurrentPage(currentPage);// 当前页码
				List<Log> entityList = (List<Log>)entityDao.findList(entity, pageUtil.getStart(), pageUtil.getPageSize());
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
			context.put("status", "查询失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
		return "list";
	}
	public String query(){
		list();
		return "query";
	}
	public String listAll() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			List<Log> entityList = (List<Log>)entityDao.findAllList(entity);
			dataMap.put("list", entityList);
			context.put("list", entityList);
			dataMap.put("message", "查询成功！");
			context.put("message", "查询成功！");
			dataMap.put("status", true);
			context.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "查询失败！");
			context.put("status", "查询失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
		return "listAll";
	}
	
	public String edit() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			entity = entityDao.findById(entity.getId());
			
			dataMap.put("message", "查询成功！");
			context.put("message", "查询成功！");
			dataMap.put("status", true);
			context.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "查询失败！");
			context.put("status", "查询失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
		return "edit";
	}

	public String add() {
		return "edit";
	}


	public String saveUpdate() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			if(entityDao.update(entity)){
				dataMap.put("message", "修改成功！");
				context.put("message", "修改成功！");
				dataMap.put("status", true);
				context.put("status", true);
			}else{
				dataMap.put("message", "修改失败！");
				context.put("message", "修改失败！");
				dataMap.put("status", false);
				context.put("status", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "修改失败！");
			context.put("message", "修改失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
		return "success";
	}

	public String delete() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			if(entityDao.delete(entity.getId())){
				dataMap.put("message", "删除成功！");
				context.put("message", "删除成功！");
				dataMap.put("status", true);
				context.put("status", true);
			}else{
				dataMap.put("message", "删除失败！");
				context.put("message", "删除失败！");
				dataMap.put("status", false);
				context.put("status", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dataMap.put("message", "删除失败！");
			context.put("message", "删除失败！");
			dataMap.put("status", false);
			context.put("status", false);
		}
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

	public Log getEntity() {
		return entity;
	}

	public void setEntity(Log entity) {
		this.entity = entity;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
