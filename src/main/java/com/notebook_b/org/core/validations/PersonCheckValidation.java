/*
package com.notebook_b.org.core.validations;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PersonCheckValidation implements ConstraintValidator<cap_software.hrms.core.validations.ValidRealPerson, PersonalInformationDto> {

    private CheckValidPersonService checkValidPersonService;

    @Override
    public void initialize(cap_software.hrms.core.validations.ValidRealPerson constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PersonalInformationDto value, ConstraintValidatorContext context) {



        return   checkValidPersonService.isValidPerson(value.getNationalIdentityNumber(),
                value.getName(),
                value.getSurname(),
                String.valueOf(value.getBirthOfDate().getYear()));
    }
}
*/
