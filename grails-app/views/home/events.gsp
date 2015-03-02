<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="basic"/>
		<title>Melanie M Zwegers - Events</title>
	</head>
	<body>
		<div class="content">
			<g:each in="${ events }">
				<div style="margin-top: 40px;">
					<h2 class="blue" style="margin-bottom: 5px;">${ it.name }</h2>
					<p style="font-size: 20px; margin-top: 0;">
						${ it.date }<br />
						${ it.venue }<br />
						${ it.location }
					</p>
				</div>
			</g:each>
		</div>
		<script>
			$(function() {
				$('#events').addClass('active');
			});
		</script>
	</body>
</html>
