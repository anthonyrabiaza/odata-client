package com.mulesoft.mule.tools;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * @author anthony.rabiaza@mulesoft.com
 */
public class CustomTrustManager {
	
	static X509TrustManager allowAllOut;
	
	static {
		allowAllOut = new X509TrustManager() {     
			public X509Certificate[] getAcceptedIssuers() { 
				return new X509Certificate[0];
			} 
			public void checkClientTrusted( 
					java.security.cert.X509Certificate[] certs, String authType) {
			} 
			public void checkServerTrusted( 
					java.security.cert.X509Certificate[] certs, String authType) {
			}
		};
	}

	public static boolean execute(org.apache.commons.logging.Log log) {
		TrustManager[] trustAllCerts = {allowAllOut}; 

		// Install the all-trusting Trust Manager
		try {
			log.info("Enabling the Custom Trust Manager...");
			SSLContext sc = SSLContext.getInstance("SSL"); 
			sc.init(null, trustAllCerts, new java.security.SecureRandom()); 
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			log.info("Trust Manager enabled");
			return true;
		} catch (GeneralSecurityException e) {
			log.error("Unable to install the Trust Manager: " + e);
			return false;
		}
	}
	
}
