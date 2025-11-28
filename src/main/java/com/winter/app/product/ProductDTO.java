package com.winter.app.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDTO {
	private Long 	pNum;
	private String 	pTitle;
	private String 	pName;
	private String 	pCate;
	private double 	pRate;
	private boolean pSale;
}
