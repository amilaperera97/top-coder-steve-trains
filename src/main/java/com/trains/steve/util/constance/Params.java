package com.trains.steve.util.constance;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Params {
    public static final List<String> VALID_PARAMS = Arrays.asList("id", "max-speed", "asc", "desc");

    public static class QueryParam {
        public static final String SORT = "sort";
        public static final String PAGE = "page";
        public static final String SIZE = "size";
    }
}
