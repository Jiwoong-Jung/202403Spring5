<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Todo List</h1>
	<input id="todoInput" type="text" placeholder="할 일을 넣으세요" />
	<button id="addButton">Add</button>
	<ul id="todoList">
		<!-- 할 일 목록이 여기에 추가됩니다. -->
	</ul>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(function() {
			$.ajax({
				url : 'GetTodos',
				method : 'GET',
				success : function(data) {
					data.forEach(function(todo) {
						addItem(todo);
					});
				}
			});
		});

		function addItem(text) {
			const list = $('#todoList');

			const item = $('<li></li>').text(text);
			const removeButton = $('<button></button>').text('삭제');
			removeButton.click(function() {
				$.ajax({
					url : 'RemoveTodo', // 서버에서 할 일을 삭제하는 엔드포인트
					method : 'POST',
					data : {text : text},
					//data: 'text='+data,
					success : function() {
						item.remove();
					}
				});
			});

			item.append(removeButton);

			list.append(item);
		}
	</script>
</body>
</html>



