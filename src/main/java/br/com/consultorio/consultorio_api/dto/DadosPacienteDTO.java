package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;

public record DadosPacienteDTO(String nome,
                               String email,
                               String telefone,
                               Endereco endereco) {
}
