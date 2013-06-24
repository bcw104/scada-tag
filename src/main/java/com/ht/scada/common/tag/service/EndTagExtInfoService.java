package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.EndTagExtInfo;

/**
 * 末端节点扩展信息
 * 
 * @author 陈志强
 * 
 */
public interface EndTagExtInfoService extends BaseService<EndTagExtInfo> {
	/**
	 * 根据单井、回路等末端节点id获取末端节点扩展信息
	 * 
	 * @param id
	 * @return
	 */
	List<EndTagExtInfo> getByEndTagId(int endTagId);
	
	/**
	 * 批量保存
	 * @param endTagExtInfoList
	 */
	void saveAll(List<EndTagExtInfo> endTagExtInfoList);
	
	/**
	 * 通过末端id删除属性
	 * @param id
	 */
	void deleteByEndTagId(Integer id);
	
	/**
	 * 通过编号和keyName获取属性
	 * @param code
	 * @param keyName
	 * @return
	 */
	EndTagExtInfo getByCodeAndKeyName(String code, String keyName);

}
