<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- newsLetters -->
<div id="newsLetters">
	<table border="0" height="113" cellspacing="0" cellpadding="0" width="172" style="table-layout:fixed">
    	<tbody>
    	<tr> 
        	<td height="44" width="111" class="textoReservasTelefonicas"><s:property escape="false" value="getText('lang.gen.glo.newsletter')"/></td>
            <td height="44" width="61">&nbsp;</td>
        </tr>
        <tr> 
			<td align="left" valign="top" class="textoHorario" colspan="2"> 
				<div id="acymailing_module_formAcymailing1" class="acymailing_module">
					<div id="acymailing_fulldiv_formAcymailing1" class="acymailing_fulldiv">
						<form name="formAcymailing1" method="post" onsubmit="return submitacymailingform('optin','formAcymailing1')" action="/index.php?option=com_acymailing&amp;ctrl=sub&amp;lang=en" id="formAcymailing1">
							<div class="acymailing_module_form">
								<table class="acymailing_form">
								<tbody>
									<tr>
										<td>
											<input type="text" size="25" value="<s:text name='lang.gen.glo.paisprovincia'/>" onblur="if(this.value=='') this.value='<s:text name='lang.gen.glo.paisprovincia'/>';" onfocus="if(this.value == '<s:text name='lang.gen.glo.paisprovincia'/>') this.value = '';" id="user_name_formAcymailing1" class="inputbox" name="user[name]">
										</td> 
									</tr>
									<tr>							
										<td>						
											<table border="0" cellspacing="0" cellpadding="0">
												<tbody>
													<tr>
														<td>
															<input type="text" value="<s:text name='lang.gen.glo.email'/>" size="20" name="user[email]" class="inputbox" onblur="if(this.value=='') this.value='<s:text name='lang.gen.glo.email'/>';" onfocus="if(this.value == '<s:text name='lang.gen.glo.email'/>') this.value = '';" id="user_email_formAcymailing1">
														</td>
														<td>
															<a onclick="try{ return submitacymailingform('optin','formAcymailing1'); }catch(err){alert('The form could not be submitted, please make sure the jdoc:include type=head tag is in your template');return false;}" href="#">
															<img src="<s:property value='getContextPath()'/>/static/crs/images/joomla/arrowRight.JPG">
															</a>									
														</td>									
													</tr>
												</tbody>
											</table>
										</td> 
									</tr>
									<tr>
										<td class="acysubbuttons"></td>
									</tr>
							</tbody>
							</table>
							<input type="hidden" value="sub" name="ctrl">
							<input type="hidden" value="notask" name="task">
							<input type="hidden" value="http%3A%2F%2Fwww.online4you.es%2Findex.php" name="redirect">
							<input type="hidden" value="http%3A%2F%2Fwww.online4you.es%2Findex.php" name="redirectunsub">
							<input type="hidden" value="com_acymailing" name="option">
							<input type="hidden" value="" name="visiblelists">
							<input type="hidden" value="2,1" name="hiddenlists">
							<input type="hidden" value="formAcymailing1" name="acyformname">
							<input type="hidden" value="1" name="Itemid">			
						</div>
					</form>
				</div>
			</div> 
			<s:text name='lang.gen.glo.textonewsletter'/>
			</td>
        </tr>
        </tbody>
    </table>
</div>
<!-- end newsLetters -->
