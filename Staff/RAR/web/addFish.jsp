<%-- 
    Document   : addFish
    Created on : Nov 30, 2015, 10:37:52 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new fish</title>
        <link rel="stylesheet" type="text/css" href="css/default.css"/>
        <script>
            function checkInput(form) {
                var RE_DATE = /^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}$/;

                var chip = form.txtChip.value;
                var type = form.txtType.value;
                var camp = form.txtCamp.value;
                var price = form.txtPrice.value;
                var size = form.txtSize.value;
                var date = form.txtDate.value;
                var description = form.txtDescription.value;
                var image = form.txtImage.value;

                var errors = [];
                if (chip.length == 0) {
                    errors[errors.length] = "Please enter the chip";
                }
                if (isNaN(chip)){   
                    errors[errors.length] = "Chip must be number";
                }
                if (type.length == 0) {
                    errors[errors.length] = "Please enter the type";
                }
                if (camp.length == 0) {
                    errors[errors.length] = "Please enter the camp";
                }
                if (price.length == 0) {
                    errors[errors.length] = "Please enter the price";
                }
                if (isNaN(price)){   
                    errors[errors.length] = "Price must be number";
                }
                if (size.length == 0) {
                    errors[errors.length] = "Please enter the size";
                }
                if (isNaN(size)){   
                    errors[errors.length] = "Size must be number";
                }
                if (!RE_DATE.test(date)) {
                    errors[errors.length] = "The date must be formatted like: dd-mm-yyyy ";
                }
                if (description.length == 0) {
                    errors[errors.length] = "Please enter the description";
                }
                if (image.length == 0) {
                    errors[errors.length] = "Please enter the image";
                }
                if (errors.length > 0) {
                    reportError(errors);
                    return false;
                }
                return true;
            }
            
            function reportError(error) {
                var msg = "";
                for (var i = 0; i < error.length; i++) {
                    msg += "* " + error[i] + "<br/>";
                }
                document.getElementById("errorWarn").innerHTML = msg;
            }
        </script>
    </head>
    <body>
        <div id="menu">
            <div id="sub-menu">
                <div id="logo">Welcome To ThienDepTrai Aquarium</div>
                <ul>
                    <li><a href="#">Welcome ${ADMIN}</a></li>
                    <li><a href="admin.jsp">AdminPage</a></li>
                    <li><a href="ProcessServlet?btnAction=LogOut">Logout</a></li>
                </ul>
            </div>
        </div><br/>
        <h1>Add a new fish</h1>
        <form action="ProcessServlet" method="POST" onsubmit="return checkInput(this)">
            <table>
                <tr>
                    <td>chip</td>
                    <td>
                        <input type="text" name="txtChip" value="" />
                    </td>
                </tr>
                <tr>
                    <td>type</td>
                    <td><input type="text" name="txtType" value="" /></td>
                </tr>
                <tr>
                    <td>breedingCamp</td>
                    <td><input type="text" name="txtCamp" value="" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="txtPrice" value="" /></td>
                </tr>
                <tr>
                    <td>Size</td>
                    <td><input type="text" name="txtSize" value="" /></td>
                </tr>
                <tr>
                    <td>Date</td>
                    <td><input type="text" name="txtDate" value="" /></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="txtDescription" value="" /></td>
                </tr>
                <tr>
                    <td>image</td>
                    <td><input type="text" name="txtImage" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="Insert new fish" name="btnAction" /> </td>
                </tr>
            </table>
        </form>
        <p id="errorWarn" style="color:red"></p>
    </body>
</html>
