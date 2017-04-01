function adicionarMembroTabela() {
        
        var optSelecionado = $("#combo_membros").find(":selected");

        if (optSelecionado) {
                $("#tabela_membros").find('tbody')
                        .append(
                                "</tr>"+
                                "<td>" + optSelecionado.val() + "</td>" +
                                "<td>" + optSelecionado.html() + "</td>" +
                                "<td>" + optSelecionado.attr("email") + "</td>" +
                                "<td>" + optSelecionado.attr("qualificacao") + "</td>" +
                                "</tr>"
                        );
                
        } else {
                alert("Preencha todos os dados do projeto.")
        }
}