package com.photel.interfaces.data.gen;

public interface ITrackingBusqueda {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  column="TB_SEQ"
	 */
	public abstract java.lang.String getTbSeq();

	/**
	 * Set the unique identifier of this class
	 * @param tbSeq the new ID
	 */
	public abstract void setTbSeq(java.lang.String tbSeq);

	/**
	 * Return the value associated with the column: TB_FECHA_ALTA
	 */
	public abstract java.util.Date getTbFechaAlta();

	/**
	 * Set the value related to the column: TB_FECHA_ALTA
	 * @param tbFechaAlta the TB_FECHA_ALTA value
	 */
	public abstract void setTbFechaAlta(java.util.Date tbFechaAlta);

	/**
	 * Return the value associated with the column: TB_IPCLIENTE
	 */
	public abstract java.lang.String getTbIpcliente();

	/**
	 * Set the value related to the column: TB_IPCLIENTE
	 * @param tbIpcliente the TB_IPCLIENTE value
	 */
	public abstract void setTbIpcliente(java.lang.String tbIpcliente);

	/**
	 * Return the value associated with the column: TB_HOSTNAME
	 */
	public abstract java.lang.String getTbHostname();

	/**
	 * Set the value related to the column: TB_HOSTNAME
	 * @param tbHostname the TB_HOSTNAME value
	 */
	public abstract void setTbHostname(java.lang.String tbHostname);

	/**
	 * Return the value associated with the column: TB_NAVEGADOR
	 */
	public abstract java.lang.String getTbNavegador();

	/**
	 * Set the value related to the column: TB_NAVEGADOR
	 * @param tbNavegador the TB_NAVEGADOR value
	 */
	public abstract void setTbNavegador(java.lang.String tbNavegador);

	/**
	 * Return the value associated with the column: TB_ACCION
	 */
	public abstract java.lang.String getTbAccion();

	/**
	 * Set the value related to the column: TB_ACCION
	 * @param tbAccion the TB_ACCION value
	 */
	public abstract void setTbAccion(java.lang.String tbAccion);

	/**
	 * Return the value associated with the column: TB_SITE
	 */
	public abstract java.lang.String getTbSite();

	/**
	 * Set the value related to the column: TB_SITE
	 * @param tbSite the TB_SITE value
	 */
	public abstract void setTbSite(java.lang.String tbSite);

	/**
	 * Return the value associated with the column: TB_HOT_IDPRC
	 */
	public abstract java.lang.String getTbHotIdprc();

	/**
	 * Set the value related to the column: TB_HOT_IDPRC
	 * @param tbHotIdprc the TB_HOT_IDPRC value
	 */
	public abstract void setTbHotIdprc(java.lang.String tbHotIdprc);

	/**
	 * Return the value associated with the column: TB_HOT_ZONA
	 */
	public abstract java.lang.String getTbHotZona();

	/**
	 * Set the value related to the column: TB_HOT_ZONA
	 * @param tbHotZona the TB_HOT_ZONA value
	 */
	public abstract void setTbHotZona(java.lang.String tbHotZona);

	/**
	 * Return the value associated with the column: TB_HOT_FECHAINICIO
	 */
	public abstract java.util.Date getTbHotFechainicio();

	/**
	 * Set the value related to the column: TB_HOT_FECHAINICIO
	 * @param tbHotFechainicio the TB_HOT_FECHAINICIO value
	 */
	public abstract void setTbHotFechainicio(java.util.Date tbHotFechainicio);

	/**
	 * Return the value associated with the column: TB_HOT_FECHAFIN
	 */
	public abstract java.util.Date getTbHotFechafin();

	/**
	 * Set the value related to the column: TB_HOT_FECHAFIN
	 * @param tbHotFechafin the TB_HOT_FECHAFIN value
	 */
	public abstract void setTbHotFechafin(java.util.Date tbHotFechafin);

	/**
	 * Return the value associated with the column: TB_HOT_ADULTOS
	 */
	public abstract java.lang.Integer getTbHotAdultos();

	/**
	 * Set the value related to the column: TB_HOT_ADULTOS
	 * @param tbHotAdultos the TB_HOT_ADULTOS value
	 */
	public abstract void setTbHotAdultos(java.lang.Integer tbHotAdultos);

