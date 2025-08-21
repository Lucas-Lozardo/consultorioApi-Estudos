package br.com.consultorio.consultorio_api.model;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    //CONSTRUTOR QUE CONVERTE DTO -> ENTITY
    public Medico (DadosCadastroMedicoDTO dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    //CONVERTE ENTITY -> DTO
    public DadosCadastroMedicoDTO toDTO() {
        return new DadosCadastroMedicoDTO(nome, email, crm, telefone, especialidade, endereco);
    }

    public void atualizarDados(DadosAtualizarMedicoDTO dto) {
        if (dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.telefone() != null){
            this.telefone = dto.telefone();
        }
        if (dto.endereco() != null){
            this.endereco.atualizarDados(dto.endereco());
        }
    }

    public void inativo() {
        this.ativo = false;
    }
}
