package com.godink.demo01.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDo {

	private Long id;
	private String name;
	private Long age;
	private Integer sex;
}
