package ru.aryukov.revolut.web;

import com.google.inject.Inject;
import ru.aryukov.revolut.dto.post.Validable;
import spark.utils.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

public abstract class AbstractController {

    public AbstractController() {
    }

    @Inject
    private Validator validator;

    public void validateIncome(Validable data) throws ValidationException {
        Set<ConstraintViolation<Validable>> violations = validator.validate(data);
        for (ConstraintViolation<Validable> violation : violations) {
            if (!StringUtils.isEmpty(violation.getMessage())) {
                throw new ValidationException(violation.getMessage());
            }
        }
    }
}
