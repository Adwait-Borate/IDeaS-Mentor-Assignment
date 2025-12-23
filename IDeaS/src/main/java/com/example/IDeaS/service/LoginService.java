package com.example.IDeaS.service;

import com.example.IDeaS.dto.LoginDTO;
import com.example.IDeaS.entity.LoginEntity;
import com.example.IDeaS.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginEntity saveLogin(LoginDTO loginDTO) {

        LoginEntity entity = new LoginEntity();
        entity.setUsername(loginDTO.getUsername());
        entity.setPassword(loginDTO.getPassword());

        return loginRepository.save(entity);
    }

    public List<LoginDTO> getAllLogins() {

        List<LoginEntity> entities = loginRepository.findAll();
        List<LoginDTO> dtoList = new ArrayList<>();

        for (LoginEntity entity : entities) {
            LoginDTO dto = new LoginDTO();
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            dtoList.add(dto);
        }

        return dtoList;
    }
}
