package br.com.consultorio.consultorio_api.validacoes;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.repository.PacienteRepository;

public class validadorPacienteAtivo {

    private PacienteRepository repo;

    public void validar(DadosAgendamentoConsultaDTO dados){

        var pacienteEstaAtivo = repo.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído!");
        }
    }
}
