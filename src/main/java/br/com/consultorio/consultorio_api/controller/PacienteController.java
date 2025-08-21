package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.DadosCadastroPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemPacienteDTO;
import br.com.consultorio.consultorio_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPacienteDTO json){
        service.cadastrarPaciente(json);
    }

    @GetMapping
    public Page<DadosListagemPacienteDTO> listarPaciente(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return service.listarPacientesDTO(paginacao);
    }
}
