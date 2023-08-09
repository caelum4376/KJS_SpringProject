<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container {
   margin-top: 50px;
}
.row {
  margin: 0px auto;
  width: 960px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">{{message}}</h1>
		<my-com1 v-bind:pdata="mycomdata[0]"></my-com1>
		<my-com1 v-bind:pdata="mycomdata[1]"></my-com1>
		<my-com1 v-bind:pdata="mycomdata[2]"></my-com1>
		<my-com1 v-bind:pdata="mycomdata[3]"></my-com1>
	</div>
	<script>
		Vue.component('my-com1', {
			props:['pdata'],
			template: `
				<div>
					<h1>Hello Template</h1>
					<h3>{{pdata}}</h3>
				</div>
			`
		})
		new Vue({
			el:'.container',
			data:{
				message:'Hello Component!!',
				mycomdata:['데이터 출력 1', '데이터 출력 2', '데이터 출력 3', '데이터 출력 4']
			}
		})
	</script>
</body>
</html>
