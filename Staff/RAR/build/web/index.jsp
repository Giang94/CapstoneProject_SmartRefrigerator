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
        <link href="css/runnable.css" rel='stylesheet' type='text/css'>
        <script src="Scripts/jquery-2.2.0.js" type="text/javascript"></script>
        <script type="text/javascript">
            var urlXPath;
            var col = 0, count = 0;
            var step = 3;
            var str1, str2;
            $(document).ready(function (){             
                var iframeDoc = document.getElementById('myframe').contentWindow ;
                $(iframeDoc).click(function (event){
                    urlXPath=createXPathFromElement(event.target);
                    getData(urlXPath);
                    alert("CONTENT: " + event.target.innerHTML + "\nXPATH: " + urlXPath);                                     
                    //addRow1('tbItems', cells)
                    //if(col%2 == 0) alert("thiendeptrai");
                    count++;
                    if ((count == 1)||(count == 2)||(count == 3)) {
                        progressBar();
                        addToCart(urlXPath);
                        showCart(sessionStorage.cart, 'tbItems');
                    }
                    if ((count%2 == 0)&&(count>=4)){
                        str1 = urlXPath;
                    } 
                    if ((count%2==1)&&(count>=4)) {
                        str2 = urlXPath;
                        //alert(sharedStart(str1, str2));
                        progressBar();
                        addToCart(sharedStart(str1, str2));
                        showCart(sessionStorage.cart, 'tbItems');
                    }
                    if (count == 7){
                        alert("FINISHED");
                        document.myForm.submit();
                    }
                });
            });
            
            function sharedStart(xpath1, xpath2){
                var L = xpath1.length, i= 0;
                while(i<L && xpath1.charAt(i)=== xpath2.charAt(i)) i++;
                var tmp = xpath1.substring(i+2,L);
                return xpath1.substring(0, i-1) + tmp;
            }
            
            function progressBar() {
                $('.progress .circle').removeClass().addClass('circle');
                $('.progress .bar').removeClass().addClass('bar');

                $('.progress .circle:nth-of-type(' + step + ')').addClass('active');
  
                $('.progress .circle:nth-of-type(' + (step-1) + ')').removeClass('active').addClass('done');
  
                $('.progress .circle:nth-of-type(' + (step-1) + ') .label').html('&#10003;');
  
                $('.progress .bar:nth-of-type(' + (step-1) + ')').addClass('active');
  
                $('.progress .bar:nth-of-type(' + (step-2) + ')').removeClass('active').addClass('done');
  
                step++;
  
                if (step==0) {
                    $('.progress .bar').removeClass().addClass('bar');
                    $('.progress div.circle').removeClass().addClass('circle');
                    step = 1;
                }
            };
            
            //Get XPath from selected Element
            function createXPathFromElement(elm) { 
                var allNodes = document.getElementsByTagName('*');                
                //alert(elm.firstChild.nodeValue);
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
                    //                    sessionStorage.cart = sessionStorage.cart +
                    //                        selectedItem +";"
                    sessionStorage.cart = selectedItem + ";";
                } else{
                    alert("browser is not supported storage!!!");
                }
            }
            
            function addRow(tableId, cells){
                var tableElem = document.getElementById(tableId);
                var newCell;               
                var newRow;
                for (var i = 0;i < cells.length-1; i++) {
                    newRow = tableElem.insertRow(tableElem.rows.length);
                    
                    newCell = newRow.insertCell(newRow.cells.length);
                    newCell.innerHTML = ++col;
                    newCell = newRow.insertCell(newRow.cells.length);
                    newCell.innerHTML = cells[i] + 
                        '<input type="hidden" name="txtXPath" value="' + cells[i] + '"/>';
                    //newCell.width = 200;
                }
                return newRow;
            }
            
            function showCart(items, tableId){
                var item = items.split(';');
                addRow(tableId,item);
            }
            
            function reset(){
                col = 0; count = 0;
                step = 0;
                sessionStorage.cart = null;
                showCart(sessionStorage.cart, 'tbItems');
            }
            
        </script>

    </script>
</head>
<body>
    <h1>Welcome to XPath + IFrame + JQuery!</h1>
    <div class="progress">
        <div class="circle done">
            <span class="label">0</span>
            <span class="title">Start</span>
        </div>
        <span class="bar half"></span>
        <div class="circle active">
            <span class="label">1</span>
            <span class="title">RecipeName</span>
        </div>
        <span class="bar"></span>
        <div class="circle">
            <span class="label">2</span>
            <span class="title">Introduction</span>
        </div>
        <span class="bar"></span>
        <div class="circle">
            <span class="label">3</span>
            <span class="title">RecipeImage</span>
        </div>
        <span class="bar"></span>
        <div class="circle">
            <span class="label">4</span>
            <span class="title">Material</span>
        </div>
        <span class="bar"></span>
        <div class="circle">
            <span class="label">5</span>
            <span class="title">RecipeStep</span>
        </div>
    </div>
    <p>
        <b>Please Select An Element And Get XPath</b><br/>

        <!--        <input type="button" value="Preview" onfocus="showCart(sessionStorage.cart, 'tbItems')" 
                       onclick="window.open('show.html', null, null)"/><br/>-->
        <input type="button" value="RESET" onclick="reset()"/>
    <form name="myForm" id="myForm" action="ScrappingServlet" method="POST">
        <table id="tbItems" border="1">
            <tr>
                <th>No.</th>
                <th>XPath</th>
            </tr>
        </table><br/>
    </form><br/>
    <iframe sandbox="allow-same-origin allow-scripts allow-popups allow-forms" width="700" height="500" 
            id="myframe" src="tmp.html">
    </iframe>
</p>
</body>
</html>
