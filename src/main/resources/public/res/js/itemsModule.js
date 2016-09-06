$(document).ready(function () {
    var itemsController = (function () {
        var urlBase = "api/items";
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
        };
        var reloadItems = function () {
            $.get(urlBase, function (data) {
                $("#items-table-body").empty();
                $.each(data, function (i, item) {
                    $("#items-table-body").append(itemTemplate(item.id, item.name, item.description));
                })
            })
                .fail(function (data) {
                    console.log("Error while fetching all items.");
                    console.log(data);
                });
        };

        return {
            init: init
        }
    })();
    itemsController.init();
});
