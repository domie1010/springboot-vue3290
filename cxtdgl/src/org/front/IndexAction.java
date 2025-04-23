package org.front;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dao.ChannelDao;
import org.dao.DocumentDao;
import org.dao.UserDao;
import org.entity.Channel;
import org.entity.Document;
import org.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Component("IndexAction")
public class IndexAction extends ActionSupport {
	private static final long serialVersionUID = 73496542982658911L;
	@Autowired
	private ChannelDao channelDao;

	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private UserDao userDao;

	private String id;
	private String username;
	private String password;

	public String index() {
		ActionContext context = ActionContext.getContext();
		Channel channel = new Channel();
		channel.setIsshow("是");
		channel.setCtype("新闻");
		context.put("channels", channelDao.findAllList(channel));

		Document document = new Document();
		document.setChannelName("通知公告");
		context.put("notes", documentDao.findList(document, 0, 10));

		document = new Document();
		document.setChannelType("新闻");
		context.put("news", documentDao.findList(document, 0, 10));

		document = new Document();
		document.setChannelName("关于我们");
		List<Document> aboutus = documentDao.findList(document, 0, 1);
		if (aboutus != null && !aboutus.isEmpty()) {
			context.put("aboutus", aboutus.get(0));
		}

		return "index";
	}

	public String list() {
		ActionContext context = ActionContext.getContext();
		Channel channel = new Channel();
		channel.setIsshow("是");
		channel.setCtype("新闻");
		context.put("channels", channelDao.findAllList(channel));

		Document document = new Document();
		document.setChannel(id);
		context.put("news", documentDao.findList(document, 0, 10));
		context.put("cid", id);
		return "list";
	}

	public String content() {
		ActionContext context = ActionContext.getContext();
		Channel channel = new Channel();
		channel.setIsshow("是");
		channel.setCtype("新闻");
		context.put("channels", channelDao.findAllList(channel));

		Document document = documentDao.findById(id);
		context.put("cid", document.getChannel());
		context.put("document", document);
		return "content";
	}
	public String check() {
		index();
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
				return "index";
			} else if (userEntity != null && StringUtils.isNotEmpty(userEntity.getIsenable()) && userEntity.getIsenable().equals("0")) {
				context.put("message", "该用户被禁用！");
				context.getSession().put("LOGIN_TYPE", 0);
				return "index";
			}
			context.put("message", "用户名或者密码错误！");
			context.getSession().put("LOGIN_TYPE", 0);
			return "index";

		} else {
			context.put("message", "用户名或者密码不能为空！");
			context.getSession().put("LOGIN_TYPE", 0);

			return "index";
		}
	}
	public String loginout(){
		index();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		session.remove("userEntity");
		context.setSession(session);
		return "index";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
