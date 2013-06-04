package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.entity.TagCfgTpl;

public interface TagCfgTplDao extends JpaRepository<TagCfgTpl, Integer>{
	
	/**
	 * 查找不同的模板
	 * @return
	 */
	@Query("select distinct t.tplName from TagCfgTpl t")
	public List<String> findDistinctByTplName();
	
	/**
	 * 通过模板名字获得所有变量
	 * @return
	 */
	@Query("select t from TagCfgTpl t where t.tplName = ?1")
	public List<TagCfgTpl> findVariablesByTplName(String tplName);
	
	/**
	 * 删除变量模板所有变量
	 * @param tplName
	 */
	@Modifying
	@Query("delete from TagCfgTpl t where t.tplName = ?1")
	public void deleteByTplName(String tplName);
	
	
	/**
	 * 通过模板名和变量名获取变量对象
	 * @param code
	 * @param varName
	 * @return
	 */
	@Query("select t from TagCfgTpl t where t.tplName = ?1 and t.varName=?2")
	TagCfgTpl getTagCfgTplByTplNameAndVarName(String tplName, String varName);

}
