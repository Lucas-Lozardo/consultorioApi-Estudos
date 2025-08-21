package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Especialidade;
import br.com.consultorio.consultorio_api.model.Medico;

public record DadosListagemMedicoDTO(Long id,
                                     Boolean ativo,
                                     String nome,
                                     String crm,
                                     String email,
                                     Especialidade especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getAtivo(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }
}
