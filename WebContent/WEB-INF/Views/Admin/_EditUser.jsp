<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tr class="tr-edit" data-user-id="${user.korisnikId}">
	<td colspan="5">
		<form:form modelAttribute="user" class="form-inline"
				   data-bv-message="Vrijednost nije validna"
    		   	   data-bv-icon-valid="glyphicon glyphicon-ok"
    		       data-bv-icon-invalid="glyphicon glyphicon-remove"
    		       data-bv-icon-validating="glyphicon glyphicon-refresh">
			<form:hidden path="korisnikId" />
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:input path="ime" class="form-control" type="text" autocomplete="off" placeholder="Ime" style="width:150px"
								data-bv-notempty="true"
								data-bv-notempty-message="Obavezan unos"
								data-bv-stringlength="true"
								data-bv-stringlength-max="20"
	                			data-bv-stringlength-message="Maksimalno 20 karaktera" />
            	</div>
			</div>
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:input path="prezime" class="form-control" type="text" autocomplete="off" placeholder="Prezime" style="width:150px"
								data-bv-notempty="true"
								data-bv-notempty-message="Obavezan unos"
								data-bv-stringlength="true"
								data-bv-stringlength-max="20"
	                			data-bv-stringlength-message="Maksimalno 20 karaktera" />
                </div>
			</div>
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:input path="email" class="form-control" type="text" autocomplete="off" placeholder="E-mail"
								data-bv-stringlength="true"
								data-bv-stringlength-max="30"
	                			data-bv-stringlength-message="Maksimalno 30 karaktera"
	                			data-bv-emailaddress="true"
	                			data-bv-emailaddress-message="E-mail nije validan" />
                </div>
			</div>
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:input path="username" class="form-control" type="text" autocomplete="off" placeholder="Username" style="width:150px"
								data-bv-notempty="true"
								data-bv-notempty-message="Obavezan unos"
								data-bv-stringlength="true"
								data-bv-stringlength-max="30"
	                			data-bv-stringlength-message="Maksimalno 30 karaktera" />
                </div>
			</div>
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:select path="status" items="${user.statusLista}" class="form-control"
								 data-bv-notempty="true"
								 data-bv-notempty-message="Izaberite status" />
				</div>
			</div>
			<div style="float:left; margin-right:8px">
				<div class="form-group">
					<form:select path="role" items="${user.roleLista}" multiple="true" class="form-control" />
				</div>
			</div>
			<div style="float:right">
				<button type="submit" 
						class="btn btn-sm btn-success" 
						style="margin:2px 0; margin-right:5px">
					<i class="fa fa-check"></i>&nbsp; Save
				</button>
				<button type="button" 
						class="btn btn-sm btn-danger" 
						style="margin:2px 0;"
						onclick="CancelUpdateAppUser(this)">
					<i class="fa fa-times"></i>&nbsp; Cancel
				</button>
			</div>
		</form:form>
	</td>
</tr>
