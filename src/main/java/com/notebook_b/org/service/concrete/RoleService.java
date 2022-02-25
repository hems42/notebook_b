package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumResponseMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;
import com.notebook_b.org.product.dto_convertor.principal_convertor.RoleDtoConvertor;
import com.notebook_b.org.product.dto.RoleDto;
import com.notebook_b.org.product.request.createRequest.LogRoleRequestCreate;
import com.notebook_b.org.product.request.createRequest.RoleRequestCreate;
import com.notebook_b.org.product.request.updateRequest.RoleRequestUpdate;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.service.abstracts.IRoleService;
import com.sun.corba.se.spi.transport.CorbaAcceptor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;


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
    public DataResult<RoleDto> addRole(RoleRequestCreate requestCreate, User user) {

        if (isNotExistRole(requestCreate.getRoleName())) {
            Role role = new Role(
                    null,
                    requestCreate.getRoleName(),
                    requestCreate.getRoleDescription(),
                    LocalDateTime.now(),
                    null);

            Role foundRole = roleDao.save(role);

            logRoleService.addLogRole(new LogRoleRequestCreate(
                    AppEnumCrud.CREATED,
                    foundRole
            ), user);

            return new SuccessDataResult(roleDtoConvertor.convert(foundRole),
                    CoreEnumResponseMessages.ROLE_SUCCESSFULLY_ADDED.toString()                 );
        } else {
            throw new AlReadyExistException(ROLE_ALREADY_EXIST,"role daha önce oluşturulmuş!!!");
        } }

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
