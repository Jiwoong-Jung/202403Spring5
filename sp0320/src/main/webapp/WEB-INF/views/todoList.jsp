<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<body>
	<h1>ajax</h1>
	<select id="selectBox">
		<option value="" selected disabled>선택</option>
		<option value="list">list</option>
		<option value="root">root</option>
		<option value="root2">root2</option>
	</select>

	<div id="here"></div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$.ajax({
				url : '/',
				method : 'GET',
				success : function(data) {
					$('#here').html(data);
				}
			});
			
			
			$("#selectBox").on("change", function(){
				console.log($(this).val());
				let sel = $(this).val();
				if (sel=='root') {
					$.ajax({
						url : '/',
						method : 'GET',
						success : function(data) {
							$('#here').html(data);
						}
					});
				} else if (sel == 'list') {
					$.ajax({
						url : '/list',
						method : 'POST',
						success : function(data) {
							$('#here').html(data);
						}
					});
				} else if (sel == 'root2') {
					$.ajax({
						url : '/root2',
						method : 'get',
						success : function(data) {
							$('#here').html(data);
						}
					});
				}
					
			});
			

			// 'Add' 버튼 클릭 시 새로운 할 일 추가
			$('#addButton').click(function() {
				var value = $('#todoInput').val();
				if (value) {
					$.ajax({
						url : 'addTodo', // 서버에 새로운 할 일을 추가하는 엔드포인트
						method : 'POST',
						data : {
							text : value
						},
						success : function(data) {
							addItem(data);
							$('#todoInput').val('');
						}
					});
				}
			});
		});

		function addItem(text) {
			var list = $('#todoList');

			var item = $('<li></li>').text(text);

			var removeButton = $('<button></button>').text('Remove');
			removeButton.click(function() {
				$.ajax({
					url : 'removeTodo', // 서버에서 할 일을 삭제하는 엔드포인트
					method : 'POST',
					data : {
						text : text
					},
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