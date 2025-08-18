package br.com.consultorio.consultorio_api.dto;

public record DadosMedicoDTO(String nome,
                             String email,
                             String crm,
                             DadosEspecialidadeDTO especialidade,
                             DadosEnderecoDTO endereco) {
}
