package com.naren.batch.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naren.batch.dao.entity.Voltage;

@Repository
public interface IVoltageRepository extends JpaRepository<Voltage, Long> {

}
