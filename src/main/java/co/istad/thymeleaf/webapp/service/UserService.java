package co.istad.thymeleaf.webapp.service;

import co.istad.thymeleaf.webapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getSingleUser(Integer id);


}
