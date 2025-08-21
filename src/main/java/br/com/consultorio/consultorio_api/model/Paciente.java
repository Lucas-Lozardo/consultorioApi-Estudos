package br.com.consultorio.consultorio_api.model;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroPacienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPacienteDTO dto) {
        this.nome = dto.nome();
        this.ativo = true;
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.endereco = new Endereco(dto.endereco());

    }

    public void atualizarDados(DadosAtualizarPacienteDTO dto){
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

    public void inativo(){
        this.ativo = false;
    }
}
