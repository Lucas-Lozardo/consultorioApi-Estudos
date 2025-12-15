package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosAgendamentoConsultaDTO;
import br.com.consultorio.consultorio_api.infra.exception.ValidacaoException;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.model.consulta.Consulta;
import br.com.consultorio.consultorio_api.repository.ConsultaRepository;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import br.com.consultorio.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepository repo;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsultaDTO dados){

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do médico não existe");
        }

        if (!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não existe");
        }

        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.data());


        repo.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsultaDTO dados) {
        if (dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null){
                throw new ValidacaoException("Especialidade obrigatória quando o médico não for escolhido");
                }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }
}
