package com.pro.sns.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pro.sns.member.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		System.out.println("supports called..");
		return Member.class.isAssignableFrom(arg0);
		/**
		 * supports메서드를 통과해야만 validate()가 호출된다
		 */
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		System.out.println(errors);
		Member m = (Member) arg0;
		System.out.println(m);
		System.out.println("validate() called");
		
		// 프로필사진은 강제가 아니므로 괜찮음
		//id는 javascript로 처리
		if (m.getId() == null || m.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
		}
		if (m.getPwd() == null || m.getPwd().trim().isEmpty()) {
			errors.rejectValue("pwd", "required");
		}
		if (m.getName() == null || m.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if (m.getEmail() == null || m.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}

	}
}