	/**
	 * Return the value associated with the column: TB_HOT_NINOS
	 */
	public abstract java.lang.Integer getTbHotNinos();

	/**
	 * Set the value related to the column: TB_HOT_NINOS
	 * @param tbHotNinos the TB_HOT_NINOS value
	 */
	public abstract void setTbHotNinos(java.lang.Integer tbHotNinos);

	/**
	 * Return the value associated with the column: TB_HOT_BEBES
	 */
	public abstract java.lang.Integer getTbHotBebes();

	/**
	 * Set the value related to the column: TB_HOT_BEBES
	 * @param tbHotBebes the TB_HOT_BEBES value
	 */
	public abstract void setTbHotBebes(java.lang.Integer tbHotBebes);

	/**
	 * Return the value associated with the column: TB_HOT_CATEGORIA
	 */
	public abstract java.lang.String getTbHotCategoria();

	/**
	 * Set the value related to the column: TB_HOT_CATEGORIA
	 * @param tbHotCategoria the TB_HOT_CATEGORIA value
	 */
	public abstract void setTbHotCategoria(java.lang.String tbHotCategoria);

	/**
	 * Return the value associated with the column: TB_HOT_REGIMEN
	 */
	public abstract java.lang.String getTbHotRegimen();

	/**
	 * Set the value related to the column: TB_HOT_REGIMEN
	 * @param tbHotRegimen the TB_HOT_REGIMEN value
	 */
	public abstract void setTbHotRegimen(java.lang.String tbHotRegimen);

	/**
	 * Return the value associated with the column: TB_HOT_HABITACIONES
	 */
	public abstract java.lang.Integer getTbHotHabitaciones();

	/**
	 * Set the value related to the column: TB_HOT_HABITACIONES
	 * @param tbHotHabitaciones the TB_HOT_HABITACIONES value
	 */
	public abstract void setTbHotHabitaciones(
			java.lang.Integer tbHotHabitaciones);

	/**
	 * Return the value associated with the column: TB_VUE_IDPRC
	 */
	public abstract java.lang.String getTbVueIdprc();

	/**
	 * Set the value related to the column: TB_VUE_IDPRC
	 * @param tbVueIdprc the TB_VUE_IDPRC value
	 */
	public abstract void setTbVueIdprc(java.lang.String tbVueIdprc);

	/**
	 * Return the value associated with the column: TB_VUE_ZONA_ORIGEN
	 */
	public abstract java.lang.String getTbVueZonaOrigen();

	/**
	 * Set the value related to the column: TB_VUE_ZONA_ORIGEN
	 * @param tbVueZonaOrigen the TB_VUE_ZONA_ORIGEN value
	 */
	public abstract void setTbVueZonaOrigen(java.lang.String tbVueZonaOrigen);

	/**
	 * Return the value associated with the column: TB_VUE_ZONA_DESTINO
	 */
	public abstract java.lang.String getTbVueZonaDestino();

	/**
	 * Set the value related to the column: TB_VUE_ZONA_DESTINO
	 * @param tbVueZonaDestino the TB_VUE_ZONA_DESTINO value
	 */
	public abstract void setTbVueZonaDestino(java.lang.String tbVueZonaDestino);

	/**
	 * Return the value associated with the column: TB_VUE_FECHAINICIO
	 */
	public abstract java.util.Date getTbVueFechainicio();

	/**
	 * Set the value related to the column: TB_VUE_FECHAINICIO
	 * @param tbVueFechainicio the TB_VUE_FECHAINICIO value
	 */
	public abstract void setTbVueFechainicio(java.util.Date tbVueFechainicio);

	/**
	 * Return the value associated with the column: TB_VUE_FECHAFIN
	 */
	public abstract java.util.Date getTbVueFechafin();

	/**
	 * Set the value related to the column: TB_VUE_FECHAFIN
	 * @param tbVueFechafin the TB_VUE_FECHAFIN value
	 */
	public abstract void setTbVueFechafin(java.util.Date tbVueFechafin);

	/**
	 * Return the value associated with the column: TB_VUE_ADULTOS
	 */
	public abstract java.lang.Integer getTbVueAdultos();

