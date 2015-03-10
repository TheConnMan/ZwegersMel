<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="basic"/>
		<title>Melanie M Zwegers - Home</title>
	</head>
	<body>
		<div class="content">
			<h3 class="blue"><i>Now Available</i></h3>
			<h1 style="margin-bottom: 0;">INTO THE GARDEN</h1>
			<h2 style="margin-top: 0;"><i>Verses for Hearts Young & Old</i></h2>
			<h3 style="margin-bottom: 0;">Written and Illustrated by</h3>
			<h3 style="margin-top: 0;">Melanie M Zwegers</h3>
			<img src="${resource(dir: 'images', file: 'Web_Rabbit_Small.png')}" />
		</div>
		<g:each in="${ images }">
			<img class="animation" src="${ resource(dir: 'images', file: 'animations/' + it) }" />
		</g:each>
		<script>
			var images = $('.animation').toArray(),
				counter = 0,
				imageHeight = 75,
				speed = 10,
				pad = 10
				content = 800,
				width = $(window).width(),
				height = $(window).height();
			
			$(function() {
				$('#home').addClass('active');
				setInterval(animate, 1000 * (speed + pad) / images.length)
			});

			function animate() {
				var cur = images[counter % images.length];
				var x = Math.random() > .5 ? (width - content) / 2 * Math.random() : (width - content) / 2 * Math.random() + (width + content) / 2;
				$(cur).css('top', -imageHeight);
				$(cur).css('left', x);
				$(cur).animate({
					top: height
				}, 1000 * speed, 'linear');
				counter++;
			}
		</script>
	</body>
</html>
