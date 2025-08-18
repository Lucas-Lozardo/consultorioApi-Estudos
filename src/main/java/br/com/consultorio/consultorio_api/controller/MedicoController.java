package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.DadosMedicoDTO;
import br.com.consultorio.consultorio_api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoService service;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody DadosMedicoDTO json){
        service.cadastrarNovoMedico(json);

    }
}
