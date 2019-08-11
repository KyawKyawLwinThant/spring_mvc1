package demo.spring.demospringmvc1.validation;

import demo.spring.demospringmvc1.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordNotSameValid implements ConstraintValidator<PasswordNotSame,User> {
  @Override
  public boolean isValid(User user, ConstraintValidatorContext context) {
    return user.getPassword().equalsIgnoreCase(user.getConfirmPassword());
  }
}
