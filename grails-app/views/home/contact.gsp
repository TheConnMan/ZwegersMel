<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="basic"/>
		<title>Melanie M Zwegers - Contact</title>
	</head>
	<body>
		<div class="content">
			<g:if test="${ flash.message }">
				<div class="message ${ flash.error ? 'error' : '' }" style="max-width: 600px; margin: 0 auto;">
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
							<g:field type="text" name="name" required="true" maxlength="255" />
							<label>Email</label><span class="required">*</span>
							<g:field type="email" name="email" required="true" maxlength="255" />
							<label>Comment</label><span class="required">*</span>
							<g:textArea name="comment" required="true" maxlength="500" />
							<button class="button">Submit</button>
						</g:form>
						<h2>Subscribe to our mailing list</h2>
						<div id="mc_embed_signup">
							<form action="//melaniemzwegers.us10.list-manage.com/subscribe/post?u=8b0918657ba200715ea743ee8&amp;id=1f11dcf750" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate contact" target="_blank" novalidate>
							    <div id="mc_embed_signup_scroll">
								<div class="mc-field-group">
									<label for="mce-EMAIL">Email Address</label><span class="required">*</span>
									<input type="email" name="EMAIL" class="required email" id="mce-EMAIL">
								</div>
								<div class="mc-field-group">
									<label for="mce-FNAME">First Name </label>
									<input type="text" name="FNAME" id="mce-FNAME">
								</div>
								<div class="mc-field-group">
									<label for="mce-LNAME">Last Name </label>
									<input type="text" name="LNAME" id="mce-LNAME">
								</div>
								<div id="mce-responses" class="clear">
									<div class="response" id="mce-error-response" style="display:none"></div>
									<div class="response" id="mce-success-response" style="display:none"></div>
								</div>
							    <div style="position: absolute; left: -5000px;"><input type="text" name="b_8b0918657ba200715ea743ee8_1f11dcf750" tabindex="-1" value=""></div>
							    <div class="clear"><input type="submit" value="Subscribe" name="subscribe" id="mc-embedded-subscribe" class="button"></div>
							    </div>
							</form>
						</div>
						<script type='text/javascript' src='//s3.amazonaws.com/downloads.mailchimp.com/js/mc-validate.js'></script><script type='text/javascript'>(function($) {window.fnames = new Array(); window.ftypes = new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='FNAME';ftypes[1]='text';fnames[2]='LNAME';ftypes[2]='text';}(jQuery));var $mcj = jQuery.noConflict(true);</script>
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
