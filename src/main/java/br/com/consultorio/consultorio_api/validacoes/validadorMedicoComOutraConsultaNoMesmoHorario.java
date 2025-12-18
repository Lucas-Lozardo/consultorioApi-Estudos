package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.interfaces.ValidadorAgendamentoDeConsulta;
import br.com.consultorio.consultorio_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repo;

    public void validar(DadosAgendamentoConsultaDTO dados){

        var medicoPossuiOutraConsultaNoMesmoHorario = repo.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada no mesmo horário");
        }
    }
}
