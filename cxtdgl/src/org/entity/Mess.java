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
 * Mess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mess")
public class Mess implements java.io.Serializable {

	// Fields

	private String id;
	private String fuserid;
	private String fusername;
	private String fmessage;
	private String tuserid;
	private String tusername;
	private String tmessage;
	private String ext1;
	private String ext2;
	private String ext3;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Mess() {
	}

	/** minimal constructor */
	public Mess(String id) {
		this.id = id;
	}

	/** full constructor */
	public Mess(String id, String fuserid, String fusername, String fmessage, String tuserid, String tusername, String tmessage, String ext1, String ext2, String ext3, Date createtime) {
		this.id = id;
		this.fuserid = fuserid;
		this.fusername = fusername;
		this.fmessage = fmessage;
		this.tuserid = tuserid;
		this.tusername = tusername;
		this.tmessage = tmessage;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
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

	@Column(name = "fuserid", length = 50)
	public String getFuserid() {
		return this.fuserid;
	}

	public void setFuserid(String fuserid) {
		this.fuserid = fuserid;
	}

	@Column(name = "fusername", length = 100)
	public String getFusername() {
		return this.fusername;
	}

	public void setFusername(String fusername) {
		this.fusername = fusername;
	}

	@Column(name = "fmessage", length = 500)
	public String getFmessage() {
		return this.fmessage;
	}

	public void setFmessage(String fmessage) {
		this.fmessage = fmessage;
	}

	@Column(name = "tuserid", length = 50)
	public String getTuserid() {
		return this.tuserid;
	}

	public void setTuserid(String tuserid) {
		this.tuserid = tuserid;
	}

	@Column(name = "tusername", length = 100)
	public String getTusername() {
		return this.tusername;
	}

	public void setTusername(String tusername) {
		this.tusername = tusername;
	}

	@Column(name = "tmessage", length = 500)
	public String getTmessage() {
		return this.tmessage;
	}

	public void setTmessage(String tmessage) {
		this.tmessage = tmessage;
	}

	@Column(name = "ext1")
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3")
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
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