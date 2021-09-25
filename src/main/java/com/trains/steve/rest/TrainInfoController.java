package com.trains.steve.rest;

import com.trains.steve.dto.BaseSearchResponseDto;
import com.trains.steve.util.constance.Params;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

import static com.trains.steve.util.constance.ControllerConstance.BASE_PATH;
import static com.trains.steve.util.constance.Params.QueryParam.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController(value = BASE_PATH)
@Validated
@RequiredArgsConstructor
public class TrainInfoController {

    @GetMapping()
    public ResponseEntity<BaseSearchResponseDto> fetchTrainData(@RequestParam(SORT) List<Params.SortParams.SortingBy> sort,
                                                                @RequestParam(PAGE) int page, @RequestParam(SIZE) int size) {

        return null;
    }
}
