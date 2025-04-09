package com.littlechef.main.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VisibilidadeConverter implements AttributeConverter<Visibilidade, String> {

    @Override
    public String convertToDatabaseColumn(Visibilidade visibilidade) {
        if (visibilidade == null) {
            return null;
        }
        return visibilidade.name();
    }

    @Override
    public Visibilidade convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Visibilidade.valueOf(dbData);
    }
}