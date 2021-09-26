package com.trains.steve.util.annotated;

import com.trains.steve.exception.custom.InvalidParameterException;
import lombok.SneakyThrows;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValuesAllowed.Validator.class})
public @interface ValuesAllowed {

    String message() default "Invalid Parameter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String propName();

    String[] values();

    class Validator implements ConstraintValidator<ValuesAllowed, String[]> {
        private String propName;
        private String message;
        private List<String> allowable;

        @Override
        public void initialize(ValuesAllowed requiredIfChecked) {
            this.propName = requiredIfChecked.propName();
            this.message = requiredIfChecked.message();
            this.allowable = Arrays.asList(requiredIfChecked.values());
        }

        @SneakyThrows
        @Override
        public boolean isValid(String[] value, ConstraintValidatorContext context) {
            Boolean valid = value == null || this.allowable.containsAll(Arrays.asList(value));

            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message)
                        .addConstraintViolation();
                throw new InvalidParameterException(message);
            }
            return true;
        }
    }
}