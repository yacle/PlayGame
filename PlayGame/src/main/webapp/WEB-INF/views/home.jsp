<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
			<a href="/product/item_list/ps4">
				<img src="/resources/home_image/ps4.png" alt="ps4" style="width:100%;">
			</a>
				<div class="carousel-caption">
					<h3>PS4</h3>
					<p>Sony PlayStation 4 Pro</p>
				</div>
			</div>

			<div class="item">
			<a href="/product/item_list/xbox">
				<img src="/resources/home_image/xbox.jpg" alt="xbox" style="width:100%;">
			</a>
				<div class="carousel-caption">
					<h3>XBOX</h3>
					<p>Microsoft XBOX ONE</p>
				</div>
			</div>

			<div class="item">
			<a href="/product/item_list/nintendo">
				<img src="/resources/home_image/nintendo.png" alt="nintendo" style="width:100%;">
			</a>
				<div class="carousel-caption">
					<h3>NINTENDO</h3>
					<p>Nintendo SWITCH</p>
				</div>
			</div>
		</div>
<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>
