window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
	
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
   	}

	const data2 = document.getElementById('data2');
    if (data2) {
        new simpleDatatables.DataTable(data2);
   	}

});
