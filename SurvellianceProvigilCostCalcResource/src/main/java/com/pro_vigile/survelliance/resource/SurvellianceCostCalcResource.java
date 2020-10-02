package com.pro_vigile.survelliance.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.pro_vigile.survelliance.resource.helper.Result;
import com.pro_vigile.survelliance.resource.helper.Subscription;

@Path("/cost")
public class SurvellianceCostCalcResource {
	private  Subscription subscription =null;

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)

	public StreamingOutput survellianceCost(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		ResponseResult responseResult = null;
        
		List listResult = new ArrayList();

		List<Subscription> subscription2 = subscriprionRequest(inputStream);
		for (Subscription subscription : subscription2) {
			Result result = new Result();

			if (subscription.getArea() <= 2500 && subscription.getPlan().equals("monthly")
					&& subscription.getLocation().equals("indoor")) {
				double cost = (subscription.getArea() * 2);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);
				

			}
			if (subscription.getArea() <= 2500 && subscription.getPlan().equals("yearly")
					&& subscription.getLocation().equals("indoor")) {
				double cost = (int) (subscription.getArea() * 1.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);
				
			}
			if (subscription.getArea() <= 2500 && subscription.getPlan().equals("monthly")
					&& subscription.getLocation().equals("outdoor")) {
				double cost = (subscription.getArea() * 2.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() <= 2500 && subscription.getPlan().equals("yearly")
					&& subscription.getLocation().equals("outdoor")) {
				double cost = (subscription.getArea() * 2);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
					&& subscription.getPlan().equals("monthly") && subscription.getLocation().equals("indoor")) {
				double cost = (2500 * 2 + (subscription.getArea() - 2500) * 1.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
					&& subscription.getPlan().equals("yearly") && subscription.getLocation().equals("indoor")) {
				double cost = (2500 * 1.5 + (subscription.getArea() - 2500) * 1);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
					&& subscription.getPlan().equals("monthly") && subscription.getLocation().equals("outdoor")) {
				double cost = (2500 * 2.5 + (subscription.getArea() - 2500) * 1.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
					&& subscription.getPlan().equals("yearly") && subscription.getLocation().equals("outdoor")) {
				double cost = (2500 * 2 + (subscription.getArea() - 2500) * 1);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}

			if (subscription.getArea() > 5000 && subscription.getArea() < 50000
					&& subscription.getPlan().equals("monthly") && subscription.getLocation().equals("indoor")) {
				int cost = (int) ((2500 * 2) + (2500 * 1.5) + ((subscription.getArea() - 5000) * 1));
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 5000 && subscription.getArea() < 50000
					&& subscription.getPlan().equals("monthly") && subscription.getLocation().equals("outdoor")) {
				double cost = (2500 * 2 + 2500 * 1.5 + (subscription.getArea() - 5000) * 1.2);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 5000 && subscription.getArea() < 50000
					&& subscription.getPlan().equals("yearly") && subscription.getLocation().equals("indoor")) {
				double cost = (2500 * 2 + 2500 * 1.5 + (subscription.getArea() - 5000) * 0.6);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 5000 && subscription.getArea() < 50000
					&& subscription.getPlan().equals("yearly") && subscription.getLocation().equals("outdoor")) {
				double cost = (2500 * 2 + 2500 * 1.5 + (subscription.getArea() - 5000) * 0.8);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 50000 && subscription.getPlan().equals("monthly")
					&& subscription.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 1 + (subscription.getArea() - 50000) * 0.8);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 50000 && subscription.getPlan().equals("monthly")
					&& subscription.getLocation().equals("outdoor")) {
				double cost = (2500 * 2 + 2500 * 1.5 + 45000 * 1.2 + (subscription.getArea() - 50000) * 0.8);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 50000 && subscription.getPlan().equals("yearly")
					&& subscription.getLocation().equals("indoor")) {
				double cost = (2500 * 2 + 2500 * 1.5 + 45000 * 0.6 + (subscription.getArea() - 50000) * 0.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			if (subscription.getArea() > 50000 && subscription.getPlan().equals("yearly")
					&& subscription.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 0.8 + (subscription.getArea() - 50000) * 0.5);
				result.setCost(cost);
				result.setSubscription_id(subscription.getSubscription_id());
				listResult.add(result);

			}
			responseResult = new ResponseResult(listResult);
		}
		return responseResult;

	}

	private List<Subscription> subscriprionRequest(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder builder = null;
		Document doc = null;
       
		List<Subscription> subscriptionsLists = null;
		subscriptionsLists = new ArrayList<Subscription>();

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		builder = documentBuilderFactory.newDocumentBuilder();
		doc = builder.parse(inputStream);
		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		subscription=new Subscription();
		if (doc.hasChildNodes()) {
			
			subscriptionsLists.add(subscription);
			subscription = nodeExecutation(doc.getChildNodes());

		}

		return subscriptionsLists;
	}

	private  Subscription nodeExecutation(NodeList nodeList) {
		    
		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				
                String elementName = null;
				String elementValue = null;
				elementName = tempNode.getNodeName();
				elementValue = tempNode.getTextContent();
				if (elementName.equals("id")) {
					subscription.setSubscription_id(Integer.parseInt(elementValue));
				} else if (elementName.equals("area")) {
					subscription.setArea(Float.parseFloat(elementValue));
				} else if (elementName.equals("plan")) {
					subscription.setPlan(elementValue);
				} else if (elementName.equals("location")) {
					subscription.setLocation(elementValue);
				}

				if (tempNode.hasChildNodes()) {

					nodeExecutation(tempNode.getChildNodes());

				}

			}

		}

		return subscription;
	}
}

final class ResponseResult implements StreamingOutput {
	private List<Result> results;

	public ResponseResult(List<Result> result) {
		// TODO Auto-generated constructor stub
		this.results = result;

	}

	@Override
	public void write(OutputStream output) throws IOException, WebApplicationException {

		StringBuffer buffer = null;
		for (Result result : results) {

			buffer = new StringBuffer();
			buffer.append("<result><subscription><id>").append(result.getSubscription_id()).append("</id><cost>")
					.append(result.getCost()).append("</cost>").append("</subscription></result>");

			output.write(buffer.toString().getBytes());

		}
		output.close();
	}
}
