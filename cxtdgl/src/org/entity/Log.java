package org.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log")
public class Log implements java.io.Serializable {

	// Fields

	private String id;
	private String userid;
	private String username;
	private String message;
	private String opip;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor */
	public Log(String id) {
		this.id = id;
	}

	/** full constructor */
	public Log(String id, String userid, String username, String message, String opip, Date createtime) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.message = message;
		this.opip = opip;
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

	@Column(name = "userid", length = 100)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "username", length = 500)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "message", length = 1000)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "opip", length = 100)
	public String getOpip() {
		return this.opip;
	}

	public void setOpip(String opip) {
		this.opip = opip;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createtime", length = 10)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}