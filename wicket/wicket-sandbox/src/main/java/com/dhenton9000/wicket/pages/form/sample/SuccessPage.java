package com.dhenton9000.wicket.pages.form.sample;

import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SuccessPage extends TemplatePage {

	public SuccessPage(final PageParameters parameters) {

                this.setPageTitle(this.getClass().getSimpleName());
		String username = parameters.get("name").toString("");
		String age = parameters.get("age").toString("");
                String userNumber = parameters.get("userNumber").toString();
		String nickname =  parameters.get("nickName").toString("");
		final Label result = new Label("result", " name : " + username
                                + "user number "+userNumber 
				+ " age : " + age + " nickname : " + nickname);
		add(result);

	}
}

