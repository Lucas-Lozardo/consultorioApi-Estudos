package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosCadastroPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemPacienteDTO;
import br.com.consultorio.consultorio_api.model.Paciente;
import br.com.consultorio.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public void cadastrarPaciente (@RequestBody DadosCadastroPacienteDTO dto){
        repository.save(new Paciente(dto));
    }

    public Page<DadosListagemPacienteDTO> listarPacientesDTO(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPacienteDTO::new);
    }
}
