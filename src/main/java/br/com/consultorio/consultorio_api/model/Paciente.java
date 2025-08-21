package br.com.consultorio.consultorio_api.model;

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
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPacienteDTO dto) {
        this.nome = dto.nome();;
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.endereco = new Endereco(dto.endereco());

    }
}
