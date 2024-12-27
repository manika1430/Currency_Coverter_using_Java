package com.learning.currency.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.learning.currency.exchange.dto.ConversionRates;

@Component
public class RestClientHelper {

	RestClient restClient = RestClient.create();

	@Autowired
	private Environment environment;

	public ConversionRates executeGetMethodFromRestClient(String serviceName, String body) {
		String urlProp = serviceName + ".url";
		String apiKey = serviceName + ".key";
		String endpoint = serviceName + ".endpoint";
		
		
		String urlPropValue = environment.getProperty(urlProp);
		String apiKeyValue = environment.getProperty(apiKey);
		String endpointValue = environment.getProperty(endpoint);

		String fullUrl = urlPropValue + apiKeyValue + endpointValue + body;

		ResponseEntity<ConversionRates> result = restClient.get().uri(fullUrl).retrieve().toEntity(ConversionRates.class);

		System.out.println("Response status: " + result.getStatusCode());
		System.out.println("Response headers: " + result.getHeaders());
		System.out.println("Contents: " + result.getBody());

		return result.getBody();

	}

}
