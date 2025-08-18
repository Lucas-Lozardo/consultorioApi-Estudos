package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;
import br.com.consultorio.consultorio_api.model.Especialidade;

public record DadosMedicoDTO(String nome,
                             String email,
                             String crm,
                             Especialidade especialidade,
                             Endereco endereco) {
}
