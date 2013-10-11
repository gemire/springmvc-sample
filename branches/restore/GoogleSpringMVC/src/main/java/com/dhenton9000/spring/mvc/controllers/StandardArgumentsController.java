package com.dhenton9000.spring.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhenton9000.spring.mvc.model.StandardArgumentData;

@Controller
@RequestMapping(value = "/data/standard/*")
public class StandardArgumentsController {

	private static Logger log = LogManager
			.getLogger(StandardArgumentsController.class);

	// request related

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView goHome() {

		return new ModelAndView("tiles.standard.args", "results", null);
	}

	@RequestMapping(value = "request", method = RequestMethod.GET)
	public ModelAndView standardRequestArgs(HttpServletRequest request,
			Principal user, Locale locale) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("request = ").append(request).append(", ");
		buffer.append("userPrincipal = ").append(user).append(", ");
		buffer.append("requestLocale = ").append(locale);
		StandardArgumentData tItem = new StandardArgumentData();
		String tString = buffer.toString();
		tItem.setResult(tString);
		tItem.setDescription("Request Parameters");
		return new ModelAndView("tiles.standard.args", "results", tItem);
	}

	@RequestMapping(value = "request/reader", method = RequestMethod.POST)
	public ModelAndView requestReader(Reader requestBodyReader)
			throws IOException {
		StandardArgumentData tItem = new StandardArgumentData();
		String tString = "Read char request body = "
				+ FileCopyUtils.copyToString(requestBodyReader);
		tItem.setResult(tString);
		tItem.setDescription("POST via Reader");
		return new ModelAndView("tiles.standard.args", "results", tItem);
	}

	@RequestMapping(value = "request/is", method = RequestMethod.POST)
	public ModelAndView requestReader(InputStream requestBodyIs)
			throws IOException {
		StandardArgumentData tItem = new StandardArgumentData();
		String tString = "Read binary request body = "
				+ new String(FileCopyUtils.copyToByteArray(requestBodyIs));
		tItem.setResult(tString);
		tItem.setDescription("POST via InputStream");
		return new ModelAndView("tiles.standard.args", "results", tItem);
	}

	// response related

	@RequestMapping("response")
	public ModelAndView response(HttpServletResponse response) {
		StandardArgumentData tItem = new StandardArgumentData();
		String tString = "response = " + response;
		tItem.setResult(tString);
		tItem.setDescription("GET Response Dump");
		return new ModelAndView("tiles.standard.args", "results", tItem);
	}

	@RequestMapping("response/writer")
	public void availableStandardResponseArguments(Writer responseWriter)
			throws IOException {
		responseWriter.write("Wrote char response using Writer");
	}

	@RequestMapping("response/os")
	public void availableStandardResponseArguments(OutputStream os)
			throws IOException {
		os.write("Wrote binary response using OutputStream".getBytes());
	}

	// HttpSession

	@RequestMapping("session")
	public ModelAndView session(HttpSession session) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("session=").append(session);
		StandardArgumentData tItem = new StandardArgumentData();
		String tString = buffer.toString();
		tItem.setResult(tString);
		tItem.setDescription("Session Dump");
		return new ModelAndView("tiles.standard.args", "results", tItem);
	}

}
