package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;
import br.com.consultorio.consultorio_api.model.Especialidade;
import br.com.consultorio.consultorio_api.model.Medico;

public record DadosDetalhamentoMedicoDTO(Long id,
                                         String nome,
                                         String email,
                                         String telefone,
                                         String crm,
                                         Especialidade especialidade,
                                         Endereco endereco) {

    public DadosDetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());

    }
}
