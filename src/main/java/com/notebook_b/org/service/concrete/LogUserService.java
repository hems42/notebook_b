package com.notebook_b.org.service.concrete;

import com.notebook_b.org.product.dto_convertor.log_convertor.LogUserDtoConvertor;
import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.entity.log.LogUser;
import com.notebook_b.org.repository.LogUserDao;
import com.notebook_b.org.service.abstracts.ILogUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogUserService implements ILogUserService {

    private final LogUserDtoConvertor logUserDtoConvertor;
    private final LogUserDao logUserDao;


    public LogUserService(LogUserDtoConvertor logUserDtoConvertor, LogUserDao logUserDao) {
        this.logUserDtoConvertor = logUserDtoConvertor;
        this.logUserDao = logUserDao;
    }

    @Override
    public void addLogUser(LogUserRequestCreate requestCreate, User user) {
        logUserDao.save(new LogUser(
                null,
                requestCreate.getUserOperationType(),
                user, LocalDateTime.now())); } }
