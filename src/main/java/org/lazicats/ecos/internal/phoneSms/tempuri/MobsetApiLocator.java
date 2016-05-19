/**
 * MobsetApiLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.lazicats.ecos.internal.phoneSms.tempuri;

import java.rmi.Remote;

public class MobsetApiLocator extends org.apache.axis.client.Service implements org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApi {

    public MobsetApiLocator() {
    }


    public MobsetApiLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MobsetApiLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MobsetApiSoap
    private java.lang.String MobsetApiSoap_address = "http://sms.mobset.com:8080/Api";

    public java.lang.String getMobsetApiSoapAddress() {
        return MobsetApiSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MobsetApiSoapWSDDServiceName = "MobsetApiSoap";

    public java.lang.String getMobsetApiSoapWSDDServiceName() {
        return MobsetApiSoapWSDDServiceName;
    }

    public void setMobsetApiSoapWSDDServiceName(java.lang.String name) {
        MobsetApiSoapWSDDServiceName = name;
    }

    public org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoap getMobsetApiSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MobsetApiSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMobsetApiSoap(endpoint);
    }

    public org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoap getMobsetApiSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoapStub _stub = new org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoapStub(portAddress, this);
            _stub.setPortName(getMobsetApiSoapWSDDServiceName());
            return (MobsetApiSoap) _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMobsetApiSoapEndpointAddress(java.lang.String address) {
        MobsetApiSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoapStub _stub = new org.lazicats.ecos.internal.phoneSms.tempuri.MobsetApiSoapStub(new java.net.URL(MobsetApiSoap_address), this);
                _stub.setPortName(getMobsetApiSoapWSDDServiceName());
                return (Remote) _stub;
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
        if ("MobsetApiSoap".equals(inputPortName)) {
            return getMobsetApiSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "MobsetApi");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "MobsetApiSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MobsetApiSoap".equals(portName)) {
            setMobsetApiSoapEndpointAddress(address);
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
