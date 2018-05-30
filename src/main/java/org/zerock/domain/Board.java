package org.zerock.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp; //jpa의 어노테이션은 아님
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "tbl_board")
@Data
public class Board {

	@Id // 각각의 엔티티는 고유한 식별자가 있다
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
	private String title, content, writer;
	// 시간처리할때 애매함.
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updateDate;

}
