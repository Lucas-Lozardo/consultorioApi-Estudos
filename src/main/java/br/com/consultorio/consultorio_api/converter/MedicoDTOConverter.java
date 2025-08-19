package br.com.consultorio.consultorio_api.converter;

import br.com.consultorio.consultorio_api.model.Medico;

public interface MedicoDTOConverter <T>{
    boolean podeConverter(Class<?> dtoClass);
    T converter(Medico medico);
}
