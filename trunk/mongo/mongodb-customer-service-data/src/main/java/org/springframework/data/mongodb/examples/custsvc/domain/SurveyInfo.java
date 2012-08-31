package org.springframework.data.mongodb.examples.custsvc.domain;

import java.util.Map;
import java.io.Serializable;

public class SurveyInfo implements Serializable {
	
	private Map<String, String> questionsAndAnswers;

	public Map<String, String> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(Map<String, String> questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}

	@Override
	public String toString() {
		return "SurveyInfo [questionsAndAnswers=" + questionsAndAnswers + "]";
	}

}
