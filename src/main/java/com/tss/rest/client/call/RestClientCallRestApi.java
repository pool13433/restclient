package com.tss.rest.client.call;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClientCallRestApi {
	public RestClientCallRestApi() {
		// TODO Auto-generated constructor stub
	}

	public ClientResponse clientGet(String url,String responseFormat) {
		ClientResponse response = null;
		//url = "http://localhost:8080/RESTfulExample/rest/json/metallica/get"; 
		// responseFormat = "application/json";
		try {

			Client client = Client.create();

			WebResource webResource = client.resource(url);

			response = webResource.accept(responseFormat).get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return response;
	}

	public ClientResponse clientPost(String url,String input,String responseFormat) {
		ClientResponse response = null;
		// String url = "http://localhost:8080/RESTfulExample/rest/json/metallica/post";
		// responseFormat = "application/json";
		try {

			Client client = Client.create();

			WebResource webResource = client.resource(url);

			//String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

			response = webResource.type(responseFormat).post(ClientResponse.class, input);
			
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return response;
	}
}
