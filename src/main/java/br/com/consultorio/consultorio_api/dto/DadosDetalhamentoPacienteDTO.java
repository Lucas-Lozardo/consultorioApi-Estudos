package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Endereco;
import br.com.consultorio.consultorio_api.model.Paciente;

public record DadosDetalhamentoPacienteDTO(Long id,
                                           String nome,
                                           String email,
                                           String telefone,
                                           String cpf,
                                           Endereco endereco) {

    public DadosDetalhamentoPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
