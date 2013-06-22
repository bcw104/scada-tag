package com.ht.scada.common.tag.entity;


import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * 采集设备(RTU)<br>
 * 用于定义采集设备的基本信息
 * @author 薄成文
 *
 */
@Entity
@Table(name="T_Acquisition_Device")
public class AcquisitionDevice extends AbstractDevice {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1515318803542455615L;

	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean used;		// 启用
	
	
	private int timeout;		// 通讯超时（ms）
	private int retry;			// 重发
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="channel_id")
	private AcquisitionChannel channel;
	
	
	@OneToMany(mappedBy="rtuDevice")
	private List<SensorDevice> sensorDevices;
	
	public AcquisitionDevice() {
	}
	
	public AcquisitionDevice(Integer id) {
		setId(id);
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

    @JSONField(serialize = false)
	public AcquisitionChannel getChannel() {
		return channel;
	}

	public void setChannel(AcquisitionChannel channel) {
		this.channel = channel;
	}

    @JSONField(serialize = false)
	public List<SensorDevice> getSensorDevices() {
		return sensorDevices;
	}
	
	public void setSensorDevices(List<SensorDevice> sensorDevices) {
		this.sensorDevices = sensorDevices;
	}
}
