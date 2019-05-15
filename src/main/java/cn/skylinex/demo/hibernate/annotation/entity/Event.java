package cn.skylinex.demo.hibernate.annotation.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="t_annotation_event")
public class Event {

	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//声明主键增长策略
	private Long id=0L;
	@Basic(fetch=FetchType.EAGER)
	private String eventName;
	//列
	@Transient//标记不需要映射的字段
	private String title;
	@Temporal(TemporalType.TIMESTAMP)//（默认）时间精度的控制
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private EvenType evenType;
	@Lob
	private String fullText1;
	@Lob
	private byte[] fullCode;
	
	@Version
	private Long version;
	
	// getter And setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EvenType getEvenType() {
		return evenType;
	}

	public void setEvenType(EvenType evenType) {
		this.evenType = evenType;
	}	
	
	public String getFullText1() {
		return fullText1;
	}

	public void setFullText1(String fullText1) {
		this.fullText1 = fullText1;
	}

	public byte[] getFullCode() {
		return fullCode;
	}

	public void setFullCode(byte[] fullCode) {
		this.fullCode = fullCode;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", date=" + date + "]";
	}
}
