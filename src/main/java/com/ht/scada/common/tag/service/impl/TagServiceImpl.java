package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.dao.AcquisitionDeviceDao;
import com.ht.scada.common.tag.dao.AreaMinorTagDao;
import com.ht.scada.common.tag.dao.EndTagDao;
import com.ht.scada.common.tag.dao.MajorTagDao;
import com.ht.scada.common.tag.dao.SensorDeviceDao;
import com.ht.scada.common.tag.dao.TagCfgTplDao;
import com.ht.scada.common.tag.dao.VarIOInfoDao;
import com.ht.scada.common.tag.entity.*;
import com.ht.scada.common.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private MajorTagDao majorTagDao;
	@Autowired
	private EndTagDao endTagDao;
	@Autowired
	private AreaMinorTagDao areaMinorTagDao;
    @Autowired
    private VarIOInfoDao varIOInfoDao;
    @Autowired
    private TagCfgTplDao tagCfgTplDao;
    @Autowired
    private AcquisitionDeviceDao acquisitionDeviceDao;
    @Autowired
    private SensorDeviceDao sensorDeviceDao;

	@Override
	public MajorTag getMajorTag(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EndTag getEndTag(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagCfgTpl getTagCfgTpl(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTagTplNameByMajorTagID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TagCfgTpl> getTagTplByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MajorTag> getMajorTagByNodeName(String name) {
		MajorTag parentMajor = majorTagDao.findByName(name);
		if(parentMajor == null) {
			return null;
		}
		return majorTagDao.findByParent(parentMajor);
	}

	@Override
	public List<EndTag> getEndTagByMajorTagAndType(int majorTagID, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SensorDevice> getSensorDeviceByRTUDeviceID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AcquisitionDevice> getDeviceByChannelName(String name) {
		return null;
	}

	@Override
	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createMajorTag(MajorTag majorTag) {
		majorTagDao.save(majorTag);
	}

	@Override
	public void deleteMajorTagById(int id) {
		majorTagDao.delete(id);
	}

	@Override
	public void updateMajorTag(MajorTag majorTag) {
		majorTagDao.save(majorTag);
	}

	@Override
	public List<MajorTag> getMajorTagsByParentId(int id) {
		MajorTag parentMajor = majorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return majorTagDao.findByParent(parentMajor);
	}

	@Override
	public List<MajorTag> getRootMajorTag() {
		return majorTagDao.findByParent(null);
	}

	@Override
	public void createEndTag(EndTag endTag) {
		endTagDao.save(endTag);
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
	public void deleteEndTagById(int id) {
		endTagDao.delete(id);
	}

	@Override
	public void updateEndTag(EndTag endTag) {
		endTagDao.save(endTag);
	}

	@Override
	public List<AreaMinorTag> getRootAreaMinorTag() {
		return areaMinorTagDao.findByParent(null);
	}

	@Override
	public List<AreaMinorTag> getAreaMinorTagsByParentId(Integer id) {
		AreaMinorTag parentMajor = areaMinorTagDao.findOne(id);
		if(parentMajor == null) {
			return null;
		}
		return areaMinorTagDao.findByParent(parentMajor);
	}

	@Override
	public void deleteAreaMinorTagById(int id) {
		areaMinorTagDao.delete(id);
	}

	@Override
	public void createAreaMinorTag(AreaMinorTag areaMinorTag) {
		areaMinorTagDao.save(areaMinorTag);
		
	}

	@Override
	public void updateAreaMinorTag(AreaMinorTag areaMinorTag) {
		areaMinorTagDao.save(areaMinorTag);
		
	}

    @Override
    public List<VarIOInfo> getAllTagIOInfo() {
        return varIOInfoDao.findAll();  //To change body of implemented methods use File | Settings | File Templates.
    }

	@Override
	public TagCfgTpl getTagCfgTplByCodeAndVarName(String code, String varName) {
		EndTag endTag = endTagDao.findByCode(code);
		if(endTag != null) {
			return tagCfgTplDao.getTagCfgTplByTplNameAndVarName(endTag.getTplName(), varName);
		}
		return null;
	}

	@Override
	public List<SensorDevice> getSensorDeviceByCode(String code) {
		EndTag endTag = endTagDao.findByCode(code);
		if(endTag != null) {
			AcquisitionDevice device = acquisitionDeviceDao.findByChannelIdAndDeviceId(endTag.getChannelIdx(), endTag.getDeviceAddr());
			if(device != null) {
				return sensorDeviceDao.findByRtuDevice(device);
			}
		}
		return null;
	}

	@Override
	public SensorDevice getSensorDeviceByCodeAndNickName(String code,
			String nickName) {
		EndTag endTag = endTagDao.findByCode(code);
		if(endTag != null) {
			AcquisitionDevice device = acquisitionDeviceDao.findByChannelIdAndDeviceId(endTag.getChannelIdx(), endTag.getDeviceAddr());
			if(device != null) {
				return sensorDeviceDao.findByNickNameAndRtuDevice(nickName, device);
			}
		}
		return null;
	}
}
