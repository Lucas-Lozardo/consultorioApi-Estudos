package br.com.consultorio.consultorio_api.service;

import br.com.consultorio.consultorio_api.converter.DadosCadastroMedicoConverter;
import br.com.consultorio.consultorio_api.converter.DadosListagemMedicoConverter;
import br.com.consultorio.consultorio_api.converter.MedicoDTOConverter;
import br.com.consultorio.consultorio_api.model.Medico;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoDTOService {

    private final List<MedicoDTOConverter<?>> conversores;


    public MedicoDTOService() {
        this.conversores = Arrays.asList(
                new DadosCadastroMedicoConverter(),
                new DadosListagemMedicoConverter()
        );
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> converterLista(List<Medico> medicos, Class<T> dtoClass){
        //ENCONTRA O CONVERSOR APROPRIADO PADRÃO CHAIN OF RESPONSIBILITY DO SOLID
        MedicoDTOConverter<T> conversor = (MedicoDTOConverter<T>) conversores.stream()
                .filter(c -> c.podeConverter(dtoClass))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nenhum conversor encontrado para " + dtoClass));

        return medicos.stream()
                .map(conversor::converter)
                .collect(Collectors.toList());
    }
}
