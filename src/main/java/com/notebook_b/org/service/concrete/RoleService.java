package com.notebook_b.org.service.concrete;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumResponseMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnSuccessfulException;
import com.notebook_b.org.core.utilities.results.DataResult;
import com.notebook_b.org.core.utilities.results.SuccessDataResult;
import com.notebook_b.org.entity.security.Role;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumRoleTypes;
import com.notebook_b.org.product.appEnums.AppEnumOperationTypes;
import com.notebook_b.org.product.dto_convertor.principal_convertor.RoleDtoConvertor;
import com.notebook_b.org.product.dto.RoleDto;
import com.notebook_b.org.product.request.createRequest.LogRoleRequestCreate;
import com.notebook_b.org.product.request.createRequest.RoleRequestCreate;
import com.notebook_b.org.product.request.updateRequest.RoleRequestUpdate;
import com.notebook_b.org.repository.RoleDao;
import com.notebook_b.org.service.abstracts.IRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

        if (util_isNotExistRole(requestCreate.getRoleName())) {
            Role role = new Role(
                    null,
                    requestCreate.getRoleName(),
                    requestCreate.getRoleDescription(),
                    LocalDateTime.now(),
                    null);

            Role foundRole = roleDao.save(role);

            logRoleService.addLogRole(new LogRoleRequestCreate(
                    AppEnumOperationTypes.CREATED,
                    foundRole
            ), user);

            return new SuccessDataResult(roleDtoConvertor.convert(foundRole),
                    CoreEnumResponseMessages.ROLE_SUCCESSFULLY_ADDED.toString());
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_ROLE_CREATED, "cant created role");
        }
    }

    @Override
    public DataResult<RoleDto> addRole(RoleRequestCreate requestCreate) {

        if (util_isNotExistRole(requestCreate.getRoleName())) {
            Role role = new Role(
                    null,
                    requestCreate.getRoleName(),
                    requestCreate.getRoleDescription(),
                    LocalDateTime.now(),
                    null);

            Role foundRole = roleDao.save(role);

            logRoleService.addLogRole(new LogRoleRequestCreate(
                    AppEnumOperationTypes.CREATED,
                    foundRole
            ), null);

            return new SuccessDataResult(roleDtoConvertor.convert(foundRole),
                    CoreEnumResponseMessages.ROLE_SUCCESSFULLY_ADDED.toString());
        } else {
            throw new UnSuccessfulException(UN_SUCCESSFUL_ROLE_CREATED, "cant created role");
        }
    }


    @Override
    public DataResult<Role> getRoleByRoleName(AppEnumRoleTypes role) {
        return new SuccessDataResult<>(util_getRoleByRole(role.getRoleName()));
    }

    @Override
    public DataResult<List<RoleDto>> getAllRole() {
        return new SuccessDataResult<List<RoleDto>>(util_getAllRole()
                .stream().map(role -> roleDtoConvertor.convert(role))
                .collect(Collectors.toList()));
    }

    @Override
    public DataResult<RoleDto> updateRole(RoleRequestUpdate requestUpdate) {
        return null;
    }


    //UTIL

    private Role util_getRoleByRole(Integer roleId) {
        Role roleFound = roleDao.getById(roleId);

        if (roleFound != null) {
            return roleFound;
        } else {
            throw new NotFoundException(NOT_FOUND_ROLE, "not found role by ıd");
        }
    }

    private Role util_getRoleByRole(String roleName) {

        Role roleFound = roleDao.getRoleByRoleName(roleName);

        if (roleFound != null) {
            return roleFound;
        } else {
            throw new NotFoundException(NOT_FOUND_ROLE, "not found role by name");
        }
    }

    private List<Role> util_getAllRole() {

        List<Role> allRoles = roleDao.findAll();

        if(allRoles!=null && allRoles.size()>0)
        {
            return allRoles;
        }
        else
        {
            throw new NotFoundException(NOT_FOUND_ROLE,"not found role by get find all role");
        }
    }

    private boolean util_isNotExistRole(Integer roleId) {

        if (roleDao.getById(roleId) == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_ROLE, "already exist role by id");
        }
    }

    private boolean util_isNotExistRole(String roleName) {

        if (roleDao.getRoleByRoleName(roleName) == null) {
            return true;
        } else {
            throw new AlReadyExistException(ALREADY_EXIST_ROLE, "already exist role by role name");
        }
    }
}
