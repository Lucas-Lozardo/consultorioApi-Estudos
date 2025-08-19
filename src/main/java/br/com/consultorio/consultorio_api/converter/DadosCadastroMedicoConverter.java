package br.com.consultorio.consultorio_api.converter;

import br.com.consultorio.consultorio_api.dto.DadosCadastroMedicoDTO;
import br.com.consultorio.consultorio_api.model.Medico;

public class DadosCadastroMedicoConverter implements MedicoDTOConverter<DadosCadastroMedicoDTO>{
    @Override
    public boolean podeConverter(Class<?> dtoClass) {
        return DadosCadastroMedicoDTO.class.equals(dtoClass);
    }

    @Override
    public DadosCadastroMedicoDTO converter(Medico medico) {
        return new DadosCadastroMedicoDTO(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
