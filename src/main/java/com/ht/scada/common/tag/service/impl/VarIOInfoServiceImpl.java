package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.VarIOInfoDao;
import com.ht.scada.common.tag.entity.VarIOInfo;
import com.ht.scada.common.tag.service.VarIOInfoService;

/**
 * 变量IO
 * 
 * @author 赵磊
 * 
 */
@Transactional
@Service("varIOInfoService")
public class VarIOInfoServiceImpl implements VarIOInfoService {

	@Autowired
	private VarIOInfoDao varIOInfoDao;

	@Override
	public void create(VarIOInfo domain) {
		varIOInfoDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		varIOInfoDao.delete(id);
	}

	@Override
	public void update(VarIOInfo domain) {
		varIOInfoDao.save(domain);
	}

	@Override
	public VarIOInfo getById(int id) {
		return varIOInfoDao.findOne(id);
	}

	@Override
	public List<VarIOInfo> findByEndTagId(int endTagId) {
		return varIOInfoDao.findByEndTagId(endTagId);
	}

	@Override
	public void saveAll(List<VarIOInfo> varIOInfoList) {
		varIOInfoDao.save(varIOInfoList);
	}


}
