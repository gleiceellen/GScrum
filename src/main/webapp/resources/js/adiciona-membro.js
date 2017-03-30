function addtable(){
	
	var nomepro = document.querySelector("#nome-pro");
    var descpro = document.querySelector("#desc-pro");
  
	if (nomepro.value!= " " && descpro.value != " "){
    var novoRegistro = "<tr>"+
                "<td>"+nomepro.value+"</td>"+
                "<td class='valor'>"+descpro.value+"</td>"+
             "</tr>";

    var tabelaEntrada = document.querySelector(".entrada");
    tabelaEntrada.innerHTML +=  novoRegistro;

    nomepro.value = "";
    descpro.value = "";

    document.querySelector("#membro").style.display="inline-block";
    document.querySelector("#memnome").style.display="inline-block";

	}else{
		alert("Preencha todos os dados do projeto.")
	}
}

function add(){
	
	var nomemem = document.querySelector("#membro").value;
	document.querySelector("#memnome").value = nomemem;
  
};

function novaTarefa(){
	
	//var memid = document.querySelector("#memid");
    var memnome = document.querySelector("#memnome");
  
	if (memnome.value != " "){
    var novoRegistro = "<tr>"+
                "<td>"+memid.value+"</td>"+
                "<td class='valor'>"+memnome.value+"</td>"+
             "</tr>";

    var tabelaTarefa = document.querySelector(".tarefas");
    tabelaTarefa.innerHTML +=  novoRegistro;

    memid.value = "";
    memnome.value = "";

	}else{
		alert("Escolha as tarefas!")
	}
  
};