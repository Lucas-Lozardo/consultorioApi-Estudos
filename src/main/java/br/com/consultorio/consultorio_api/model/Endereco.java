package br.com.consultorio.consultorio_api.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    @NotBlank
    private String logradouro;
    private String numero;
    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;


    public Endereco(Endereco endereco) {
        this.cep = endereco.cep;
        this.logradouro = endereco.logradouro;
        this.numero = endereco.numero;
        this.complemento = endereco.complemento;
        this.bairro = endereco.bairro;
        this.cidade = endereco.cidade;
        this.uf = endereco.uf;
    }
}
