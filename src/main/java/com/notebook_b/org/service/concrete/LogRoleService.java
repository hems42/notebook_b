package com.notebook_b.org.service.concrete;

import com.notebook_b.org.entity.User;
import com.notebook_b.org.entity.log.LogRole;
import com.notebook_b.org.product.dto_convertor.log_convertor.LogRoleDtoConvertor;
import com.notebook_b.org.product.request.createRequest.LogRoleRequestCreate;
import com.notebook_b.org.repository.LogRoleDao;
import com.notebook_b.org.service.abstracts.ILogRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogRoleService implements ILogRoleService {

    private final LogRoleDao roleDao;
    private final LogRoleDtoConvertor roleDtoConvertor;

    public LogRoleService(LogRoleDao roleDao, LogRoleDtoConvertor roleDtoConvertor) {
        this.roleDao = roleDao;
        this.roleDtoConvertor = roleDtoConvertor;
    }

    @Override
    public void addLogRole(LogRoleRequestCreate requestCreate, User user) {

        roleDao.save(new LogRole(
                null,
                requestCreate.getCrud(),
                requestCreate.getRole(),
                user,
                LocalDateTime.now())); }
}
