package stepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.addressbook.wsdlClasses.AddContactRequest;
import com.addressbook.wsdlClasses.AddContactResponse;
import com.addressbook.wsdlClasses.ContactInfo;
import com.addressbook.wsdlClasses.ContactInfoWithoutId;
import com.addressbook.wsdlClasses.DeleteContactRequest;
import com.addressbook.wsdlClasses.DeleteContactResponse;
import com.addressbook.wsdlClasses.GetAllContactRequest;
import com.addressbook.wsdlClasses.GetAllContactResponse;
import com.addressbook.wsdlClasses.GetContactByIdRequest;
import com.addressbook.wsdlClasses.GetContactByIdResponse;
import com.addressbook.wsdlClasses.UpdateContactRequest;
import com.addressbook.wsdlClasses.UpdateContactResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressbookStepsDefs {
	
	private static final String SERVICE_URL = "http://localhost:8080/ws";
	
	@Autowired
	Jaxb2Marshaller marshaller; 
	
	WebServiceTemplate template;
	
	GetContactByIdResponse response;
	GetAllContactResponse getAllContactResponse;
	AddContactResponse addContactResponse;
	DeleteContactResponse deleteContactResponse; 
	UpdateContactResponse updateContactResponse;
	String status;
	
	@When("Get contact by {int}")
	public void get_contact_by(Integer id) {
		GetContactByIdRequest request= new GetContactByIdRequest();
		request.setId(id);
	    template = new WebServiceTemplate(marshaller);
	    response= (GetContactByIdResponse)template.marshalSendAndReceive(
				SERVICE_URL , request);
	    status=response.getServiceStatus().getMessage();
	}

	@Then("Return success message")
	public void return_success_message() {
		assertEquals("Got conatct by Id", status);
	}
	
	@When("Get All contacts")
	public void get_all_contacts() {
		GetAllContactRequest request= new GetAllContactRequest();
	    template = new WebServiceTemplate(marshaller);
	    getAllContactResponse= (GetAllContactResponse)template.marshalSendAndReceive(
	    		SERVICE_URL	 , request);
	    status=getAllContactResponse.getServiceStatus().getMessage(); 
	}

	@Then("Return Success message")
	public void return_success_message_GetAllContacts() {
		assertEquals("Success", status);
	}
	
	@When("user wants to add contact with {string},{string},{string},{string},{string},{int}")
	public void user_wants_to_add_contact_with(String name, String city, 
												String state, String address, String phonenumber, Integer zipcode) {
		AddContactRequest request= new AddContactRequest();
		ContactInfoWithoutId info = new ContactInfoWithoutId();
		info.setName(name);
		info.setCity(city);
		info.setState(state);
		info.setAddress(address);
		info.setPhonenumber(phonenumber);
		info.setZipcode(zipcode);
		request.setContactInfoWithoutId(info);
	    template = new WebServiceTemplate(marshaller);
	    addContactResponse= (AddContactResponse)template.marshalSendAndReceive(
				SERVICE_URL , request);
	    status=addContactResponse.getServiceStatus().getMessage();
	}

	@Then("Return success message as Employee Created successfully")
	public void return_success_message_as_employee_created_successfully() {
		assertEquals("Employee Added Successfully", status);
	}
	
	@When("Get contact  by id {int}")
	public void get_contact_by_id(Integer id) {
		DeleteContactRequest request= new DeleteContactRequest();
		request.setId(id);
	    template = new WebServiceTemplate(marshaller);
	    deleteContactResponse= (DeleteContactResponse)template.marshalSendAndReceive(
				SERVICE_URL , request);
	    status=deleteContactResponse.getServiceStatus().getMessage(); 
	}

	@Then("Return message {string}")
	public void return_message(String message) {
		assertEquals(message, status);
	}
	
	@When("user wants to add contact with {int},{string},{string},{string},{string},{string},{int}")
	public void user_wants_to_add_contact_with(Integer id, String name, String city, 
			String state, String address, String phonenumber, Integer zipcode) {
		UpdateContactRequest request= new UpdateContactRequest();
		ContactInfo info = new ContactInfo();
		info.setId(id);
		info.setName(name);
		info.setCity(city);
		info.setState(state);
		info.setAddress(address);
		info.setPhonenumber(phonenumber);
		info.setZipcode(zipcode);
		request.setContactInfo(info);
	    template = new WebServiceTemplate(marshaller);
	    updateContactResponse= (UpdateContactResponse)template.marshalSendAndReceive(
				SERVICE_URL , request);
	    status=updateContactResponse.getServiceStatus().getMessage(); 
	}

	@Then("Return success message as {string}")
	public void return_success_message_as(String message) {
		assertEquals(message, status);
	}
	
	@When("wants to add contact with {string},{string},{string},{string},{string},{int}")
	public void wants_to_add_contact_with(String name, String city, 
											String state, String address, String phonenumber, Integer zipcode) {
		AddContactRequest request= new AddContactRequest();
		ContactInfoWithoutId info = new ContactInfoWithoutId();
		info.setName(name);
		info.setCity(city);
		info.setState(state);
		info.setAddress(address);
		info.setPhonenumber(phonenumber);
		info.setZipcode(zipcode);
		request.setContactInfoWithoutId(info);
	    template = new WebServiceTemplate(marshaller);
	    addContactResponse= (AddContactResponse)template.marshalSendAndReceive(
				SERVICE_URL , request);
	    status=addContactResponse.getServiceStatus().getMessage();
	}

	@Then("Return success message {string}")
	public void return_success_message(String message) {
		assertEquals(message, status);
	}

}
