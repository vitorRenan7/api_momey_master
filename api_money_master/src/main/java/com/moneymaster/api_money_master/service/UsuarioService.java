package com.moneymaster.api_money_master.service;

import com.moneymaster.api_money_master.model.UsuarioModel;
import com.moneymaster.api_money_master.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
