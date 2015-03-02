<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="basic"/>
		<title>Melanie M Zwegers - Contact</title>
	</head>
	<body>
		<div class="content">
			<g:if test="${ flash.message }">
				<div class="message" style="max-width: 600px; margin: 0 auto;">
					${ flash.message }
				</div>
			</g:if>
			<table class="split-content">
				<tr>
					<td style="text-align: right;">
						<img src="${resource(dir: 'images', file: 'Contact.jpg')}" style="margin-top: 45px;" />
					</td>
					<td>
						<h2>Contact Melanie M Zwegers</h2>
						<g:form action="submitContact" class="contact">
							<label>Name</label><span class="required">*</span>
							<g:field type="text" name="name" required="true" />
							<label>Email</label><span class="required">*</span>
							<g:field type="email" name="email" required="true" />
							<label>Comment</label><span class="required">*</span>
							<g:textArea name="comment" required="true" maxlength="500" />
							<button class="button">Submit</button>
						</g:form>
					</td>
				</tr>
			</table>
		</div>
		<script>
			$(function() {
				$('#contact').addClass('active');
			});
		</script>
	</body>
</html>
