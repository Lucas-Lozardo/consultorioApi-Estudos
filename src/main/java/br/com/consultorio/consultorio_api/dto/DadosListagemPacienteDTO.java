package br.com.consultorio.consultorio_api.dto;

import br.com.consultorio.consultorio_api.model.Paciente;

public record DadosListagemPacienteDTO(String nome,
                                       String email,
                                       String cpf) {

    public DadosListagemPacienteDTO(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
