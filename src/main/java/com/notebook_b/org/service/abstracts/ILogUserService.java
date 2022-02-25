package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.product.request.createRequest.LogUserRequestCreate;
import com.notebook_b.org.entity.leadRole.User;

public interface ILogUserService {

    void addLogUser(LogUserRequestCreate requestCreate, User user);



}
