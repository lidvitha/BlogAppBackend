package com.lid.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {


	private int id;
	@NotEmpty
	@Size(min=4,message="Username must be atleast of 4 characters")
	private String name;
	@Email(message="Email address is invalid")
	private String email;
	@NotEmpty
	private String password;
	private String about;
}
