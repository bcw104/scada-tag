package com.ht.scada.common.tag.type.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ht.scada.common.tag.type.entity.CommunicationProtocalType;

public interface CommunicationProtocalTypeDao extends JpaRepository<CommunicationProtocalType, Integer> {

}
