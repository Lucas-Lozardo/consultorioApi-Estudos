package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.interfaces.ValidadorAgendamentoDeConsulta;
import br.com.consultorio.consultorio_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorPacienteSemOutraConsultaNoMesmoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repo;

    public void validar(DadosAgendamentoConsultaDTO dados){

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoMesmoDia = repo.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoMesmoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nessse dia!");
        }
    }
}
