package com.market.connect.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentManagerDto {

	private String commentText;
    private Long replyingTo;
    private byte commentStatus;
    private Long companyId;
    private String commenter;
    private Date commentDate;
    private Long createdBy;
}