	/**
	 * Set the value related to the column: TB_VUE_ADULTOS
	 * @param tbVueAdultos the TB_VUE_ADULTOS value
	 */
	public abstract void setTbVueAdultos(java.lang.Integer tbVueAdultos);

	/**
	 * Return the value associated with the column: TB_VUE_NINOS
	 */
	public abstract java.lang.Integer getTbVueNinos();

	/**
	 * Set the value related to the column: TB_VUE_NINOS
	 * @param tbVueNinos the TB_VUE_NINOS value
	 */
	public abstract void setTbVueNinos(java.lang.Integer tbVueNinos);

	/**
	 * Return the value associated with the column: TB_VUE_BEBES
	 */
	public abstract java.lang.Integer getTbVueBebes();

	/**
	 * Set the value related to the column: TB_VUE_BEBES
	 * @param tbVueBebes the TB_VUE_BEBES value
	 */
	public abstract void setTbVueBebes(java.lang.Integer tbVueBebes);

	/**
	 * Return the value associated with the column: TB_VUE_SOLOIDA
	 */
	public abstract java.lang.String getTbVueSoloida();

	/**
	 * Set the value related to the column: TB_VUE_SOLOIDA
	 * @param tbVueSoloida the TB_VUE_SOLOIDA value
	 */
	public abstract void setTbVueSoloida(java.lang.String tbVueSoloida);

	/**
	 * Return the value associated with the column: TB_VUE_COMPANIA
	 */
	public abstract java.lang.String getTbVueCompania();

	/**
	 * Set the value related to the column: TB_VUE_COMPANIA
	 * @param tbVueCompania the TB_VUE_COMPANIA value
	 */
	public abstract void setTbVueCompania(java.lang.String tbVueCompania);

	/**
	 * Return the value associated with the column: TB_VUE_SOLOVUESDIRECTOS
	 */
	public abstract java.lang.String getTbVueSolovuesdirectos();

	/**
	 * Set the value related to the column: TB_VUE_SOLOVUESDIRECTOS
	 * @param tbVueSolovuesdirectos the TB_VUE_SOLOVUESDIRECTOS value
	 */
	public abstract void setTbVueSolovuesdirectos(
			java.lang.String tbVueSolovuesdirectos);

	/**
	 * Return the value associated with the column: TB_COC_IDPRC
	 */
	public abstract java.lang.String getTbCocIdprc();

	/**
	 * Set the value related to the column: TB_COC_IDPRC
	 * @param tbCocIdprc the TB_COC_IDPRC value
	 */
	public abstract void setTbCocIdprc(java.lang.String tbCocIdprc);

	/**
	 * Return the value associated with the column: TB_COC_ZONA_ORIGEN
	 */
	public abstract java.lang.String getTbCocZonaOrigen();

	/**
	 * Set the value related to the column: TB_COC_ZONA_ORIGEN
	 * @param tbCocZonaOrigen the TB_COC_ZONA_ORIGEN value
	 */
	public abstract void setTbCocZonaOrigen(java.lang.String tbCocZonaOrigen);

	/**
	 * Return the value associated with the column: TB_COC_ZONA_DESTINO
	 */
	public abstract java.lang.String getTbCocZonaDestino();

	/**
	 * Set the value related to the column: TB_COC_ZONA_DESTINO
	 * @param tbCocZonaDestino the TB_COC_ZONA_DESTINO value
	 */
	public abstract void setTbCocZonaDestino(java.lang.String tbCocZonaDestino);

	/**
	 * Return the value associated with the column: TB_COC_FECHAINICIO
	 */
	public abstract java.util.Date getTbCocFechainicio();

	/**
	 * Set the value related to the column: TB_COC_FECHAINICIO
	 * @param tbCocFechainicio the TB_COC_FECHAINICIO value
	 */
	public abstract void setTbCocFechainicio(java.util.Date tbCocFechainicio);

	/**
	 * Return the value associated with the column: TB_COC_FECHAFIN
	 */
	public abstract java.util.Date getTbCocFechafin();

	/**
	 * Set the value related to the column: TB_COC_FECHAFIN
	 * @param tbCocFechafin the TB_COC_FECHAFIN value
	 */
	public abstract void setTbCocFechafin(java.util.Date tbCocFechafin);

