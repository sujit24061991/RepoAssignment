package com.pro_vigile.survelliance.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
		
		ResponseResult responseResult = null;
		Result result = null;
		double cost = 0;
        result=new Result();

		Subscription subscription = subscriprionRequest(inputStream);
		if (subscription.getArea() <= 2500 && subscription.getLocation().equals("indoor")
				&& subscription.getPlan().equals("monthly")) {
			//result = new Result();
			cost = 2 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() <= 2500 && subscription.getLocation().equals("indoor")
				&& subscription.getPlan().equals("yearly")) {
			//result = new Result();
			cost = 1.5 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() <= 2500 && subscription.getLocation().equals("outdoor")
				&& subscription.equals("monthly")) {
			//result = new Result();
			cost = 2.5 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}
		if (subscription.getArea() <= 2500 && subscription.getLocation().equals("outdoor")
				&& subscription.equals("yearly")) {
			//result = new Result();
			cost = 2 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
				&& subscription.getLocation().equals("indoor")
				|| subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("monthly")) {
			//result = new Result();
			cost = 1.5 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 2500 && subscription.getArea() <= 5000
				&& subscription.getLocation().equals("indoor")
				|| subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("yearly")) {
			//result = new Result();
			cost = 1 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 5000 && subscription.getArea() <= 50000
				&& subscription.getLocation().equals("indoor") && subscription.getPlan().equals("monthly")) {
			//result = new Result();
			cost = 1 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 5000 && subscription.getArea() <= 50000
				&& subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("monthly")) {
			//result = new Result();
			cost = 1.2 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 5000 && subscription.getArea() <= 50000
				&& subscription.getLocation().equals("indoor") && subscription.getPlan().equals("yearly")) {
			//result = new Result();
			cost = 0.6 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}
		if (subscription.getArea() > 5000 && subscription.getArea() <= 50000
				&& subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("yearly")) {
			//result = new Result();
			cost = 0.8 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 50000 && subscription.getLocation().equals("indoor")
				|| subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("monthly")) {
			//result = new Result();
			cost = 0.8 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		if (subscription.getArea() > 50000 && subscription.getLocation().equals("indoor")
				|| subscription.getLocation().equals("outdoor") && subscription.getPlan().equals("yearly")) {
			//result = new Result();
			cost = 0.5 * subscription.getArea();
			result.setCost(cost);
			result.setSubscription_id(subscription.getSubscription_id());
			responseResult = new ResponseResult(result);

		}

		return responseResult;

	}

	public Subscription subscriprionRequest(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		Subscription subscription = null;
		DocumentBuilderFactory documentBuilderFactory = null;
		DocumentBuilder builder = null;
		Node rootElement = null;
		NodeList children = null;
		Document doc = null;
		Node child = null;
		String elementName = null;
		String elementValue = null;

		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		builder = documentBuilderFactory.newDocumentBuilder();
		doc = builder.parse(inputStream);
		rootElement = doc.getFirstChild();
		children = rootElement.getChildNodes();

		subscription = new Subscription();
		for (int i = 0; i < children.getLength(); i++) {
			child = children.item(i);
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
	private Result result;

	public ResponseResult(Result result) {
		// TODO Auto-generated constructor stub
		this.result = result;

	}

	@Override
	public void write(OutputStream output) throws IOException, WebApplicationException {
		StringBuffer buffer = null;

		buffer = new StringBuffer();
		buffer.append("<result><subscription><id>").append(result.getSubscription_id()).append("</id><cost>")
				.append(result.getCost()).append("</cost>").append("</subscription></result>");

		output.write(buffer.toString().getBytes());
		output.close();

	}
}