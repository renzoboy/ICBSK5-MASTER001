(function(g){"function"===typeof define&&define.amd?define(["jquery","datatables.net","datatables.net-buttons"],function(d){return g(d,window,document)}):"object"===typeof exports?module.exports=function(d,e){d||(d=window);if(!e||!e.fn.dataTable)e=require("datatables.net")(d,e).$;e.fn.dataTable.Buttons||require("datatables.net-buttons")(d,e);return g(e,d,d.document)}:g(jQuery,window,document)})(function(g,d,e,h){d=g.fn.dataTable;g.extend(d.ext.buttons,{colvis:function(b,a){return{extend:"collection",
text:function(c){return c.i18n("buttons.colvis","Column visibility")},className:"buttons-colvis",buttons:[{extend:"columnsToggle",columns:a.columns}]}},columnsToggle:function(b,a){return b.columns(a.columns).indexes().map(function(c){return{extend:"columnToggle",columns:c}}).toArray()},columnToggle:function(b,a){return{extend:"columnVisibility",columns:a.columns}},columnsVisibility:function(b,a){return b.columns(a.columns).indexes().map(function(c){return{extend:"columnVisibility",columns:c,visibility:a.visibility}}).toArray()},
columnVisibility:{columns:h,text:function(b,a,c){return c._columnText(b,c.columns)},className:"buttons-columnVisibility",action:function(b,a,c,f){b=a.columns(f.columns);a=b.visible();b.visible(f.visibility!==h?f.visibility:!(a.length&&a[0]))},init:function(b,a,c){var f=this,a=b.column(c.columns);b.on("column-visibility.dt"+c.namespace,function(b,a,d,e){!a.bDestroying&&d===c.columns&&f.active(e)}).on("column-reorder.dt"+c.namespace,function(a,d,e){1===b.columns(c.columns).count()&&("number"===typeof c.columns&&
(c.columns=e.mapping[c.columns]),a=b.column(c.columns),f.text(c._columnText(b,c.columns)),f.active(a.visible()))});this.active(a.visible())},destroy:function(b,a,c){b.off("column-visibility.dt"+c.namespace).off("column-reorder.dt"+c.namespace)},_columnText:function(b,a){var c=b.column(a).index();return b.settings()[0].aoColumns[c].sTitle.replace(/\n/g," ").replace(/<.*?>/g,"").replace(/^\s+|\s+$/g,"")}},colvisRestore:{className:"buttons-colvisRestore",text:function(b){return b.i18n("buttons.colvisRestore",
"Restore visibility")},init:function(b,a,c){c._visOriginal=b.columns().indexes().map(function(a){return b.column(a).visible()}).toArray()},action:function(b,a,c,d){a.columns().every(function(b){b=a.colReorder&&a.colReorder.transpose?a.colReorder.transpose(b,"toOriginal"):b;this.visible(d._visOriginal[b])})}},colvisGroup:{className:"buttons-colvisGroup",action:function(b,a,c,d){a.columns(d.show).visible(!0);a.columns(d.hide).visible(!1)},show:[],hide:[]}});return d.Buttons});

