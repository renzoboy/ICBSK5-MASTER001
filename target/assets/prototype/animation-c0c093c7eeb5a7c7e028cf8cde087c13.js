YAHOO.util.Anim=function(el,attributes,duration,method){el&&this.init(el,attributes,duration,method)},YAHOO.util.Anim.prototype={doMethod:function(attribute,start,end){return this.method(this.currentFrame,start,end-start,this.totalFrames)},setAttribute:function(attribute,val,unit){YAHOO.util.Dom.setStyle(this.getEl(),attribute,val+unit)},getAttribute:function(attribute){return parseFloat(YAHOO.util.Dom.getStyle(this.getEl(),attribute))},defaultUnit:"px",defaultUnits:{opacity:" "},init:function(el,attributes,duration,method){var isAnimated=!1,startTime=null,endTime=null,actualFrames=0,defaultValues={};el=YAHOO.util.Dom.get(el),this.attributes=attributes||{},this.duration=duration||1,this.method=method||YAHOO.util.Easing.easeNone,this.useSeconds=!0,this.currentFrame=0,this.totalFrames=YAHOO.util.AnimMgr.fps,this.getEl=function(){return el},this.setDefault=function(attribute,val){if(val.constructor!=Array&&("auto"==val||isNaN(val)))switch(attribute){case"width":val=el.clientWidth||el.offsetWidth;break;case"height":val=el.clientHeight||el.offsetHeight;break;case"left":val="absolute"==YAHOO.util.Dom.getStyle(el,"position")?el.offsetLeft:0;break;case"top":val="absolute"==YAHOO.util.Dom.getStyle(el,"position")?el.offsetTop:0;break;default:val=0}defaultValues[attribute]=val},this.getDefault=function(attribute){return defaultValues[attribute]},this.isAnimated=function(){return isAnimated},this.getStartTime=function(){return startTime},this.animate=function(){if(this.isAnimated())return!1;this.onStart.fire(),this._onStart.fire(),this.totalFrames=this.useSeconds?Math.ceil(YAHOO.util.AnimMgr.fps*this.duration):this.duration,YAHOO.util.AnimMgr.registerElement(this);{var val,attributes=this.attributes;this.getEl()}for(var attribute in attributes)val=this.getAttribute(attribute),this.setDefault(attribute,val);isAnimated=!0,actualFrames=0,startTime=new Date},this.stop=function(){if(!this.isAnimated())return!1;this.currentFrame=0,endTime=new Date;var data={time:endTime,duration:endTime-startTime,frames:actualFrames,fps:actualFrames/this.duration};isAnimated=!1,actualFrames=0,this.onComplete.fire(data)};var onTween=function(){var start,val,unit,end=null,attributes=this.attributes;for(var attribute in attributes){if(unit=attributes[attribute].unit||this.defaultUnits[attribute]||this.defaultUnit,start="undefined"!=typeof attributes[attribute].from?attributes[attribute].from:this.getDefault(attribute),"undefined"!=typeof attributes[attribute].to)end=attributes[attribute].to;else if("undefined"!=typeof attributes[attribute].by)if(start.constructor==Array){end=[];for(var i=0,len=start.length;len>i;++i)end[i]=start[i]+attributes[attribute].by[i]}else end=start+attributes[attribute].by;null!==end&&"undefined"!=typeof end&&(val=this.doMethod(attribute,start,end),("width"==attribute||"height"==attribute||"opacity"==attribute)&&0>val&&(val=0),this.setAttribute(attribute,val,unit))}actualFrames+=1};this._onStart=new YAHOO.util.CustomEvent("_onStart",this),this.onStart=new YAHOO.util.CustomEvent("start",this),this.onTween=new YAHOO.util.CustomEvent("tween",this),this._onTween=new YAHOO.util.CustomEvent("_tween",this),this.onComplete=new YAHOO.util.CustomEvent("complete",this),this._onTween.subscribe(onTween)}},YAHOO.util.AnimMgr=new function(){var thread=null,queue=[],tweenCount=0;this.fps=200,this.delay=1,this.registerElement=function(tween){return tween.isAnimated()?!1:(queue[queue.length]=tween,tweenCount+=1,void this.start())},this.start=function(){null===thread&&(thread=setInterval(this.run,this.delay))},this.stop=function(tween){if(tween)tween.stop(),tweenCount-=1,0>=tweenCount&&this.stop();else{clearInterval(thread);for(var i=0,len=queue.length;len>i;++i)queue[i].isAnimated()&&queue[i].stop();queue=[],thread=null,tweenCount=0}},this.run=function(){for(var i=0,len=queue.length;len>i;++i){var tween=queue[i];tween&&tween.isAnimated()&&(tween.currentFrame<tween.totalFrames||null===tween.totalFrames?(tween.currentFrame+=1,tween.useSeconds&&correctFrame(tween),tween.onTween.fire(),tween._onTween.fire()):YAHOO.util.AnimMgr.stop(tween))}};var correctFrame=function(tween){var frames=tween.totalFrames,frame=tween.currentFrame,expected=tween.currentFrame*tween.duration*1e3/tween.totalFrames,elapsed=new Date-tween.getStartTime(),tweak=0;tweak=elapsed<1e3*tween.duration?Math.round((elapsed/expected-1)*tween.currentFrame):frames-(frame+1),tweak>0&&isFinite(tweak)&&(tween.currentFrame+tweak>=frames&&(tweak=frames-(frame+1)),tween.currentFrame+=tweak)}},YAHOO.util.Bezier=new function(){this.getPosition=function(points,t){for(var n=points.length,tmp=[],i=0;n>i;++i)tmp[i]=[points[i][0],points[i][1]];for(var j=1;n>j;++j)for(i=0;n-j>i;++i)tmp[i][0]=(1-t)*tmp[i][0]+t*tmp[parseInt(i+1,10)][0],tmp[i][1]=(1-t)*tmp[i][1]+t*tmp[parseInt(i+1,10)][1];return[tmp[0][0],tmp[0][1]]}},YAHOO.util.Easing=new function(){this.easeNone=function(t,b,c,d){return b+c*(t/=d)},this.easeIn=function(t,b,c,d){return b+c*(t/=d)*t*t},this.easeOut=function(t,b,c,d){var ts=(t/=d)*t,tc=ts*t;return b+c*(tc+-3*ts+3*t)},this.easeBoth=function(t,b,c,d){var ts=(t/=d)*t,tc=ts*t;return b+c*(-2*tc+3*ts)},this.backIn=function(t,b,c,d){var ts=(t/=d)*t,tc=ts*t;return b+c*(-3.4005*tc*ts+10.2*ts*ts+-6.2*tc+.4*ts)},this.backOut=function(t,b,c,d){var ts=(t/=d)*t,tc=ts*t;return b+c*(8.292*tc*ts+-21.88*ts*ts+22.08*tc+-12.69*ts+5.1975*t)},this.backBoth=function(t,b,c,d){var ts=(t/=d)*t,tc=ts*t;return b+c*(.402*tc*ts+-2.1525*ts*ts+-3.2*tc+8*ts+-2.05*t)}},YAHOO.util.Motion=function(el,attributes,duration,method){el&&this.initMotion(el,attributes,duration,method)},YAHOO.util.Motion.prototype=new YAHOO.util.Anim,YAHOO.util.Motion.prototype.defaultUnits.points="px",YAHOO.util.Motion.prototype.doMethod=function(attribute,start,end){var val=null;if("points"==attribute){var translatedPoints=this.getTranslatedPoints(),t=this.method(this.currentFrame,0,100,this.totalFrames)/100;translatedPoints&&(val=YAHOO.util.Bezier.getPosition(translatedPoints,t))}else val=this.method(this.currentFrame,start,end-start,this.totalFrames);return val},YAHOO.util.Motion.prototype.getAttribute=function(attribute){var val=null;return"points"==attribute?(val=[this.getAttribute("left"),this.getAttribute("top")],isNaN(val[0])&&(val[0]=0),isNaN(val[1])&&(val[1]=0)):val=parseFloat(YAHOO.util.Dom.getStyle(this.getEl(),attribute)),val},YAHOO.util.Motion.prototype.setAttribute=function(attribute,val,unit){"points"==attribute?(YAHOO.util.Dom.setStyle(this.getEl(),"left",val[0]+unit),YAHOO.util.Dom.setStyle(this.getEl(),"top",val[1]+unit)):YAHOO.util.Dom.setStyle(this.getEl(),attribute,val+unit)},YAHOO.util.Motion.prototype.initMotion=function(el,attributes,duration,method){YAHOO.util.Anim.call(this,el,attributes,duration,method),attributes=attributes||{},attributes.points=attributes.points||{},attributes.points.control=attributes.points.control||[],this.attributes=attributes;var start,end=null,translatedPoints=null;this.getTranslatedPoints=function(){return translatedPoints};var translateValues=function(val,self){var pageXY=YAHOO.util.Dom.getXY(self.getEl());return val=[val[0]-pageXY[0]+start[0],val[1]-pageXY[1]+start[1]]},onStart=function(){start=this.getAttribute("points");var attributes=this.attributes,control=attributes.points.control||[];control.length>0&&control[0].constructor!=Array&&(control=[control]),"static"==YAHOO.util.Dom.getStyle(this.getEl(),"position")&&YAHOO.util.Dom.setStyle(this.getEl(),"position","relative"),"undefined"!=typeof attributes.points.from?(YAHOO.util.Dom.setXY(this.getEl(),attributes.points.from),start=this.getAttribute("points")):(0===start[0]||0===start[1])&&(YAHOO.util.Dom.setXY(this.getEl(),YAHOO.util.Dom.getXY(this.getEl())),start=this.getAttribute("points"));var i,len;if("undefined"!=typeof attributes.points.to)for(end=translateValues(attributes.points.to,this),i=0,len=control.length;len>i;++i)control[i]=translateValues(control[i],this);else if("undefined"!=typeof attributes.points.by)for(end=[start[0]+attributes.points.by[0],start[1]+attributes.points.by[1]],i=0,len=control.length;len>i;++i)control[i]=[start[0]+control[i][0],start[1]+control[i][1]];end&&(translatedPoints=[start],control.length>0&&(translatedPoints=translatedPoints.concat(control)),translatedPoints[translatedPoints.length]=end)};this._onStart.subscribe(onStart)},YAHOO.util.Scroll=function(el,attributes,duration,method){el&&YAHOO.util.Anim.call(this,el,attributes,duration,method)},YAHOO.util.Scroll.prototype=new YAHOO.util.Anim,YAHOO.util.Scroll.prototype.defaultUnits.scroll=" ",YAHOO.util.Scroll.prototype.doMethod=function(attribute,start,end){var val=null;return val="scroll"==attribute?[this.method(this.currentFrame,start[0],end[0]-start[0],this.totalFrames),this.method(this.currentFrame,start[1],end[1]-start[1],this.totalFrames)]:this.method(this.currentFrame,start,end-start,this.totalFrames)},YAHOO.util.Scroll.prototype.getAttribute=function(attribute){var val=null,el=this.getEl();return val="scroll"==attribute?[el.scrollLeft,el.scrollTop]:parseFloat(YAHOO.util.Dom.getStyle(el,attribute))},YAHOO.util.Scroll.prototype.setAttribute=function(attribute,val,unit){var el=this.getEl();"scroll"==attribute?(el.scrollLeft=val[0],el.scrollTop=val[1]):YAHOO.util.Dom.setStyle(el,attribute,val+unit)};