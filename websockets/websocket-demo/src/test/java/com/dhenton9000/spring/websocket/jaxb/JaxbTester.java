/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.spring.websocket.jaxb;

 

 
import com.dhenton9000.auctions.model.AuctionItem;
import com.dhenton9000.auctions.model.Bidders;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamReader;
 import javax.xml.transform.stream.StreamSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaxbTester {
	private static Logger log = LoggerFactory.getLogger(JaxbTester.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = marshallSample();
                log.debug("\n"+test+"\n");
		Bidders off = (Bidders) unmarshallSample(test);
		log.debug("off "+off.getUserName());

	}

	private static Object unmarshallSample(String xml) {
		Object o = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(Bidders.class);
			XMLStreamReader reader = null;

			StringReader sR = new StringReader(xml);

			o = context.createUnmarshaller().unmarshal(
					new StreamSource(sR));

		} catch (JAXBException e) {
			log.error("problem ",e);
		}
		return o;
	}

	private static String marshallSample() {

		String info = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Bidders.class);
			Bidders o = new Bidders();
			o.setUserName("fred@friendly");
			o.setId(3);
                        o.setPassword("getajob");
                        
                        ArrayList<AuctionItem> auctionItems = new ArrayList<>();
                        o.setAuctionItems(auctionItems);
                        auctionItems.add(new AuctionItem("get a job 1", 5.00f));
                        auctionItems.add(new AuctionItem("get a job 2", 6.00f)); 
                        auctionItems.add(new AuctionItem("get a job 3", 12.00f));
                        
			StringBuilder ws = new StringBuilder();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			context.createMarshaller().marshal(o, baos);

			try {
				info = baos.toString("UTF-8");
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
			log.debug(info);
		} catch (JAXBException e) {
			log.error("problem ",e);
		}

		return info;
	}

}