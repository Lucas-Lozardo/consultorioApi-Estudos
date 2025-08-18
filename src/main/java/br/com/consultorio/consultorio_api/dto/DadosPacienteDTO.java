package br.com.consultorio.consultorio_api.dto;

public record DadosPacienteDTO(String nome,
                               String email,
                               String telefone,
                               DadosEnderecoDTO endereco) {
}
