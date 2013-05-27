package com.ht.scada.common.tag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ht.scada.common.tag.entity.AcquisitionChannel;
import com.ht.scada.common.tag.entity.AcquisitionDevice;

public interface AcquisitionDeviceDao extends JpaRepository<AcquisitionDevice, Integer> {

	/***
	 * 根据通道获得对应设备
	 * @param channelObject
	 * @return
	 */
	List<AcquisitionDevice> findByChannel(AcquisitionChannel channelObject);
	
	@Query("select a from AcquisitionDevice a where a.address = ?2 and a.channel.idx = ?1")
	AcquisitionDevice findByChannelIdAndDeviceId(Integer channelId, Integer deviceId);

}
