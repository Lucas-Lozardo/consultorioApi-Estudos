package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;


    //POST  DTO -> ENTITY
    public void cadastrarNovoMedico(DadosCadastroMedicoDTO dadosDTO){
        repository.save(new Medico(dadosDTO));
    }

    //GET
    public Page<DadosListagemMedicoDTO> listarMedicoDTO(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoDTO::new);
    }

    //PUT
    public void AtualizarMedico(DadosAtualizarMedicoDTO dto){
        var medico = repository.getReferenceById(dto.id());
        medico.atualizarDados(dto);
    }

    //DELETE
    public void inativarMedico(Long id){
        var medico = repository.getReferenceById(id);
        medico.inativo();
        //repository.deleteById(id);  FUNÇÃO PARA APAGAR DEFINITIVAMENTE DO BD.
    }

}
