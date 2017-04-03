function adicionarMembroTabela() {
        var optSelecionado = $("#combo_membros").find(":selected");
        
        if (optSelecionado) {
                var idPessoa = optSelecionado.val();
                var qtdLinhas = $("#tabela_membros").find('tbody > tr').length;
                var hiddenId = "<input type='hidden' name='membrosAssociados["+qtdLinhas+"].pessoa.idPessoa' value='"+idPessoa+"' />";
                
                $("#tabela_membros").find('tbody')
                        .append(
                                "<tr>"+
                                "<td>" + idPessoa + " " +hiddenId+ "</td>" +
                                "<td>" + optSelecionado.html() + "</td>" +
                                "<td>" + optSelecionado.attr("email") + "</td>" +
                                "<td>" + optSelecionado.attr("qualificacao") + "</td>" +
                                "</tr>"
                        );
                
        } else {
                alert("Preencha todos os dados do projeto.")
        }
}