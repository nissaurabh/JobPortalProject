/**
 * 
 */
package com.capgemini.job.portal.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author sryarlag
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wwsId",
    "commentDate",
    "comment",
    "commentId"
})

public class NeedCommentJAXB {
	
	private String wwsId;
	
	private String commentDate;

	private String comment;
	
	private String commentId;

	public String getWwsId() {
		return wwsId;
	}

	public void setWwsId(String wwsId) {
		this.wwsId = wwsId;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

}
