package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.Role_Permission;

@Repository
public interface Role_PermissionRepository extends JpaRepository<Role_Permission, Long> {

}
