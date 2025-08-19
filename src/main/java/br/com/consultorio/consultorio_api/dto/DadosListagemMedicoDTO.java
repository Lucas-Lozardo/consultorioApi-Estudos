package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Especialidade;

public record DadosListagemMedicoDTO(String nome,
                                     String crm,
                                     String email,
                                     Especialidade especialidade) {
}
