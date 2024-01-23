package com.market.connect.entity;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment_manager")
public class CommentManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment_text", length = 200)
    private String commentText;

    @Column(name = "replying_to")
    private Long replyingTo;

    @Column(name = "comment_status", nullable = false)
    private byte commentStatus;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "commenter", length = 2, nullable = false)
    private String commenter;

    @Column(name = "comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;
	
}
