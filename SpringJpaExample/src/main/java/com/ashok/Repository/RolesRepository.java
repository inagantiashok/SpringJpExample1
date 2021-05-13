package com.ashok.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.entity.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
}
