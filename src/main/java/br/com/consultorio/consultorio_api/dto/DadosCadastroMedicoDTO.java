package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;
import br.com.consultorio.consultorio_api.model.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicoDTO(

        @NotBlank //SOMENTE PARA STRING E É TAMBÉM NOTNULL
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")   //d DE DIGITO, DE 4 A 6 DIGITOS
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid                          //PARA VALIDAR O CONTEÚDO DO OBJETO (TUDO)
        Endereco endereco) {
}
