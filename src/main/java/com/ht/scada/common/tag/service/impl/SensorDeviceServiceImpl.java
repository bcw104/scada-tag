package com.ht.scada.common.tag.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ht.scada.common.tag.dao.AcquisitionDeviceDao;
import com.ht.scada.common.tag.dao.SensorDeviceDao;
import com.ht.scada.common.tag.entity.AcquisitionDevice;
import com.ht.scada.common.tag.entity.SensorDevice;
import com.ht.scada.common.tag.service.SensorDeviceService;

@Transactional
@Service("sensorDeviceService")
public class SensorDeviceServiceImpl implements SensorDeviceService {

	@Autowired
	AcquisitionDeviceDao acquisitionDeviceDao;
	@Autowired
	SensorDeviceDao sensorDeviceDao;
	
	@Override
	public void create(SensorDevice domain) {
		sensorDeviceDao.save(domain);
	}

	@Override
	public void deleteById(int id) {
		sensorDeviceDao.delete(id);
	}

	@Override
	public void update(SensorDevice domain) {
		sensorDeviceDao.save(domain);
	}

	@Override
	public SensorDevice getById(int id) {
		return sensorDeviceDao.findOne(id);
	}

	@Override
	public List<SensorDevice> getSensorByDeviceId(Integer id) {
		AcquisitionDevice deviceObject = acquisitionDeviceDao.findOne(id);
		if(deviceObject == null) {
			return null;
		}
		return sensorDeviceDao.findByRtuDevice(deviceObject);
	}

}
