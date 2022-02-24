package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.entity.Role;
import com.notebook_b.org.product.dto_convertor.entity_convertor.RoleDtoConvertor;
import com.notebook_b.org.product.dto.RoleDto;
import com.notebook_b.org.product.request.createRequest.RoleRequestCreate;
import com.notebook_b.org.product.request.updateRequest.RoleRequestUpdate;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.service.abstracts.IRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final RoleDao roleDao;
    private final RoleDtoConvertor roleDtoConvertor;
    private final LogRoleService logRoleService;

    public RoleService(RoleDao roleDao,
                       RoleDtoConvertor roleDtoConvertor,
                       LogRoleService logRoleService) {
        this.roleDao = roleDao;
        this.roleDtoConvertor = roleDtoConvertor;
        this.logRoleService = logRoleService;
    }


    @Override
    public DataResult<RoleDto> addRole(RoleRequestCreate requestCreate) {
        Role role = new Role(
                null,
                requestCreate.getRoleName(),
                requestCreate.getRoleDescription(),
                LocalDateTime.now(),
                null);

        Role foundRole = roleDao.save(role);
        return null;
    }

    @Override
    public List<DataResult<RoleDto>> getAllRole() {
        return null;
    }

    @Override
    public DataResult<RoleDto> updateRole(RoleRequestUpdate requestUpdate) {
        return null;
    }

    private boolean isNotExistRole(String roleName) {
        return roleDao.getRoleByRoleName(roleName) == null;
    }
}
