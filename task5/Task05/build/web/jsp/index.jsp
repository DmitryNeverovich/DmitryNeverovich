<%-- 
    Document   : index
    Created on : 01.07.2014, 23:49:55
    Author     : Dima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select parser</title>
    </head>
    <body>
        <form action="controller" method="post">
            <input type="hidden" name="command" value="parsing_xml"/>
            <input type="hidden" name="filename" value="c:\Users\Dima\Documents\NetBeansProjects\Task05\build\web\Greenhouse.xml"/>
            <input type="radio" name="parser" value="sax" checked="checked"> Sax<Br>
            <input type="radio" name="parser" value="stax" > StaX<Br>
            <input type="radio" name="parser" value="dom"> DOM<Br>
            <input type="submit" value="Processor"/>
        </form>
    </body>
</html>