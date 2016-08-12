/**
 * 
 */
package com.capgemini.job.portal.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sryarlag
 *
 */

@Entity
@Table(name="wws_need_comment")
public class NeedComment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="need_comment_id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer needCommentId;
	
	@Column(name="comment_date")
	private Date commentDate;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="created_date")
	private Date created;
	
	@Column(name="wws_id")
	private Integer wwsId;

	public Integer getNeedCommentId() {
		return needCommentId;
	}

	public void setNeedCommentId(Integer needCommentId) {
		this.needCommentId = needCommentId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getWwsId() {
		return wwsId;
	}

	public void setWwsId(Integer wwsId) {
		this.wwsId = wwsId;
	}

}
