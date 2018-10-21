<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>
            Device detail
        </title>
        <script type="text/javascript">
			var $j=jQuery;
		</script>
       
       <script type="text/javascript">
	       $j(document).ready(function() {
				 	$j('#fechaInicio').jdPicker({ 
						  	     date_format:"dd/mm/YYYY", 
						  	     show_week:1, 
						  	     //week_label:"we", 
						  	     start_of_week:1, 
						  	     date_min:"<s:property value='getToday()'/>", 
						  	     //selectable_days:[1, 2, 3, 4, 5, 6, 7]
						  	     //non_selectable:["May 24 2010"], 
						  	     //rec_non_selectable: ["Jan 01", "May 26"] 
						  	});
	      	 });
       </script>
    </head>
    <body>
       	<div id="deviceOperations" style="overflow:hidden;height: 33%;border-style: solid;border-color: #47B224;border-radius: 10px 10px 0 0;">
	        <div style="display: table;">
	        	<div style="display: table-row;">
	        		 <div style="display: table-cell;">
	        		 	<img class="deviceIcon" src="<s:property value="getContextPath()"/><s:property value="device.imgUrl"/>"/>
	        		 	<br>
	        		 	<s:property value="device.systemId"/>-<s:property value="device.cellId"/>-<s:property value="device.id"/>::<s:property value="device.name"/>
	        		 </div>
	        		 <div style="display: table-cell;vertical-align: middle;">
	        		 		<div id="switch" class="onoffImg_<s:property value="device.state"/>" onclick="javascript: switchDevice('switch');"/>
	        		 </div>
	        	</div>
	        </div>
        	
        	
        </div>
        <div id="devicePrograms" style="overflow:hidden;height: 33%;border-style: solid;border-color: #47B224;padding:5px">
        	<div style="display: table;">
        			<div style="display: table-row;">
				        	<div style="display: table-cell;">
					        	<input type="radio" name="programa" value="1"><s:text name="lang.gen.programacion.unaVez"/></input>
					        	<br>
								<input type="radio" name="programa" value="1"><s:text name="lang.gen.programacion.diariamente"/></input>
								<br>
								<input type="radio" name="programa" value="1"><s:text name="lang.gen.programacion.Semanalmente"/></input>
							</div>
							<div style="display: table-cell;">
								<s:text name="lang.gen.programacion.inicio"/>
								<input id="fechaInicio" type="text" value="" size="9"/>
								<select>
									<s:iterator var="#hora" value="getHoras()">
										<option value="<s:property value='#hora'/>"><s:property value='#hora'/></option>
									</s:iterator>
								</select>
								<select>
									<s:iterator var="#min" value="getMinutes()">
										<option value="<s:property value='#min'/>"><s:property value='#min'/></option>
									</s:iterator>
								</select>
							</div>
							<div style="display: table-cell;" >
							asdfasd
							</div>
					</div>
						<div style="display: table-row;" id="programUnaVez">
									<div style="display: table-cell;" >
							***********************************************************
									</div>
						</div>
						<div style="display: table-row;" id="programUnaVez">
									<div style="display: table-cell;" >
							program 1
									</div>
						</div>
						<div style="display: table-row;" id="programUnaVez">
									<div style="display: table-cell;" >
							program 2
									</div>
						</div>
						<div style="display: table-row;" id="programUnaVez">
									<div style="display: table-cell;" >
							program 3
									</div>
						</div>
			</div>
								

        </div>
        <div id="deviceMessages" style="overflow:hidden;height: 33%;border-style: solid;border-color: #47B224;border-radius: 0 0 10px 10px;">
        	<div style="display: table;">
        				<div style="display: table-row;">
	        		 		<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
        						<b><s:text name="lang.gen.systemFrom"/></b>
        					</div>
        					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.cellFrom"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.deviceFrom"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.systemTo"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.cellTo"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.deviceTo"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.operationType"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.operation"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;">
								<b><s:text name="lang.gen.stateCause"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;border-right: 1px solid;padding: 5px;width: 120px;">
								<b><s:text name="lang.gen.time"/></b>
        					</div>
         					<div style="display: table-cell;border-bottom: 2px solid;padding: 5px;width: 120px;">
								<b><s:text name="lang.gen.validUntill"/></b>
        					</div>
        				</div>
        	<s:iterator var="msg" value="device.InfoMessages" status="messagesStatus">
        		<s:if test="#messagesStatus.index<maxMessages">
        			
	        			<div style="display: table-row;">
	        		 		<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
        						<s:property value="#msg.systemFrom"/>
        					</div>
        					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.cellFrom"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.deviceFrom"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.systemTo"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.cellTo"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.deviceTo"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.operationType"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.operation"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="#msg.stateCause"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;border-right: 1px solid;">
								<s:property value="getDateToStringNoMilis(#msg.calendarTime)"/>
        					</div>
         					<div style="display: table-cell;border-bottom: 1px solid;">
								<s:property value="getDateToStringNoMilis(#msg.calendarValidUntill)"/>
        					</div>
        				</div>
        		</s:if>
        	</s:iterator>
        	</div>
        </div>
    </body>
</html>
