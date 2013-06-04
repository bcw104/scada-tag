package com.ht.scada.common.tag.service;

import java.util.List;

import com.ht.scada.common.tag.entity.VarIOInfo;

/**
 * 变量IO
 * 
 * @author 赵磊
 * 
 */
public interface VarIOInfoService extends BaseService<VarIOInfo> {

	/**
	 * 通过监控对象id获取变量IO信息
	 * @param endTagId
	 * @return
	 */
	List<VarIOInfo> findByEndTagId(int endTagId);
	
	/**
	 * 批量保存
	 * @param varIOInfoList
	 */
	void saveAll(List<VarIOInfo> varIOInfoList);
	
	/**
	 * 通过监控对象id与变量名获得变量IO信息
	 * @param endTagId
	 * @param varName
	 * @return
	 */
	VarIOInfo getByEndTagIdAndVarName(int endTagId, String varName);
}
