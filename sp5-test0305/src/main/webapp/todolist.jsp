<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <h1>Todo List</h1>
    <input id="todoInput" type="text" placeholder="New task">
    <button id="addButton">Add</button>
    <ul id="todoList"></ul>
    <script>
        $(function() {
            loadTodos();

            $("#addButton").click(function() {
                var value = $("#todoInput").val();
                if (value) {
                    $.post('TodoServlet', {text: value}, function(res) {
                        addItem(res, value);
                        $("#todoInput").val("");
                    });
                }
            });

            function loadTodos() {
                $.get('TodoServlet', function(res) {
                    res.forEach(function(todo) {
                        addItem(todo.id, todo.text);
                    });
                });
            }

            function addItem(id, text) {
                var item = $("<li>").text(text);
                var deleteButton = $("<button>").text("Delete");
                deleteButton.click(function() {
                    $.ajax({
                        url: 'TodoServlet?id=' + id,
                        type: 'DELETE',
                        success: function(res) {
                            item.remove();
                        }
                    });
                });
                item.append(deleteButton);
                $("#todoList").append(item);
            }
        });
    </script>
</body>
</html>