<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">쉐프 목록</header>
          <ul class="nospace clear">
            <li v-for="vo,index in chef_list" :class="index%4==0?'one_quarter first':'one_quarter'"><a :href="'../recipe/chef_find.do?chef='+vo.chef"><img :src="vo.poster" :title="vo.chef"></a></li>
          </ul>
          <figcaption>Gallery Description Goes Here</figcaption>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
		<nav class="pagination">
			<ul>
				<li v-if="startPage>1"><a href="#" v-on:click="prev()">&laquo;</a></li>
				<li v-for="i in range(startPage,endPage)" :class="i==curpage?'current':''">
					<a href="#" v-on:click="pageChange(i)">{{i}}</a>
				</li>
				<li v-if="endPage<totalpage"><a href="#" @click="next()">&raquo;</a></li>
			</ul>
		</nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
<script>
	new Vue({
		el:'.container',
		data:{
			chef_list:[],
			page_list:{},
			curpage:1,
			totalpage:0,
			startPage:0,
			endPage:0
		},
		mounted:function(){
			this.dataRecive()
		},
		methods:{
			dataRecive:function(){
				axios.get('../recipe/chef_list_vue.do',{
					params:{
						page:this.curpage
					}
				}).then(res=>{
					console.log(res.data)
					this.chef_list = res.data
				}).catch(error=>{
					console.log(error.response)
				})
				
				// 페이지 정보
				axios.get('../recipe/chef_page_vue.do',{
					params:{
						page:this.curpage
					}
				}).then(res=>{
					console.log(res.data)
					this.page_list = res.data
					this.curpage = this.page_list.curpage
					this.totalpage = this.page_list.totalpage
					this.startPage = this.page_list.startPage
					this.endPage = this.page_list.endPage
				}).catch(error=>{
					console.log(error.response)
				})
			},
			range:function(start, end){
				let arr=[]
				let length=end-start
				for (let i=0; i<=length; i++){
					arr[i] = start
					start++
				}
				return arr
			},
			pageChange:function(page){
				this.curpage=page
				this.dataRecive()
			},
			prev:function(){
				this.curpage=this.startPage-1
				this.dataRecive()
			},
			next:function(){
				this.curpage=this.endPage+1
				this.dataRecive()
			}
		}
	})
</script>
</body>
</html>