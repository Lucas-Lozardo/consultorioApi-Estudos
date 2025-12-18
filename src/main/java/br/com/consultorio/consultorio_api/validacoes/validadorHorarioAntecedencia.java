package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.interfaces.ValidadorAgendamentoDeConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class validadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsultaDTO dados){

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if ( diferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}
