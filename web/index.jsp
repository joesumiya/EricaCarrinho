<%-- 
    Document   : index
    Created on : 05/10/2011, 20:37:34
    Author     : Joe Sumiya, Ricardo Sasaki e Vitor Vergaças
--%>

<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <style>
            .box {
                text-align: center;
                float: left;
                width: 200px;
                height: 150px;
                border: 1px solid #000;
                margin-left: 10px;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="InserirServlet" name="form" method="post"><br>
        Nome do Produto: <input type="text" name="produto" value=""/><br>
        Preço Unitario: <input type="text" name="precounitario" value=""/><br>
        <input type="submit" value="Enviar dados"/>
                
            </table>
        </form>
        
        <p>
            <% 
                ArrayList<Produto> produtos = (ArrayList<Produto>)request.getAttribute("produtos"); 
                for(Produto p: produtos) {
            %>
            <div class="box">
                <p><%= p.getNome() %></p>
                <p>Preço:<%= p.getPrecoUnitario() %></p>
                <p><a href="">comprar</a></p>
            </div>
            <% } %>
        </p>
        
        
    </body>
</html>
