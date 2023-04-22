package co.istad.thymeleaf.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String username;
    private String gender;
    private String email;
    private String address;
    private String cover;


}
