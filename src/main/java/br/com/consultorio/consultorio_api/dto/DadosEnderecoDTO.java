package br.com.consultorio.consultorio_api.dto;

public record DadosEnderecoDTO(String logradouro,
                               String bairro,
                               String cep,
                               String cidade,
                               String uf,
                               String complemento,
                               String numero) {
}
