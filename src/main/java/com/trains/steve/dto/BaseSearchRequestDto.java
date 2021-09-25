package com.trains.steve.dto;

import lombok.Data;
import org.springframework.data.domain.Sort.Direction;

import javax.validation.constraints.NotNull;

@Data
public class BaseSearchRequestDto {
    @NotNull
    private Integer pageIndex = 0;
    private String sortingField = "id";
    private Direction sortingDirection = Direction.ASC;
    @NotNull
    private Integer itemPerPage = 10;
}
