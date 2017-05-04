package com.mulesoft.mule.tools.odata;

import org.odata4j.consumer.ODataClientRequest;
import org.odata4j.consumer.behaviors.OClientBehavior;

public class CustomOClientBehavior implements OClientBehavior {

	private String authorizationType, token;

	public CustomOClientBehavior(String authorizationType, String token){
		this.authorizationType = authorizationType;
		this.token = token;
	}

	@Override
	public ODataClientRequest transform(ODataClientRequest request) {
		System.out.println("************DEBUG CustomOClientBehavior**************");
		return request.header("Authorization", authorizationType + " " + token);
	}
}
