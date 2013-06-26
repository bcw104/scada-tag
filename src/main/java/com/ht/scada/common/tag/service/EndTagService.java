package com.ht.scada.common.tag.service;

import com.ht.scada.common.tag.entity.EndTag;

import java.util.List;

public interface EndTagService extends BaseService<EndTag>{
	
	/**
	 * 通过id获得所有末端节点
	 * 
	 * @param id
	 * @return
	 */
	public List<EndTag> getEndTagByParentId(int id);

    /**
     * 查询指定MajorTag下的所有末端对象
     * @param id
     * @return
     */
    List<EndTag> getEndTagByMajorTagId(int id);

    List<EndTag> getEndTag4Comm();

    EndTag getByCode(String code);
    /**
     * 批量保存
     * @param endTagList
     */
    void saveAll(List<EndTag> endTagList);
    /**
     * 通过类型获得所有EndTag
     * @param type
     * @return 
     */
    List<EndTag> getByType(String type);
    /**
     * 获取所有EndTag
     * @return
     */
    List<EndTag> getAllEndTag();
}
