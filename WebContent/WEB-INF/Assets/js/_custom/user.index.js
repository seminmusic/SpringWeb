var tabelaUsers;

$(function() {
	
	// Select2 za drop-down filter:
    $("#filter-polje").select2({
        allowClear: true,
        placeholder: "Search by ..."
    });
	
	tabelaUsers = $("#TabelaUsers").DataTable({
		"dom": '<"row"<"col-xs-12"r>><"row"<"col-xs-12 col-sm-8 margin-bottom-20"i><"col-xs-12 col-sm-4 margin-bottom-20 text-right"l>><"row"<"col-xs-12 margin-bottom-20"<"table-scroll"t>>><"row"<"col-xs-12 margin-bottom-20"p>>',
        "bServerSide": true,
        "sAjaxSource": "/app/users/ajax/users-data",
        "bProcessing": true,
        "aoColumns": [
        	{ "sName": "userId" },
        	{ "sName": "bankName" },
        	{ "sName": "telephoneNumber" },
        	{ "sName": "status" },
        	{ "sName": "activationDate" },
        	{ "sName": "registrationDate" },
        	{ "sName": "registrationCodeExpiration" },
        	{ "sName": "deactivationDate" },
        	{ "sName": "dailyLimitTransactions" },
        	{ "sName": "dailyLimitAmount" },
        	{ "sName": "loginAttempts" }
        ]
	});
	
	$("#filter-vrijednost").keyup(function (e) {
	    var indeksKolone = $("#filter-polje").val();
	    var podatak = $(this).val();
	    if (podatak == "") {
	    	tabelaUsers.columns().search("").draw();  // Poništavanje pretrage
	    	return;
	    }
	    if (e.which == 13 && indeksKolone != "" && podatak != "") {
	        Pretraga(indeksKolone, podatak);
	    }
	});
	
});


function Pretraga(i, p) {
    var indeks = parseInt(i);
    // DataTables filtriranje:
    tabelaUsers.columns().search("");   // Poništavanje svih filtera jer ostaju prethodni filteri aktivni (bez draw() - da ne ide odmah na server)
    tabelaUsers.column(indeks).search(p).draw();
}
