var $j=jQuery;

	jQuery(function ($) {
		$j('[tipo=modal]').click(function (e) {
			e.preventDefault();

			// example of calling the confirm function
			// you must use a callback function to perform the "yes" action
			confirm("Continue to the SimpleModal Project page?", function () {
				window.location.href = 'http://www.ericmmartin.com/projects/simplemodal/';
			});
		});
	});

	function confirm(message) {
		$j('#confirm').modal({
			
			closeHTML: "<a class='cerrar' title='close' href='#'></a>",
			opacity:80,
			minWidth:400,
			minHeight:143,
			overlayCss: {backgroundColor:"#fff"},
			overlayId: 'confirm-overlay',
			containerId: 'confirm-container', 
			onShow: function (dialog) {
				var modal = this;
				$j('.message', dialog.data[0]).append(message);
			}
		});
	}

	//si input text y los text area value a mayusculas  si en su name existe mail entoces minusculas
	//$('input[type=text],textarea').keyup( function(){ var g = $(this).attr('value'); var n= ($(this).attr("name").indexOf("mail")!=-1 || $(this).attr("name").indexOf("provincia")!=-1 || $(this).attr("name").indexOf("destino")!=-1)?g.toLowerCase():g.toUpperCase(); $(this).attr('value',n); });
	$j('input[type=text],textarea').live('keyup', function(){var g = $j(this).attr('value');var n= ($j(this).attr("name").indexOf("mail")!=-1)?g.toLowerCase():($j(this).attr("name").indexOf("provincia")!=-1 || $j(this).attr("name").indexOf("destino")!=-1)?strCapitalize(g):g.toUpperCase();$j(this).attr('value',n); });
	$j('input[filtro=numerico]').live('keypress',function(e){var a=/[0-9]/;if(!a.test(String.fromCharCode(e.which)) && e.which!=8 && e.which!=0){return false;}return String.fromCharCode(e.which);});


function strCapitalize(string){
	  return string.substr(0,1).toUpperCase()+string.substr(1,string.length).toLowerCase();
	}

function hideCargando(idCapa) {
	$j('#'+idCapa).hide();
	$j('#nombreProveedor').cycle({fx:'fade',speed:'800',timeout: 1000});
	$j('#main').show();
}
function showCargando(idCapa) {
	$j('#'+idCapa).show();
	$j('#main').hide();
	$j('#nombreProveedor').cycle('stop');
	$j('#'+idCapa).css('zIndex',5000);
}
function rellenaLongitud(campo){
	if(campo.value.length<1){
		return;
	}
	if(campo.value.length>9){
		return;
	}
	var auxVal=campo.value;
	var auxNum=(isNaN(auxVal.substring(auxVal.length-1)))?auxVal.substring(0,auxVal.length-1):auxVal;
	var auxLength=(isNaN(auxNum))?0:auxNum.length;
	var auxCeros=8-auxLength;
	for(var k=0;k<auxCeros;k++){
		auxVal="0"+auxVal;
	}
	if(auxVal.length>9){
		return;
	}
	$j("#"+campo.id).val(auxVal);
	
}
function valida_nif_cif_nie(a) {
    //1 > NIF correcto / -1 > NIF incorrecto
    //2 > CIF correcto / -2 > CIF incorrecto
    //3 > NIE correcto / -3 > NIE incorrecto
    //0 > Valor desconocido (campo vacio, formato incorrecto, etc)

	var temp=a.toUpperCase();
	var cadenadni="TRWAGMYFPDXBNJZSQVHLCKE"; 
	if (temp!==''){
		//si no tiene un formato valido devuelve error
		if ((!/^[A-Z]{1}[0-9]{7}[A-Z0-9]{1}$/.test(temp) && !/^[T]{1}[A-Z0-9]{8}$/.test(temp)) && !/^[0-9]{8}[A-Z]{1}$/.test(temp)){
			return 0;
		}
		//comprobacion de NIFs estandar
		if (/^[0-9]{8}[A-Z]{1}$/.test(temp)){
			posicion = a.substring(8,0) % 23;
			letra = cadenadni.charAt(posicion);
			var letradni=temp.charAt(8);
			if (letra == letradni){
			   	return 1;
			}else{
				return -1;
			}
		}
 
		//algoritmo para comprobacion de codigos tipo CIF
		suma = parseInt(a[2])+parseInt(a[4])+parseInt(a[6]);
		for (i = 1; i < 8; i += 2){
			temp1 = 2 * parseInt(a[i]);
			temp1 += '';
			temp1 = temp1.substring(0,1);
			temp2 = 2 * parseInt(a[i]);
			temp2 += '';
			temp2 = temp2.substring(1,2);
			if (temp2 == ''){
				temp2 = '0';
			}
			suma += (parseInt(temp1) + parseInt(temp2));
		}
		suma += '';
		n = 10 - parseInt(suma.substring(suma.length-1, suma.length));
		//comprobacion de NIFs especiales (se calculan como CIFs)
		if (/^[KLM]{1}/.test(temp)){
			if (a[8] == String.fromCharCode(64 + n)){
				return 1;
			}else{
				return -1;
			}
		}
		//comprobacion de CIFs
		if (/^[ABCDEFGHJNPQRSUVW]{1}/.test(temp)){
			temp = n + '';
			if (a[8] == String.fromCharCode(64 + n) || a[8] == parseInt(temp.substring(temp.length-1, temp.length))){
				return 2;
			}else{
				return -2;
			}
		}
		//comprobacion de NIEs
		//T
		if (/^[T]{1}/.test(temp)){
			if (a[8] == /^[T]{1}[A-Z0-9]{8}$/.test(temp)){
				return 3;
			}
			else{
				return -3;
			}
		}
 
		//XYZ
		if (/^[XYZ]{1}/.test(temp)){
			pos = str_replace(['X', 'Y', 'Z'], ['0','1','2'], temp).substring(0, 8) % 23;
			if (a[8] == cadenadni.substring(pos, pos + 1)){
				return 3;
			}else{
				return -3;
			}
		}
	}
 
	return 0;
}
function str_replace(search, replace, subject) {
    // *     example 1: str_replace(' ', '.', 'Kevin van Zonneveld');
    // *     returns 1: 'Kevin.van.Zonneveld'
    // *     example 2: str_replace(['{name}', 'l'], ['hello', 'm'], '{name}, lars');
    // *     returns 2: 'hemmo, mars'
 
    var f = search, r = replace, s = subject;
    var ra = r instanceof Array, sa = s instanceof Array, f = [].concat(f), r = [].concat(r), i = (s = [].concat(s)).length;
 
    while (j = 0, i--) {
        if (s[i]) {
            while (s[i] = s[i].split(f[j]).join(ra ? r[j] || "" : r[0]), ++j in f){};
        }
    };
 
    return sa ? s : s[0];
}
