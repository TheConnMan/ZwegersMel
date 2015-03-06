<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="basic"/>
		<title>Melanie M Zwegers - Reviews</title>
	</head>
	<body>
		<div class="content">
			<g:if test="${ flash.message }">
				<div class="message" style="max-width: 600px; margin: 0 auto;">
					${ flash.message }
				</div>
			</g:if>
			<div class="reviews">
				<g:each in="${ reviews }" var="review">
					<div class="review">
						<h2 class="blue">${ review.title }</h2>
						<p>
							${ review.content }
						</p>
						<p>
						-- ${ review.author } - ${ review.createdDate.format('MM/dd/yyyy') }
						</p>
					</div>
				</g:each>
			</div>
			<div style="width: 600px; margin: 0 auto;">
				<h2 class="blue">Have a review or testimonial you'd like to share?</h2>
				<h3>Let us know by filling out the form below!</h3>
				<g:form action="submitReview" class="contact">
					<label>Review Title</label><span class="required">*</span>
					<g:field type="text" name="title" required="true" />
					<label>Your Name</label>
					<g:field type="text" name="author" placeholder="Anonymous" />
					<label>Review</label><span class="required">*</span>
					<g:textArea name="content" required="true" maxlength="2000" />
					<button class="button">Submit Review</button>
				</g:form>
			</div>
		</div>
		<script>
			$(function() {
				$('#reviews').addClass('active');
			});
		</script>
	</body>
</html>
