(window.webpackJsonp=window.webpackJsonp||[]).push([[9,14,16,19,22,23],{"8vYt":function(e,t,a){"use strict";a.r(t);var s=a("+QwO"),i=a.n(s);function n(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);t&&(s=s.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),a.push.apply(a,s)}return a}function l(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}t.default=class{constructor(e){this.validations=e}validate(e){let t=this.valid();return this.validations.forEach(a=>{let s=a.aliasField||a.field;if(!a.disabled&&!t[s].isInvalid){const n=(e[s]||"").toString(),l=a.args||[];("string"==typeof a.method?i.a[a.method]:a.method)(n,...l,e,t,s)!=a.validWhen&&(t[s]={isInvalid:!0,message:a.message},t.isValid=!1)}}),t}enableDisableRules(e,t){this.validations.forEach(a=>{a.disabled=e.includes(a.field)?t:!!a.disabled})}valid(){const e={};return this.validations.map(t=>e[t.aliasField||t.field]={isInvalid:!1,message:""}),function(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?n(a,!0).forEach(function(t){l(e,t,a[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):n(a).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))})}return e}({isValid:!0},e)}}},ICSB:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),n=a("0oA5"),l=a("U1Tq"),r=a("iqOp"),o=a("YGfb");a("AjUr");function h(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);t&&(s=s.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),a.push.apply(a,s)}return a}function p(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?h(a,!0).forEach(function(t){c(e,t,a[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):h(a).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))})}return e}function c(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}class d extends i.a.Component{constructor(e){super(e),this.state={popoverOpen:!1},this.showPopover=this.showPopover.bind(this),this.hidePopover=this.hidePopover.bind(this)}showPopover(){this.setState({popoverOpen:!0})}hidePopover(){this.setState({popoverOpen:!1})}render(){return i.a.createElement(i.a.Fragment,null,i.a.createElement("i",{id:"guestCheckoutIcon",onMouseLeave:this.hidePopover,onClick:this.showPopover,className:"fas fa-info-circle cu-pointer"}),i.a.createElement(r.a,{placement:"right",isOpen:this.state.popoverOpen,target:"guestCheckoutIcon"},i.a.createElement(o.a,null,Object(n.p)(this.props.infoMsg))))}}t.default=class extends i.a.PureComponent{getComp(e){let t=p({},this.props,{id:e});switch(this.props.type){case"number":return i.a.createElement(l.NumberField,t);case"phone":return i.a.createElement(l.PhoneField,t);case"select":return i.a.createElement(l.Select,t);default:return i.a.createElement(l.Input,t)}}renderLabel(e,t={}){const a=this.props;return i.a.createElement("label",{title:t.text||a.title||"",htmlFor:e,className:t.className||a.labelClassName},Object(n.p)(t.text||a.label),!t.subTitle&&this.props.mandatory&&i.a.createElement("small",{className:"mandatory"},"*"))}render(){const e=this.props,t=e.id||e.name+(new Date).getTime(),a=this.getComp(t);return i.a.createElement("div",{className:e.hidden?"d-none":e.className||"form-group"},e.label&&!e.labelPostField&&this.renderLabel(t),a,e.label&&e.labelPostField&&this.renderLabel(t),e.subTitle&&this.renderLabel(t,p({},e.subTitle,{subTitle:!0})),e.infoMsg&&i.a.createElement(d,{infoMsg:e.infoMsg}))}}},U1Tq:function(e,t,a){"use strict";a.r(t),a.d(t,"Select",function(){return b}),a.d(t,"PhoneField",function(){return f}),a.d(t,"QuantityBox",function(){return y}),a.d(t,"NumberField",function(){return C}),a.d(t,"Input",function(){return N});var s=a("q1tI"),i=a.n(s),n=a("0oA5"),l=a("ltjX"),r=a("+QwO"),o=a.n(r),h=a("oI+J"),p=a("Z7gm"),c=a("X68C");function d(){return(d=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var s in a)Object.prototype.hasOwnProperty.call(a,s)&&(e[s]=a[s])}return e}).apply(this,arguments)}function m(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);t&&(s=s.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),a.push.apply(a,s)}return a}function u(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?m(a,!0).forEach(function(t){g(e,t,a[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):m(a).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))})}return e}function g(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}function v(e,t){let a=e.fieldClassName||"form-control",s=e.extraPops||{},l=u({id:e.id||e.name+(new Date).getTime(),name:e.nameAlias||e.name,disabled:!!e.disabled,value:void 0!=e.value?e.value:"",className:a+" "+(t.isInvalid&&"is-invalid"),placeholder:Object(n.p)(e.placeholder||"")},s);e.onChange&&(l.onChange=e.onChange),e.onKeyPress&&(l.onKeyPress=e.onKeyPress),e.onBlur&&(l.onBlur=e.onBlur),e.onClick&&(l.onClick=e.onClick);let r=e.type||"text";switch(e.type){case"textarea":return e.rows&&(l.rows=e.rows),i.a.createElement("textarea",l);case"radio":case"checkbox":l.checked=!!e.checked;default:return i.a.createElement("input",d({type:r},l))}}class b extends i.a.Component{constructor(e){super(e),this.changeHandler=this.changeHandler.bind(this),this.toggleDropDown=this.toggleDropDown.bind(this),this.onSearch=this.onSearch.bind(this),this.id=this.props.id||"select-"+this.props.name+"-"+(new Date).getTime(),this.setProps(),this.state={dropDownToggle:!1},this.searchable=!!this.p.searchable,this.searchItemLimit=this.p.searchItemLimit?parseInt(this.p.searchItemLimit):10,this.searchText=""}setProps(){let e=this.props.extraPops||{},t=this.props.value||this.props.defaultValue||"",a=0;this.options={},this.items=[],this.props.options&&this.props.options.forEach(e=>{if(e.value=e.value||e.code,e.key=e.key||e.value.trim().replace(/[^a-z0-9-]/gim,"_"),e.label=e.label||e.value,this.options[e.key]=e,this.options[e.value]=e,this.searchable){let t=new RegExp(this.searchText,"im");(!this.searchText||t.test(e.label))&&a<this.searchItemLimit&&(a++,this.items.push(e))}else this.items.push(e)}),this.p=u({},this.props,{type:"text",onChange:this.changeHandler},e,{value:t,id:this.id})}onSearch(e){this.searchText=e.target.value,this.searchText&&this.props.onSearch?this.props.onSearch(e,this.searchText):this.setState({searching:!0})}changeHandler(e){let t=e.currentTarget.attributes.valuekey.value;this.p.value=t,this.setState({dropDownToggle:!1}),this.props.onChange&&this.props.onChange(e,u({field:this.props.name,value:t,id:this.id},this.getItemInfo(t)))}getItemInfo(e){return this.options[e]||{}}toggleDropDown(){this.setState({dropDownToggle:!this.state.dropDownToggle})}render(){if(!this.props.options)return i.a.createElement("div",null);this.setProps();const e=this.p,t=this.props.validator&&this.props.validator[e.name]||{isInvalid:!1};return i.a.createElement(i.a.Fragment,null,i.a.createElement(h.a,{isOpen:this.state.dropDownToggle,toggle:this.toggleDropDown,className:"custom-select reactdrop w-auto "+(this.props.fieldClassName||"")+(t.isInvalid?" is-invalid":"")},i.a.createElement(p.a,{tag:"div",className:"reactdrop-lbl pr-2 position-relative d-flex"},e.preIcon&&i.a.createElement("i",{className:e.iconClassName}),i.a.createElement("label",{className:"m-0",title:Object(n.p)(this.getItemInfo(e.value).label||this.props.defaultValue||"")},Object(n.p)(this.getItemInfo(e.value).label||this.props.defaultValue||"")),!e.preIcon&&i.a.createElement("i",{className:e.iconClassName||"fas fa-sort sort-ico"})),i.a.createElement(c.a,{tag:"ul",className:"w-100"},i.a.createElement(i.a.Fragment,null,this.searchable&&this.props.options.length>this.searchItemLimit&&i.a.createElement("li",{className:"select-search-box"},i.a.createElement(N,{name:this.props.name+"-search",placeholder:"app.userorders.search",onChange:this.onSearch,value:this.searchText})),this.items.map((t,a)=>i.a.createElement("li",{className:"cu-pointer p-1 "+(e.value==t.value?"active":""),key:t.key||t.value,valuekey:t.key||t.value,value:t.value,onClick:this.changeHandler},i.a.createElement("label",{className:"m-0"},Object(n.p)(t.label)),e.itemIconConfig&&e.itemIconConfig.active&&e.value==t.value&&i.a.createElement("i",{className:e.itemIconConfig.className})))))),i.a.createElement(l.default,{htmlFor:this.id,error:Object(n.p)(t.message||"")}))}}class f extends i.a.Component{constructor(e){super(e),this.changeHandler=this.changeHandler.bind(this),this.id=this.props.id||"phone-"+this.props.name+"-"+(new Date).getTime(),this.setProps(),this.state={},this.valueChangable=!!this.props.onChange,this.countryCodes=app.phoneCountryCodes.map(e=>({value:e}))}setProps(){let e=!this.updated&&this.init&&this.p.value!=this.props.value,t=this.props.extraPops||{},a=this.props.value||this.props.defaultValue||"",s=app.phoneCountryCodes[0];a&&a.startsWith("+")&&(s=a.substring(0,3),a=a.substring(3)),this.p=u({},this.props,{contryCode:s,type:"text",onChange:this.changeHandler},t,{value:a,id:this.id}),e&&this.sendData(null)}changeHandler(e,t={}){this.updated=!0;let a=e.target.value;t.value?this.p.contryCode=t.value.toString():a&&o.a.isInt(a)&&(this.p.value=a&&"0"==a.charAt(0)?a.substring(1):a),a=this.p.contryCode+this.p.value,this.sendData(e)}valid(){let e=!o.a.isEmpty(this.p.value,{ignore_whitespace:!0})&&o.a.isInt(this.p.value);return(this.p.minLength||this.p.maxLength)&&e&&(e=o.a.isLength(this.p.value,{min:this.p.minLength||0,max:this.p.maxLength})),e}componentDidMount(){this.init=!0,this.sendData(null,{init:!0})}validPhone(){return this.p.contryCode+(this.p.value&&"0"==this.p.value.charAt(0)?this.p.value.substring(1):this.p.value)}sendData(e,t={}){this.props.onChange&&this.props.onChange(e,u({},t,{id:this.id,field:this.p.name,value:this.validPhone(),contryCode:this.p.contryCode,phone:this.p.value,valid:this.valid()}))}componentDidUpdate(){}render(){this.setProps();const e=this.p,t=this.props.validator&&this.props.validator[e.name]||{isInvalid:!1};return i.a.createElement(i.a.Fragment,null,i.a.createElement("div",{className:"phone-field d-flex"},i.a.createElement(b,{options:this.countryCodes,name:"country-"+e.name,value:e.contryCode,fieldClassName:"reactdrop",id:"country-"+this.id,onChange:this.changeHandler}),v(e,t)),i.a.createElement(l.default,{htmlFor:this.id,error:Object(n.p)(t.message||"")}))}}class y extends i.a.Component{constructor(e){super(e),this.changeHandler=this.changeHandler.bind(this),this.id=this.props.id||"quantity-"+this.props.name+"-"+(new Date).getTime(),this.setProps(),this.state={}}setProps(){let e=this.props.extraPops||{},t=this.props.value||this.props.defaultValue||"";this.p=u({},this.props,{type:"text",onChange:this.changeHandler},e,{value:t,id:this.id})}changeHandler(e,t={}){let a=t.action||e.currentTarget.getAttribute("action"),s=t.value||this.p.value,i=!1;"-"==a?(s=parseInt(s)-1,i=!0):"+"==a&&(s=parseInt(s)+1,i=!0),this.valid(s)&&(this.p.value=s,this.props.onChange&&this.props.onChange(e,{action:a,field:this.p.name,value:s,rawValue:s,id:this.id}),i&&this.props.onBlur&&this.props.onBlur(e,{eventType:"blur",field:this.p.name,value:s,rawValue:s,id:this.id}))}valid(e){let t=!0;return void 0!=this.p.min&&e<parseInt(this.p.min)&&(t=!1),void 0!=this.p.max&&e>parseInt(this.p.max)&&(t=!1),t}componentDidMount(){this.init=!0}componentDidUpdate(){}render(){this.setProps();const e=this.p;return i.a.createElement("div",{className:"form-group"},i.a.createElement("div",{className:"calculator"},i.a.createElement("div",{className:"input-group"},i.a.createElement("span",{className:"input-group-btn"},i.a.createElement("button",{type:"button",className:"btn btn-number",action:"-",onClick:this.changeHandler,disabled:this.props.value==this.p.min},i.a.createElement("i",{className:"fas fa-minus"}))),i.a.createElement(C,e),i.a.createElement("span",{className:"input-group-btn"},i.a.createElement("button",{type:"button",className:"btn btn-number",action:"+",onClick:this.changeHandler,disabled:this.props.value==this.p.max},i.a.createElement("i",{className:"fas fa-plus"}))))))}}class C extends i.a.Component{constructor(e){super(e),this.changeHandler=this.changeHandler.bind(this),this.onBlurHandler=this.onBlurHandler.bind(this),this.id=this.props.id||"number-"+this.props.name+"-"+(new Date).getTime(),this.setProps(),this.state={},this.valueChangable=!!this.props.onChange,this.validValue=this.props.value||this.p.defaultValue,this.decimalPlace=parseInt(this.p.decimalPlace||"0"),this.maxDigit=this.p.maxDigit?parseInt(this.p.maxDigit):null}setProps(e){let t=this.props.extraPops||{};this.p=u({},this.props,{type:"text",onChange:this.changeHandler,onBlur:this.onBlurHandler},t,{value:e||this.props.value||this.props.defaultValue||"",id:this.id})}onBlurHandler(e){this.props.onBlur&&this.props.onBlur(e,{eventType:"blur",field:this.p.name,value:this.p.value,rawValue:this.p.value,id:this.id})}process(e){let t=e.toString().split(".");return this.maxDigit&&t[0].length>this.maxDigit&&(t[0]=t[0].substring(0,this.maxDigit)),!this.decimalPlace&&e.toString().indexOf(".")>-1?t.splice(1,1):t[1]&&t[1].length>this.decimalPlace&&(t[1]=t[1].substring(0,this.decimalPlace)),t.join(".")}changeHandler(e){let t=e.target.value;e.target.name;if(t&&isNaN(Number(t)))return void this.setState({changed:!0});let a=(t=this.process(t))?this.decimalPlace>0?Object(n.q)(t,this.decimalPlace):parseInt(t):t,s=a==t?t:a;if(t=a,this.p.value=s,this.setState({value:t}),void 0!=this.p.min||void 0!=this.p.max){this.processing=!0,this.validationTimer&&clearTimeout(this.validationTimer),this.validationTimer=null;let t=Object(n.i)(s,this.p.min,this.p.max,(t,a)=>{let i=Object(n.q)(s,this.decimalPlace),l=s==i?s:i;console.log(i+"-----vvv-----"+l),t?this.validValue=s:l=i=this.p.emptyValue?"":parseFloat(this.p.defaultValue||this.validValue),this.p.value=l,this.setState({value:i},()=>this.processing=!1),this.sendData(e,{value:i,rawValue:l,resetted:!t})});this.validationTimer=t.timer,t.valid&&this.sendData(e,{value:t.value,rawValue:s})}else this.sendData(e,{value:t,rawValue:s})}sendData(e,t={}){this.props.onChange&&this.props.onChange(e,u({action:"click",field:this.p.name,id:this.id},t))}componentDidUpdate(){this.processing||!this.valueChangable||this.p.value==this.props.value||isNaN(this.props.value)||(this.p.value=this.props.value,this.setState({value:this.p.value})),this.setProps(this.p.value)}render(){const e=this.p,t=e.validator&&e.validator[e.name]||{isInvalid:!1};return i.a.createElement(i.a.Fragment,null,v(e,t),i.a.createElement(l.default,{htmlFor:this.id,error:Object(n.p)(t.message||"")}))}}class N extends i.a.PureComponent{render(){const e=this.props,t=e.validator&&e.validator[e.name]||{isInvalid:!1};return i.a.createElement(i.a.Fragment,null,v(e,t),i.a.createElement(l.default,{htmlFor:e.id,error:Object(n.p)(t.message||"")}))}}},UJ58:function(e,t,a){"use strict";a.r(t),a.d(t,"Heading",function(){return n});var s=a("q1tI"),i=a.n(s);a("bBnu");class n extends s.Component{constructor(e){super(e),this.state={}}render(){return i.a.createElement("div",{className:"row heading-row"},i.a.createElement("h4",null,this.props.heading))}}t.default=n},bBnu:function(e,t,a){},dQBp:function(e,t,a){"use strict";a.r(t),a.d(t,"registerEmployee",function(){return m});var s=a("q1tI"),i=a.n(s),n=a("Bbg3"),l=a("ICSB"),r=a("8vYt"),o=a("qcPu"),h=a("UJ58");function p(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var s=Object.getOwnPropertySymbols(e);t&&(s=s.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),a.push.apply(a,s)}return a}function c(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?p(a,!0).forEach(function(t){d(e,t,a[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):p(a).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))})}return e}function d(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}class m extends s.Component{constructor(e){super(e),this.validateFieldData=this.validateFieldData.bind(this),this.validEmailData=this.validEmailData.bind(this),this.validator=new r.default([{field:"firstName",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"First name is empty"},{field:"lastName",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Last name is empty"},{field:"designation",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Designation is empty"},{field:"email",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Email is empty"},{field:"email",method:this.validEmailData,args:[{ignore_whitespace:!0}],validWhen:!0,message:"Invalid format"},{field:"dob",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Date of birth is empty"},{field:"contactNo",method:this.validateFieldData,args:[{propName:"phone"}],validWhen:!0,message:"Contact number is empty"},{field:"contactNo",method:this.validateFieldData,args:[{propName:"valid"}],validWhen:!0,message:"Invalid contact number"},{field:"emergencyContactName",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Emergency contact name is empty"},{field:"emergencyContact",method:this.validateFieldData,args:[{propName:"phone"}],validWhen:!0,message:"Emergency contact number is empty"},{field:"emergencyContact",method:this.validateFieldData,args:[{propName:"valid"}],validWhen:!0,message:"Invalid emergency contact number"},{field:"healthCardNo",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Health card number is empty"},{field:"empNo",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Employee number is empty"},{field:"bloodGroup",method:"isEmpty",args:[{ignore_whitespace:!0}],validWhen:!1,message:"Select blood group"}]),this.state=c({},this.getStateData(this.props),{validation:this.validator.valid()}),this.handleInputChange=this.handleInputChange.bind(this),this.submit=this.submit.bind(this),this.update=this.update.bind(this),this.cancel=this.cancel.bind(this),this.fieldData={}}componentDidMount(){app.events.trigger(n.q,{status:!1,reset:!0}),-1!=this.props.match.params.empId&&o.a.getRequest("getEmpDetails",{empId:this.props.match.params.empId}).then(e=>{this.setState(c({},this.getStateData(e)))}).catch(e=>{console.error(e)})}getStateData(e){return{firstName:e.firstName||"",lastName:e.lastName||"",email:e.email||"",designation:e.designation||"",dob:e.dob||"",contactNo:e.contactNo||"",emergencyContactName:e.emergencyContactName||"",emergencyContact:e.emergencyContact||"",healthCardNo:e.healthCardNo||"",empNo:e.empNo||"",bloodGroup:e.bloodGroup||""}}validEmailData(e,t,a,s,i){return RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i).test(e)}validateFieldData(e,t,a,s,i){return this.fieldData[i]&&!!this.fieldData[i][t.propName]}handleInputChange(e,t={}){let a=t.field||e.target.name,s=t.value||e.target.value||"";this.fieldData[a]=t,e&&this.setState({[a]:"checkbox"==e.target.type?e.target.checked:s})}submit(){const e=this.validator.validate(this.state);this.setState({validation:e}),this.submitted=!0,e.isValid&&o.a.postRequest("registered",c({},this.getStateData(this.state))).then(e=>{"success"==e.status?app.events.trigger(n.F,{visible:!0,type:n.b.SUCESS,msg:"Successfully Submitted"}):app.events.trigger(n.F,{visible:!0,type:n.b.DANGER,msg:`${e.message}`})}).catch(e=>{console.log(e)})}update(){const e=this.validator.validate(this.state);this.setState({validation:e}),this.submitted=!0,e.isValid&&o.a.putRequest("updateEmployee",c({empId:this.props.match.params.empId},this.getStateData(this.state))).then(e=>{"success"==e.status?app.events.trigger(n.F,{visible:!0,type:n.b.SUCESS,msg:"Successfully updated"}):app.events.trigger(n.F,{visible:!0,type:n.b.DANGER,msg:`${e.message}`})}).catch(e=>{console.log(e)})}cancel(){app.events.trigger(n.r,{routerKey:n.o})}render(){let e=this.submitted?this.validator.validate(this.state):this.state.validation;var t=this.props.match.params.empId;return i.a.createElement("div",{className:"form-wrapper"},-1==t?i.a.createElement(h.default,{heading:"REGISTER EMPLOYEE"}):i.a.createElement(h.default,{heading:"UPDATE EMPLOYEE"}),i.a.createElement("div",{className:"d-flex justify-content-sm-around"},i.a.createElement("div",{className:"p-2 w-25 mt-5"},i.a.createElement(l.default,{label:"First Name",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,name:"firstName",onChange:this.handleInputChange,value:this.state.firstName,placeholder:"First Name",validator:e}),i.a.createElement(l.default,{label:"Last Name",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"lastName",value:this.state.lastName,placeholder:"Last Name",validator:e}),i.a.createElement(l.default,{label:"Email",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"email",value:this.state.email,placeholder:"Email",validator:e}),i.a.createElement(l.default,{label:"Designation",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"designation",value:this.state.designation,placeholder:"Designation",validator:e}),i.a.createElement(l.default,{label:"DOB",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"dob",type:-1==t?"date":"",value:this.state.dob,placeholder:"DOB",validator:e})),i.a.createElement("div",{className:"p-2 w-25 mt-5"},i.a.createElement(l.default,{label:"Contact Number",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"contactNo",value:this.state.contactNo,placeholder:"Contact Number",type:"phone",minLength:"8",maxLength:"10",validator:e}),i.a.createElement(l.default,{label:"Emergency Contact Name",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"emergencyContactName",value:this.state.emergencyContactName,placeholder:"Emergency Contact Name",validator:e}),i.a.createElement(l.default,{label:"Emergency Contact Number",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"emergencyContact",value:this.state.emergencyContact,placeholder:"Emergency Contact Number",type:"phone",minLength:"8",maxLength:"10",validator:e}),i.a.createElement(l.default,{label:"Healthcard Number",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,onChange:this.handleInputChange,name:"healthCardNo",value:this.state.healthCardNo,placeholder:"Healthcard Number",validator:e}),i.a.createElement(l.default,{label:"Employee Number",labelClassName:"txt-label",fieldClassName:"txt-input",mandatory:!0,disabled:"-1"!=t,onChange:this.handleInputChange,name:"empNo",value:this.state.empNo,placeholder:"Employee Number",validator:e}),i.a.createElement(l.default,{type:"select",label:"Blood Group",labelClassName:"txt-label",fieldClassName:"select-input",mandatory:!0,name:"bloodGroup",nameAlias:"abc_fullName",onChange:this.handleInputChange,options:[{value:"A+",label:"A+"},{value:"A-",label:"A-"},{value:"B",label:"B+"},{value:"B-",label:"B-"},{value:"AB+",label:"AB+"},{value:"AB-",label:"AB-"},{value:"O+",label:"O+"},{value:"O-",label:"O-"}],value:this.state.bloodGroup,placeholder:"Blood Group",validator:e}))),i.a.createElement("div",{className:"btn-wrapper"},"-1"==t?i.a.createElement("button",{type:"button",className:"btn submit-btn",onClick:this.submit},"Submit"):i.a.createElement("button",{type:"button",className:"btn submit-btn",onClick:this.update},"Update"),i.a.createElement("button",{type:"button",className:"btn cancel-btn",onClick:this.cancel},"Cancel")))}}t.default=m},ltjX:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),n=a("0oA5");t.default=class extends i.a.PureComponent{render(){if(!this.props.error&&!this.props.msg)return null;let e="error"==(this.props.type||"error");return i.a.createElement("div",{className:(this.props.htmFor?"":e?"is-invalid ":"is-valid ")+(e?"invalid-feedback":"valid-feedback")+" "+this.props.className,dangerouslySetInnerHTML:{__html:Object(n.p)(this.props.msg||this.props.error)}})}}}}]);