package com.provigil.cost.resource.marshal.unmarshal;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
@Provider
@Produces(MediaType.APPLICATION_XML)
public class ProvigilJaxBMessageBodyWritter implements MessageBodyWriter<Object> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		if (type.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(object, entityStream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException();
		}
	}

}
