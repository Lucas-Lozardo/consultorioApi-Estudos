package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.dto.DadosMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;
import br.com.consultorio.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;

    List<DadosMedicoDTO> converteDadosDTOList (List<Medico> medicos){
        return medicos.stream()
                .map(m -> new DadosMedicoDTO(m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade(), m.getEndereco()))
                .collect(Collectors.toList());
    }


    //POST  DTO -> ENTITY
    public void cadastrarNovoMedico(@RequestBody DadosMedicoDTO dadosDTO){
        repository.save(new Medico(dadosDTO));
    }
}