	/**
	 * Return the value associated with the column: TB_COC_VEHICULO
	 */
	public abstract java.lang.String getTbCocVehiculo();

	/**
	 * Set the value related to the column: TB_COC_VEHICULO
	 * @param tbCocVehiculo the TB_COC_VEHICULO value
	 */
	public abstract void setTbCocVehiculo(java.lang.String tbCocVehiculo);

	/**
	 * Return the value associated with the column: TB_VAC_IDPRC
	 */
	public abstract java.lang.String getTbVacIdprc();

	/**
	 * Set the value related to the column: TB_VAC_IDPRC
	 * @param tbVacIdprc the TB_VAC_IDPRC value
	 */
	public abstract void setTbVacIdprc(java.lang.String tbVacIdprc);

	/**
	 * Return the value associated with the column: TB_VAC_ZONA_ORIGEN
	 */
	public abstract java.lang.String getTbVacZonaOrigen();

	/**
	 * Set the value related to the column: TB_VAC_ZONA_ORIGEN
	 * @param tbVacZonaOrigen the TB_VAC_ZONA_ORIGEN value
	 */
	public abstract void setTbVacZonaOrigen(java.lang.String tbVacZonaOrigen);

	/**
	 * Return the value associated with the column: TB_VAC_ZONA_DESTINO
	 */
	public abstract java.lang.String getTbVacZonaDestino();

	/**
	 * Set the value related to the column: TB_VAC_ZONA_DESTINO
	 * @param tbVacZonaDestino the TB_VAC_ZONA_DESTINO value
	 */
	public abstract void setTbVacZonaDestino(java.lang.String tbVacZonaDestino);

	/**
	 * Return the value associated with the column: TB_VAC_FECHAINICIO
	 */
	public abstract java.util.Date getTbVacFechainicio();

	/**
	 * Set the value related to the column: TB_VAC_FECHAINICIO
	 * @param tbVacFechainicio the TB_VAC_FECHAINICIO value
	 */
	public abstract void setTbVacFechainicio(java.util.Date tbVacFechainicio);

	/**
	 * Return the value associated with the column: TB_VAC_FECHAFIN
	 */
	public abstract java.util.Date getTbVacFechafin();

	/**
	 * Set the value related to the column: TB_VAC_FECHAFIN
	 * @param tbVacFechafin the TB_VAC_FECHAFIN value
	 */
	public abstract void setTbVacFechafin(java.util.Date tbVacFechafin);

	/**
	 * Return the value associated with the column: TB_VAC_ADULTOS
	 */
	public abstract java.lang.Integer getTbVacAdultos();

	/**
	 * Set the value related to the column: TB_VAC_ADULTOS
	 * @param tbVacAdultos the TB_VAC_ADULTOS value
	 */
	public abstract void setTbVacAdultos(java.lang.Integer tbVacAdultos);

	/**
	 * Return the value associated with the column: TB_VAC_NINOS
	 */
	public abstract java.lang.Integer getTbVacNinos();

	/**
	 * Set the value related to the column: TB_VAC_NINOS
	 * @param tbVacNinos the TB_VAC_NINOS value
	 */
	public abstract void setTbVacNinos(java.lang.Integer tbVacNinos);

	/**
	 * Return the value associated with the column: TB_VAC_BEBES
	 */
	public abstract java.lang.Integer getTbVacBebes();

	/**
	 * Set the value related to the column: TB_VAC_BEBES
	 * @param tbVacBebes the TB_VAC_BEBES value
	 */
	public abstract void setTbVacBebes(java.lang.Integer tbVacBebes);

	/**
	 * Return the value associated with the column: TB_VAC_CATEGORIA
	 */
	public abstract java.lang.String getTbVacCategoria();

	/**
	 * Set the value related to the column: TB_VAC_CATEGORIA
	 * @param tbVacCategoria the TB_VAC_CATEGORIA value
	 */
	public abstract void setTbVacCategoria(java.lang.String tbVacCategoria);

	/**
	 * Return the value associated with the column: TB_VAC_REGIMEN
	 */
	public abstract java.lang.String getTbVacRegimen();

