package http.dto;

import lombok.*;

import java.util.Objects;

//Генерирует геттеры,сеттеры,иквалс,хэшкод и т.д
@Value
@Builder
public class FlightDto {
    Long id;
    String description;

}
