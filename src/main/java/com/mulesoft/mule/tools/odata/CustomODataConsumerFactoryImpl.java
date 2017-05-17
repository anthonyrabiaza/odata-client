package com.mulesoft.mule.tools.odata;

import org.mule.modules.odata.factory.ODataConsumerFactory;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.behaviors.OClientBehavior;
import org.odata4j.core.ODataVersion;
import org.odata4j.format.FormatType;
import org.odata4j.jersey.consumer.ODataJerseyConsumer;
import org.odata4j.jersey.consumer.ODataJerseyConsumer.Builder;

/**
 * @author anthony.rabiaza@mulesoft.com
 */
public class CustomODataConsumerFactoryImpl implements ODataConsumerFactory {

	@Override
	public ODataConsumer newConsumer(String baseServiceUri, FormatType formatType, String username, String password,
			ODataVersion version) {
		OClientBehavior auth = new CustomOClientBehavior(username, password);
		Builder builder = ODataJerseyConsumer.newBuilder(baseServiceUri, version).setFormatType(formatType);
		if (auth != null) {
			builder.setClientBehaviors(auth);
		}
		
		System.out.println("************DEBUG CustomODataConsumerFactoryImpl**************");
		return builder.build();
	}
	
	//com.mulesoft.mule.tools.odata.CustomODataConsumerFactoryImpl

}
