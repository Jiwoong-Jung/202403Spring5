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
			
			// 'Add' 버튼 클릭 시 새로운 할 일 추가
		    $('#addButton').click(function() {
		        const value = $('#todoInput').val();
		        if (value) {
		            $.ajax({
		                url: 'AddTodo', // 서버에 새로운 할 일을 추가하는 엔드포인트
		                method: 'POST',
		                data: { text: value },
		                success: function(data) {
		                    addItem(data);
		                    $('#todoInput').val('');
		                }
		            });
		        }
		    });
		});

		function addItem(text1) {
			const list = $('#todoList');

			const item = $('<li></li>').text(text1);
			const removeButton = $('<button></button>').text('삭제');
			removeButton.click(function() {
				$.ajax({
					url : 'RemoveTodo', // 서버에서 할 일을 삭제하는 엔드포인트
					method : 'POST',
					data : {text : text1},
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



