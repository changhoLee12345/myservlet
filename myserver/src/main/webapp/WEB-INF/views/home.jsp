<%@ page session="false"%>
<html>

<head>
	<title>Home</title>
	<meta charset="utf-8">
	<link rel="icon" href="./resources/images/favicon.png" />
	<style>
		.main>div>a {
			font-size: 2em;
		}
	</style>
</head>

<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<div class="main">
		<div> <a href="template/cart.html">cart</a> </div>
		<div> <a href="template/empJob.html">employee</a> </div>
		<div> <a href="template/petShop.html">petShop</a> </div>
		<div> <a href="template/user.html">user</a> </div>
	</div>

</body>

</html>