(window.webpackJsonp=window.webpackJsonp||[]).push([[8,14,19],{D514:function(e,t,a){},Kmxm:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),r=a("17x9"),n=a.n(r),l=(a("0oA5"),a("Bbg3"));class h extends i.a.Component{constructor(e){super(e),this.minNavItems=7,this.setProperties();let t={};t.pages=this.calculatePages(t),this.state=t}setProperties(){this.deepPaginationLimit=this.props.deepPaginationLimit||0,this.limitedPageNav=this.deepPaginationLimit>0,this.activePage=this.props.activePage,this.maxNavItems=this.props.maxNavItems<this.minNavItems?this.minNavItems:this.props.maxNavItems,this.totalItems=this.props.totalItems,this.itemsPerPage=this.props.itemsPerPage,"mini"==this.props.type&&(this.maxNavItems=1,this.itemsPerPage=1),this.totalPages=Math.floor(this.totalItems/this.itemsPerPage)+(this.totalItems%this.itemsPerPage==0?0:1),this.p={activePage:this.activePage,totalItems:this.totalItems}}prevPage(){return this.activePage>1}nextPage(){return this.activePage<this.totalPages}isPropertyChanged(){return this.props.totalItems!=this.p.totalItems||this.props.activePage!=this.p.activePage}changePage(e,t){if(e){let e=this.state;this.activePage=this.activePage+t,this.activePageChange(),this.props.onPageChange&&(e={totalPages:this.totalPages,totalItems:this.totalItems,itemsPerPage:this.itemsPerPage,activePage:this.activePage},this.props.onPageChange(e)),app.events.trigger(l.F)}}activePageChange(){let e=this.calculatePages();this.setState({pages:e})}isPageAccessable(e){return!this.limitedPageNav||e<=this.deepPaginationLimit}getPageData(e,t,a=!0,s){let i=[];for(let r=e;r<=t;r++)a&&!this.isPageAccessable(r)&&(a=!1),i.push({index:i.length,no:r,text:s||r,link:a,active:this.activePage==r});return i}calculatePages(e){if("mini"==this.props.type)return this.getPageData(this.activePage,this.activePage);if(this.maxNavItems>=this.totalPages)return this.getPageData(1,this.totalPages);let t=this.maxNavItems<9?1:this.maxNavItems>20?3:2,a=this.totalPages,s=this.activePage,i=[1,this.totalPages],r=1,n=Math.floor((this.maxNavItems-t)/2),l=a-(this.maxNavItems-n-t)+1,h=a;if(this.limitedPageNav){let e=s+Math.floor(this.maxNavItems/2);return r=1,(n=this.maxNavItems)<e&&(r=(n=e<=this.totalPages?e:this.totalPages)-this.maxNavItems+1),this.getPageData(r,n)}if(!i.includes(s)){let e=n==s?1:2;if(n==s||s==n+1)n+=e=s-n+1,l+=e;else if(l==s||l-1==s)n-=e=l-s+1,l-=e;else if(n<s&&l>s){e=2;let a=1,i=1,r=1,o=t>1?2:1;return s-n<3?(a=1,n-=2,l+=2,i=1,t>2&&(r=2)):l-s<3?(i=1,n-=2,l+=2,a=1,o=1,r=t>1?2:1,t>2&&(o=2)):(a=1,n-=2,l+=2,i=1,t>2&&(r=2)),[...this.getPageData(1,n),...this.getPageData(n+1,n+a,!1,"..."),...this.getPageData(s-r,s+o),...this.getPageData(l-i,l-1,!1,"..."),...this.getPageData(l,h)]}}return[...this.getPageData(1,n),...this.getPageData(n+1,n+t,!1,"..."),...this.getPageData(l,h)]}calculatePagesOld(e){let t=this.activePage,a=this.maxNavItems>=this.totalPages,s=a?this.totalPages:this.maxNavItems,i=[],r=a?0:s<9?1:s>20?3:2,n=this.totalPages,l=(Math.floor(n/3),Math.floor((s-r)/2)),h=Math.floor(l/2),o=Math.floor(h/2),c=1,g=l,m=n-l+1,p=n,P=g+1,d=m-1;if(!a&&t>=P&&t<=d){let e=t-h,a=t-o,i=t-l;e+s-1<=n&&(c=e,P=(g=e+l-1)+1),a+s-1<=n?(c=a,P=(g=a+l-1)+1):i+s-1<=n?(c=i,P=(g=i+l-1+r-(r>1?1:0))+1,r=r>1?1:0):m-r<=t?(g-=r,d=(m-=r)-1):t-g+c<m-1&&(c=t-g+c,g=t,d=(m-=1)-1)}let u=s-(g-c+r+p-m+2);u>0&&(t<=g?P=(g+=u)+1:d=(m-=u)-1);let v=0,f=0;for(f=c;f<=g;f++)i.push({index:i.length,no:f,text:f,link:!0,active:t==f}),v++;for(f=0;f<r;f++)i.push({index:i.length,no:f,text:"...",link:!1,active:!1}),v++;for(f=m;v<s&&f<=p;f++)i.push({index:i.length,no:f,text:f,link:!0,active:t==f}),v++;return i}componentDidUpdate(){this.isPropertyChanged()&&(this.setProperties(),this.activePageChange())}render(){return i.a.createElement("div",{className:"bxpagn "+(this.props.className||"")},i.a.createElement("nav",null,i.a.createElement("ul",{className:"pagination justify-content-center"+(this.totalPages<2?" d-none":"")},i.a.createElement("li",{className:"page-item "+(this.prevPage()?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(this.prevPage(),-1),className:"page-link cu-pointer"},i.a.createElement("i",{className:"fas fa-chevron-left"}))),this.state.pages.map((e,t)=>i.a.createElement("li",{key:t,className:"page-item "+(e.active?"active":e.link?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(e.link,e.no-this.activePage),className:"page-link cu-pointer"},i.a.createElement("span",{className:"number-font"},e.text)))),i.a.createElement("li",{className:"page-item "+(this.nextPage()?"":"disabled")},i.a.createElement("a",{onClick:()=>this.changePage(this.nextPage(),1),className:"page-link cu-pointer"},i.a.createElement("i",{className:"fas fa-chevron-right"}))))))}}h.propTypes={activePage:n.a.number,maxNavItems:n.a.number,totalItems:n.a.number.isRequired,itemsPerPage:n.a.number,onPageChange:n.a.func},h.defaultProps={activePage:1,maxNavItems:10,itemsPerPage:10},t.default=h},gePh:function(e,t,a){"use strict";a.r(t);var s=a("q1tI"),i=a.n(s),r=(a("Bbg3"),a("17x9")),n=a.n(r),l=a("Kmxm"),h=a("hKt2");class o extends s.Component{constructor(e){super(e),this.state={},this.renderTableHeader=this.renderTableHeader.bind(this),this.renderTableData=this.renderTableData.bind(this),this.onPageChange=this.onPageChange.bind(this)}renderTableHeader(){return this.props.fields.map((e,t)=>this.props.sortRequired?0==t||"editDelete"==e.key||"status"==e.key?i.a.createElement("th",{key:t},e.label.toUpperCase()):i.a.createElement("th",{key:t},e.label.toUpperCase(),"   ",i.a.createElement("i",{class:"fas fa-sort",onClick:()=>{this.props.sortHandler(e)}})):i.a.createElement("th",{key:t},e.label.toUpperCase()))}renderTableData(){const e=this.props.datas||[],t=this.props.fields||[];return e.map((e,a)=>i.a.createElement("tr",{key:a},t.map((t,s)=>{let r=(this.state.activePage-1||0)*this.props.recordsPerPage+(a+1);if("index"==t.key)return i.a.createElement("td",{key:s},r);if("editDelete"!==t.key&&"status"!==t.key)return 1==s?i.a.createElement("td",{key:s,onClick:()=>{this.props.detailsHandler(e)}},i.a.createElement("a",{href:"#"},e[t.key])):i.a.createElement("td",{key:s},e[t.key]);if("editDelete"==t.key)return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>{this.props.editHandler(e)},className:"btn btn-primary action"},i.a.createElement("i",{className:"fas fa-edit"})),i.a.createElement("button",{onClick:()=>{this.props.deleteHandler(e)},className:"btn btn-danger action"},i.a.createElement("i",{className:"fas fa-trash"})));if("status"==t.key){if("Assigned"==e[t.key])return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>this.props.unAssignHandler(e),className:"btn btn-warning"},"UnAssign"));if("Unassigned"==e[t.key])return i.a.createElement("td",{key:s},i.a.createElement("button",{onClick:()=>this.props.assignHandler(e),className:"btn btn-success"},"Assign"))}})))}onPageChange(e){this.setState({activePage:e.activePage}),this.props.pageHandler(e.activePage)}render(){return i.a.createElement("div",null,i.a.createElement("table",{className:"table  list text-center"},i.a.createElement("thead",null,i.a.createElement("tr",null,this.renderTableHeader())),i.a.createElement("tbody",null,this.renderTableData())),this.props.datas&&this.props.datas.length<1&&i.a.createElement(h.default,null),i.a.createElement(l.default,{totalItems:this.props.totalRecords||1,onPageChange:this.onPageChange}))}}t.default=o,o.propTypes={totalRecords:n.a.number,recordsPerPage:n.a.number,activePage:n.a.number,datas:n.a.array,fields:n.a.array,pageHandler:n.a.func.isRequired,editHandler:n.a.func,deleteHandler:n.a.func,sortRequired:n.a.bool},o.defaultProps={recordsPerPage:10,activePage:1,sortRequired:!1}},hKt2:function(e,t,a){"use strict";a.r(t),a.d(t,"NoRecordsFound",function(){return r});var s=a("q1tI"),i=a.n(s);a("D514");class r extends s.Component{constructor(e){super(e),this.state={}}render(){return i.a.createElement("div",{class:" no-records"},i.a.createElement("h1",{className:"text-center"},"No Records Found"))}}t.default=r}}]);