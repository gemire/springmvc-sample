package com.dhenton9000.registration.components;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import com.dhenton9000.registration.components.ws.RegisterInput;

public class FredRegistrationTransformer extends AbstractTransformer {

	@Override
	protected Object doTransform(Object arg0, String arg1)
			throws TransformerException {
		RegisterInput rI = (RegisterInput) arg0;
		rI.setName(rI.getName()+" Fred,fred,FRed ");
		return arg0;
	}

}
