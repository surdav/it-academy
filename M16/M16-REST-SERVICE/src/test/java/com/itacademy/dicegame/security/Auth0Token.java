package com.itacademy.dicegame.security;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Auth0Token {

	public String getToken() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		JSONObject requestBody = new JSONObject();
		try {
			requestBody.put("client_id", "s9YaCO9LD8h2qQv0ihTLPuHXuR3IwRUN");
			requestBody.put("client_secret", "zo_bxhku2wn4WKGXwAmNosW6yA4hTUzqQlJt5GrLaaDCsnF5PoXdm5HVR4jGG_BQ");
			requestBody.put("audience", "m16DiceGame");
			requestBody.put("grant_type", "client_credentials");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		HttpEntity<String> request = new HttpEntity<String>(requestBody.toString(), headers);

		RestTemplate restTemplate = new RestTemplate();
		HashMap<String, String> result = restTemplate.postForObject("https://suren-davidiants.eu.auth0.com/oauth/token",
				request, HashMap.class);
		
		return result.get("access_token");
	}

}
