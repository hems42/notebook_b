package com.notebook_b.org.service.concrete;

import com.notebook_b.org.dto.convertor.LogUserDtoConvertor;
import com.notebook_b.org.dto.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.entity.User;
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
        LogUser logUser = new LogUser(null,requestCreate.getUserOperationType(),user, LocalDateTime.now());
        logUserDao.save(logUser);
    }
}
