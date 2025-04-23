package mk.finki.ukim.mk.emtproject.dto;


import mk.finki.ukim.mk.emtproject.model.domain.User;
import mk.finki.ukim.mk.emtproject.model.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        String surname,
        Role role
) {

    /*
        todo: add repeat password logic
     */
    public User toUser() {
        return new User(username, password, name, surname, role);
    }
}

