package com.provigil.cost.resource.marshal.unmarshal;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
@Consumes(MediaType.APPLICATION_XML)
@Provider
public class ProvigilJaxBMessageBodyReader implements MessageBodyReader<Object> {

	@Override
	public boolean isReadable(Class<?> classType, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		if(classType.isAnnotationPresent(XmlRootElement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> classType, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		
		Object object=null;
		
		try {
			JAXBContext jaxbContext=JAXBContext.newInstance(classType);
			Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
			object=unmarshaller.unmarshal(entityStream);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

}
