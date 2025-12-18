package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.repository.ConsultaRepository;

public class validadorPacienteSemOutraConsultaNoMesmoDia {

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
