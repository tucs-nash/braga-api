package br.com.bragarepresentacoes.api.web.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class LocalDateConverter implements Converter<String, LocalDate> {
    
    private final DateTimeFormatter formatter;
    
    public LocalDateConverter(String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }
 
    @Override
    public LocalDate convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
 
        return LocalDate.parse(source, formatter);
    }
}
