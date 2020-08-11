!function($,window,document,undefined){"use strict";var Timepicker=function(element,options){this.widget="",this.$element=$(element),this.defaultTime=options.defaultTime,this.disableFocus=options.disableFocus,this.isOpen=options.isOpen,this.minuteStep=options.minuteStep,this.modalBackdrop=options.modalBackdrop,this.secondStep=options.secondStep,this.showInputs=options.showInputs,this.showMeridian=options.showMeridian,this.showSeconds=options.showSeconds,this.template=options.template,this.appendWidgetTo=options.appendWidgetTo,this.upArrowStyle=options.upArrowStyle,this.downArrowStyle=options.downArrowStyle,this.containerClass=options.containerClass,this._init()};Timepicker.prototype={constructor:Timepicker,_init:function(){var self=this;this.$element.parent().hasClass("input-append")||this.$element.parent().hasClass("input-prepend")?(this.$element.parent(".input-append, .input-prepend").find(".add-on").length?this.$element.parent(".input-append, .input-prepend").find(".add-on").on({"click.timepicker":$.proxy(this.showWidget,this)}):this.$element.closest(this.containerClass).find(".add-on").on({"click.timepicker":$.proxy(this.showWidget,this)}),this.$element.on({"focus.timepicker":$.proxy(this.highlightUnit,this),"click.timepicker":$.proxy(this.highlightUnit,this),"keydown.timepicker":$.proxy(this.elementKeydown,this),"blur.timepicker":$.proxy(this.blurElement,this)})):this.$element.on(this.template?{"focus.timepicker":$.proxy(this.showWidget,this),"click.timepicker":$.proxy(this.showWidget,this),"blur.timepicker":$.proxy(this.blurElement,this)}:{"focus.timepicker":$.proxy(this.highlightUnit,this),"click.timepicker":$.proxy(this.highlightUnit,this),"keydown.timepicker":$.proxy(this.elementKeydown,this),"blur.timepicker":$.proxy(this.blurElement,this)}),this.$widget=this.template!==!1?$(this.getTemplate()).prependTo(this.$element.parents(this.appendWidgetTo)).on("click",$.proxy(this.widgetClick,this)):!1,this.showInputs&&this.$widget!==!1&&this.$widget.find("input").each(function(){$(this).on({"click.timepicker":function(){$(this).select()},"keydown.timepicker":$.proxy(self.widgetKeydown,self)})}),this.setDefaultTime(this.defaultTime)},blurElement:function(){this.highlightedUnit=undefined,this.updateFromElementVal()},decrementHour:function(){if(this.showMeridian)if(1===this.hour)this.hour=12;else{if(12===this.hour)return this.hour--,this.toggleMeridian();if(0===this.hour)return this.hour=11,this.toggleMeridian();this.hour--}else 0===this.hour?this.hour=23:this.hour--;this.update()},decrementMinute:function(step){var newVal;newVal=step?this.minute-step:this.minute-this.minuteStep,0>newVal?(this.decrementHour(),this.minute=newVal+60):this.minute=newVal,this.update()},decrementSecond:function(){var newVal=this.second-this.secondStep;0>newVal?(this.decrementMinute(!0),this.second=newVal+60):this.second=newVal,this.update()},elementKeydown:function(e){switch(e.keyCode){case 9:switch(this.updateFromElementVal(),this.highlightedUnit){case"hour":e.preventDefault(),this.highlightNextUnit();break;case"minute":(this.showMeridian||this.showSeconds)&&(e.preventDefault(),this.highlightNextUnit());break;case"second":this.showMeridian&&(e.preventDefault(),this.highlightNextUnit())}break;case 27:this.updateFromElementVal();break;case 37:e.preventDefault(),this.highlightPrevUnit(),this.updateFromElementVal();break;case 38:switch(e.preventDefault(),this.highlightedUnit){case"hour":this.incrementHour(),this.highlightHour();break;case"minute":this.incrementMinute(),this.highlightMinute();break;case"second":this.incrementSecond(),this.highlightSecond();break;case"meridian":this.toggleMeridian(),this.highlightMeridian()}break;case 39:e.preventDefault(),this.updateFromElementVal(),this.highlightNextUnit();break;case 40:switch(e.preventDefault(),this.highlightedUnit){case"hour":this.decrementHour(),this.highlightHour();break;case"minute":this.decrementMinute(),this.highlightMinute();break;case"second":this.decrementSecond(),this.highlightSecond();break;case"meridian":this.toggleMeridian(),this.highlightMeridian()}}},formatTime:function(hour,minute,second,meridian){return hour=10>hour?"0"+hour:hour,minute=10>minute?"0"+minute:minute,second=10>second?"0"+second:second,hour+":"+minute+(this.showSeconds?":"+second:"")+(this.showMeridian?" "+meridian:"")},getCursorPosition:function(){var input=this.$element.get(0);if("selectionStart"in input)return input.selectionStart;if(document.selection){input.focus();var sel=document.selection.createRange(),selLen=document.selection.createRange().text.length;return sel.moveStart("character",-input.value.length),sel.text.length-selLen}},getTemplate:function(){var template,hourTemplate,minuteTemplate,secondTemplate,meridianTemplate,templateContent;switch(this.showInputs?(hourTemplate='<input type="text" name="hour" class="bootstrap-timepicker-hour form-control" maxlength="2"/>',minuteTemplate='<input type="text" name="minute" class="bootstrap-timepicker-minute form-control" maxlength="2"/>',secondTemplate='<input type="text" name="second" class="bootstrap-timepicker-second form-control" maxlength="2"/>',meridianTemplate='<input type="text" name="meridian" class="bootstrap-timepicker-meridian form-control" maxlength="2"/>'):(hourTemplate='<span class="bootstrap-timepicker-hour"></span>',minuteTemplate='<span class="bootstrap-timepicker-minute"></span>',secondTemplate='<span class="bootstrap-timepicker-second"></span>',meridianTemplate='<span class="bootstrap-timepicker-meridian"></span>'),templateContent='<table><tr><td><a href="#" data-action="incrementHour"><i class="'+this.upArrowStyle+'"></i></a></td><td class="separator">&nbsp;</td><td><a href="#" data-action="incrementMinute"><i class="'+this.upArrowStyle+'"></i></a></td>'+(this.showSeconds?'<td class="separator">&nbsp;</td><td><a href="#" data-action="incrementSecond"><i class="'+this.upArrowStyle+'"></i></a></td>':"")+(this.showMeridian?'<td class="separator">&nbsp;</td><td class="meridian-column"><a href="#" data-action="toggleMeridian"><i class="'+this.upArrowStyle+'"></i></a></td>':"")+"</tr><tr><td>"+hourTemplate+'</td> <td class="separator">:</td><td>'+minuteTemplate+"</td> "+(this.showSeconds?'<td class="separator">:</td><td>'+secondTemplate+"</td>":"")+(this.showMeridian?'<td class="separator">&nbsp;</td><td>'+meridianTemplate+"</td>":"")+'</tr><tr><td><a href="#" data-action="decrementHour"><i class="'+this.downArrowStyle+'"></i></a></td><td class="separator"></td><td><a href="#" data-action="decrementMinute"><i class="'+this.downArrowStyle+'"></i></a></td>'+(this.showSeconds?'<td class="separator">&nbsp;</td><td><a href="#" data-action="decrementSecond"><i class="'+this.downArrowStyle+'"></i></a></td>':"")+(this.showMeridian?'<td class="separator">&nbsp;</td><td><a href="#" data-action="toggleMeridian"><i class="'+this.downArrowStyle+'"></i></a></td>':"")+"</tr></table>",this.template){case"modal":template='<div class="bootstrap-timepicker-widget modal hide fade in" data-backdrop="'+(this.modalBackdrop?"true":"false")+'"><div class="modal-header"><a href="#" class="close" data-dismiss="modal">×</a><h3>Pick a Time</h3></div><div class="modal-content">'+templateContent+'</div><div class="modal-footer"><a href="#" class="btn btn-primary" data-dismiss="modal">OK</a></div></div>';break;case"dropdown":template='<div class="bootstrap-timepicker-widget dropdown-menu">'+templateContent+"</div>"}return template},getTime:function(){return this.formatTime(this.hour,this.minute,this.second,this.meridian)},hideWidget:function(){this.isOpen!==!1&&(this.showInputs&&this.updateFromWidgetInputs(),this.$element.trigger({type:"hide.timepicker",time:{value:this.getTime(),hours:this.hour,minutes:this.minute,seconds:this.second,meridian:this.meridian}}),"modal"===this.template&&this.$widget.modal?this.$widget.modal("hide"):this.$widget.removeClass("open"),$(document).off("mousedown.timepicker"),this.isOpen=!1)},highlightUnit:function(){this.position=this.getCursorPosition(),this.position>=0&&this.position<=2?this.highlightHour():this.position>=3&&this.position<=5?this.highlightMinute():this.position>=6&&this.position<=8?this.showSeconds?this.highlightSecond():this.highlightMeridian():this.position>=9&&this.position<=11&&this.highlightMeridian()},highlightNextUnit:function(){switch(this.highlightedUnit){case"hour":this.highlightMinute();break;case"minute":this.showSeconds?this.highlightSecond():this.showMeridian?this.highlightMeridian():this.highlightHour();break;case"second":this.showMeridian?this.highlightMeridian():this.highlightHour();break;case"meridian":this.highlightHour()}},highlightPrevUnit:function(){switch(this.highlightedUnit){case"hour":this.highlightMeridian();break;case"minute":this.highlightHour();break;case"second":this.highlightMinute();break;case"meridian":this.showSeconds?this.highlightSecond():this.highlightMinute()}},highlightHour:function(){var $element=this.$element.get(0);this.highlightedUnit="hour",$element.setSelectionRange&&setTimeout(function(){$element.setSelectionRange(0,2)},0)},highlightMinute:function(){var $element=this.$element.get(0);this.highlightedUnit="minute",$element.setSelectionRange&&setTimeout(function(){$element.setSelectionRange(3,5)},0)},highlightSecond:function(){var $element=this.$element.get(0);this.highlightedUnit="second",$element.setSelectionRange&&setTimeout(function(){$element.setSelectionRange(6,8)},0)},highlightMeridian:function(){var $element=this.$element.get(0);this.highlightedUnit="meridian",$element.setSelectionRange&&(this.showSeconds?setTimeout(function(){$element.setSelectionRange(9,11)},0):setTimeout(function(){$element.setSelectionRange(6,8)},0))},incrementHour:function(){if(this.showMeridian){if(11===this.hour)return this.hour++,this.toggleMeridian();12===this.hour&&(this.hour=0)}return 23===this.hour?void(this.hour=0):(this.hour++,void this.update())},incrementMinute:function(step){var newVal;newVal=step?this.minute+step:this.minute+this.minuteStep-this.minute%this.minuteStep,newVal>59?(this.incrementHour(),this.minute=newVal-60):this.minute=newVal,this.update()},incrementSecond:function(){var newVal=this.second+this.secondStep-this.second%this.secondStep;newVal>59?(this.incrementMinute(!0),this.second=newVal-60):this.second=newVal,this.update()},remove:function(){$("document").off(".timepicker"),this.$widget&&this.$widget.remove(),delete this.$element.data().timepicker},setDefaultTime:function(defaultTime){if(this.$element.val())this.updateFromElementVal();else if("current"===defaultTime){var dTime=new Date,hours=dTime.getHours(),minutes=Math.floor(dTime.getMinutes()/this.minuteStep)*this.minuteStep,seconds=Math.floor(dTime.getSeconds()/this.secondStep)*this.secondStep,meridian="AM";this.showMeridian&&(0===hours?hours=12:hours>=12?(hours>12&&(hours-=12),meridian="PM"):meridian="AM"),this.hour=hours,this.minute=minutes,this.second=seconds,this.meridian=meridian,this.update()}else defaultTime===!1?(this.hour=0,this.minute=0,this.second=0,this.meridian="AM"):this.setTime(defaultTime)},setTime:function(time){var arr,timeArray;this.showMeridian?(arr=time.split(" "),timeArray=arr[0].split(":"),this.meridian=arr[1]):timeArray=time.split(":"),this.hour=parseInt(timeArray[0],10),this.minute=parseInt(timeArray[1],10),this.second=parseInt(timeArray[2],10),isNaN(this.hour)&&(this.hour=0),isNaN(this.minute)&&(this.minute=0),this.showMeridian?(this.hour>12?this.hour=12:this.hour<1&&(this.hour=12),"am"===this.meridian||"a"===this.meridian?this.meridian="AM":("pm"===this.meridian||"p"===this.meridian)&&(this.meridian="PM"),"AM"!==this.meridian&&"PM"!==this.meridian&&(this.meridian="AM")):this.hour>=24?this.hour=23:this.hour<0&&(this.hour=0),this.minute<0?this.minute=0:this.minute>=60&&(this.minute=59),this.showSeconds&&(isNaN(this.second)?this.second=0:this.second<0?this.second=0:this.second>=60&&(this.second=59)),this.update()},showWidget:function(){if(!this.isOpen&&!this.$element.is(":disabled")){var self=this;$(document).on("mousedown.timepicker",function(e){0===$(e.target).closest(".bootstrap-timepicker-widget").length&&self.hideWidget()}),this.$element.trigger({type:"show.timepicker",time:{value:this.getTime(),hours:this.hour,minutes:this.minute,seconds:this.second,meridian:this.meridian}}),this.disableFocus&&this.$element.blur(),this.updateFromElementVal(),"modal"===this.template&&this.$widget.modal?this.$widget.modal("show").on("hidden",$.proxy(this.hideWidget,this)):this.isOpen===!1&&this.$widget.addClass("open"),this.isOpen=!0}},toggleMeridian:function(){this.meridian="AM"===this.meridian?"PM":"AM",this.update()},update:function(){this.$element.trigger({type:"changeTime.timepicker",time:{value:this.getTime(),hours:this.hour,minutes:this.minute,seconds:this.second,meridian:this.meridian}}),this.updateElement(),this.updateWidget()},updateElement:function(){this.$element.val(this.getTime()).change()},updateFromElementVal:function(){var val=this.$element.val();val&&this.setTime(val)},updateWidget:function(){if(this.$widget!==!1){var hour=this.hour<10?"0"+this.hour:this.hour,minute=this.minute<10?"0"+this.minute:this.minute,second=this.second<10?"0"+this.second:this.second;this.showInputs?(this.$widget.find("input.bootstrap-timepicker-hour").val(hour),this.$widget.find("input.bootstrap-timepicker-minute").val(minute),this.showSeconds&&this.$widget.find("input.bootstrap-timepicker-second").val(second),this.showMeridian&&this.$widget.find("input.bootstrap-timepicker-meridian").val(this.meridian)):(this.$widget.find("span.bootstrap-timepicker-hour").text(hour),this.$widget.find("span.bootstrap-timepicker-minute").text(minute),this.showSeconds&&this.$widget.find("span.bootstrap-timepicker-second").text(second),this.showMeridian&&this.$widget.find("span.bootstrap-timepicker-meridian").text(this.meridian))}},updateFromWidgetInputs:function(){if(this.$widget!==!1){var time=$("input.bootstrap-timepicker-hour",this.$widget).val()+":"+$("input.bootstrap-timepicker-minute",this.$widget).val()+(this.showSeconds?":"+$("input.bootstrap-timepicker-second",this.$widget).val():"")+(this.showMeridian?" "+$("input.bootstrap-timepicker-meridian",this.$widget).val():"");this.setTime(time)}},widgetClick:function(e){e.stopPropagation(),e.preventDefault();var action=$(e.target).closest("a").data("action");action&&this[action]()},widgetKeydown:function(e){var $input=$(e.target).closest("input"),name=$input.attr("name");switch(e.keyCode){case 9:if(this.showMeridian){if("meridian"===name)return this.hideWidget()}else if(this.showSeconds){if("second"===name)return this.hideWidget()}else if("minute"===name)return this.hideWidget();this.updateFromWidgetInputs();break;case 27:this.hideWidget();break;case 38:switch(e.preventDefault(),name){case"hour":this.incrementHour();break;case"minute":this.incrementMinute();break;case"second":this.incrementSecond();break;case"meridian":this.toggleMeridian()}break;case 40:switch(e.preventDefault(),name){case"hour":this.decrementHour();break;case"minute":this.decrementMinute();break;case"second":this.decrementSecond();break;case"meridian":this.toggleMeridian()}}}},$.fn.timepicker=function(option){var args=Array.apply(null,arguments);return args.shift(),this.each(function(){var $this=$(this),data=$this.data("timepicker"),options="object"==typeof option&&option;data||$this.data("timepicker",data=new Timepicker(this,$.extend({},$.fn.timepicker.defaults,options,$(this).data()))),"string"==typeof option&&data[option].apply(data,args)})},$.fn.timepicker.defaults={defaultTime:"current",disableFocus:!1,isOpen:!1,minuteStep:15,modalBackdrop:!1,secondStep:15,showSeconds:!1,showInputs:!0,showMeridian:!0,template:"dropdown",appendWidgetTo:".bootstrap-timepicker",upArrowStyle:"glyphicon glyphicon-chevron-up",downArrowStyle:"glyphicon glyphicon-chevron-down",containerClass:"bootstrap-timepicker"},$.fn.timepicker.Constructor=Timepicker}(jQuery,window,document);