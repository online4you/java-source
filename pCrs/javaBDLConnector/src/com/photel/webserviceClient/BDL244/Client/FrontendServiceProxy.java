package com.photel.webserviceClient.BDL244.Client;

public class FrontendServiceProxy implements FrontendService {
  private String _endpoint = null;
  private FrontendService frontendService = null;
  
  public FrontendServiceProxy() {
    _initFrontendServiceProxy();
  }
  
  public FrontendServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initFrontendServiceProxy();
  }
  
  private void _initFrontendServiceProxy() {
    try {
      frontendService = (new FrontendServiceServiceLocator()).getFrontendService();
      if (frontendService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)frontendService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)frontendService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (frontendService != null)
      ((javax.xml.rpc.Stub)frontendService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public FrontendService getFrontendService() {
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService;
  }
  
  public java.lang.Object cancelProtectionAdd(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.cancelProtectionAdd(part);
  }
  
  public java.lang.Object cancelProtectionRemove(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.cancelProtectionRemove(part);
  }
  
  public java.lang.Object getCarCountryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getCarCountryList(part);
  }
  
  public java.lang.Object getCarInfoSet(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getCarInfoSet(part);
  }
  
  public java.lang.Object getCarValuedAvail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getCarValuedAvail(part);
  }
  
  public java.lang.Object getCountryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getCountryList(part);
  }
  
  public java.lang.Object getDestinationGroupList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getDestinationGroupList(part);
  }
  
  public java.lang.Object getHotelBoardGroupList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelBoardGroupList(part);
  }
  
  public java.lang.Object getHotelBoardList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelBoardList(part);
  }
  
  public java.lang.Object getHotelCategoryGroupList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelCategoryGroupList(part);
  }
  
  public java.lang.Object getHotelCategoryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelCategoryList(part);
  }
  
  public java.lang.Object getHotelCountryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelCountryList(part);
  }
  
  public java.lang.Object getHotelDetail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelDetail(part);
  }
  
  public java.lang.Object getHotelList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelList(part);
  }
  
  public java.lang.Object getHotelRoomTypeGroupList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelRoomTypeGroupList(part);
  }
  
  public java.lang.Object getHotelValuedAvail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getHotelValuedAvail(part);
  }
  
  public java.lang.Object getIncomingOfficeDetail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getIncomingOfficeDetail(part);
  }
  
  public java.lang.Object getIncomingOfficeList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getIncomingOfficeList(part);
  }
  
  public java.lang.Object getInsuranceValuedAvail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getInsuranceValuedAvail(part);
  }
  
  public java.lang.Object purchaseCancel(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.purchaseCancel(part);
  }
  
  public java.lang.Object purchaseConfirm(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.purchaseConfirm(part);
  }
  
  public java.lang.Object getPurchaseDetail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getPurchaseDetail(part);
  }
  
  public java.lang.Object purchaseFlush(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.purchaseFlush(part);
  }
  
  public java.lang.Object getPurchaseList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getPurchaseList(part);
  }
  
  public java.lang.Object serviceAdd(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.serviceAdd(part);
  }
  
  public java.lang.Object serviceRemove(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.serviceRemove(part);
  }
  
  public java.lang.Object getTicketAvail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTicketAvail(part);
  }
  
  public java.lang.Object getTicketClassificationList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTicketClassificationList(part);
  }
  
  public java.lang.Object getTicketCountryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTicketCountryList(part);
  }
  
  public java.lang.Object getTicketDetail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTicketDetail(part);
  }
  
  public java.lang.Object getTicketValuation(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTicketValuation(part);
  }
  
  public java.lang.Object getTransferCountryList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTransferCountryList(part);
  }
  
  public java.lang.Object getTransferValuedAvail(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getTransferValuedAvail(part);
  }
  
  public java.lang.Object getZoneGroupList(java.lang.Object part) throws java.rmi.RemoteException{
    if (frontendService == null)
      _initFrontendServiceProxy();
    return frontendService.getZoneGroupList(part);
  }
  
  
}