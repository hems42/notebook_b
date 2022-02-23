package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.dto.entity.RoleDto;
import com.notebook_b.org.dto.entity.UserDto;
import com.notebook_b.org.dto.request.createRequest.RoleRequestCreate;
import com.notebook_b.org.dto.request.createRequest.UserRequestCreate;
import com.notebook_b.org.dto.request.updateRequest.RoleRequestUpdate;

import java.util.List;

public interface IRoleService {

    DataResult<RoleDto> addRole(RoleRequestCreate requestCreate);

    List<DataResult<RoleDto>> getAllRole();

    DataResult<RoleDto> updateRole(RoleRequestUpdate requestUpdate);
}
