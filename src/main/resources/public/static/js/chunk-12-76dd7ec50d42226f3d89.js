(window.webpackJsonp=window.webpackJsonp||[]).push([[12,18,23],{KChy:function(e,t,a){"use strict";a.r(t),a.d(t,"ReimbursementEmployeeListing",function(){return h});var s=a("q1tI"),i=a.n(s),n=a("Bbg3"),r=a("qcPu"),l=a("gePh");a("OA7p");class h extends s.Component{constructor(e){super(e),this.state={activePage:1,recordsPerPage:10,fields:[{label:"si no",key:"index"},{label:"Reimbursement Id",key:"reimbursementId"},{label:"date",key:"reimbursementDate"},{label:"Total cost",key:"totalCost"}]},this.handlePage=this.handlePage.bind(this),this.handleDetails=this.handleDetails.bind(this),this.gettingData=this.gettingData.bind(this)}componentDidMount(){app.events.trigger(n.q,{status:!1,reset:!0}),this.gettingData()}gettingData(){const e={page:this.state.activePage-1,empNo:this.props.match.params.empNo,size:this.state.recordsPerPage};r.a.postRequest("reimbursementEmployee",e).then(e=>{console.log(e),this.setState({totalRecords:e.totalElements,datas:e.reimbursementDetails})}).catch(e=>{console.log(e)})}handlePage(e){this.setState({activePage:e},()=>{this.gettingData()})}handleDetails(e){console.log("details"),console.log(e),app.events.trigger(n.r,{routerKey:n.z,params:{reimbursementId:e.reimbursementId}})}render(){return i.a.createElement("div",null,i.a.createElement(l.default,{totalRecords:this.state.totalRecords,fields:this.state.fields,datas:this.state.datas,pageHandler:this.handlePage,detailsHandler:this.handleDetails}))}}t.default=h},Kmxm:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),n=a("17x9"),r=a.n(n),l=(a("0oA5"),a("Bbg3"));class h extends i.a.Component{constructor(e){super(e),this.minNavItems=7,this.setProperties();let t={};t.pages=this.calculatePages(t),this.state=t}setProperties(){this.deepPaginationLimit=this.props.deepPaginationLimit||0,this.limitedPageNav=this.deepPaginationLimit>0,this.activePage=this.props.activePage,this.maxNavItems=this.props.maxNavItems<this.minNavItems?this.minNavItems:this.props.maxNavItems,this.totalItems=this.props.totalItems,this.itemsPerPage=this.props.itemsPerPage,"mini"==this.props.type&&(this.maxNavItems=1,this.itemsPerPage=1),this.totalPages=Math.floor(this.totalItems/this.itemsPerPage)+(this.totalItems%this.itemsPerPage==0?0:1),this.p={activePage:this.activePage,totalItems:this.totalItems}}prevPage(){return this.activePage>1}nextPage(){return this.activePage<this.totalPages}isPropertyChanged(){return this.props.totalItems!=this.p.totalItems||this.props.activePage!=this.p.activePage}changePage(e,t){if(e){let e=this.state;this.activePage=this.activePage+t,this.activePageChange(),this.props.onPageChange&&(e={totalPages:this.totalPages,totalItems:this.totalItems,itemsPerPage:this.itemsPerPage,activePage:this.activePage},this.props.onPageChange(e)),app.events.trigger(l.C)}}activePageChange(){let e=this.calculatePages();this.setState({pages:e})}isPageAccessable(e){return!this.limitedPageNav||e<=this.deepPaginationLimit}getPageData(e,t,a=!0,s){let i=[];for(let n=e;n<=t;n++)a&&!this.isPageAccessable(n)&&(a=!1),i.push({index:i.length,no:n,text:s||n,link:a,active:this.activePage==n});return i}calculatePages(e){if("mini"==this.props.type)return this.getPageData(this.activePage,this.activePage);if(this.maxNavItems>=this.totalPages)return this.getPageData(1,this.totalPages);let t=this.maxNavItems<9?1:this.maxNavItems>20?3:2,a=this.totalPages,s=this.activePage,i=[1,this.totalPages],n=1,r=Math.floor((this.maxNavItems-t)/2),l=a-(this.maxNavItems-r-t)+1,h=a;if(this.limitedPageNav){let e=s+Math.floor(this.maxNavItems/2);return n=1,(r=this.maxNavItems)<e&&(n=(r=e<=this.totalPages?e:this.totalPages)-this.maxNavItems+1),this.getPageData(n,r)}if(!i.includes(s)){let e=r==s?1:2;if(r==s||s==r+1)r+=e=s-r+1,l+=e;else if(l==s||l-1==s)r-=e=l-s+1,l-=e;else if(r<s&&l>s){e=2;let a=1,i=1,n=1,g=t>1?2:1;return s-r<3?(a=1,r-=2,l+=2,i=1,t>2&&(n=2)):l-s<3?(i=1,r-=2,l+=2,a=1,g=1,n=t>1?2:1,t>2&&(g=2)):(a=1,r-=2,l+=2,i=1,t>2&&(n=2)),[...this.getPageData(1,r),...this.getPageData(r+1,r+a,!1,"..."),...this.getPageData(s-n,s+g),...this.getPageData(l-i,l-1,!1,"..."),...this.getPageData(l,h)]}}return[...this.getPageData(1,r),...this.getPageData(r+1,r+t,!1,"..."),...this.getPageData(l,h)]}calculatePagesOld(e){let t=this.activePage,a=this.maxNavItems>=this.totalPages,s=a?this.totalPages:this.maxNavItems,i=[],n=a?0:s<9?1:s>20?3:2,r=this.totalPages,l=(Math.floor(r/3),Math.floor((s-n)/2)),h=Math.floor(l/2),g=Math.floor(h/2),o=1,c=l,m=r-l+1,p=r,d=c+1,P=m-1;if(!a&&t>=d&&t<=P){let e=t-h,a=t-g,i=t-l;e+s-1<=r&&(o=e,d=(c=e+l-1)+1),a+s-1<=r?(o=a,d=(c=a+l-1)+1):i+s-1<=r?(o=i,d=(c=i+l-1+n-(n>1?1:0))+1,n=n>1?1:0):m-n<=t?(c-=n,P=(m-=n)-1):t-c+o<m-1&&(o=t-c+o,c=t,P=(m-=1)-1)}let u=s-(c-o+n+p-m+2);u>0&&(t<=c?d=(c+=u)+1:P=(m-=u)-1);let v=0,b=0;for(b=o;b<=c;b++)i.push({index:i.length,no:b,text:b,link:!0,active:t==b}),v++;for(b=0;b<n;b++)i.push({index:i.length,no:b,text:"...",link:!1,active:!1}),v++;for(b=m;v<s&&b<=p;b++)i.push({index:i.length,no:b,text:b,link:!0,active:t==b}),v++;return i}componentDidUpdate(){this.isPropertyChanged()&&(this.setProperties(),this.activePageChange())}render(){return i.a.createElement("div",{className:"bxpagn "+(this.props.className||"")},i.a.createElement("nav",null,i.a.createElement("ul",{className:"pagination justify-content-center"+(this.totalPages<2?" d-none":"")},i.a.createElement("li",{className:"page-item "+(this.prevPage()?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(this.prevPage(),-1),className:"page-link cu-pointer"},i.a.createElement("i",{className:"fas fa-chevron-left"}))),this.state.pages.map((e,t)=>i.a.createElement("li",{key:t,className:"page-item "+(e.active?"active":e.link?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(e.link,e.no-this.activePage),className:"page-link cu-pointer"},i.a.createElement("span",{className:"number-font"},e.text)))),i.a.createElement("li",{className:"page-item "+(this.nextPage()?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(this.nextPage(),1),className:"page-link cu-pointer"},i.a.createElement("i",{className:"fas fa-chevron-right"}))))))}}h.propTypes={activePage:r.a.number,maxNavItems:r.a.number,totalItems:r.a.number.isRequired,itemsPerPage:r.a.number,onPageChange:r.a.func},h.defaultProps={activePage:1,maxNavItems:10,itemsPerPage:10},t.default=h},OA7p:function(e,t,a){},gePh:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),n=(a("Bbg3"),a("17x9")),r=a.n(n),l=a("Kmxm");class h extends s.Component{constructor(e){super(e),this.state={},this.renderTableHeader=this.renderTableHeader.bind(this),this.renderTableData=this.renderTableData.bind(this),this.onPageChange=this.onPageChange.bind(this)}renderTableHeader(){return this.props.fields.map((e,t)=>i.a.createElement("th",{key:t},e.label.toUpperCase()))}renderTableData(){const e=this.props.datas||[],t=this.props.fields||[];return e.map((e,a)=>i.a.createElement("tr",{key:a},t.map((t,s)=>{if("index"==t.key)return i.a.createElement("td",{key:s},a+1);if("editDelete"!==t.key&&"status"!==t.key)return 1==s?i.a.createElement("td",{key:s,onClick:()=>{this.props.detailsHandler(e)}},i.a.createElement("a",{href:"#"},e[t.key])):i.a.createElement("td",{key:s},e[t.key]);if("editDelete"==t.key)return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>{this.props.editHandler(e)},className:"btn btn-primary action"},i.a.createElement("i",{className:"fas fa-edit"})),i.a.createElement("button",{onClick:()=>{this.props.deleteHandler(e)},className:"btn btn-danger action"},i.a.createElement("i",{className:"fas fa-trash"})));if("status"==t.key){if("Assigned"==e[t.key])return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>this.props.unAssignHandler(e),className:"btn btn-warning"},"UnAssign"));if("Unassigned"==e[t.key])return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>this.props.assignHandler(e),className:"btn btn-success"},"Assign"))}})))}onPageChange(e){this.setState({activePage:e.activePage}),this.props.pageHandler(e.activePage)}render(){return i.a.createElement("div",null,i.a.createElement("table",{className:"table  list text-center"},i.a.createElement("thead",null,i.a.createElement("tr",null,this.renderTableHeader())),i.a.createElement("tbody",null,this.renderTableData())),i.a.createElement(l.default,{totalItems:this.props.totalRecords||1,onPageChange:this.onPageChange}))}}t.default=h,h.propTypes={totalRecords:r.a.number,recordsPerPage:r.a.number,activePage:r.a.number,datas:r.a.array,fields:r.a.array,pageHandler:r.a.func.isRequired,editHandler:r.a.func,deleteHandler:r.a.func},h.defaultProps={recordsPerPage:10,activePage:1}}}]);