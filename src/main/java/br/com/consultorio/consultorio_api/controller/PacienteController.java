package br.com.consultorio.consultorio_api.controller;

import br.com.consultorio.consultorio_api.dto.DadosCadastroPacienteDTO;
import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void cadastrarPaciente(@RequestBody DadosCadastroPacienteDTO json){
        System.out.println(json);
    }


}
