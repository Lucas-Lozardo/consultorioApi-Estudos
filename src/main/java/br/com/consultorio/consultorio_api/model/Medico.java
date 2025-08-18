package br.com.consultorio.consultorio_api.model;

import br.com.consultorio.consultorio_api.dto.DadosMedicoDTO;
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
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    //CONSTRUTOR QUE CONVERTE DTO -> ENTITY
    public Medico (DadosMedicoDTO dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    //CONVERTE ENTITY -> DTO
    public DadosMedicoDTO toDTO() {
        return new DadosMedicoDTO(nome, email, crm, especialidade, endereco);
    }
}
