package wsminorsaffairs.utilities;




import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import weblogic.xml.saaj.util.IOUtils;

public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {
    
    private static final Logger LOGGER = Logger.getLogger(LoggingHandler.class.getName());
    @Override
    public void close(MessageContext messageContext) {
        // TODO Implement this method
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outbound) {
         
         LOGGER.info("SOAP Inbound Request!!!!!");
            Map<String, List<String>> responseHeaders = (Map<String, List<String>>) context
                    .get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
            try {
             
                String username = (String) context.get(BindingProvider.USERNAME_PROPERTY) ;
                String password = (String) context.get(BindingProvider.PASSWORD_PROPERTY) ;
                String url = (String) context.get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY) ;
                //remote id
                HttpServletRequest req = (HttpServletRequest)context.get(MessageContext.SERVLET_REQUEST); 
                LOGGER.info("Remote Client IP = " + req.getRemoteAddr()); 
                String body = getBody(context.getMessage());
                
                LOGGER.info(body);
               // System.out.println(body);
            } catch (Exception ex) {
                // TODO: What do I have to do in this case?
            }
        } else {
            LOGGER.info("SOAP Outbound Response !!!!!");
            //System.out.println("SOAP Inbound Response !!!!!");
            Map<String, List<String>> requestHeaders = (Map<String, List<String>>) context
                    .get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
            try {
               /*  String headers = getHeaders(requestHeaders);
              System.out.println(headers); */
        
                String body = getBody(context.getMessage());
                LOGGER.info(body);
            } catch (Exception ex) {
                // TODO: What do I have to do in this case?
            }
        }
        return true;
    }

    @Override
    public Set<QName> getHeaders() {
        // TODO Implement this method
        return Collections.emptySet();
    }

    @Override
    public boolean handleFault(SOAPMessageContext sOAPMessageContext) {
        // TODO Implement this method
        return false;
    }

    private String getBody(SOAPMessage message) throws SOAPException, IOException {
        OutputStream stream = new ByteArrayOutputStream();
        message.writeTo(stream);
        return stream.toString();
    }

    public String getFullHttpRequest(HttpServletRequest request) throws IOException {
        InputStream in = request.getInputStream();
        String encoding = request.getCharacterEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String body = IOUtils.toString(in, encoding);
        return body;
    }

    private String getHeaders(Map<String, List<String>> headers) throws IOException {
        StringBuffer result = new StringBuffer();
        if (headers != null) {
          //  Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            for (Map.Entry<String, List<String>> header : headers.entrySet()) {
                if (header.getValue().isEmpty()) {
                    // I don't think this is legal, but let's just dump it,
                    // as the point of the dump is to uncover problems.
                    result.append(header.getValue());
                } else {
                    for (String value : header.getValue()) {
                        result.append(header.getKey() + ": " + value);
                    }
                }
                result.append("\n");
            }
        }
        return result.toString();
    }

}