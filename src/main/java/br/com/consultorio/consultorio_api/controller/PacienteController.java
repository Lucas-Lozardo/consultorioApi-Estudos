package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.*;
import br.com.consultorio.consultorio_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    public ResponseEntity cadastrarPaciente(@RequestBody DadosCadastroPacienteDTO json, UriComponentsBuilder uriBuilder){
        var paciente = service.cadastrarPaciente(json);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPacienteDTO>> listarPaciente(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        var paciente = service.listarPacientesDTO(paginacao);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping
    public ResponseEntity atualizarPaciente(@RequestBody DadosAtualizarPacienteDTO dto){
        var paciente = service.atualizarPaciente(dto);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity inativarPaciente(@PathVariable Long id){
        service.inativarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity localizarPacientePorId(@PathVariable Long id){
        var paciente = service.localizarPacientePorId(id);
        return ResponseEntity.ok(new DadosDetalhamentoPacienteDTO(paciente));
    }
}
