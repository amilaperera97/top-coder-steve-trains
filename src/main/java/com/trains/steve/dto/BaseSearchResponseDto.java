package com.trains.steve.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseSearchResponseDto {
    @Builder.Default
    private long totalItems = 1;
    @Builder.Default
    private long totalPages = 1;
    @Builder.Default
    private int currentPage = 0;
    private List<?> items;
    private Object item;

    /**
     * @param page non null value required.
     * @return {@link BaseSearchResponseDto}
     * <p> Using {@link Page} to calculate totalItems, totalPages, currentPage <p/>
     */
    public BaseSearchResponseDto calculatePageable(@NotNull Page<?> page) {
        this.totalItems = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
        return this;
    }
}