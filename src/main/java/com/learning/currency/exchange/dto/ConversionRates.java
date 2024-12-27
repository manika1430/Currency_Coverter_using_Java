package com.learning.currency.exchange.dto;

import java.io.Serializable;
import java.util.Map;

public class ConversionRates implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String>conversion_rates;
	private String base_code;
	private String result;
	
	
	public Map<String, String> getConversion_rates() {
		return conversion_rates;
	}
	public void setConversion_rates(Map<String, String> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
	public String getBase_code() {
		return base_code;
	}
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "ConversionRates [conversion_rates=" + conversion_rates + ", base_code=" + base_code + ", result="
				+ result + "]";
	}
	
	
	
}
