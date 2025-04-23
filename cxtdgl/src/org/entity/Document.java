package org.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "document")
public class Document implements java.io.Serializable {

	private static final long serialVersionUID = 4627946777044037747L;
	private String id;
	private String channel;
	private String channelType;
	private String channelTypeId;
	private String channelName;
	private String istop;
	private String title;
	private String summary;
	private String content;
	private String filepath;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** minimal constructor */
	public Document(String id) {
		this.id = id;
	}

	/** full constructor */
	public Document(String id, String channel, String channelName,
			String title, String content, Timestamp createtime) {
		this.id = id;
		this.channel = channel;
		this.channelName = channelName;
		this.title = title;
		this.content = content;
		this.createtime = createtime;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@javax.persistence.Column(name = "ID", length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CHANNEL", length = 38)
	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Column(name = "CHANNELNAME", length = 200)
	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CONTENT")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Column(name = "ISTOP")
	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop;
	}
	@Column(name = "FILEPATH")
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	@Column(name = "SUMMARY")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	@Column(name = "CHANNELTYPE")
	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	@Column(name = "CHANNELTYPEID")
	public String getChannelTypeId() {
		return channelTypeId;
	}

	public void setChannelTypeId(String channelTypeId) {
		this.channelTypeId = channelTypeId;
	}
	
}