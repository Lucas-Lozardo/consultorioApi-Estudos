package br.com.consultorio.consultorio_api.repository;

import br.com.consultorio.consultorio_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
