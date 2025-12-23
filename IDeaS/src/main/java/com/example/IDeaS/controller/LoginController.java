package com.example.IDeaS.controller;

import com.example.IDeaS.dto.LoginDTO;
import com.example.IDeaS.entity.LoginEntity;
import com.example.IDeaS.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/hello")
    public String demo() {
        return "IDeaS api running";
    }

    @GetMapping("/get-data")
    public List<LoginDTO> getAllLogins() {
        return loginService.getAllLogins();
    }

    @PostMapping("/post-data")
    public LoginDTO saveLogin(@RequestBody LoginDTO loginDTO) {

        LoginEntity savedEntity = loginService.saveLogin(loginDTO);

        LoginDTO responseDTO = new LoginDTO();
        responseDTO.setId(savedEntity.getId());
        responseDTO.setUsername(savedEntity.getUsername());
        responseDTO.setPassword(savedEntity.getPassword());

        return responseDTO;
    }
}
