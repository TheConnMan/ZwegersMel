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
						<g:each in="${ (0..4) }">
							<i class="star ${ it < review.stars ? 'full' : 'empty' }"></i>
						</g:each>
						<p>
							${ review.content }
						</p>
						<p>
						-- ${ review.author } - ${ review.createdDate.format('MM/dd/yyyy HH:mm') }
						</p>
					</div>
				</g:each>
			</div>
			<div style="width: 600px; margin: 0 auto;">
				<h2 class="blue">Have a review or testimonial you'd like to share?</h2>
				<h3>Let us know by filling out the form below!</h3>
				<g:form action="submitReview" class="contact">
					<label>Title</label><span class="required">*</span>
					<g:field type="text" name="title" required="true" />
					<label>Author</label>
					<g:field type="text" name="author" placeholder="Anonymous" />
					<label>Stars</label><span class="required">*</span><br />
					<g:each in="${ (0..4) }">
						<i class="star clickable full" id="star-${ it }"></i>
					</g:each><br />
					<g:field type="hidden" name="stars" value="5" />
					<label>Review</label><span class="required">*</span>
					<g:textArea name="content" required="true" maxlength="500" />
					<button class="button">Submit</button>
				</g:form>
			</div>
		</div>
		<script>
			$(function() {
				$('#reviews').addClass('active');
				$('.star.clickable').click(function() {
					var num = parseInt($(this).attr('id').split('-')[1]);
					$('#stars').val(num + 1);
					console.log($('.star.clickable:lt(' + (num + 1) + ')'))
					$('.star.clickable:lt(' + (num + 1) + ')').removeClass('empty').addClass('full');
					$('.star.clickable:gt(' + num + ')').removeClass('full').addClass('empty');
				});
			});
		</script>
	</body>
</html>
