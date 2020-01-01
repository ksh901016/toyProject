package com.corn.toy.simple.validator;


import com.corn.toy.simple.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) { // 타입 검증
        // 서브클래스가 사용될 수 있도록 isAssignableForm 사용
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) { // 입력값 검증
        User user = (User) target;

        if(user.getUsername() == null || user.getUsername().length() == 0){
            // 두 번째 인자는 에러 코드
            errors.rejectValue("username", "field.required");
        }
        // 위의 코드와 같다.
        ValidationUtils.rejectIfEmpty(errors, "username", "field.required");

        if(user.getAge() < 0)
            // 세 번째, 네 번째 파라미터는 에러 코드와 함께 에러 메시지를 작성할 때 사용될 정보
            errors.rejectValue("age", "field.min", new Object[]{0}, null);
    }
}
