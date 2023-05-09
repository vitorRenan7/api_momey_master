package com.moneymaster.api_money_master.controller;

import com.moneymaster.api_money_master.dto.UsuarioDto;
import com.moneymaster.api_money_master.model.UsuarioModel;
import com.moneymaster.api_money_master.repository.UsuarioRepository;
import com.moneymaster.api_money_master.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> saveUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        if(usuarioService.existsByEmail(usuarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Esse e-mail já foi registrado!");
        }

        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
    }
}
