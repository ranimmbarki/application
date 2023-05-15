<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Liste des contacts</title>
</head>
<body>
    <h1> Liste des contacts</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <% List <Contact> contacts = (List<Contact>) request.getAttribute("contacts");
               for (Contact contact : contacts) { %>
                <tr>
                    <td><%= contact.getId() %></td>
                    <td><%= contact.getNom() %></td>
                    <td><%= contact.getEmail() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>