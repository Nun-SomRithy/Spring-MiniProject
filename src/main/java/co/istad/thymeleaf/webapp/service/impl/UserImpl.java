package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.User;
import co.istad.thymeleaf.webapp.repository.UserRepository;
import co.istad.thymeleaf.webapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {

    private  final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {

        return  userRepository.getListUser();
    }

    @Override
    public User getSingleUser(Integer id) {
        return userRepository.getListUser().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
