package com.learning.currency.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.currency.exchange.dto.ConversionRates;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	RestClientHelper restClientHelper;

	public double getExchangeAmount(String fromCurrency, String toCurrency, double amount) {
		String exchangeRate=getExchangeRate(fromCurrency, toCurrency);
		double exchangedAmount=Double.parseDouble(exchangeRate)*amount;
		return exchangedAmount;
	}

	private String getExchangeRate(String fromCurrency, String toCurrency) {
		String exchangeRate="";
		ConversionRates conversionRates=restClientHelper.executeGetMethodFromRestClient("exchangerate-api", fromCurrency);
		if(conversionRates!=null && conversionRates.getConversion_rates()!=null) {
			 exchangeRate=conversionRates.getConversion_rates().get(toCurrency);
		}
		return exchangeRate;
	}
	
}
