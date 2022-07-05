<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <a href="showflights1.jsp">List of flights</a> 
    <h1>JOURNEY DETAILS</h1>
    
    <div class="booking-form">
<label>Source</label>
<input type="text" class="form-control" placeholder="City"><br><br>
<label>Destination</label>
<input type="text" class="form-control" placeholder="City">
<br><br>

<div class="input-grp">
<label>No. of Travelers</label>
<input type="text" class="form-control" value="1">
</div>
<br>

        <title>Travel Details</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
    </head>
    <body>
        <Pre>
        <form action="DatePicker">
            <label for="datepicker">Enter Your Date of Travel:</label>
                <input type="text" name="dot" id="datepicker">
                <div class="input-grp">
<button type="button" class="btn btn-primary flight">Book Flight
</button>


</div>
            
           <%-- <input type="submit" value="Submit">--%> 
        </form>
        </pre> 
           
    </body>