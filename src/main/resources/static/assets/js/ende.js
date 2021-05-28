$("#modalExcluirUsuario").on("show.bs.modal", function (event) {

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


$(function () {

    $("[rel='tooltip']").tooltip();

    $(".js-atualizar-statusParceiro").on("click", function (event) {
        event.preventDefault();

        var button = $(event.currentTarget);
        var url = button.attr("href");

        var response = $.ajax({
            url: url,
            type: "PUT"
        });

        response.done(function (e) {
            var codigoParceiro = button.data('codigo');

            $('[data-role=' + codigoParceiro + ']').html('<span class="label label-success">' + e + ' </span>');

        });

        response.fail(function (e) {
            console.log(e);
        });

    });

    $(".js-atualizar-statusParceiroOcupado").on("click", function (event) {
        event.preventDefault();

        var button = $(event.currentTarget);
        var url = button.attr("href");

        var response = $.ajax({
            url: url,
            type: "PUT"
        });

        response.done(function (e) {
            var codigoParceiro = button.data('codigo');

            $('[data-role=' + codigoParceiro + ']').html('<span class="label label-danger">' + e + ' </span>');

        });

        response.fail(function (e) {
            console.log(e);
        });

    });
});

