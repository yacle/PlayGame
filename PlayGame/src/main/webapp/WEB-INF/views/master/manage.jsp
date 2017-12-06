<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.manage{
	margin: 20px;
}
</style>
<div>
	<a href="#"><button type="button" class="manage" id="product_add">상품 추가</button></a>
	<a href="/master/order"><button type="button" class="manage">주문관리</button></a>
</div>
<script>
$("#product_add").click(function(){
	window.open("/product/add", "product_reg", "width=600, height=900");
})
</script>
