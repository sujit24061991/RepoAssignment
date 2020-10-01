package com.provigil.cost.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.provigil.cost.resource.dto.SubscriberRequestDto;
import com.provigil.cost.resource.dto.SubscriberResponse;
import com.provigil.cost.resource.dto.SubscriberResponseDto;
import com.provigil.cost.resource.dto.Subscription;

@Path("/calculate")
public class ProvigilCostCalculatorResource2 {
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/costInfo")
	public SubscriberResponse survillanceCostCalculate(Subscription subscription) {
		SubscriberResponseDto subscriberResponseDto = null;
		SubscriberResponse subscriberResponse = null;
		List<SubscriberRequestDto> subscriberLists = subscription.getSubscriberRequestDto();
		SubscriberRequestDto subscriberRequestDto = null;
		List<SubscriberResponseDto> list = new ArrayList<SubscriberResponseDto>();
		subscriberResponseDto = new SubscriberResponseDto();
		subscriberResponse = new SubscriberResponse();

		for (SubscriberRequestDto subscriberRequestDto1 : subscriberLists) {
			subscriberRequestDto = subscriberRequestDto1;
			if (subscriberRequestDto.getArea() <= 2500 && subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (subscriberRequestDto.getArea() * 2);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);

			}
			if (subscriberRequestDto.getArea() <= 2500 && subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (subscriberRequestDto.getArea() * 1.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() <= 2500 && subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (subscriberRequestDto.getArea() * 2.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() <= 2500 && subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (subscriberRequestDto.getArea() * 2);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 2500 && subscriberRequestDto.getArea() <= 5000
					&& subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 2 + (subscriberRequestDto.getArea() - 2500) * 1.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 2500 && subscriberRequestDto.getArea() <= 5000
					&& subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 1.5 + (subscriberRequestDto.getArea() - 2500) * 1);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 2500 && subscriberRequestDto.getArea() <= 5000
					&& subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2.5 + (subscriberRequestDto.getArea() - 2500) * 1.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 2500 && subscriberRequestDto.getArea() <= 5000
					&& subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + (subscriberRequestDto.getArea() - 2500) * 1);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}

			if (subscriberRequestDto.getArea() > 5000 && subscriberRequestDto.getArea() < 50000
					&& subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) ((2500 * 2) + (2500 * 1.5) + ((subscriberRequestDto.getArea() - 5000) * 1));
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 5000 && subscriberRequestDto.getArea() < 50000
					&& subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + (subscriberRequestDto.getArea() - 5000) * 1.2);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 5000 && subscriberRequestDto.getArea() < 50000
					&& subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + (subscriberRequestDto.getArea() - 5000) * 0.6);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 5000 && subscriberRequestDto.getArea() < 50000
					&& subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + (subscriberRequestDto.getArea() - 5000) * 0.8);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);
			}
			if (subscriberRequestDto.getArea() > 50000 && subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 1 + (subscriberRequestDto.getArea() - 50000) * 0.8);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);

			}
			if (subscriberRequestDto.getArea() > 50000 && subscriberRequestDto.getPlan().equals("monthly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 1.2 + (subscriberRequestDto.getArea() - 50000) * 0.8);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);

			}
			if (subscriberRequestDto.getArea() > 50000 && subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("indoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 0.6 + (subscriberRequestDto.getArea() - 50000) * 0.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);

			}
			if (subscriberRequestDto.getArea() > 50000 && subscriberRequestDto.getPlan().equals("yearly")
					&& subscriberRequestDto.getLocation().equals("outdoor")) {
				int cost = (int) (2500 * 2 + 2500 * 1.5 + 45000 * 0.8 + (subscriberRequestDto.getArea() - 50000) * 0.5);
				subscriberResponseDto.setCost(cost);
				subscriberResponseDto.setSubscription_id(subscriberRequestDto.getSubscriber_id());
				list.add(subscriberResponseDto);

			}
			subscriberResponse.setListSubscriberResponse(list);

		}
		return subscriberResponse;

	}

}
