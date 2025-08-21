package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService service;


    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO json){
        service.cadastrarNovoMedico(json);

    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listarMedicoDTO(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return service.listarMedicoDTO(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosAtualizarMedicoDTO json){
        service.AtualizarMedico(json);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public void apagarMedico(@PathVariable Long id){
        service.apagarMedico(id);
    }
}
