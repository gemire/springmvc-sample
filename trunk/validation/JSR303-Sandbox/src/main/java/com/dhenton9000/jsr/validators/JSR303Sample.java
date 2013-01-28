/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jsr.validators;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *BEAN ENTRY
 * <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean">
    <property name="messageInterpolator" ref="webLocaleInterpolator" />
</bean>
 * 
 * @author dhenton
 */
 
@PasswordVerification
public class JSR303Sample implements Serializable {
 
	// The email
	private String email;
 
	@NotNull
	@Email
	@Size(min=4,max=255)
	public String getEmail() {
		return this.email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
 
	// The password (uncyphered at this stage)
	private String password;
 
	@NotNull
	@Size(min=4)
	public String getPassword() {
		return this.password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
 
	// The password verification
	private String passwordVerification;
 
	@NotNull
	public String getPasswordVerification() {
		return this.passwordVerification;
	}
 
	public void setPasswordVerification(String passwordVerification) {
		this.passwordVerification = passwordVerification;
	}
 
 
	// The age
	private Integer age;
 
	@NotNull
	@Max(140)
	@Min(18)
	public Integer getAge() {
		return this.age;
	}
 
	public void setAge(Integer age) {
		this.age = age;
	}
 
}