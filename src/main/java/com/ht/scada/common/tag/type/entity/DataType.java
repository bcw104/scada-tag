package com.ht.scada.common.tag.type.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 值类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_Data")
public class DataType extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 459214192672340896L;
	/**
	 * 英文名
	 */
	private String name;
	/**
	 * 中文值
	 */
	private String value;
	
	public DataType() {
		
	}
	
	public DataType(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


}
