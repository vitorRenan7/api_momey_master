package com.moneymaster.api_money_master.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDto {

    @NotBlank
    @Size(max = 30)
    private String nome;

    @NotBlank
    @Size(max = 30)
    private String sobrenome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

}
