package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    @Autowired
    private MedicoDTOService medicoDTOService;


    //POST  DTO -> ENTITY
    public void cadastrarNovoMedico(@RequestBody DadosCadastroMedicoDTO dadosDTO){
        repository.save(new Medico(dadosDTO));
    }

    //GET
    public List<DadosListagemMedicoDTO> listarMedicoDTO(){
        List<Medico> medicos = repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        return medicoDTOService.converterLista(medicos, DadosListagemMedicoDTO.class);
    }
}
