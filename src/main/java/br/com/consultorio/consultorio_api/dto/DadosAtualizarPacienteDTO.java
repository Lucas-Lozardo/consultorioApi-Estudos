package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPacienteDTO(

        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
