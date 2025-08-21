package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemPacienteDTO;
import br.com.consultorio.consultorio_api.model.Paciente;
import br.com.consultorio.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Transactional
    public Paciente cadastrarPaciente (DadosCadastroPacienteDTO dto){
        return repository.save(new Paciente(dto));
    }

    public Page<DadosListagemPacienteDTO> listarPacientesDTO(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacienteDTO::new);
    }

    @Transactional
    public Paciente atualizarPaciente(DadosAtualizarPacienteDTO dto){
        var paciente = repository.getReferenceById(dto.id());
         paciente.atualizarDados(dto);
         return paciente;
    }

    @Transactional
    public void inativarPaciente(Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativo();
    }

    public Paciente localizarPacientePorId(Long id){
        return repository.getReferenceById(id);
    }
}
