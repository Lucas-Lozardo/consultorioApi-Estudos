package br.com.consultorio.consultorio_api.repository;

import br.com.consultorio.consultorio_api.model.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
