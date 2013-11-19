package com.dhenton9000.spring.mvc.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

 

public class ValidateBean {

	private static Logger log = LogManager
	.getLogger(ValidateBean.class);



		@NotNull
		@Max(5)
		private Integer number;

		@NotNull
		@Future
		@DateTimeFormat(iso = ISO.DATE)
		private Date date;

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

		public Date getDate() {
			log.debug("@@@get for date "+date);
			return date;
		}

		public void setDate(Date date) {
			log.debug("@@@set for date "+date);
			this.date = date;
		}


//http://blog.inflinx.com/2010/03/10/jsr-303-bean-validation-using-spring-3/
}
