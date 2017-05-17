package com.mulesoft.mule.tools.odata;

import org.odata4j.consumer.ODataClientRequest;
import org.odata4j.consumer.behaviors.OClientBehavior;
import org.odata4j.repack.org.apache.commons.codec.binary.Base64;

/**
 * @author anthony.rabiaza@mulesoft.com
 */
public class CustomOClientBehavior implements OClientBehavior {

	private String user, password;

	public CustomOClientBehavior(String user, String password){
		this.user = user;
		this.password = password;
	}

	@Override
	public ODataClientRequest transform(ODataClientRequest request) {
		System.out.println("************DEBUG CustomOClientBehavior**************");
		if("MERGE".equals(request.getHeaders().get("X-HTTP-METHOD"))){
			//Overridding POST method to PUT
			request = request.method("PUT");
			System.out.println("************DEBUG CustomOClientBehavior Putting PUT **************");
		}
		
		if(user!=null) {
			if(user.contains(" ")) {
				request = request.header("Authorization", user);
			} else {
				String userPassword = user + ":" + password;
			    String encoded = Base64.encodeBase64String(userPassword.getBytes());
			    encoded = encoded.replaceAll("\r\n?", "");
			    request = request.header("Authorization", "Basic " + encoded);
			}
		}
	    
		return request.header("X-Requested-With", "XMLHttpRequest");
	}
}