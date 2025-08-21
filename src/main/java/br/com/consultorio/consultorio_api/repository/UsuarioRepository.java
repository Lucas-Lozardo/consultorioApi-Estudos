package br.com.consultorio.consultorio_api.repository;

import br.com.consultorio.consultorio_api.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;

@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String login);
}
