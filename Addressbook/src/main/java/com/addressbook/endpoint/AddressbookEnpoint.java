package com.addressbook.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.addressbook.service.IAddessbookService;
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

@Endpoint
public class AddressbookEnpoint {

	public static final String NAMESPACE_URI = "http://addressbook.com/contact";

	@Autowired
	IAddessbookService bookService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addContactRequest")
	@ResponsePayload
	public AddContactResponse addContact(@RequestPayload AddContactRequest request) {
		AddContactResponse response = new AddContactResponse();
		response = bookService.addContact(request);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContactByIdRequest")
	@ResponsePayload
	public GetContactByIdResponse getContactById(@RequestPayload GetContactByIdRequest request) {
		return bookService.getContactById(request);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllContactRequest")
	@ResponsePayload
	public GetAllContactResponse getAllConatct(@RequestPayload GetAllContactRequest request) {
		return  bookService.getAllContact(request);	
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteContactRequest")
	@ResponsePayload
	public DeleteContactResponse deleteContact(@RequestPayload DeleteContactRequest request) {
		return bookService.deleteContact(request);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateContactRequest")
	@ResponsePayload
	public UpdateContactResponse updateEmployee(@RequestPayload UpdateContactRequest request) {
		return bookService.updateContact(request);
	}

}
