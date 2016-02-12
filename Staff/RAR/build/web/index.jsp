<%-- 
    Document   : index
    Created on : Jan 14, 2016, 11:22:32 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Get element Xpath of Selected Items</title>
        <script src="Scripts/jquery-2.2.0.js" type="text/javascript"></script>
        <script type="text/javascript">
            var urlXPath;
            $(document).ready(function (){             
                var iframeDoc = document.getElementById('myframe').contentWindow ;
                $(iframeDoc).click(function (event){
                    urlXPath=createXPathFromElement(event.target);
                    getData(urlXPath);
                    alert(urlXPath);
                    addToCart(urlXPath);
                });
            });
            
            //Get XPath from selected Element
            function createXPathFromElement(elm) { 
                var allNodes = document.getElementsByTagName('*'); 
                for (var segs = []; elm && elm.nodeType == 1; elm = elm.parentNode) 
                { 
                    if (elm.hasAttribute('id')) { 
                        var uniqueIdCount = 0; 
                        for (var n=0;n < allNodes.length;n++) { 
                            if (allNodes[n].hasAttribute('id') && allNodes[n].id == elm.id) uniqueIdCount++; 
                            if (uniqueIdCount > 1) break; 
                        }; 
                        if ( uniqueIdCount == 1) { 
                            segs.unshift("id('" + elm.getAttribute('id') + "')"); 
                            return segs.join('/'); 
                        } else { 
                            segs.unshift(elm.localName.toLowerCase() + "[@id='" + elm.getAttribute('id') + "']"); 
                        } 
                    } else if (elm.hasAttribute('class')) { 
                        segs.unshift(elm.localName.toLowerCase() + "[@class='" + elm.getAttribute('class') + "']"); 
                    } else { 
                        for (i = 1, sib = elm.previousSibling; sib; sib = sib.previousSibling) { 
                            if (sib.localName == elm.localName)  i++; }; 
                        segs.unshift(elm.localName.toLowerCase() + '[' + i + ']'); 
                    }; 
                }; 
                var pos = 0;
                var string = segs.length ? '/' + segs.join('/') : null;
                string = string.replace("")
                var str_array = string.split("/");
                var l = str_array.length;
                for (i = l - 1 ; i > 0; i--) {
                    if (str_array[i].search("class")!=-1){
                        pos = i;
                        break
                    }
                }
                var rs = "/";
                for (i = pos; i < l; i++) {
                    rs = rs + '/' + str_array[i]
                }
                return rs;
            }; 
            
            //Using AJAX call function
            function getData(url) {
                //alert("getData");
                $.ajax({
                    url: "GetElementContentServlet",
                    type: "POST",
                    data: { urlXPath: url }
                    //                    success: function (result) {
                    //                        alert(result.toString());
                    //            }
                });
            }     
            
            //Preview
            function addToCart(selectedItem) {
                if(typeof(sessionStorage)!=="undefined") {
                    if (sessionStorage.cart == null) {
                        sessionStorage.cart = '';
                    }
                    sessionStorage.cart = sessionStorage.cart +
                        selectedItem +";"
                } else{
                    alert("browser is not supported storage!!!");
                }
            }
            
        </script>

    </script>
</head>
<body>
    <h1>Welcome to XPath + IFrame + JQuery!</h1>
    <p>
        <b>Please Select An Element And Get XPath</b><br/>
        
        <input type="button" value="Preview" onclick="window.open('show.html', null, null)"/><br/>
        <iframe sandbox="allow-same-origin allow-scripts allow-popups allow-forms" width="700" height="500" 
                id="myframe" src="tmp.html">
        </iframe>
    </p>
</body>
</html>
