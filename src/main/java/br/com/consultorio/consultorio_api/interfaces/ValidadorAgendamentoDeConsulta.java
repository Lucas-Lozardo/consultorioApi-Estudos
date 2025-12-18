package br.com.consultorio.consultorio_api.interfaces;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsultaDTO dados);
}
