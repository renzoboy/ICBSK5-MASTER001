$(document).ready(function(){function deleteRow(currentNode){$(currentNode).parent().parent().remove()}var clonedRow=$(".info1").clone().html(),appendRow='<tr class = "info1">'+clonedRow+"</tr>";$("#btnAddMore").click(function(){$(".check-table tr:last").after(appendRow)}),$(".deleteThisRow").live("click",function(){var rowLength=$(".info1").length;rowLength>1?deleteRow(this):($(".check-table tr:last").after(appendRow),deleteRow(this))})});