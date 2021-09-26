package com.trains.steve.rest;

import com.trains.steve.dto.BaseSearchResponseDto;
import com.trains.steve.util.annotated.ValuesAllowed;
import com.trains.steve.util.constance.Params;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.trains.steve.util.constance.ControllerConstance.TRAINS;
import static com.trains.steve.util.constance.Params.QueryParam.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@Validated
@RequiredArgsConstructor
public class TrainInfoController {

    @GetMapping(value = TRAINS)
    public ResponseEntity<BaseSearchResponseDto> fetchTrainData(@RequestParam(defaultValue = "id,desc")
                                                                @ValuesAllowed(propName = "sort", values = {"id","desc","asc","max-speed"}) String[] sort,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "3") int size) {
        try {

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
