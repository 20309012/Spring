package labarary.labarairy.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import labarary.labarairy.domin.UserRole;

public class UserDto {

    private String username;
    private String pasword;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
