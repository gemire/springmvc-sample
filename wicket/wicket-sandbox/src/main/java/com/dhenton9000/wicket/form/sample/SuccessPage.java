package com.dhenton9000.wicket.form.sample;

import com.dhenton9000.wicket.TemplatePage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class SuccessPage extends TemplatePage {

	public SuccessPage(final PageParameters parameters) {

                this.setPageTitle("Wicket PropertyModel Example - SuccessPage.html");
		String username = parameters.get("name").toString("");
		String age = parameters.get("age").toString("");
		String nickname =  parameters.get("nickname").toString("");
		final Label result = new Label("result", " name : " + username
				+ " age : " + age + " nickname : " + nickname);
		add(result);

	}
}

