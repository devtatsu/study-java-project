"use strict";(self.webpackChunkwebsite=self.webpackChunkwebsite||[]).push([[803],{3905:function(t,e,n){n.d(e,{Zo:function(){return d},kt:function(){return N}});var a=n(7294);function r(t,e,n){return e in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function l(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(t);e&&(a=a.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,a)}return n}function i(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?l(Object(n),!0).forEach((function(e){r(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):l(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}function p(t,e){if(null==t)return{};var n,a,r=function(t,e){if(null==t)return{};var n,a,r={},l=Object.keys(t);for(a=0;a<l.length;a++)n=l[a],e.indexOf(n)>=0||(r[n]=t[n]);return r}(t,e);if(Object.getOwnPropertySymbols){var l=Object.getOwnPropertySymbols(t);for(a=0;a<l.length;a++)n=l[a],e.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(t,n)&&(r[n]=t[n])}return r}var m=a.createContext({}),u=function(t){var e=a.useContext(m),n=e;return t&&(n="function"==typeof t?t(e):i(i({},e),t)),n},d=function(t){var e=u(t.components);return a.createElement(m.Provider,{value:e},t.children)},o={inlineCode:"code",wrapper:function(t){var e=t.children;return a.createElement(a.Fragment,{},e)}},k=a.forwardRef((function(t,e){var n=t.components,r=t.mdxType,l=t.originalType,m=t.parentName,d=p(t,["components","mdxType","originalType","parentName"]),k=u(n),N=r,f=k["".concat(m,".").concat(N)]||k[N]||o[N]||l;return n?a.createElement(f,i(i({ref:e},d),{},{components:n})):a.createElement(f,i({ref:e},d))}));function N(t,e){var n=arguments,r=e&&e.mdxType;if("string"==typeof t||r){var l=n.length,i=new Array(l);i[0]=k;var p={};for(var m in e)hasOwnProperty.call(e,m)&&(p[m]=e[m]);p.originalType=t,p.mdxType="string"==typeof t?t:r,i[1]=p;for(var u=2;u<l;u++)i[u]=n[u];return a.createElement.apply(null,i)}return a.createElement.apply(null,n)}k.displayName="MDXCreateElement"},5023:function(t,e,n){n.r(e),n.d(e,{contentTitle:function(){return m},default:function(){return k},frontMatter:function(){return p},metadata:function(){return u},toc:function(){return d}});var a=n(7462),r=n(3366),l=(n(7294),n(3905)),i=["components"],p={sidebar_label:"\u8a2d\u8a08\u66f8",title:"\u8a2d\u8a08\u6642\u306e\u8003\u3048\u65b9\u3068\u4f5c\u6210"},m=void 0,u={unversionedId:"design-documents/design-documents",id:"design-documents/design-documents",isDocsHomePage:!1,title:"\u8a2d\u8a08\u6642\u306e\u8003\u3048\u65b9\u3068\u4f5c\u6210",description:"REST API",source:"@site/docs/design-documents/design-documents.md",sourceDirName:"design-documents",slug:"/design-documents/design-documents",permalink:"/study-java-project/design-documents/design-documents",tags:[],version:"current",frontMatter:{sidebar_label:"\u8a2d\u8a08\u66f8",title:"\u8a2d\u8a08\u6642\u306e\u8003\u3048\u65b9\u3068\u4f5c\u6210"}},d=[{value:"REST API",id:"rest-api",children:[{value:"\u5165\u529b\uff08INPUT\uff09\u3068\u51fa\u529b\uff08OUTPUT\uff09",id:"\u5165\u529binput\u3068\u51fa\u529boutput",children:[]},{value:"\u30ea\u30bd\u30fc\u30b9\u3068\u64cd\u4f5c",id:"\u30ea\u30bd\u30fc\u30b9\u3068\u64cd\u4f5c",children:[]}]},{value:"\u30d0\u30c3\u30c1\u30b5\u30fc\u30d3\u30b9",id:"\u30d0\u30c3\u30c1\u30b5\u30fc\u30d3\u30b9",children:[]}],o={toc:d};function k(t){var e=t.components,n=(0,r.Z)(t,i);return(0,l.kt)("wrapper",(0,a.Z)({},o,n,{components:e,mdxType:"MDXLayout"}),(0,l.kt)("h2",{id:"rest-api"},"REST API"),(0,l.kt)("p",null,"\u30d7\u30ed\u30b8\u30a7\u30af\u30c8\u3067\u5b9a\u3081\u305f\u5de5\u7a0b\u3084\u30eb\u30fc\u30eb\u306b\u3088\u3063\u3066\u3001\u305d\u308c\u305e\u308c\u306e\u8a2d\u8a08\u66f8\uff08\u4f8b\u3048\u3070\u3001\u57fa\u672c\u8a2d\u8a08\u3084\u8a73\u7d30\u8a2d\u8a08 \u7b49\uff09\u3078\u8a18\u8f09\u3059\u3079\u304d\u5185\u5bb9\u306f\u5909\u308f\u308a\u307e\u3059\u304c\u3001\n\u57fa\u672c\u7684\u306b\u3001",(0,l.kt)("inlineCode",{parentName:"p"},"REST API"),"\u306e\u8a2d\u8a08\u3092\u9032\u3081\u308b\u4e2d\u3067\u7e8f\u3081\u308b\u5fc5\u8981\u304c\u3042\u308b\u30dd\u30a4\u30f3\u30c8\u306f\u4ee5\u4e0b\u306e\u3068\u304a\u308a\u3067\u3059\u3002"),(0,l.kt)("h3",{id:"\u5165\u529binput\u3068\u51fa\u529boutput"},"\u5165\u529b\uff08INPUT\uff09\u3068\u51fa\u529b\uff08OUTPUT\uff09"),(0,l.kt)("p",null,"\u5165\u529b\u3068\u51fa\u529b\u306e\u30a4\u30f3\u30bf\u30fc\u30d5\u30a7\u30fc\u30b9\u3092\u6c7a\u5b9a\u3059\u308b\u5fc5\u8981\u304c\u3042\u308a\u307e\u3059\u3002\n\u30dd\u30a4\u30f3\u30c8\u306f\u3001\u4ee5\u4e0b\u306e\u3068\u304a\u308a\u3067\u3059\u3002"),(0,l.kt)("h4",{id:"\u5f62\u5f0f"},"\u5f62\u5f0f"),(0,l.kt)("p",null,"\u5f62\u5f0f\u3068\u306f\u3001",(0,l.kt)("inlineCode",{parentName:"p"},"JSON"),"\u3084",(0,l.kt)("inlineCode",{parentName:"p"},"XML"),"\u306a\u3069\u3092\u6307\u3057\u307e\u3059\u3002\n\u3053\u308c\u306f\u3001\u30ea\u30af\u30a8\u30b9\u30c8\u5143\uff08\u30af\u30e9\u30a4\u30a2\u30f3\u30c8\uff09\u3068\u5f62\u5f0f\u3092\u5408\u308f\u305b\u308b\u5fc5\u8981\u304c\u3042\u308a\u307e\u3059\u3002"),(0,l.kt)("h4",{id:"\u9805\u76ee"},"\u9805\u76ee"),(0,l.kt)("p",null,"\u9805\u76ee\u306f\u3001",(0,l.kt)("inlineCode",{parentName:"p"},"\u9805\u76ee\u540d\uff08\u8ad6\u7406\u540d\u3068\u7269\u7406\u540d\uff09"),"\u3068\u305d\u306e\u9805\u76ee\u306e\u578b\u3092\u6c7a\u3081\u307e\u3059\u3002\n\u305d\u3057\u3066\u3001\u305d\u308c\u305e\u308c\u306e\u9805\u76ee\u306e\u5358\u9805\u76ee\u30c1\u30a7\u30c3\u30af\u3068\u76f8\u95a2\u30c1\u30a7\u30c3\u30af\u306e\u8981\u5426\u3092\u6c7a\u3081\u307e\u3059\u3002\n\u30c1\u30a7\u30c3\u30af\u7d50\u679c\u3001\u5165\u529b\u8981\u4ef6\u3092\u6e80\u305f\u3057\u3066\u3044\u306a\u3044\u5834\u5408\u306e\u6319\u52d5\u306b\u3064\u3044\u3066\u3082\u7e8f\u3081\u308b\u5fc5\u8981\u304c\u3042\u308a\u307e\u3059\u3002"),(0,l.kt)("p",null,"\u4e0a\u8a18\u3092\u6c7a\u3081\u305f\u3089\u3001\u8a2d\u8a08\u66f8\u3078\u306f\u4ee5\u4e0b\u306e\u3088\u3046\u306b\u53d6\u308a\u307e\u3068\u3081\u307e\u3059\u3002"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},"\u30c7\u30fc\u30bf\u5f62\u5f0f\uff1a",(0,l.kt)("inlineCode",{parentName:"li"},"JSON")),(0,l.kt)("li",{parentName:"ul"},"\u30c7\u30fc\u30bf\u9805\u76ee")),(0,l.kt)("table",null,(0,l.kt)("thead",{parentName:"table"},(0,l.kt)("tr",{parentName:"thead"},(0,l.kt)("th",{parentName:"tr",align:null},"NO"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u9805\u76ee\u540d(\u8ad6\u7406)"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u9805\u76ee\u540d(\u7269\u7406)"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u578b"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u5fc5\u9808\u8981\u5426"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u76f8\u95a2\u30c1\u30a7\u30c3\u30af"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217\u9577"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u5c5e\u6027\u30c1\u30a7\u30c3\u30af"),(0,l.kt)("th",{parentName:"tr",align:"left"},"\u5916\u5b57\u30c1\u30a7\u30c3\u30af"))),(0,l.kt)("tbody",{parentName:"table"},(0,l.kt)("tr",{parentName:"tbody"},(0,l.kt)("td",{parentName:"tr",align:null},"1"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u793e\u54e1ID"),(0,l.kt)("td",{parentName:"tr",align:"left"},"employeeId"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u8981"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"6"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u3042\u308a")),(0,l.kt)("tr",{parentName:"tbody"},(0,l.kt)("td",{parentName:"tr",align:null},"2"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6c0f\u540d(\u59d3)"),(0,l.kt)("td",{parentName:"tr",align:"left"},"lastname"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u5426"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6709"),(0,l.kt)("td",{parentName:"tr",align:"left"},"5"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u3042\u308a")),(0,l.kt)("tr",{parentName:"tbody"},(0,l.kt)("td",{parentName:"tr",align:null},"3"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6c0f\u540d(\u540d)"),(0,l.kt)("td",{parentName:"tr",align:"left"},"firstname"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u5426"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6709"),(0,l.kt)("td",{parentName:"tr",align:"left"},"5"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u3042\u308a")),(0,l.kt)("tr",{parentName:"tbody"},(0,l.kt)("td",{parentName:"tr",align:null},"4"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u90e8\u9580"),(0,l.kt)("td",{parentName:"tr",align:"left"},"department"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u5426"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"255"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u3042\u308a")),(0,l.kt)("tr",{parentName:"tbody"},(0,l.kt)("td",{parentName:"tr",align:null},"5"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u5165\u793e\u65e5"),(0,l.kt)("td",{parentName:"tr",align:"left"},"hireDate"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u6587\u5b57\u5217"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u5426"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u306a\u3057"),(0,l.kt)("td",{parentName:"tr",align:"left"},"10"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u65e5\u4ed8"),(0,l.kt)("td",{parentName:"tr",align:"left"},"\u3042\u308a")))),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},"\u30d0\u30ea\u30c7\u30fc\u30b7\u30e7\u30f3\u30c1\u30a7\u30c3\u30af")),(0,l.kt)("p",null,"\u30d0\u30ea\u30c7\u30fc\u30b7\u30e7\u30f3\u30c1\u30a7\u30c3\u30af\u306b\u306f\u4e3b\u306b\u5358\u9805\u76ee\u30c1\u30a7\u30c3\u30af\u3068\u76f8\u95a2\u30c1\u30a7\u30c3\u30af\u306e2\u7a2e\u985e\u304c\u3042\u308a\u307e\u3059\u3002\n\u305d\u308c\u305e\u308c\u306e\u30c1\u30a7\u30c3\u30af\u6761\u4ef6\u3084\u305d\u306e\u6761\u4ef6\u306b\u8a72\u5f53\uff08\u3064\u307e\u308a\u30a8\u30e9\u30fc\uff09\u3057\u305f\u5834\u5408\u306e\u632f\u308b\u821e\u3044\u3092\u8a2d\u8a08\u66f8\u3078\u307e\u3068\u3081\u307e\u3059\u3002"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},"\u5358\u9805\u76ee\u30c1\u30a7\u30c3\u30af")),(0,l.kt)("p",null,"\u5358\u9805\u76ee\u30c1\u30a7\u30c3\u30af\u3068\u306f\u3001\u5358\u4f53\u306e\u9805\u76ee\u306b\u5bfe\u3059\u308b\u30c1\u30a7\u30c3\u30af\u3092\u6307\u3057\u307e\u3059\u3002\n\u5358\u9805\u76ee\u30c1\u30a7\u30c3\u30af\u306e\u5bfe\u8c61\u9805\u76ee\u3084\u30c1\u30a7\u30c3\u30af\u306e\u6761\u4ef6\u3001\u30ec\u30b9\u30dd\u30f3\u30b9\u5f62\u5f0f\u3084\u5185\u5bb9\u3092\u307e\u3068\u3081\u307e\u3059\u3002"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"\u5bfe\u8c61\u9805\u76ee\uff1a\u793e\u54e1ID\uff08employeeId\uff09")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"\u6761\u4ef6\uff1a\u5024\u304c",(0,l.kt)("inlineCode",{parentName:"p"},"null"),"\u306e\u5834\u5408\uff08\u5165\u529bI/F\u306b\u9805\u76ee\u304c\u5b58\u5728\u3057\u306a\u3044\u306e\u3082\u542b\u3080\uff09")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"HTTP\u30b9\u30c6\u30fc\u30bf\u30b9\uff1a400(Bad Request)")),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},'\u30a8\u30e9\u30fc\u30b3\u30fc\u30c9\uff1a"W-0001"')),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},'\u30e1\u30c3\u30bb\u30fc\u30b8\uff1a"{\u9805\u76ee\u540d}\u306f\u5fc5\u9808\u9805\u76ee\u3067\u3059"')),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"\u30ec\u30b9\u30dd\u30f3\u30b9body\uff08JSON\u5f62\u5f0f\uff09"),(0,l.kt)("pre",{parentName:"li"},(0,l.kt)("code",{parentName:"pre",className:"language-json"},'{\n    code:"W-0001"\n    msg:"\u6c0f\u540d(\u59d3)\u306f\u5fc5\u9808\u9805\u76ee\u3067\u3059\u3002"\n}\n'))),(0,l.kt)("li",{parentName:"ul"},(0,l.kt)("p",{parentName:"li"},"\u76f8\u95a2\u30c1\u30a7\u30c3\u30af"))),(0,l.kt)("p",null,"\u76f8\u95a2\u30c1\u30a7\u30c3\u30af\u3068\u306f\u3001\u8907\u6570\u306e\u9805\u76ee\u306b\u5165\u529b\u3055\u308c\u305f\u5024\u306e\u59a5\u5f53\u6027\u306e\u30c1\u30a7\u30c3\u30af\u3067\u3059\u3002\n\u8907\u6570\u306e\u9805\u76ee\u306e\u95a2\u4fc2\u6027\u304c\u59a5\u5f53\u306a\u3082\u306e\u3067\u3042\u308b\u304b\u3092\u30c1\u30a7\u30c3\u30af\u3059\u308b\u3053\u3068\u3092\u6307\u3057\u307e\u3059\u3002\n\u76f8\u95a2\u30c1\u30a7\u30c3\u30af\u306e\u5bfe\u8c61\u9805\u76ee\u3084\u30c1\u30a7\u30c3\u30af\u306e\u6761\u4ef6\u3001\u30ec\u30b9\u30dd\u30f3\u30b9\u5f62\u5f0f\u3084\u5185\u5bb9\u3092\u307e\u3068\u3081\u307e\u3059\u3002"),(0,l.kt)("ul",null,(0,l.kt)("li",{parentName:"ul"},"\u5bfe\u8c61\u9805\u76ee\uff1a\u6c0f\u540d(\u59d3)\uff08lastname\uff09\u3001\u6c0f\u540d(\u540d)\uff08firstname\uff09"),(0,l.kt)("li",{parentName:"ul"},"\u6761\u4ef6\uff1a\u3069\u3061\u3089\u304b\u306e\u9805\u76ee\u307e\u305f\u306f\u3001\u5024\u304c\u5b58\u5728\u3059\u308b\u5834\u5408\u3001\u5bfe\u306e\u9805\u76ee\u307e\u305f\u306f\u3001\u5024\u304c\u5b58\u5728\u3057\u306a\u3044\u5834\u5408"),(0,l.kt)("li",{parentName:"ul"},"HTTP\u30b9\u30c6\u30fc\u30bf\u30b9\uff1a400(Bad Request)"),(0,l.kt)("li",{parentName:"ul"},'\u30a8\u30e9\u30fc\u30b3\u30fc\u30c9\uff1a"W-0002"'),(0,l.kt)("li",{parentName:"ul"},'\u30e1\u30c3\u30bb\u30fc\u30b8\uff1a"{\u9805\u76ee\u540d}\u304c\u5b58\u5728\u3057\u307e\u305b\u3093\u3002"'),(0,l.kt)("li",{parentName:"ul"},"\u30ec\u30b9\u30dd\u30f3\u30b9body\uff08JSON\u5f62\u5f0f\uff09",(0,l.kt)("pre",{parentName:"li"},(0,l.kt)("code",{parentName:"pre",className:"language-json"},'{\n    code:"W-0002"\n    msg:"\u6c0f\u540d(\u59d3)\u304c\u5b58\u5728\u3057\u307e\u305b\u3093\u3002"\n}\n')))),(0,l.kt)("h3",{id:"\u30ea\u30bd\u30fc\u30b9\u3068\u64cd\u4f5c"},"\u30ea\u30bd\u30fc\u30b9\u3068\u64cd\u4f5c"),(0,l.kt)("h2",{id:"\u30d0\u30c3\u30c1\u30b5\u30fc\u30d3\u30b9"},"\u30d0\u30c3\u30c1\u30b5\u30fc\u30d3\u30b9"),(0,l.kt)("p",null,"\ud83d\udea7\u4f5c\u6210\u4e2d\ud83d\udea7"))}k.isMDXComponent=!0}}]);