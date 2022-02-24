package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.entity.User;
import com.notebook_b.org.product.request.createRequest.LogRoleRequestCreate;

public interface ILogRoleService {

    void addLogRole(LogRoleRequestCreate requestCreate, User user);
}
