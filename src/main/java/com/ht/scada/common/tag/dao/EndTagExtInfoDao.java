package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.entity.EndTagExtInfo;
/**
 * 
 * @author 陈志强
 * 
 */
public interface EndTagExtInfoDao extends JpaRepository<EndTagExtInfo, Integer> {
	/**
	 * 根据单井、回路等末端节点id获取末端节点扩展信息
	 * @return
	 */
	@Query("select e from EndTagExtInfo e where e.endTag.id = ?1")
	public List<EndTagExtInfo> getByEndTagId(int endTagId);
	
	/**
	 * 通过末端Id删除
	 * @param id
	 */
	@Modifying
	@Query("delete from EndTagExtInfo e where e.endTag.id = ?1")
	public void deleteByTagId(int id);
	
	/**
	 * 通过code获得EndTagExtInfo
	 * @param code
	 * @return
	 */
	@Query("select e from EndTagExtInfo e where e.endTag.code = ?1")
	List<EndTagExtInfo> getByEndTagCode(String code);
	
	/**
	 * 通过编号和keyName获取属性
	 * @param code
	 * @param keyName
	 * @return
	 */
	@Query("select e from EndTagExtInfo e where e.endTag.code = ?1 and e.keyName = ?2")
	EndTagExtInfo getByCodeAndKeyName(String code, String keyName);
	
}
