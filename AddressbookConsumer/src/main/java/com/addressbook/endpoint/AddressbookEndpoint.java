package com.addressbook.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.addressbook.service.AddressbookService;
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
public class AddressbookEndpoint {
	
private static final String NAMESPACE = "http://addressbook.com/contact";
	
	@Autowired
	AddressbookService service;
	
	@ResponsePayload
    @PayloadRoot(namespace = NAMESPACE, localPart = "getAllContactRequest")
    public GetAllContactResponse getAllContactDetails(@RequestPayload GetAllContactRequest request){
        return service.getAllContact(request);
    }
	
	@ResponsePayload
    @PayloadRoot(namespace = NAMESPACE, localPart = "getContactByIdRequest")
    public GetContactByIdResponse getContactDetailsById(@RequestPayload GetContactByIdRequest request){
        return service.getConatctById(request);
    }
	
	@ResponsePayload
    @PayloadRoot(namespace = NAMESPACE, localPart = "addContactRequest")
    public AddContactResponse addContactDetails(@RequestPayload AddContactRequest request){
        return service.addContact(request);
    }
	
	@ResponsePayload
    @PayloadRoot(namespace = NAMESPACE, localPart = "updateContactRequest")
    public UpdateContactResponse updateContactDetails(@RequestPayload UpdateContactRequest request){
        return service.updateContact(request);
    }

}
