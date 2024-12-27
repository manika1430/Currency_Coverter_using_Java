package com.learning.currency.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyExchangeController {
	
	
	@Autowired
	CurrencyExchangeService service;

	@RequestMapping("currencyExchangeDisplay")
	public String currencyExchangeDisplay() {
		return "currencyExchangeUI";

	}

	@RequestMapping("exchange")
	public String exchange(@RequestParam double amount, @RequestParam String fromCurrency,
			@RequestParam String toCurrency, Model model) {
		
		model.addAttribute("amount", amount);
		model.addAttribute("fromCurrency", fromCurrency);
		model.addAttribute("toCurrency", toCurrency);
		
		if(fromCurrency==null || fromCurrency.isEmpty()) {
			model.addAttribute("exchangeError", "Please enter From Currency");
		}else if(toCurrency==null || toCurrency.isEmpty()) {
			model.addAttribute("exchangeError", "Please enter To Currency");
		}else {
			
			try {
				double exchangedValue=  service.getExchangeAmount(fromCurrency, toCurrency, amount);
				model.addAttribute("exchangedValue",exchangedValue);
			}catch(Exception e) {
				System.out.println("Error encountered while hitting service -> "+ e.getMessage());
				model.addAttribute("exchangeError", "Service is currently down! Please try again in some time");
			}
			
		}
		
		
		return "currencyExchangeUI";

	}

}
