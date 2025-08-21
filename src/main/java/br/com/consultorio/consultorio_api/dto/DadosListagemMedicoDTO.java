package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Especialidade;
import br.com.consultorio.consultorio_api.model.Medico;

public record DadosListagemMedicoDTO(String nome,
                                     String crm,
                                     String email,
                                     Especialidade especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }
}
