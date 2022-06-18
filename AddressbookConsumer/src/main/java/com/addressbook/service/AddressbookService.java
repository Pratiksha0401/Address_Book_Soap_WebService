package com.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.addressbook.wsdlClasses.AddContactRequest;
import com.addressbook.wsdlClasses.AddContactResponse;
import com.addressbook.wsdlClasses.DeleteContactRequest;
import com.addressbook.wsdlClasses.DeleteContactResponse;
import com.addressbook.wsdlClasses.GetAllContactRequest;
import com.addressbook.wsdlClasses.GetAllContactResponse;
import com.addressbook.wsdlClasses.GetContactByIdRequest;
import com.addressbook.wsdlClasses.GetContactByIdResponse;
import com.addressbook.wsdlClasses.UpdateContactRequest;
import com.addressbook.wsdlClasses.UpdateContactResponse;

@Service
public class AddressbookService {
	
	private static final String SERVICE_URL = "http://localhost:8080/ws";

	@Autowired
	Jaxb2Marshaller marshaller;

	WebServiceTemplate template;
	
	public GetAllContactResponse getAllContact(GetAllContactRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (GetAllContactResponse) template.marshalSendAndReceive(SERVICE_URL, request);
	}

	public GetContactByIdResponse getConatctById(GetContactByIdRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (GetContactByIdResponse) template.marshalSendAndReceive(SERVICE_URL, request);
	}

	public AddContactResponse addContact(AddContactRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (AddContactResponse) template.marshalSendAndReceive(SERVICE_URL, request);
	}
	
	public DeleteContactResponse deleteContact(DeleteContactRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (DeleteContactResponse) template.marshalSendAndReceive(SERVICE_URL, request);
	}
	
	public UpdateContactResponse updateContact(UpdateContactRequest request) {
		template = new WebServiceTemplate(marshaller);
		return (UpdateContactResponse) template.marshalSendAndReceive(SERVICE_URL, request);
	}

}
