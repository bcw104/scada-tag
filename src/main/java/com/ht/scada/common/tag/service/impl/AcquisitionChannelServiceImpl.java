package com.ht.scada.common.tag.service.impl;

import com.ht.scada.common.tag.dao.AcquisitionChannelDao;
import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.service.AcquisitionChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("acquisitionChannelService")
public class AcquisitionChannelServiceImpl implements AcquisitionChannelService {

	@Autowired
	private AcquisitionChannelDao acquisitionChannelDao;

	

    @Override
    public List<AcquisitionChannel> getAllChannel() {
        return acquisitionChannelDao.findAll();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
	public void create(AcquisitionChannel domain) {
		acquisitionChannelDao.save(domain);
		
	}

	@Override
	public void deleteById(int id) {
		acquisitionChannelDao.delete(id);
	}

	@Override
	public void update(AcquisitionChannel domain) {
		acquisitionChannelDao.save(domain);
		
	}

	@Override
	public AcquisitionChannel getById(int id) {
		return acquisitionChannelDao.findOne(id);
	}

	@Override
	public AcquisitionChannel getByIdx(Integer idx) {
		return acquisitionChannelDao.findByIdx(idx);
	}

	

}
