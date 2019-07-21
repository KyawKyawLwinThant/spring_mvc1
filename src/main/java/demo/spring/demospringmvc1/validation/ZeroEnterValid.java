/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.spring.demospringmvc1.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author kyawkyawlwin
 */
public class ZeroEnterValid implements ConstraintValidator<NotZero, Integer>{

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value!=0;
    }
    
}
