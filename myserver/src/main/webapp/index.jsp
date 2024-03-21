<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="icon" href="./resources/images/favicon.png" />
	<style>
		.main>div>a {
			font-size: 2em;
		}
	</style>
</head>

<body>
	<h1>Hello world!(index)</h1>

	<div class="main">
		<div> <a href="template/cart.html">cart</a> </div>
		<div> <a href="template/empJob.html">employee</a> </div>
		<div> <a href="template/petShop.html">petShop</a> </div>
		<div> <a href="template/user.html">user</a> </div>
	</div>
	<button id="payBtn">Daum api</button>

	<script>
		document.querySelector('#payBtn').addEventListener('click', function (e) {
			fetch('https://open-api.kakaopay.com/online/v1/payment/ready', {
				method: 'POST',
				headers: {
					'Authorization': 'SECRET_KEY DEV0B27379694E3CE6CA6DA5184951A4E611C945',
					'Content-Type': 'application/json'
				},
				// body: '{\n\t\t"cid": "TC0ONETIME",\n\t\t"partner_order_id": "partner_order_id",\n\t\t"partner_user_id": "partner_user_id",\n\t\t"item_name": "\uCD08\uCF54\uD30C\uC774",\n\t\t"quantity": "1",\n\t\t"total_amount": "2200",\n\t\t"vat_amount": "200",\n\t\t"tax_free_amount": "0",\n\t\t"approval_url": "https://developers.kakao.com/success",\n\t\t"fail_url": "https://developers.kakao.com/fail",\n\t\t"cancel_url": "https://developers.kakao.com/cancel"\n\t}',
				body: JSON.stringify({
					'cid': 'TC0ONETIME',
					'partner_order_id': 'partner_order_id',
					'partner_user_id': 'partner_user_id',
					'item_name': '\uCD08\uCF54\uD30C\uC774',
					'quantity': '1',
					'total_amount': '2200',
					'vat_amount': '200',
					'tax_free_amount': '0',
					'approval_url': 'https://developers.kakao.com/success',
					'fail_url': 'https://developers.kakao.com/fail',
					'cancel_url': 'https://developers.kakao.com/cancel'
				})
			});
		})
	</script>
</body>

</html>