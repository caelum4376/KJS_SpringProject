<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css"/>
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.16/dist/vue.js"></script>
<script src="https://unpkg.com/babel-polyfill@latest/dist/polyfill.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style>
.row {
	margin: 0px auto;
	width: 100%;
}
</style>
</head>
<body>
	<div class="wrapper row3">
		<main class="container clear">
			<h2 class="sectiontitle">회원가입</h2>
			<div class="row">
				<form method="post" action="../member/join_ok.do" @submit="submitForm">
					<table class="table">
						<tr>
							<th class="text-right" width=10%>ID</th>
							<td width=90% class="inline">
								<input type=text name=id ref=id v-model=id size=20 
									class="input-sm" @keyup="idCheck">
									<!--  v-bind:disabled="isDisabled" -->
								<p>{{idOk}}</p>
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>비밀번호</th>
							<td width=90% class="inline">
								<input type=password name=pwd ref=pwd size=20 class="input-sm" v-model="pwd"
									@keyup="pwdValidate">
								 &nbsp;재입력:<input type=password name=pwd1 ref=pwd1 size=20 class="input-sm"
								 	@keyup="pwdValidate2" v-model="pwd1">
								 <br>
								 <p>{{pwdOk}}</p>
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>이름</th>
							<td width=90% class="inline">
								<input type=text name=name ref=name size=20 class="input-sm"
									v-model="name">
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>성별</th>
							<td width=90% class="inline">
								<input type="radio" name=sex value="남자" checked
									ref="sex" v-model="sex">남자 
								<input type="radio" name=sex value="여자"
									ref="sex" v-model="sex">여자</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>생년월일</th>
							<td width=90% class="inline">
								<input type="date" name=birthday size=20
									ref="birthday" v-model="birthday">
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>이메일</th>
							<td width=90% class="inline">
								<input type=text name=email ref=email size=55 class="input-sm"
									v-model="email"
									@keyup="emailCheck">
								<br>
								<p>{{emailOk}}</p>								
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>우편번호</th>
							<td width=90% class="inline">
								<input type=text name=post ref=post v-model=post size=10 class="input-sm">
								<input type=button value="우편번호검색" class="btn btn-sm btn-info"
									v-on:click="postFind()">
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>주소</th>
							<td width=90% class="inline">
								<input type=text name=addr1 ref=addr1 v-model=addr1 size=55 class="input-sm" readonly>
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>상세주소</th>
							<td width=90% class="inline">
								<input type=text name=addr2 ref=addr2 v-model=addr2 size=55 class="input-sm"></td>
						</tr>

						<tr>
							<th class="text-right" width=10%>전화</th>
							<td width=90% class="inline">
								<select name=phone1 ref=phone1 v-model=phone1 class="input-sm">
										<option>010</option>
								</select> 
								<input type=text name=phone ref=phone v-model=phone size=12 class="input-sm">
								<input type=button value="전화체크" class="btn btn-sm btn-warning"
									id="phoneBtn">
							</td>
						</tr>

						<tr>
							<th class="text-right" width=10%>소개</th>
							<td width=90% class="inline">
								<textarea rows="10" cols="55" name=content ref=content v-model=content></textarea>
							</td>
						</tr>

						<tr>
							<td colspan="2" class="text-center">
								<input type="submit" value="회원가입" class="btn btn-success btn-sm" 
									id="joinBtn">
								<input type=button value="취소" class="btn btn-info btn-sm"
									onclick="javascript:history.back()"></td>
						</tr>
					</table>
				</form>
			</div>
		</main>
	</div>
	<script>
		new Vue({
			el:'.container',
			data:{
				id:'',
				pwd:'',
				pwd1:'',
				name:'',
				sex:'',
				birthday:'',
				email:'',
				post:'',
				addr1:'',
				addr2:'',
				phone1:'010',
				phone:'',
				content:'',
				idOk:'',
				pwdOk:'',
				pwdOk2:'',
				emailOk:'',
				phoneOk:'',
				isDisabled:false
			},
			methods:{
				submitForm:function(event){
					if (this.id && this.name && this.pwd && this.pwd1
							&& this.sex && this.email && this.birthday
							&& this.post && this.addr1 && this.phone
							&& this.phone1 && !this.idOk && !this.emailOk) {
						return true
					}
					if (this.id == '' || this.idOk != '') {
						this.$refs.id.focus()
					} else if (this.pwd == '') {
						this.$refs.pwd.focus()
					} else if (this.pwd1 == '') {
						this.$refs.pwd1.focus()
					} else if (this.pwd != this.pwd1) {
						this.pwd=''
						this.pwd1=''
					} else if (this.name == '') {
						this.$refs.name.focus()
					} else if (this.email == '' || this.emailOk != '') {
						this.$refs.email.focus()
					} else if (this.phone == '') {
						this.$refs.phone.focus()
					} else if (this.post == '') {
						alert('우편번호 찾기를 하세요')
					}
					event.preventDefault()
				},
				postFind:function(){
					let _this=this;
					/* new를 사용하면 새로운 객체가 생성되는 것 => this는 그 객체의 변수를 의미하므로 _this 필요 */
					new daum.Postcode({
						oncomplete:function(data){
							_this.post=data.zonecode;
							_this.addr1=data.address;
						}
					}).open()
				},
				idCheck:function(){
					if (this.id!=='') {
						axios.get("http://localhost/web/member/idcheck_ok_vue.do", {
							params: {
								id:this.id
							}
						}).then(res=>{
							if(res.data=='no') {
								this.idOk = '이미 존재하는 아이디입니다.'
							} else {
								this.idCheckValidate(res.data)
							}
						})
					} else {
						this.idOk = ''
					}
				},
				idCheckValidate:function(id){
					// g : 전역 검색 플래그가 있는 경우에는 모든 검색 결과를 배열로 반환
					// i : 대소문자 구별 없음
					console.log(id)
					let id_res = String(id)
					let num = id_res.search(/[0-9]/g)
					let eng = id_res.search(/[a-z]/ig)
					if (id_res.length<6 || id_res.length>12) {
						this.idOk = '아이디는 6자리~12자리 이내로 입력해 주세요'
					} else if (id_res.search(/\s/)!=-1) {
						// 공백 찾기
						this.idOk = '아이디는 공백 없이 입력해주세요'
						return
					} else if (num < 0 || eng < 0) {
						this.idOk = '아이디는 영문, 숫자를 혼합하여 입력해주세요'
						return
					} else {
						this.idOk = ''
						this.isDisabled=true
						return
					}
				},
				pwdValidate:function(){
					let pwd = String(this.pwd)
					let num = pwd.search(/[0-9]/g)
					let eng = pwd.search(/[a-z]/ig)
					if (pwd==='') {
						this.pwdOk = ''
						return
					}
					if (pwd.length<8 || pwd.length>20) {
						this.pwdOk = '비밀번호는 8자리~20자 이내로 입력하세요'
						return
					} else if (pwd.search(/\s/) != -1) {
						this.pwdOk = '비밀번호는 공백없이 입력하세요'
						return
					} else if (num < 0 || eng < 0) {
						this.pwdOk = '비밀번호는 영문, 숫자를 혼합해서 입력하세요'
						return
					} else {
						this.pwdOk = ''
						return
					}
				},
				pwdValidate2:function(){
					if (this.pwd != this.pwd1) {
						this.pwdOk = '재입력이 일치하지 않습니다'
					} else {
						this.pwdOk = ''
					}
				},
				emailCheck:function(){
					if(this.email != '') {
						axios.get('../member/email_check_ok_vue.do',{
							params:{
								email:this.email
							}
						}).then(res=>{
							if(res.data=='no') {
								this.emailOk='이미 존재하는 이메일입니다'
							} else {
								this.emailValidate(res.data)
							}
						})
					} else {
						this.emailOk=''
					}
				},
				emailValidate:function(email){
					let re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
					// test() => 정규식을 비교할 때 사용
					if (!re.test(this.email)) {
						this.emailOk = "이메일 형식이 올바르지 못합니다"
					} else {
						this.emailOk=''
					}
				}
			}
		})
	</script>
</body>
</html>