<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="naslov-stranice">User List</h3>

<!-- Pretraga: -->
<div class="row">
	<div class="col-xs-6 col-md-3 margin-bottom-20">
        <button type="button" class="btn btn-success" onclick="ModalNoviUnos()">
            <i class="fa fa-plus"></i>&nbsp; New User
        </button>
    </div>
    <div class="col-xs-6 col-md-9 margin-bottom-20 text-right">
    	<div style="float:right; text-align:left">
            <input type="text" class="form-control" id="filter-vrijednost" style="width:200px" />
        </div>
        <div style="float:right; text-align:left; margin-right:20px">
            <select id="filter-polje" style="width:245px">
                <option></option>
                <option value="0">User ID</option>
                <option value="1">Bank Name</option>
                <option value="2">Telephone Number</option>
                <option value="3">User Status</option>
                <option value="4">Activation Date</option>
                <option value="5">Registration Date</option>
                <option value="6">Registration Code Expiration</option>
                <option value="7">Deactivation Date</option>
                <option value="8">DailyLimit Transactions</option>
                <option value="9">DailyLimit Amount</option>
                <option value="10">Login Attempts</option>
            </select>
        </div>
    </div>
</div>

<!-- Tabela: -->
<div class="row" id="row-tabela">
	<div class="col-xs-12">
		<div>
			<table id="TabelaUsers" class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>User ID</th>
						<th>Bank Name</th>
						<th>Telephone Number</th>
						<th>User Status</th>
						<th>Activation Date</th>
						<th>Registration Date</th>
						<th>Registration Code Expiration</th>
						<th>Deactivation Date</th>
						<th>DailyLimit Transactions</th>
						<th>DailyLimit Amount</th>
						<th>Login Attempts</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</div>
