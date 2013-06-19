package com.ht.scada.common.tag.dao;

import com.ht.scada.common.tag.entity.EndTag;
import com.ht.scada.common.tag.entity.MajorTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EndTagDao extends JpaRepository<EndTag, Integer> {

    @Query("select t from EndTag t where t.majorTag.id=?1")
    public List<EndTag> findByMajorTagId(Integer majorTagId);

	public List<EndTag> findByMajorTag(MajorTag majorTag);
    public List<EndTag> findByChannelIdxNotNullAndDeviceAddrNotNull();
    public EndTag findByCode(String code);
}
