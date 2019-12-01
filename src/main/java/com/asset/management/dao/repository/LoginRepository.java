package com.asset.management.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.management.dao.entity.AssetEntity;
import com.asset.management.dao.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByUsername(String username);

}
