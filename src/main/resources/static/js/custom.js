var lote = [];

$(document).ready(function () {
    $('.selecionados').hide();

    $('.selecionados').click(function () {

        $(`<div class="modal fade" id="myModal" role="dialog">
     <div class="modal-dialog">
       <!-- Modal            deleteInLote();
 content-->
                <div class="modal-content">
                <div class="modal-body" style="padding:10px;">
                <h4 class="text-center">Confirmar Exclusão em lote?</h4>
                <div class="text-center">
                <a class="btn btn-success excluirLote" href="javascript:;">Sim</a>
                <a class="btn btn-danger" data-dismiss="modal" >Não</a>
                </div>
                </div>
                </div>
                </div>
                </div>`).appendTo('body');

        //Trigger the modal
        $("#myModal").modal({
            backdrop: 'static',
            keyboard: false
        });



        $('.excluirLote').click(function () {
            lote.forEach(function (item) {
                $.ajax({
                    url: item
                }).done( function () {
                    console.log('OK...')
                    location.reload();
                })

            })
        })
    });
})

function ConfirmDialog(id) {
    $(`<div class="modal fade" id="myModal" role="dialog">
     <div class="modal-dialog">
       <!-- Modal            deleteInLote();
 content-->
                <div class="modal-content">
                <div class="modal-body" style="padding:10px;">
                <h4 class="text-center">Confirmar Exclusão?</h4>
                <div class="text-center">
                <a class="btn btn-success" href="/delete/${id}">Sim</a>
                <a class="btn btn-danger" data-dismiss="modal" >Não</a>
                </div>
                </div>
                </div>
                </div>
                </div>`).appendTo('body');

    //Trigger the modal
    $("#myModal").modal({
        backdrop: 'static',
        keyboard: false
    });

}

function checkAll() {
    lote = [];
    if ($("#checkedAll").is(':checked')) {
        $(".checkBoxClass").prop('checked', true);
        $('.selecionados').show();
        $('.table tr td .idCliente').each(function (item, value) {
            var url = $(this).attr('href');
            url = url.replace('edit', 'delete');
            lote.push(url);
        })
    } else {
        $('.selecionados').hide();
        $(".checkBoxClass").prop('checked', false);
        lote = [];
    }

}


function addToLote(id) {
    let urlid = '/delete/' + id;
    if (!lote.includes(urlid)) {
        $('.selecionados').show();
        lote.push(urlid);
    } else {
        $('.selecionados').hide();
        lote = lote.filter(a => a !== urlid);
    }
    console.log(lote);
}


