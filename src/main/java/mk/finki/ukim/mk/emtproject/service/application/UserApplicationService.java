package mk.finki.ukim.mk.emtproject.service.application;

import mk.finki.ukim.mk.emtproject.dto.CreateUserDto;
import mk.finki.ukim.mk.emtproject.dto.DisplayUserDto;
import mk.finki.ukim.mk.emtproject.dto.LoginResponseDto;
import mk.finki.ukim.mk.emtproject.dto.LoginUserDto;

import java.util.Optional;

public interface UserApplicationService {

    Optional<DisplayUserDto> register(CreateUserDto createUserDto);

    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);

    Optional<DisplayUserDto> findByUsername(String username);
}

