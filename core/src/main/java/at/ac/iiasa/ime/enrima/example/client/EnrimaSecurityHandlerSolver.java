package at.ac.iiasa.ime.enrima.example.client;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class EnrimaSecurityHandlerSolver implements
		SOAPHandler<SOAPMessageContext> {

	private String username;
	private String password;

	public Set<QName> getHeaders() {
		return new TreeSet();
	}

	public EnrimaSecurityHandlerSolver(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (outboundProperty.booleanValue()) {
			try {
				SOAPEnvelope envelope = context.getMessage().getSOAPPart()
						.getEnvelope();
				SOAPFactory factory = SOAPFactory.newInstance();
				String prefix = "sec";
				String uri = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
				SOAPElement securityElem = factory.createElement("Security",
						prefix, uri);
				SOAPElement tokenElem = factory.createElement("UsernameToken",
						prefix, uri);
				SOAPElement userName = factory.createElement("Username",
						prefix, uri);
				userName.addTextNode(this.username);
				SOAPElement password = factory.createElement("Password",
						prefix, uri);
				password.addTextNode(this.password);
				tokenElem.addChildElement(userName);
				tokenElem.addChildElement(password);
				securityElem.addChildElement(tokenElem);
				SOAPHeader header = envelope.addHeader();
				header.addChildElement(securityElem);

			} catch (Exception e) {
				System.out.println("Exception in handler: " + e);
			}
		} else {
			// inbound
		}
		return true;
	}

	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
		//
	}

}
