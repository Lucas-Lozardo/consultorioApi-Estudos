package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;


    //POST  DTO -> ENTITY
    public void cadastrarNovoMedico(@RequestBody DadosCadastroMedicoDTO dadosDTO){
        repository.save(new Medico(dadosDTO));
    }

    //GET
    public Page<DadosListagemMedicoDTO> listarMedicoDTO(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedicoDTO::new);
    }

}