	/**
	 * Set the value related to the column: TB_VAC_REGIMEN
	 * @param tbVacRegimen the TB_VAC_REGIMEN value
	 */
	public abstract void setTbVacRegimen(java.lang.String tbVacRegimen);

	/**
	 * Return the value associated with the column: TB_VAC_HABITACIONES
	 */
	public abstract java.lang.Integer getTbVacHabitaciones();

	/**
	 * Set the value related to the column: TB_VAC_HABITACIONES
	 * @param tbVacHabitaciones the TB_VAC_HABITACIONES value
	 */
	public abstract void setTbVacHabitaciones(
			java.lang.Integer tbVacHabitaciones);

	/**
	 * Return the value associated with the column: TB_ESP_TIPO
	 */
	public abstract java.lang.String getTbEspTipo();

	/**
	 * Set the value related to the column: TB_ESP_TIPO
	 * @param tbEspTipo the TB_ESP_TIPO value
	 */
	public abstract void setTbEspTipo(java.lang.String tbEspTipo);

	/**
	 * Return the value associated with the column: TB_ESP_EVENTO
	 */
	public abstract java.lang.String getTbEspEvento();

	/**
	 * Set the value related to the column: TB_ESP_EVENTO
	 * @param tbEspEvento the TB_ESP_EVENTO value
	 */
	public abstract void setTbEspEvento(java.lang.String tbEspEvento);

	/**
	 * Return the value associated with the column: TB_HOT_EDADNINOS
	 */
	public abstract java.lang.String getTbHotEdadninos();

	/**
	 * Set the value related to the column: TB_HOT_EDADNINOS
	 * @param tbHotEdadninos the TB_HOT_EDADNINOS value
	 */
	public abstract void setTbHotEdadninos(java.lang.String tbHotEdadninos);

	/**
	 * Return the value associated with the column: TB_VAC_EDADNINOS
	 */
	public abstract java.lang.String getTbVacEdadninos();

	/**
	 * Set the value related to the column: TB_VAC_EDADNINOS
	 * @param tbVacEdadninos the TB_VAC_EDADNINOS value
	 */
	public abstract void setTbVacEdadninos(java.lang.String tbVacEdadninos);

	/**
	 * Return the value associated with the column: TB_VAC_EDADBEBES
	 */
	public abstract java.lang.String getTbVacEdadbebes();

	/**
	 * Set the value related to the column: TB_VAC_EDADBEBES
	 * @param tbVacEdadbebes the TB_VAC_EDADBEBES value
	 */
	public abstract void setTbVacEdadbebes(java.lang.String tbVacEdadbebes);

	/**
	 * Return the value associated with the column: TB_VUE_HORAIDA
	 */
	public abstract java.lang.String getTbVueHoraida();

	/**
	 * Set the value related to the column: TB_VUE_HORAIDA
	 * @param tbVueHoraida the TB_VUE_HORAIDA value
	 */
	public abstract void setTbVueHoraida(java.lang.String tbVueHoraida);

	/**
	 * Return the value associated with the column: TB_VUE_HORAVUELTA
	 */
	public abstract java.lang.String getTbVueHoravuelta();

	/**
	 * Set the value related to the column: TB_VUE_HORAVUELTA
	 * @param tbVueHoravuelta the TB_VUE_HORAVUELTA value
	 */
	public abstract void setTbVueHoravuelta(java.lang.String tbVueHoravuelta);

	/**
	 * Return the value associated with the column: TB_VAC_CODTPR
	 */
	public abstract java.lang.String getTbVacCodtpr();

	/**
	 * Set the value related to the column: TB_VAC_CODTPR
	 * @param tbVacCodtpr the TB_VAC_CODTPR value
	 */
	public abstract void setTbVacCodtpr(java.lang.String tbVacCodtpr);

	/**
	 * Return the value associated with the column: TB_ID_USUARIO_MAQUINA
	 */
	public abstract java.lang.String getTbIdUsuarioMaquina();

	/**
	 * Set the value related to the column: TB_ID_USUARIO_MAQUINA
	 * @param tbIdUsuarioMaquina the TB_ID_USUARIO_MAQUINA value
	 */
	public abstract void setTbIdUsuarioMaquina(
			java.lang.String tbIdUsuarioMaquina);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}