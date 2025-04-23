package org.front;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.struts2.ServletActionContext;
import org.dao.ChannelDao;
import org.dao.DocumentDao;
import org.entity.Channel;
import org.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.util.PageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*

 */
@Scope("prototype")
@Component("DocumentAction")
public class DocumentAction extends ActionSupport {
	private static final long serialVersionUID = -9167213418951271794L;

	private int pageSize = 10;
	private int currentPage = 1;
	private Document entity = new Document();

	private Map<String, Object> dataMap = new HashMap<String, Object>();

	@Autowired
	private DocumentDao entityDao;
	@Autowired
	private ChannelDao channelDao;

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
				List<Document> entityList = (List<Document>) entityDao.findList(entity, pageUtil.getStart(), pageUtil.getPageSize());
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

	public String listAll() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			List<Document> entityList = (List<Document>) entityDao.findAllList(entity);
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
			context.put("channel", channelDao.findAllList(new Channel()));
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
		ActionContext context = ActionContext.getContext();
		context.put("channel", channelDao.findAllList(new Channel()));
		return "edit";
	}

	public String saveUpdate() {
		ActionContext context = ActionContext.getContext();
		dataMap.clear();
		try {
			String filePath = upload();
			if (StringUtils.isNotEmpty(filePath)) {
				entity.setFilepath(filePath);
			}
			Channel channel = channelDao.findById(entity.getChannel());
			entity.setChannelType(channel.getCtype());
			entity.setChannelName(channel.getCname());
			if (entityDao.update(entity)) {
				dataMap.put("message", "修改成功！");
				context.put("message", "修改成功！");
				dataMap.put("status", true);
				context.put("status", true);
			} else {
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
			if (entityDao.delete(entity.getId())) {
				dataMap.put("message", "删除成功！");
				context.put("message", "删除成功！");
				dataMap.put("status", true);
				context.put("status", true);
			} else {
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

	public Document getEntity() {
		return entity;
	}

	public void setEntity(Document entity) {
		this.entity = entity;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/************* 文件上传开始 *****************/
	private File image; // 上传图片获取的File对象
	private String imageFileName; // 上传图片获取的图片名字
	private String imageContentType; // 上传图片获取的图片类型

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String upload() {
		// 设置文件存放位置
		String path = ServletActionContext.getServletContext().getRealPath("/attached/image/");
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath = request.getContextPath();
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + basePath + "/";

		String imageUrl = "";
		if (null != image) {
			File filepath = new File(path);
			if (!filepath.exists()) {// 判断文件路径是否存在，不存在就创建
				filepath.mkdir();
			}
			String yyyyMMdd = DateFormatUtils.format(new Date(), "yyyyMMdd");
			String yyyyMMddhhmmss = DateFormatUtils.format(new Date(), "yyyyMMddhhmmss");
			String imageName = yyyyMMddhhmmss + "-" + imageFileName;
			File target = new File(path + "/" + yyyyMMdd, imageName);
			try {
				FileUtils.copyFile(image, target);
				imageUrl = basePath + "attached/image/" + yyyyMMdd + "/" + imageName;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imageUrl;
	}
	/************* 文件上传结束 *****************/
}
