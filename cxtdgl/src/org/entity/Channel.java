package org.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "channel")
public class Channel implements java.io.Serializable {

	private static final long serialVersionUID = 1999121850711119504L;
	private String id;
	private String cname;
	private String ctype;
	private String isshow;
	private String temppath;
	private Integer csort;
	private String cparent;
	private String cparentName;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Channel() {
	}

	/** minimal constructor */
	public Channel(String id) {
		this.id = id;
	}

	/** full constructor */
	public Channel(String id, String cname, String ctype, Integer csort,
			String cparent, String cparentName, Timestamp createtime) {
		this.id = id;
		this.cname = cname;
		this.ctype = ctype;
		this.csort = csort;
		this.cparent = cparent;
		this.cparentName = cparentName;
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

	@Column(name = "CNAME", length = 100)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CTYPE", length = 100)
	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Column(name = "CSORT")
	public Integer getCsort() {
		return this.csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	@Column(name = "CPARENT", length = 38)
	public String getCparent() {
		return this.cparent;
	}

	public void setCparent(String cparent) {
		this.cparent = cparent;
	}

	@Column(name = "CPARENTNAME", length = 100)
	public String getCparentName() {
		return this.cparentName;
	}

	public void setCparentName(String cparentName) {
		this.cparentName = cparentName;
	}

	@Column(name = "CREATETIME", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(name = "ISSHOW", length = 100)
	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	
	@Column(name = "TEMPPATH", length = 100)
	public String getTemppath() {
		return temppath;
	}

	public void setTemppath(String temppath) {
		this.temppath = temppath;
	}

}