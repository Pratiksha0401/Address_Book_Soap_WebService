package stepDefinations;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.hamcrest.MatcherAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressbookSteps {

	HttpClient client = HttpClient.newHttpClient();
	HttpResponse<String> httpResponse;
	final String BASE_URI = "http://localhost:8080/ws";
	HttpRequest request;

	@When("Get contact from database whose id is {int}")
	public void get_contact_from_database_whose_id_is(Integer id) {
		String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://addressbook.com/contact\">\r\n"
							+ "   <soapenv:Header/>\r\n" 
							+ "   <soapenv:Body>\r\n" 
							+ "      <con:getContactByIdRequest>\r\n"
							+ "         <con:id>"+id+"</con:id>\r\n" 
							+ "      </con:getContactByIdRequest>\r\n"
							+ "   </soapenv:Body>\r\n" 
							+ "</soapenv:Envelope>";

		request = HttpRequest.newBuilder().uri(URI.create(BASE_URI))
				.header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response===:::===" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("Return success message with status code {int}")
	public void return_success_message_with_status_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		//System.out.println("sattuscode=="+currentHttpStatusCode);
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}
	
	@When("Get All contacts from addressbook")
	public void get_all_contacts_from_addressbook() {
	    String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://addressbook.com/contact\">\r\n"
	    		+ "   <soapenv:Header/>\r\n"
	    		+ "   <soapenv:Body>\r\n"
	    		+ "      <con:getAllContactRequest/>\r\n"
	    		+ "   </soapenv:Body>\r\n"
	    		+ "</soapenv:Envelope>";
	    
	    request = HttpRequest.newBuilder().uri(URI.create(BASE_URI))
				.header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response===:::===" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Return Success with status code {int}")
	public void return_success_with_status_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		//System.out.println("sattuscode=="+currentHttpStatusCode);
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}
	
	@When("Add contact with {string},{string},{string},{string},{string},{int}")
	public void add_contact_with(String name, String city, 
								 String state, String address, String phonenumber, Integer zipcode) {
	    String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://addressbook.com/contact\">\r\n"
	    		+ "   <soapenv:Header/>\r\n"
	    		+ "   <soapenv:Body>\r\n"
	    		+ "      <con:addContactRequest>\r\n"
	    		+ "         <con:contactInfoWithoutId>\r\n"
	    		+ "            <con:name>"+name+"</con:name>\r\n"
	    		+ "            <con:address>"+address+"</con:address>\r\n"
	    		+ "            <con:city>"+city+"</con:city>\r\n"
	    		+ "            <con:state>"+state+"</con:state>\r\n"
	    		+ "            <con:zipcode>"+zipcode+"</con:zipcode>\r\n"
	    		+ "            <con:phonenumber>"+phonenumber+"</con:phonenumber>\r\n"
	    		+ "         </con:contactInfoWithoutId>\r\n"
	    		+ "      </con:addContactRequest>\r\n"
	    		+ "   </soapenv:Body>\r\n"
	    		+ "</soapenv:Envelope>";
	    
	    request = HttpRequest.newBuilder().uri(URI.create(BASE_URI))
				.header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response===:::===" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Return success message with staus code {int}")
	public void return_success_message_with_staus_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		System.out.println("sattuscode=="+currentHttpStatusCode);
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}
	
	@When("Delete contact  by id {int}")
	public void delete_contact_by_id(Integer id) {
		String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://addressbook.com/contact\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <con:deleteContactRequest>\r\n"
				+ "         <con:id>"+id+"</con:id>\r\n"
				+ "      </con:deleteContactRequest>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		

	    request = HttpRequest.newBuilder().uri(URI.create(BASE_URI))
				.header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response===:::===" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Return sucess with status code {int}")
	public void return_sucess_with_status_code(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		System.out.println("sattuscode=="+currentHttpStatusCode);
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}
	
	@When("Wants to update contact with {int},{string},{string},{string},{string},{string},{int}")
	public void wants_to_update_contact_with(Integer id, String name, String city, 
											String state, String address, String phonenumber, Integer zipcode) {
		String requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://addressbook.com/contact\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <con:updateContactRequest>\r\n"
				+ "         <con:contactInfo>\r\n"
				+ "            <con:id>"+id+"</con:id>\r\n"
				+ "            <con:name>"+name+"</con:name>\r\n"
				+ "            <con:address>"+address+"</con:address>\r\n"
				+ "            <con:city>"+city+"</con:city>\r\n"
				+ "            <con:state>"+state+"</con:state>\r\n"
				+ "            <con:zipcode>"+zipcode+"</con:zipcode>\r\n"
				+ "            <con:phonenumber>"+phonenumber+"</con:phonenumber>\r\n"
				+ "         </con:contactInfo>\r\n"
				+ "      </con:updateContactRequest>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		request = HttpRequest.newBuilder().uri(URI.create(BASE_URI))
				.header("Content-Type", "text/xml")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		try {
			httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Response===:::===" + httpResponse.body());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Return success with status code1 {int}")
	public void return_success_with_status_code1(Integer statusCode) {
		final int currentHttpStatusCode = httpResponse.statusCode();
		System.out.println("sattuscode=="+currentHttpStatusCode);
		MatcherAssert.assertThat("The status code is incorrect", currentHttpStatusCode == statusCode);
	}

}
