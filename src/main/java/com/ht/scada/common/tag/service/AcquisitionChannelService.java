package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.AcquisitionChannel;

import java.util.List;

/**
 * 提供通道查询服务
 * 
 * @author 陈志强
 * 
 */
public interface AcquisitionChannelService extends
		BaseService<AcquisitionChannel> {



    /**
     * 获取所有采集通道
     * @return
     */
    List<AcquisitionChannel> getAllChannel();
    /**
     * 通过序号获取采集通道
     * @return
     */
    AcquisitionChannel getByIdx(Integer idx);

}
