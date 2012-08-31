package com.dhenton9000.registration.components;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import com.dhenton9000.registration.components.ws.RegisterInput;

public class RegistrationTransformer extends AbstractTransformer {

	@Override
	protected Object doTransform(Object arg0, String arg1)
			throws TransformerException {
		RegisterInput rI = (RegisterInput) arg0;
		 
		return arg0;
	}

}
