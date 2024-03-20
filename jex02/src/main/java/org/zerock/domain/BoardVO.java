package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long boardNo;
	private String title;
	private String content;
	private String writer;
	private Date createDate;
	private Date updateDate;
}
