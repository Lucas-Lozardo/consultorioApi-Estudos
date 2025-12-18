package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.interfaces.ValidadorAgendamentoDeConsulta;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repo;

    public void validar(DadosAgendamentoConsultaDTO dados){

        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repo.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta deve ser agendada com médico existente");
        }
    }
}
