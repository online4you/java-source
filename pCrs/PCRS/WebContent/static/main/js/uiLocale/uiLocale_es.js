$j().ready(function() {
		/* Inicializaci�n en espa�ol para la extensi�n 'UI date picker' para jQuery. */
		   $.datepicker.regional['es'] = {
		      closeText: 'Cerrar',
		      prevText: '<Ant',
		      nextText: 'Sig>',
		      currentText: 'Hoy',
		      monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
		      monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
		      dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi�rcoles', 'Jueves', 'Viernes', 'S�bado'],
		      dayNamesShort: ['Dom','Lun','Mar','Mi�','Juv','Vie','Sab'],
		      dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S�'],
		      weekHeader: 'Sm',
		      dateFormat: 'dd/mm/yy',
		      firstDay: 1,
		      isRTL: false,
		      showMonthAfterYear: false,
		      yearSuffix: ''};
		   $.datepicker.setDefaults($.datepicker.regional['es']);
	}); 