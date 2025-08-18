package br.com.consultorio.consultorio_api.repository;

import br.com.consultorio.consultorio_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
