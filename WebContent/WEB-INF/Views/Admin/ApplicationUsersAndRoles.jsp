<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<h3 class="naslov-stranice">Application Users and Roles</h3>

<div class="row">
	<div class="col-xs-12">
		<div>
  			<ul class="nav nav-tabs" role="tablist">
    			<li role="presentation" class="active">
					<a href="#tab-users" aria-controls="tab-users" role="tab" data-toggle="tab">Users</a>
				</li>
    			<li role="presentation">
					<a href="#tab-roles" aria-controls="tab-roles" role="tab" data-toggle="tab">Roles</a>
				</li>
  			</ul>
  			<div class="tab-content">
    			<div role="tabpanel" class="tab-pane active" id="tab-users">
        			<tiles:insertAttribute name="_AppUsers" />
    			</div>
    			<div role="tabpanel" class="tab-pane" id="tab-roles">
    			
    			</div>
  			</div>
		</div>
	</div>
</div>
