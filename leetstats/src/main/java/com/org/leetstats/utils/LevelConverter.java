package com.org.leetstats.utils;

import com.org.leetstats.enums.Level;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;
@Converter(autoApply = true)
public class LevelConverter implements AttributeConverter<Level, Character> {
    @Override
    public Character convertToDatabaseColumn(Level attribute) {
        if (attribute == null) return null;
        return attribute.getType();
    }

    @Override
    public Level convertToEntityAttribute(Character dbData) {
        return Stream.of(Level.values())
                .filter((level) -> level.getType() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

