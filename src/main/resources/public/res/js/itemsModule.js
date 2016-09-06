$(document).ready(function () {
    var itemsController = (function () {
        var urlBase = "api/items";
        var createItemForm = $("#create-item-form");
        var itemTemplate = function (id, name, description) {
            return "" +
                "<tr>" +
                "   <td>" + name + "</td>" +
                "   <td>" +
                "       <button class=\"btn btn-info pull-right\" data-item-id=\"" + id + "\" data-toggle=\"modal\" data-target=\"#viewItemModal\">" +
                "           view" +
                "       </button>" +
                "   </td>" +
                "   <td>" +
                "       <button class=\"btn btn-success pull-right\" data-item-id=\"" + id + "\" data-toggle=\"modal\" data-target=\"#updateItemModal\">" +
                "           update" +
                "       </button>" +
                "   </td>" +
                "   <td>" +
                "       <button class=\"btn btn-warning pull-right\" data-item-id=\"" + id + "\" data-toggle=\"modal\" data-target=\"#deleteItemModal\">" +
                "           delete" +
                "       </button>" +
                "   </td>" +
                "</tr>";
        };

        var init = function () {
            reloadItems();
            bindForms();
        };
        var bindForms = function () {
            createItemForm.submit(function (e) {
                e.preventDefault();
                saveItem();
            });
        };
        var reloadItems = function () {
            $.get(urlBase, function (data) {
                $("#items-table-body").empty();
                $.each(data, function (i, item) {
                    $("#items-table-body").append(itemTemplate(item.id, item.name, item.description));
                })
            })
                .fail(function (xhr, status, error) {
                    handleError(xhr, status, error);
                });
        };
        var saveItem = function () {
            var newItemName = $("#new-item-name");
            var newItemDescription = $("#new-item-description");
            var createItemData = JSON.stringify({
                name: newItemName.val(),
                description: newItemDescription.val()
            });
            $.ajax({
                type: "POST",
                url: urlBase,
                data: createItemData,
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    newItemName.val("");
                    newItemDescription.val("");
                    reloadItems();
                },
                error: function (data) {
                    handleError(data);
                }
            });
        };
        var handleError = function (xhr, status, error) {
            var message = "status: " + status + ", responseText: " + xhr.responseText + ", error: " + error;
            $("#errorMessage").text(message);
            $("#errorModal").modal('show');
        };
        return {
            init: init
        }
    })();
    itemsController.init();
});
