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
                 {name: 'lastMessage', type: 'string'}
        ]
    });
    var store = Ext.create('Ext.data.TreeStore', {
        model: 'Device',
        proxy: {
            type: 'ajax',
            //the store will get the content from the .json file
            url: jsonUrl
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
    
    //Ext.ux.tree.TreeGrid is no longer a Ux. You can simply use a tree.TreePanel
    var tree = Ext.create('Ext.tree.Panel', {
        title: 'Servo Dispositius',
        width: 500,
        height: 500,
        renderTo: Ext.getBody(),
        collapsible: true,
        useArrows: true,
        rootVisible: false,
        store: store,
        dragable: true,
        listeners: { 
        	  itemclick: function(view, record, item, index, e, options){ 
        		if (record.childNodes.length==0){
        			menuContext.showAt(e.xy);
        		}
        	  } 
        	},
        multiSelect: true,
        singleExpand: false,


        //the 'columns' property is now 'headers'
        columns: [{
            xtype: 'treecolumn', //this is so we know which column will show the tree
            text: 'Dispositivo',
            flex: 2,
            sortable: true,
            dataIndex: 'device'
        },{
            text: 'Tipo',
            flex: 1,
            dataIndex: 'type',
            sortable: true
        },{
            text: 'Ultimo MSG',
            flex: 1,
            dataIndex: 'lastMessage',
            sortable: true
        }]
    });
    

   
    
});

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