package com.readlearncode.questions;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Questions {

    public static void main(String... args) {

    /* Q1. The Bean Validation 2.0 API introduces new constraint. Which of the following are among those new constraints?

    1. @NotBlank String id;
    2. @EAN String barcode;
    3. @Email String email;
    4. @DurationMax int length;
    5. @NegativeOrZero int daysToRelease;
    6. @PastOrPresent Year released;
    7. @CreditCardNumber String ccNumber;

    Answer: 1, 3, 5, 6
    */

    /* Q2. Which of the following Email constraints are valid?
    @Email()
    @Email(regexp = ".*com # Allow only .com emails", flags = Pattern.Flag.COMMENTS)
    @Email(regexp = ".*com # Allow only .com emails")
    @Email(flags = Pattern.Flag.CASE_INSENSITIVE)
    @Email(domains = {".com",".co.uk",".net"})

    Answer: 1, 2, 4

    */

    /* Q4. Which of the following Strings will cause a validation failure for the `@NotBlank` constraint?
        1. "    "
        2. "Hello World"
        3. null
        4. ""
        5. " "
*/
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        // "    "
        Set<ConstraintViolation<Person>> constraintViolations = validator.validateValue(Person.class, "firstName", "    ");
        System.out.println(constraintViolations.size());

        // "Hello World"
        constraintViolations = validator.validateValue(Person.class, "firstName", "Hello World");
        System.out.println(constraintViolations.size());

        // null
        constraintViolations = validator.validateValue(Person.class, "firstName", null);
        System.out.println(constraintViolations.size());

        // ""
        constraintViolations = validator.validateValue(Person.class, "firstName", "");
        System.out.println(constraintViolations.size());

        // " "
        constraintViolations = validator.validateValue(Person.class, "firstName", " ");
        System.out.println(constraintViolations.size());


    }
}