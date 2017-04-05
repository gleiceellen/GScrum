<div id="barramenu" class="topnav">
  <a id="menuHome"      href="home" onclick="setMenuAtivo(this);">Home</a>
  <a id="menuPessoas"   href="listaPessoas" onclick="setMenuAtivo(this);">Pessoas</a>
  <a id="menuProjetos"  href="listaProjetos" onclick="setMenuAtivo(this);">Projetos</a>
  <a id="menuSprints"  href="listaSprints" onclick="setMenuAtivo(this);">Sprints</a>
  <a id="menuTarefas"   href="listaTarefas" onclick="setMenuAtivo(this);">Tarefa</a>
</div>
<script>
        function setMenuAtivo(obj){
               $("#barramenu a").removeClass("active"); 
               $("#"+obj.id).addClass("active");
        }
</script>