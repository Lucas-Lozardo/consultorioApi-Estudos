package br.com.consultorio.consultorio_api.converter;

import br.com.consultorio.consultorio_api.dto.DadosListagemMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;

public class DadosListagemMedicoConverter implements MedicoDTOConverter<DadosListagemMedicoDTO>{
    @Override
    public boolean podeConverter(Class<?> dtoClass) {
        return DadosListagemMedicoDTO.class.equals(dtoClass);
    }

    @Override
    public DadosListagemMedicoDTO converter(Medico medico) {
        return new DadosListagemMedicoDTO(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade()
        );
    }
}
