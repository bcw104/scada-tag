package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.*;

import java.util.List;

/**
 * 提供标签配置信息查询服务
 * 
 * @author 薄成文
 * @author 赵磊
 * @author 陈志强
 * 
 */
public interface TagService {

	/**
	 * 创建主索引
	 * 
	 * @param majorTag
	 */
	public void createMajorTag(MajorTag majorTag);

	/**
	 * 添加末端节点
	 * 
	 * @param endTag
	 */
	public void createEndTag(EndTag endTag);
	
	/**
	 * 通过编号和变量名获得变量
	 * @param code 井号
	 * @param varName 变量key
	 * @return
	 */
	public TagCfgTpl getTagCfgTplBy(String code, String varName);

	/**
	 * 删除主索引
	 * 
	 * @param id
	 */
	public void deleteMajorTagById(int id);

	/**
	 * 删除末端节点
	 * 
	 * @param id
	 */
	public void deleteEndTagById(int id);

	/**
	 * 修改末端节点
	 * 
	 * @param endTag
	 */
	public void updateEndTag(EndTag endTag);

	/**
	 * 修改主索引
	 * 
	 * @param majorTag
	 */
	public void updateMajorTag(MajorTag majorTag);

	/**
	 * 获取所有子节点
	 * 
	 * @param id
	 * @return
	 */
	public List<MajorTag> getMajorTagsByParentId(int id);

	/**
	 * 通过id获得所有末端节点
	 * 
	 * @param id
	 * @return
	 */
	public List<EndTag> getEndTagByParentId(int id);

	/**
	 * 通过主键查询主标签节点
	 * 
	 * @param id
	 * @return
	 */
	public MajorTag getMajorTag(int id);

	/**
	 * 通过主键查询末端节点
	 * 
	 * @param id
	 * @return
	 */
	public EndTag getEndTag(int id);

	public TagCfgTpl getTagCfgTpl(int id);

	/**
	 * @param id
	 * @return
	 */
	public String getTagTplNameByMajorTagID(int id);

	/**
	 * 根据变量词典模板名称获取变量词典
	 * 
	 * @param name
	 * @return
	 */
	public List<TagCfgTpl> getTagTplByName(String name);

	public List<VarIOInfo> getTagIOInfoByEndTagID(int endTagID);

	/**
	 * 通过主标签名称获取标签列表(用于模拟树型结构)
	 * 
	 * @param name
	 * @return
	 */
	public List<MajorTag> getMajorTagByNodeName(String name);

	/**
	 * 通过主标签ID和末端类型获取所有末端, 如果末端类型为空负不过滤
	 * 
	 * @param majorTagID
	 *            主标签主键
	 * @param type
	 *            末端类型
	 * @return
	 */
	public List<EndTag> getEndTagByMajorTagAndType(int majorTagID, String type);

	/**
	 * 获取RTU设备下面的所有传感器设备
	 * 
	 * @param id
	 * @return
	 */
	public List<SensorDevice> getSensorDeviceByRTUDeviceID(int id);

	/**
	 * 获取所有采集通道名称（含带通讯规约）
	 * 
	 * @return
	 */
	public List<String> getAllChannel();

	/**
	 * 通过采集通道名称获取
	 * 
	 * @param name
	 * @return
	 */
	public List<AcquisitionDevice> getDeviceByChannelName(String name);

	/**
	 * 获得根主索引
	 * 
	 * @return
	 */
	public List<MajorTag> getRootMajorTag();

	/**
	 * 获得根常规索引
	 * @return
	 */
	public List<AreaMinorTag> getRootAreaMinorTag();
	/**
	 * 通过父id获得所有末端节点
	 * @param id
	 * @return
	 */
	public List<AreaMinorTag> getAreaMinorTagsByParentId(Integer id);
	/**
	 * 删除分区次索引
	 * 
	 * @param id
	 */
	public void deleteAreaMinorTagById(int id);
	/**
	 * 创建常规索引
	 * 
	 * @param areaMinorTag
	 */
	public void createAreaMinorTag(AreaMinorTag areaMinorTag);
	/**
	 * 修改常规索引
	 * 
	 * @param areaMinorTag
	 */
	public void updateAreaMinorTag(AreaMinorTag areaMinorTag);

    List<VarIOInfo> getAllTagIOInfo();
}
