package com.notebook_b.org.service.abstracts;

import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.request.authenticate.RegistrationRequest;

public interface IRegistrationService {

    String register(RegistrationRequest request, User user);

    Boolean confirmToken(String confirmationToken);

    String buildEmail(String name, String link);
}
