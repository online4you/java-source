package com.photel.interfaces.BDL244;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHimages;


public interface IBDLHotel {

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract String getServicioCodigo();

	public abstract void setServicioCodigo(String servicioCodigo);

	public abstract String getServicio();

	public abstract void setServicio(String servicio);

	public abstract String getProducto();

	public abstract void setProducto(String producto);

	public abstract String getZona();

	public abstract void setZona(String zona);

	public abstract String getZonaCodigo();

	public abstract void setZonaCodigo(String zonaCodigo);

	public abstract String getCategoria();

	public abstract void setCategoria(String categoria);

	public abstract String getCategoriaCodigo();

	public abstract void setCategoriaCodigo(String categoriaCodigo);

	public abstract List<IBDLContrato> getContratos();

	public abstract void setContratos(List<IBDLContrato> contratos);

	public abstract String getLatitud();

	public abstract void setLatitud(String latitud);

	public abstract String getLongitud();

	public abstract void setLongitud(String longitud);

	public abstract List<String> getImagenes();

	public abstract void setImagenes(List<String> imagenes);
	
	public BigDecimal getPrecioMin() ;

	public void setPrecioMin(BigDecimal precioMin);

	public BigDecimal getPrecioMax();

	public void setPrecioMax(BigDecimal precioMax);
	
	public String getDescripcion();

	public void setDescripcion(String descripcion);
	
	public String getAvailToken();

	public void setAvailToken(String availToken);

	public IBDLPurchase getPurchase();

	public void setPurchase(IBDLPurchase purchase);
	
	public String getSPUI() ;

	public void setSPUI(String sPUI);

	public String getLocalidad();

	public void setLocalidad(String localidad) ;

	public String getPais();

	public void setPais(String pais);

	public String getLocalidadCodigo();



	public void setLocalidadCodigo(String localidadCodigo);

	public String getPaisCodigo() ;



	public void setPaisCodigo(String paisCodigo);
	

	public GregorianCalendar getAvailTimeStamp();
	public void setAvailTimeStamp(GregorianCalendar availTimeStamp) ;
	
	public Hashtable<String, IBdlHdetailDescriptions> getDescriptions();
	public void setDescriptions(Hashtable<String, IBdlHdetailDescriptions> descriptions) ;
	public IBdlHdetailDescriptions getDescription(String languageCode) ;
	public void setDescription(String languageCode, IBdlHdetailDescriptions description) ;
	
	public void setFacilities(Hashtable<String, ArrayList<IBdlvHdetailFacilities>> facilities);

	public Hashtable<String, ArrayList<IBdlvHdetailFacilities>> getFacilities() ;
	
	public Hashtable<String, ArrayList<IBdlvHimages>> getImagesMap();

	public void setImagesMap(Hashtable<String, ArrayList<IBdlvHimages>> imagesMap) ;

	public ArrayList<IBdlvHimages> getImagesList() ;

	public void setImagesList(ArrayList<IBdlvHimages> imagesList);
	public String getDestino();

	public void setDestino(String destino);

	public String getDestinoCodigo();

	public void setDestinoCodigo(String destinoCodigo);
	
	public String getCadena();

	public void setCadena(String cadena);

	public String getCadenaCodigo();
	
	public void setCadenaCodigo(String cadenaCodigo);
	
}