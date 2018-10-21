/**
 * FrontendServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.photel.webserviceClient.BDL244.Client;

public class FrontendServiceServiceLocator extends org.apache.axis.client.Service implements FrontendServiceService {

    public FrontendServiceServiceLocator() {
    }


    public FrontendServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FrontendServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FrontendService
    private java.lang.String FrontendService_address = "http://212.170.239.71/appservices/ws/FrontendService";

    public java.lang.String getFrontendServiceAddress() {
        return FrontendService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FrontendServiceWSDDServiceName = "FrontendService";

    public java.lang.String getFrontendServiceWSDDServiceName() {
        return FrontendServiceWSDDServiceName;
    }

    public void setFrontendServiceWSDDServiceName(java.lang.String name) {
        FrontendServiceWSDDServiceName = name;
    }

    public FrontendService getFrontendService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FrontendService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFrontendService(endpoint);
    }

    public FrontendService getFrontendService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            FrontendServiceSoapBindingStub _stub = new FrontendServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getFrontendServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFrontendServiceEndpointAddress(java.lang.String address) {
        FrontendService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (FrontendService.class.isAssignableFrom(serviceEndpointInterface)) {
                FrontendServiceSoapBindingStub _stub = new FrontendServiceSoapBindingStub(new java.net.URL(FrontendService_address), this);
                _stub.setPortName(getFrontendServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FrontendService".equals(inputPortName)) {
            return getFrontendService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.hotelbeds.com/wsdl/2005/06", "FrontendServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.hotelbeds.com/wsdl/2005/06", "FrontendService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FrontendService".equals(portName)) {
            setFrontendServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
