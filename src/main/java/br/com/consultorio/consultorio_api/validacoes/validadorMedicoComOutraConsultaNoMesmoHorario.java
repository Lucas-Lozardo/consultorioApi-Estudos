package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.repository.ConsultaRepository;

public class validadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repo;

    public void validar(DadosAgendamentoConsultaDTO dados){

        var medicoPossuiOutraConsultaNoMesmoHorario = repo.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada no mesmo horário");
        }
    }
}
