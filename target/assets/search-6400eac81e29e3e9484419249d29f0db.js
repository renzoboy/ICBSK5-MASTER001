ns("icbs.Utilities"),icbs.Utilities.Search=function(url,searchDiv){var self=this,rootUrl=url;console.log("url?? "+url);var searchFormId="#searchForm",sDiv=searchDiv||"#inlineSearchDiv";console.log(sDiv);var searchCallback=function(data){$(sDiv).html(data)};this.searchMe=function(link){var retUrl;null!=link?(retUrl=link,console.log("returl 1 "+retUrl)):(retUrl=rootUrl,console.log("returl 2 "+retUrl)),icbs.Dependencies.Ajax.run({url:retUrl,params:$(sDiv).find(searchFormId).serialize(),callback:searchCallback})};var setupGridAjax=function(){$(sDiv).find(".pagination a, th.sortable a").on("click",function(event){event.preventDefault();var tempUrl=$(this).attr("href"),url=rootUrl+tempUrl.substring(tempUrl.indexOf("?"));self.searchMe(url)})};this.setupGridAjax=function(){$(sDiv).find(".pagination a, th.sortable a").on("click",function(event){event.preventDefault();var tempUrl=$(this).attr("href"),url=rootUrl+tempUrl.substring(tempUrl.indexOf("?"));self.searchMe(url)})},icbs.Dependencies.Ajax.addLoadEvent(function(){setupGridAjax(),$(sDiv).find(searchFormId).on("submit",function(e){e.preventDefault()})}),setupGridAjax()};