package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> listUser;
    @PostConstruct
    void init(){
        listUser = new ArrayList<>(){{
            add(new User(1,"Rii",
                    "Rii Roy",
                    "Male",
                    "Rii@Gmail.com"
                    ,"Phnom Penh"
                    ,"https://images.pexels.com/photos/1323206/pexels-photo-1323206.jpeg?cs=srgb&dl=pexels-mixu-1323206.jpg&fm=jpg"));
            add(new User(2,"Doo Dii",
                    "Nun Doo Dii",
                    "Male",
                    "DooDii@Gmail.com"
                    ,"Phnom Penh"
                    ,"https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"));
            add(new User(3,"KooKii",
                    "Nun KooKii",
                    "Male",
                    "KooKii@Gmail.com"
                    ,"Phnom Penh"
                    ,"https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80    "));
            add(new User(4,"FiiFoo",
                    "Nun FiiFoo",
                    "Male",
                    "FiiFoo@Gmail.com"
                    ,"Phnom Penh"
                    ,"https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8&w=1000&q=80"));

        }};
    }

    public User getSingleUser(Integer id){
        return listUser.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

   public List<User> getListUser(){

        return listUser;
    }



}
