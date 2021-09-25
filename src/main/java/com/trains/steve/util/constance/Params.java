package com.trains.steve.util.constance;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Params {
    public static class QueryParam {
        public static final String SORT = "sort";
        public static final String PAGE = "page";
        public static final String SIZE = "size";
    }

    public static class SortParams {
        public static final String ID = "id";
        public static final String DESCENDING = "desc";
        public static final String MAX_SPEED = "max-speed";
        public static final String ASCENDING = "asc";

        public static enum SortingBy {
            ID("id"), DESC("desc"), ASC("asc"), MAX_SPEED("max-speed");

            private SortingBy(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            private final String name;
            }
    }
}
