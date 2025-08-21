package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.DadosAtualizarMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosDetalhamentoMedicoDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService service;


    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO json, UriComponentsBuilder uriBuilder){
        var medico = service.cadastrarNovoMedico(json);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDTO(medico));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listarMedicoDTO(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        var medico = service.listarMedicoDTO(paginacao);
        return ResponseEntity.ok(medico);

    }

    @PutMapping
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosAtualizarMedicoDTO json){
        var medico = service.atualizarMedico(json);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity inativarMedico(@PathVariable Long id){
        service.inativarMedico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity localizarMedicoPorId(@PathVariable Long id){
        var medico = service.localizarMedicoPorId(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }
}
