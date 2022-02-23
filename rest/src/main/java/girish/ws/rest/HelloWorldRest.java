package girish.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import girish.ws.rest.beans.Hello;



// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class HelloWorldRest {

 @GET
 @Path("/{param}/")
 public String getMsg(@PathParam("param") String msg) {

  String output = "Jersey say : " + msg;

  return output;

 }
 @GET
 @Path("/world")
 public String getFixedMsg(String msg) {

  String output = "Jersey say : fixed path" + msg;

  return output;

 }
 // This method is called if TEXT_PLAIN is request
 @GET
 //@Path("helloworld")
 @Produces(MediaType.TEXT_PLAIN)
 public String sayPlainTextHello() {
  System.out.println("sayPlain");
  return "Hello Jersey";
 }

 // This method is called if XML is request
 @GET
 //@Path("helloworld")
 @Produces(MediaType.TEXT_XML)
 public String sayXMLHello() {
  System.out.println("sayXML");
  return "" + " Hello Jersey" + "";
 }

 // This method is called if HTML is request
 @GET
 //@Path("helloworld")
 @Produces(MediaType.TEXT_HTML)
 public String sayHtmlHello() {
  System.out.println("sayHTML");
  return "<html> " + "<title>" + "Hello Jersey" + "</title>"
    + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
 }

 // This method is called if JSON is request
 @GET
 @Path("helloworld")
 @Produces(MediaType.APPLICATION_JSON)
 public Hello sayJsonHello() {
  return new Hello("Hello", "Jersey");
 }
 
 // This method is called if JSON is request
 @GET
 @Path("hellojersey")
 @Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_HTML})
 public Hello sayJsonOrXMLHello() {
  return new Hello("Hello", "Jersey");
 }

 @POST
 @Produces(MediaType.APPLICATION_JSON)
 public Hello createHello(Hello hello)
 {
  System.out.println("post");
  return hello;
 }

}