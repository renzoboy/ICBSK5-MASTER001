!function($){function getBlacklistAscii(){var blacklist="!@#$%^&*()+=[]\\';,/{}|\":<>?~`.-_";return blacklist+=" "}function getBlacklistNonAscii(){var blacklist="¬€£¦";return blacklist}function setupEventHandlers($textboxes,trimFunction,settings){$textboxes.each(function(){var $textbox=$(this);$textbox.off(".alphanum").on("keyup.alphanum change.alphanum paste.alphanum",function(e){var pastedText="";e.originalEvent&&e.originalEvent.clipboardData&&e.originalEvent.clipboardData.getData&&(pastedText=e.originalEvent.clipboardData.getData("text/plain")),setTimeout(function(){trimTextbox($textbox,trimFunction,settings,pastedText)},0)}).on("keypress.alphanum",function(e){var charCode=e.charCode?e.charCode:e.which;if(!(isControlKey(charCode)||e.ctrlKey||e.metaKey)){var newChar=String.fromCharCode(charCode),selectionObject=$textbox.selection(),start=selectionObject.start,end=selectionObject.end,textBeforeKeypress=$textbox.val(),potentialTextAfterKeypress=textBeforeKeypress.substring(0,start)+newChar+textBeforeKeypress.substring(end),validatedText=trimFunction(potentialTextAfterKeypress,settings);validatedText!=potentialTextAfterKeypress&&e.preventDefault()}})})}function numericField_Blur(inputBox,settings){var fieldValueNumeric=parseFloat($(inputBox).val()),$inputBox=$(inputBox);return isNaN(fieldValueNumeric)?void $inputBox.val(""):(isNumeric(settings.min)&&fieldValueNumeric<settings.min&&$inputBox.val(""),void(isNumeric(settings.max)&&fieldValueNumeric>settings.max&&$inputBox.val("")))}function isNumeric(value){return!isNaN(value)}function isControlKey(charCode){return charCode>=32?!1:10==charCode?!1:13==charCode?!1:!0}function trimTextbox($textBox,trimFunction,settings,pastedText){var inputString=$textBox.val();""==inputString&&pastedText.length>0&&(inputString=pastedText);var outputString=trimFunction(inputString,settings);if(inputString!=outputString){var caretPos=$textBox.alphanum_caret();$textBox.val(outputString),$textBox.alphanum_caret(inputString.length==outputString.length+1?caretPos-1:caretPos)}}function getCombinedSettingsAlphaNum(settings,defaultSettings){"undefined"==typeof defaultSettings&&(defaultSettings=DEFAULT_SETTINGS_ALPHANUM);var userSettings,combinedSettings={};return userSettings="string"==typeof settings?CONVENIENCE_SETTINGS_ALPHANUM[settings]:"undefined"==typeof settings?{}:settings,$.extend(combinedSettings,defaultSettings,userSettings),"undefined"==typeof combinedSettings.blacklist&&(combinedSettings.blacklistSet=getBlacklistSet(combinedSettings.allow,combinedSettings.disallow)),combinedSettings}function getCombinedSettingsNum(settings){var userSettings,combinedSettings={};return userSettings="string"==typeof settings?CONVENIENCE_SETTINGS_NUMERIC[settings]:"undefined"==typeof settings?{}:settings,$.extend(combinedSettings,DEFAULT_SETTINGS_NUM,userSettings),combinedSettings}function alphanum_allowChar(validatedStringFragment,Char,settings){return settings.maxLength&&validatedStringFragment.length>=settings.maxLength?!1:settings.allow.indexOf(Char)>=0?!0:settings.allowSpace&&" "==Char?!0:settings.allowNewline||"\n"!=Char&&"\r"!=Char?settings.blacklistSet.contains(Char)?!1:!settings.allowNumeric&&DIGITS[Char]?!1:!settings.allowUpper&&isUpper(Char)?!1:!settings.allowLower&&isLower(Char)?!1:!settings.allowCaseless&&isCaseless(Char)?!1:!settings.allowLatin&&LATIN_CHARS.contains(Char)?!1:settings.allowOtherCharSets?!0:DIGITS[Char]||LATIN_CHARS.contains(Char)?!0:!1:!1}function numeric_allowChar(validatedStringFragment,Char,settings){if(DIGITS[Char])return isMaxDigitsReached(validatedStringFragment,settings)?!1:isMaxPreDecimalsReached(validatedStringFragment,settings)?!1:isMaxDecimalsReached(validatedStringFragment,settings)?!1:isGreaterThanMax(validatedStringFragment+Char,settings)?!1:isLessThanMin(validatedStringFragment+Char,settings)?!1:!0;if(settings.allowPlus&&"+"==Char&&""==validatedStringFragment)return!0;if(settings.allowMinus&&"-"==Char&&""==validatedStringFragment)return!0;if(Char==THOU_SEP&&settings.allowThouSep&&allowThouSep(validatedStringFragment))return!0;if(Char==DEC_SEP){if(validatedStringFragment.indexOf(DEC_SEP)>=0)return!1;if(settings.allowDecSep&&0===settings.maxDecimalPlaces)return!1;if(settings.allowDecSep)return!0}return!1}function countDigits(string){return string+="",string.replace(/[^0-9]/g,"").length}function isMaxDigitsReached(string,settings){var maxDigits=settings.maxDigits;if(""===maxDigits||isNaN(maxDigits))return!1;var numDigits=countDigits(string);return numDigits>=maxDigits?!0:!1}function isMaxDecimalsReached(string,settings){var maxDecimalPlaces=settings.maxDecimalPlaces;if(""===maxDecimalPlaces||isNaN(maxDecimalPlaces))return!1;var indexOfDecimalPoint=string.indexOf(DEC_SEP);if(-1==indexOfDecimalPoint)return!1;var decimalSubstring=string.substring(indexOfDecimalPoint),numDecimals=countDigits(decimalSubstring);return numDecimals>=maxDecimalPlaces?!0:!1}function isMaxPreDecimalsReached(string,settings){var maxPreDecimalPlaces=settings.maxPreDecimalPlaces;if(""===maxPreDecimalPlaces||isNaN(maxPreDecimalPlaces))return!1;var indexOfDecimalPoint=string.indexOf(DEC_SEP);if(indexOfDecimalPoint>=0)return!1;var numPreDecimalDigits=countDigits(string);return numPreDecimalDigits>=maxPreDecimalPlaces?!0:!1}function isGreaterThanMax(numericString,settings){if(!settings.max||settings.max<0)return!1;var outputNumber=parseFloat(numericString);return outputNumber>settings.max?!0:!1}function isLessThanMin(numericString,settings){if(!settings.min||settings.min>0)return!1;var outputNumber=parseFloat(numericString);return outputNumber<settings.min?!0:!1}function trimAlphaNum(inputString,settings){if("string"!=typeof inputString)return inputString;var Char,inChars=inputString.split(""),outChars=[],i=0;for(i=0;i<inChars.length;i++){Char=inChars[i];var validatedStringFragment=outChars.join("");alphanum_allowChar(validatedStringFragment,Char,settings)&&outChars.push(Char)}var outputString=outChars.join("");return settings.forceLower?outputString=outputString.toLowerCase():settings.forceUpper&&(outputString=outputString.toUpperCase()),outputString}function trimNum(inputString,settings){if("string"!=typeof inputString)return inputString;var Char,inChars=inputString.split(""),outChars=[],i=0;for(i=0;i<inChars.length;i++){Char=inChars[i];var validatedStringFragment=outChars.join("");numeric_allowChar(validatedStringFragment,Char,settings)&&outChars.push(Char)}return outChars.join("")}function isUpper(Char){var upper=Char.toUpperCase(),lower=Char.toLowerCase();return Char==upper&&upper!=lower?!0:!1}function isLower(Char){var upper=Char.toUpperCase(),lower=Char.toLowerCase();return Char==lower&&upper!=lower?!0:!1}function isCaseless(Char){return Char.toUpperCase()==Char.toLowerCase()?!0:!1}function getBlacklistSet(allow,disallow){var setOfBadChars=new Set(BLACKLIST+disallow),setOfGoodChars=new Set(allow),blacklistSet=setOfBadChars.subtract(setOfGoodChars);return blacklistSet}function getDigitsMap(){var digit,array="0123456789".split(""),map={},i=0;for(i=0;i<array.length;i++)digit=array[i],map[digit]=!0;return map}function getLatinCharsSet(){var lower="abcdefghijklmnopqrstuvwxyz",upper=lower.toUpperCase(),azAZ=new Set(lower+upper);return azAZ}function allowThouSep(currentString){if(0==currentString.length)return!1;var posOfDecSep=currentString.indexOf(DEC_SEP);if(posOfDecSep>=0)return!1;var posOfFirstThouSep=currentString.indexOf(THOU_SEP);if(0>posOfFirstThouSep)return!0;var posOfLastThouSep=currentString.lastIndexOf(THOU_SEP),charsSinceLastThouSep=currentString.length-posOfLastThouSep-1;if(3>charsSinceLastThouSep)return!1;var digitsSinceFirstThouSep=countDigits(currentString.substring(posOfFirstThouSep));return digitsSinceFirstThouSep%3>0?!1:!0}function Set(elems){this.map="string"==typeof elems?stringToMap(elems):{}}function stringToMap(string){var Char,map={},array=string.split(""),i=0;for(i=0;i<array.length;i++)Char=array[i],map[Char]=!0;return map}$.fn.alphanum=function(settings){var combinedSettings=getCombinedSettingsAlphaNum(settings),$collection=this;return setupEventHandlers($collection,trimAlphaNum,combinedSettings),this},$.fn.alpha=function(settings){var defaultAlphaSettings=getCombinedSettingsAlphaNum("alpha"),combinedSettings=getCombinedSettingsAlphaNum(settings,defaultAlphaSettings),$collection=this;return setupEventHandlers($collection,trimAlphaNum,combinedSettings),this},$.fn.numeric=function(settings){var combinedSettings=getCombinedSettingsNum(settings),$collection=this;return setupEventHandlers($collection,trimNum,combinedSettings),$collection.blur(function(){numericField_Blur(this,combinedSettings)}),this};var DEFAULT_SETTINGS_ALPHANUM={allow:"",disallow:"",allowSpace:!0,allowNewline:!0,allowNumeric:!0,allowUpper:!0,allowLower:!0,allowCaseless:!0,allowLatin:!0,allowOtherCharSets:!0,forceUpper:!1,forceLower:!1,maxLength:0/0},DEFAULT_SETTINGS_NUM={allowPlus:!1,allowMinus:!0,allowThouSep:!0,allowDecSep:!0,allowLeadingSpaces:!1,maxDigits:0/0,maxDecimalPlaces:0/0,maxPreDecimalPlaces:0/0,max:0/0,min:0/0},CONVENIENCE_SETTINGS_ALPHANUM={alpha:{allowNumeric:!1},upper:{allowNumeric:!1,allowUpper:!0,allowLower:!1,allowCaseless:!0},lower:{allowNumeric:!1,allowUpper:!1,allowLower:!0,allowCaseless:!0}},CONVENIENCE_SETTINGS_NUMERIC={integer:{allowPlus:!1,allowMinus:!0,allowThouSep:!1,allowDecSep:!1},positiveInteger:{allowPlus:!1,allowMinus:!1,allowThouSep:!1,allowDecSep:!1}},BLACKLIST=getBlacklistAscii()+getBlacklistNonAscii(),THOU_SEP=",",DEC_SEP=".",DIGITS=getDigitsMap(),LATIN_CHARS=getLatinCharsSet();Set.prototype.add=function(set){var newSet=this.clone();for(var key in set.map)newSet.map[key]=!0;return newSet},Set.prototype.subtract=function(set){var newSet=this.clone();for(var key in set.map)delete newSet.map[key];return newSet},Set.prototype.contains=function(key){return this.map[key]?!0:!1},Set.prototype.clone=function(){var newSet=new Set;for(var key in this.map)newSet.map[key]=!0;return newSet},$.fn.alphanum.backdoorAlphaNum=function(inputString,settings){var combinedSettings=getCombinedSettingsAlphaNum(settings);return trimAlphaNum(inputString,combinedSettings)},$.fn.alphanum.backdoorNumeric=function(inputString,settings){var combinedSettings=getCombinedSettingsNum(settings);return trimNum(inputString,combinedSettings)},$.fn.alphanum.setNumericSeparators=function(settings){1==settings.thousandsSeparator.length&&1==settings.decimalSeparator.length&&(THOU_SEP=settings.thousandsSeparator,DEC_SEP=settings.decimalSeparator)}}(jQuery),function($){function caretTo(el,index){if(el.createTextRange){var range=el.createTextRange();range.move("character",index),range.select()}else null!=el.selectionStart&&(el.focus(),el.setSelectionRange(index,index))}function caretPos(el){if("selection"in document){var range=el.createTextRange();try{range.setEndPoint("EndToStart",document.selection.createRange())}catch(e){return 0}return range.text.length}return null!=el.selectionStart?el.selectionStart:void 0}$.fn.alphanum_caret=function(index,offset){return"undefined"==typeof index?caretPos(this.get(0)):this.queue(function(next){if(isNaN(index)){var i=$(this).val().indexOf(index);offset===!0?i+=index.length:"undefined"!=typeof offset&&(i+=offset),caretTo(this,i)}else caretTo(this,index);next()})}}(jQuery),function(e){var r=function(e){return e?e.ownerDocument.defaultView||e.ownerDocument.parentWindow:window},i=function(t){var r=e.Range.current(t).clone(),i=e.Range(t).select(t);return r.overlaps(i)?(r.compare("START_TO_START",i)<1?(startPos=0,r.move("START_TO_START",i)):(fromElementToCurrent=i.clone(),fromElementToCurrent.move("END_TO_START",r),startPos=fromElementToCurrent.toString().length),endPos=r.compare("END_TO_END",i)>=0?i.toString().length:startPos+r.toString().length,{start:startPos,end:endPos}):null},s=function(t){var n=r(t);if(void 0!==t.selectionStart)return document.activeElement&&document.activeElement!=t&&t.selectionStart==t.selectionEnd&&0==t.selectionStart?{start:t.value.length,end:t.value.length}:{start:t.selectionStart,end:t.selectionEnd};if(n.getSelection)return i(t,n);try{if("input"==t.nodeName.toLowerCase()){var s=r(t).document.selection.createRange(),o=t.createTextRange();o.setEndPoint("EndToStart",s);var u=o.text.length;return{start:u,end:u+s.text.length}}var a=i(t,n);if(!a)return a;var f=e.Range.current().clone(),l=f.clone().collapse().range,c=f.clone().collapse(!1).range;return l.moveStart("character",-1),c.moveStart("character",-1),0!=a.startPos&&""==l.text&&(a.startPos+=2),0!=a.endPos&&""==c.text&&(a.endPos+=2),a}catch(h){return{start:t.value.length,end:t.value.length}}},o=function(e,t,n){var i=r(e);if(e.setSelectionRange)void 0===n?(e.focus(),e.setSelectionRange(t,t)):(e.select(),e.selectionStart=t,e.selectionEnd=n);else if(e.createTextRange){var s=e.createTextRange();s.moveStart("character",t),n=n||t,s.moveEnd("character",n-e.value.length),s.select()}else if(i.getSelection){var o=i.document,u=i.getSelection(),f=o.createRange(),l=[t,void 0!==n?n:t];a([e],l),f.setStart(l[0].el,l[0].count),f.setEnd(l[1].el,l[1].count),u.removeAllRanges(),u.addRange(f)}else if(i.document.body.createTextRange){var f=document.body.createTextRange();f.moveToElementText(e),f.collapse(),f.moveStart("character",t),f.moveEnd("character",void 0!==n?n:t),f.select()}},u=function(e,t,n,r){"number"==typeof n[0]&&n[0]<t&&(n[0]={el:r,count:n[0]-e}),"number"==typeof n[1]&&n[1]<=t&&(n[1]={el:r,count:n[1]-e})},a=function(e,t,n){var r,i;n=n||0;for(var s=0;e[s];s++)r=e[s],3===r.nodeType||4===r.nodeType?(i=n,n+=r.nodeValue.length,u(i,n,t,r)):8!==r.nodeType&&(n=a(r.childNodes,t,n));return n};jQuery.fn.selection=function(e,t){return void 0!==e?this.each(function(){o(this,e,t)}):s(this[0])},e.fn.selection.getCharElement=a}(jQuery);