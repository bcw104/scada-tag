package com.ht.scada.common.tag.type.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * 变量类型
 * @author 赵磊
 *
 */
@Entity
@Table(name = "T_Type_Var")
public class VarType extends AbstractPersistable<Integer> {

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
	
	public VarType() {
		
	}
	
	public VarType(String name, String value) {
		this.name = name;
		this.value = value;
	}
	@OneToMany(mappedBy = "varType")
	private List<VarSubType> varSubTypeList;
	
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
	public List<VarSubType> getVarSubTypeList() {
		return varSubTypeList;
	}
	public void setVarSubTypeList(List<VarSubType> varSubTypeList) {
		this.varSubTypeList = varSubTypeList;
	}
	
	

}
