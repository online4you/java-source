Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tree.*'
]);

Ext.onReady(function() {
    //we want to setup a model and store instead of using dataUrl
    Ext.define('Device', {
        extend: 'Ext.data.Model',
        fields: [
                 {name: 'device',     type: 'string'},
                 {name: 'type',     type: 'string'},
                 {name: 'deviceId', type: 'string'}
        ]
    });
    var store = Ext.create('Ext.data.TreeStore', {
        model: 'Device',
        proxy: {
            type: 'ajax',
            //the store will get the content from the .json file
            url: jsonUrl,
            reader: {
                type: 'json'
            }
        },
        root:
        {
            expanded: true
        },
        folderSort: true
    });
    
   
    
    var menuContext = new Ext.menu.Menu({ 
        items: [{ 
            id: 'ON', 
            text: 'Encender' 
        },{ 
            id: 'OFF', 
            text: 'Apagar' 
        },{ 
            id: 'BLINK', 
            text: 'Parpadear' 
        }], 
        listeners: { 
            click: function(item) { 
            	switch (item.activeItem.id) { 
                    case 'ON': 
                    	sendOperation('ON');
                        break; 
                    case 'OFF': 
                    	sendOperation('OFF');
                        break;
                    case 'BLINK': 
                    	sendOperation('BLINK');
                        break;
                } 
            } 
        } 
    }); 
    var recordSelected;
    var div = Ext.Element.get('treePanel');
    //Ext.ux.tree.TreeGrid is no longer a Ux. You can simply use a tree.TreePanel
    var tree = Ext.create('Ext.tree.Panel', {
    	title: 'Servo Dispositius',
        /*width: 500,*/
        /*height: 500,*/
        collapsible: false,
        useArrows: true,
        rootVisible: false,
        renderTo: div,
        store: store,
        dragable: true,
        listeners: { 
        	  itemclick: function(view, record, item, index, e, options){ 
        		loadItem(view, record, item, index, e, options);
        		  
        		  /*
        		  if (record.childNodes.length==0){
        			menuContext.showAt(e.xy);
        		}*/
        	  } 
        	},
        multiSelect: true,
        singleExpand: false,


        //the 'columns' property is now 'headers'
        columns: [{
            xtype: 'treecolumn', //this is so we know which column will show the tree
            text: 'Dispositivo',
            flex: 2,
            height: 0,
            //hidden: true,
            sortable: true,
            dataIndex: 'device'
        }
        /*,{
            text: 'Tipo',
            flex: 1,
            dataIndex: 'type',
            sortable: true
        },{
            text: 'Ultimo MSG',
            flex: 1,
            dataIndex: 'lastMessage',
            sortable: true
        }*/
        ]
    });
    
    
});
function loadItem(view, record, item, index, e, options){
	if (record.data.deviceId.split("##")[0]=="D"){
		loadItemIntoDiv (record.data.deviceId);
	}
}
function loadItemIntoDiv(itemId){
	$j.ajax({ 
	    url: deviceContentUrl, 
	    type: "post", 
	    data: {keyId:itemId}, 
	    // callback handler that will be called on success 
	    success: function(response, textStatus, jqXHR){ 
	    	$j('#deviceContent').html(response);
	    	
	    }, 
	    // callback handler that will be called on error 
	    error: function(jqXHR, textStatus, errorThrown){ 
	    	alert(textStatus);
	    }, 
	    // callback handler that will be called on completion 
	    // which means, either on success or error 
	    complete: function(){ 
	    	 //setFadeOff();
	    } 
	}); 
}
function sendOperation(operation){
	$j.ajax({ 
	    url: operationUrl, 
	    type: "post", 
	    data: {operation:operation}, 
	    // callback handler that will be called on success 
	    success: function(response, textStatus, jqXHR){ 
	    	if(response['result']!=''){
	    		alert(response['result']);
	    	}else{
	    		alert('Dispositivo apagado!');
	    	}
	    	
	    }, 
	    // callback handler that will be called on error 
	    error: function(jqXHR, textStatus, errorThrown){ 
	    	alert(textStatus);
	    }, 
	    // callback handler that will be called on completion 
	    // which means, either on success or error 
	    complete: function(){ 
	    	 //setFadeOff();
	    } 
	}); 
}
var deviceId='on';
function switchDevice(id){
	var dev=deviceId;
	if (dev=='on'){
		$j("#"+id).attr("class", "onoffImg_OFF");
		dev='off';
	}else{
		$j("#"+id).attr("class", "onoffImg_ON");
		dev='on';
	}
	deviceId=dev;
}
