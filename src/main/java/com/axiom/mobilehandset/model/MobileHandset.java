package com.axiom.mobilehandset.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MobileHandset {

	private Integer id;
	private String brand;
	private String phone;
	private String picture;
	private String sim;
	private String resolution;
	private Hardware hardware;
	private Release release;
}
