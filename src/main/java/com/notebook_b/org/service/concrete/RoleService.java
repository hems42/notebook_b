package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.convertor.RoleDtoConvertor;
import com.notebook_b.org.dto.entity.RoleDto;
import com.notebook_b.org.dto.request.createRequest.RoleRequestCreate;
import com.notebook_b.org.dto.request.updateRequest.RoleRequestUpdate;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.service.abstracts.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final RoleDao roleDao;
    private final RoleDtoConvertor roleDtoConvertor;

    public RoleService(RoleDao roleDao, RoleDtoConvertor roleDtoConvertor) {
        this.roleDao = roleDao;
        this.roleDtoConvertor = roleDtoConvertor;
    }


    @Override
    public DataResult<RoleDto> addRole(RoleRequestCreate requestCreate) {
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
}
