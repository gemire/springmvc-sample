package com.dhenton9000.spring.mvc.controllers;

import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/*
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
*/

/**
 * This code will not compile on the Google app engine, but could be
 * used to generate images on the fly, such as CAPTCHA
 * @author Don
 *
 */



@Controller
@RequestMapping(value = "/image/generator/*")
public class ImageGeneratorController {
/*
	public static final String IMAGE_DESTINATION_TILE = "tiles.imagegenerator";
	public static final String IMAGE_KEY = "image";

	private static Logger log = LogManager
			.getLogger(ImageGeneratorController.class);

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showFormInInitialState() {

		return IMAGE_DESTINATION_TILE;

	}

	@RequestMapping(value = "getImageBuffer", method = RequestMethod.GET,
			headers="Accept=image/jpeg, image/jpg, image/png, image/gif")
	@ResponseBody
	public byte[] drawPng(HttpServletResponse response)
			throws IOException {
		log.debug("hit getImageBuffer");
		return createImage("png", "Spring MVC");

	}

	@RequestMapping(value="getImage", method = RequestMethod.GET,
			headers="Accept=image/jpeg, image/jpg, image/png, image/gif")
	public void getImageViaResponse(HttpServletResponse response) throws IOException {
	    response.setContentType("image/png");
	    log.debug("hit getImage");
	    byte[] imgBytes = createImage("png","Get a job");
	    IOUtils.write(imgBytes,response.getOutputStream());
	}
	
	
	
	
	

	private byte[] createImage(String sImgType, String message) {
		ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
		byte[] captchaBytes = null; // imageBytes

		int width = 200;
		int height = 50;

		try {
			BufferedImage bufImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bufImage.createGraphics();
			drawString(g2d, Color.BLUE, new Font("mono", Font.BOLD, 10),
					message, 3, 10);


			drawBorder(g2d, Color.BLUE, width, height);
			g2d.setColor(Color.RED);
			g2d.drawArc(100, 25, 20, 20, 0,360);
			
			g2d.dispose();

			ImageIO.write(bufImage, sImgType, imgOutputStream);
			captchaBytes = imgOutputStream.toByteArray();
			//

		} catch (Exception e) {
			//
			log.error("Image failed #0001 ");
		}
		return captchaBytes;
	}

	
	private void drawBorder(Graphics2D g, Color color, int width, int height) {
		// draw a border
		g.setColor(color);
		g.drawRect(0, 0, width - 1, height - 1);
	}

	
	private void drawString(Graphics2D g, Color color, Font font, String str,
			int posX, int posY) {
		// Draw a string
		g.setColor(color);
		g.setFont(font);
		g.drawString(str, posX, posY);
	}

	
	private void fillBackground(Graphics2D g, Color color, int width, int height) {
		// Fill background
		g.setColor(color);
		g.fillRect(0, 0, width, height);
	}
*/
}
