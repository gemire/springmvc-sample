/*
 * $Id$ -------------------------------------------------------------------------------------- Copyright (c) MuleSource,
 * Inc. All rights reserved. http://www.mulesource.com The software in this package is published under the terms of the
 * CPAL v1.0 license, a copy of which has been included with this distribution in the LICENSE.txt file.
 */

package org.mule.module.saaj.i18n;
import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;

public class SaajMessages extends MessageFactory {

	private static final String BUNDLE_PATH = getBundlePath("saaj");
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;
	private static final int EIGHT = 8;
	private static final int NINE = 9;
	private static final int TEN = 10;

	private static final SaajMessages FACTORY = new SaajMessages();

	public static Message failedToExtractSoapBody() {
		return FACTORY.createMessage(BUNDLE_PATH, 1);
	}

	public static Message failedToCreateDocumentBuilder() {
		return FACTORY.createMessage(BUNDLE_PATH, TWO);
	}

	public static Message couldNotCreateSaajConnection() {
		return FACTORY.createMessage(BUNDLE_PATH, THREE);
	}

	public static Message soapResponseIsNull() {
		return FACTORY.createMessage(BUNDLE_PATH, FOUR);
	}

	public static Message soapFault(String faultCode, String faultString, String faultActor, String faultDetails) {
		return FACTORY.createMessage(BUNDLE_PATH, FIVE, faultCode, faultString, faultActor, faultDetails);
	}

	public static Message failedToCreateDocumentFactories() {
		return FACTORY.createMessage(BUNDLE_PATH, SIX);
	}

	public static Message failedToBuildSOAPMessage() {
		return FACTORY.createMessage(BUNDLE_PATH, SEVEN);
	}

	public static Message failedToAddMIMEHeader() {
		return FACTORY.createMessage(BUNDLE_PATH, EIGHT);
	}

	public static Message failedToGetSOAPMessageAsByteArray() {
		return FACTORY.createMessage(BUNDLE_PATH, NINE);
	}

	public static Message failedToEvaluateFault() {
		return FACTORY.createMessage(BUNDLE_PATH, TEN);
	}
}
