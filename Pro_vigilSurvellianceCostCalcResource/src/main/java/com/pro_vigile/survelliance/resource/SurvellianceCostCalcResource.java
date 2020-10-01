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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.pro_vigile.survelliance.resource.helper.Result;
import com.pro_vigile.survelliance.resource.helper.Subscription;

@Path("/cost")
public class SurvellianceCostCalcResource {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)

	public StreamingOutput survellianceCost(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		// Subscription subscription =null;
		ResponseResult responseResult = null;
		Result result = null;

		result = new Result();
		List listResult = new ArrayList();

		Subscription subscription = subscriprionRequest(inputStream);
		if (subscription.getArea() <= 2500 && subscription.getPlan().equals("monthly")
				&& subscription.getLocation().equals("indoor")) {
			double cost = (subscription.getArea() * 2);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			// responseResult = new ResponseResult(result);

		}
		if (subscription.getArea() <= 2500 && subscription.getPlan().equals("yearly")
				&& subscription.getLocation().equals("indoor")) {
			double cost = (int) (subscription.getArea() * 1.5);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			// responseResult = new ResponseResult(result);
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
		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000 && subscription.getPlan().equals("monthly")
				&& subscription.getLocation().equals("indoor")) {
			double cost = (2500 * 2 + (subscription.getArea() - 2500) * 1.5);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);

		}
		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000 && subscription.getPlan().equals("yearly")
				&& subscription.getLocation().equals("indoor")) {
			double cost = (2500 * 1.5 + (subscription.getArea() - 2500) * 1);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			
		}
		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000 && subscription.getPlan().equals("monthly")
				&& subscription.getLocation().equals("outdoor")) {
			double cost = (2500 * 2.5 + (subscription.getArea() - 2500) * 1.5);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			
		}
		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000 && subscription.getPlan().equals("yearly")
				&& subscription.getLocation().equals("outdoor")) {
			double cost = (2500 * 2 + (subscription.getArea() - 2500) * 1);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			
		}

		if (subscription.getArea() > 5000 && subscription.getArea() < 50000 && subscription.getPlan().equals("monthly")
				&& subscription.getLocation().equals("indoor")) {
			int cost = (int) ((2500 * 2) + (2500 * 1.5) + ((subscription.getArea() - 5000) * 1));
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
	
		}
		if (subscription.getArea() > 5000 && subscription.getArea() < 50000 && subscription.getPlan().equals("monthly")
				&& subscription.getLocation().equals("outdoor")) {
			double cost = (2500 * 2 + 2500 * 1.5 + (subscription.getArea() - 5000) * 1.2);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			
		}
		if (subscription.getArea() > 5000 && subscription.getArea() < 50000 && subscription.getPlan().equals("yearly")
				&& subscription.getLocation().equals("indoor")) {
			double cost = (2500 * 2 + 2500 * 1.5 + (subscription.getArea() - 5000) * 0.6);
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			listResult.add(result);
			
		}
		if (subscription.getArea() > 5000 && subscription.getArea() < 50000 && subscription.getPlan().equals("yearly")
				&& subscription.getLocation().equals("outdoor")) {
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

		return responseResult;

	}

	private Subscription subscriprionRequest(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		Subscription subscription = null;
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder builder = null;
		Node rootElement = null;
		NodeList children = null;
		Document doc = null;
		String elementName = null;
		String elementValue = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		builder = documentBuilderFactory.newDocumentBuilder();
		doc = builder.parse(inputStream);
		doc.getDocumentElement().normalize();
		rootElement = doc.getFirstChild();
		System.out.println(rootElement);
		children = rootElement.getChildNodes();

		System.out.println(children);

		subscription = new Subscription();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);

			if (child.getNodeType() == Node.ELEMENT_NODE) {
				elementName = child.getNodeName();
				elementValue = child.getFirstChild().getNodeValue();

				if (elementName.equals("id")) {
					subscription.setSubscription_id(Integer.parseInt(elementValue));
				} else if (elementName.equals("area")) {
					subscription.setArea(Float.parseFloat(elementValue));
				} else if (elementName.equals("plan")) {
					subscription.setPlan(elementValue);
				} else if (elementName.equals("location")) {
					subscription.setLocation(elementValue);
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
		output.close();
	}
}
}