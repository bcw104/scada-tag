package com.ht.scada.common.tag.dao;

import java.util.List;

import com.ht.scada.common.tag.entity.VarIOInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created with IntelliJ IDEA.
 * 作者: "薄成文"
 * 日期: 13-5-16 下午2:03
 * To change this template use File | Settings | File Templates.
 */
public interface VarIOInfoDao extends JpaRepository<VarIOInfo, Integer> {
	/**
	 * 通过监控对象id获取变量IO信息
	 * @param endTagId
	 * @return
	 */
	@Query("select v from VarIOInfo v where v.endTag.id = ?1")
	List<VarIOInfo> findByEndTagId(int endTagId);
}
