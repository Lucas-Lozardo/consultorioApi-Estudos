package br.com.consultorio.consultorio_api.model;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarMedicoDTO;
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

    public void atualizarDados(Endereco dto) {
        if (dto.cep != null){
            this.cep = dto.cep;
        }
        if (dto.logradouro != null){
            this.logradouro = dto.logradouro;
        }
        if (dto.numero != null){
            this.numero = dto.numero;
        }
        if (dto.complemento != null){
            this.complemento = dto.complemento;
        }
        if (dto.bairro != null){
            this.bairro = dto.bairro;
        }
        if (dto.cidade != null){
            this.cidade = dto.cidade;
        }
        if (dto.uf != null){
            this.uf = dto.uf;
        }
    }
}
