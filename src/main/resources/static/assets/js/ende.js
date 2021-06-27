$('#modalExcluirUsuario').on('show.bs.modal', function (event){

    var button = $(event.relatedTarget);

    var codigoUsuario = button.data("codigo");
    var nome = button.data("nome");

    var modal = $(this);
    var form = modal.find("form");
    var action = form.data("url-base");

    if (!action.endsWith("/")) {
        action += "/";
    }

    form.attr("action", action + codigoUsuario);

    modal.find(".modal-body span").html("Tem certeza que deseja excluir o usuario <strong>" + nome + "<strong>?")

});