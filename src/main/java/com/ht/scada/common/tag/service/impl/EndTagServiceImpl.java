package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.dao.EndTagDao;
import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import com.ht.scada.common.tag.service.EndTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("endTagService")
public class EndTagServiceImpl implements EndTagService {

	@Autowired
	private EndTagDao endTagDao;
	@Autowired
	private MajorTagDao majorTagDao;
	
	@Override
	public void create(EndTag domain) {
		endTagDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		endTagDao.delete(id);
	}

	@Override
	public void update(EndTag domain) {
		endTagDao.save(domain);
	}

	@Override
	public EndTag getById(int id) {
		return endTagDao.findOne(id);
	}

	@Override
	public List<EndTag> getEndTagByParentId(int id) {
		MajorTag parentMajor = majorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return endTagDao.findByMajorTag(parentMajor);
	}

    @Override
    public List<EndTag> getEndTagByMajorTagId(int id) {
        return endTagDao.findByMajorTagId(id);
    }

    @Override
    public List<EndTag> getEndTag4Comm() {
        return endTagDao.findByChannelIdxNotNullAndDeviceAddrNotNull();
    }

    @Override
    public EndTag getByCode(String code) {
        return endTagDao.findByCode(code);
    }

	@Override
	public void saveAll(List<EndTag> endTagList) {
		endTagDao.save(endTagList);
	}

    @Override
    public List<EndTag> getByType(String type) {
        return endTagDao.findByType(type);
    }

}
