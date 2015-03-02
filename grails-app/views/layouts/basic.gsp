<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Melanie M Zwegers"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<g:javascript src="jquery.min.js" />
		<link href='//fonts.googleapis.com/css?family=EB+Garamond&subset=latin,latin-ext' rel='stylesheet' type='text/css' />
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'zwegersmel.css')}" type="text/css">
		<g:layoutHead/>
		<g:javascript library="application"/>		
		<r:layoutResources />
	</head>
	<body>
		<h1 class="title">MELANIE M ZWEGERS</h1>
		<ul class="menu">
			<li id="home"><g:link controller="home">Home</g:link></li>
			<li id="book"><g:link controller="home" action="book">Buy The Book</g:link></li>
			<li id="about"><g:link controller="home" action="about">About</g:link></li>
			<li id="events"><g:link controller="home" action="events">Events</g:link></li>
			<li id="contact"><g:link controller="home" action="contact">Contact</g:link></li>
			<li id="review"><g:link controller="home" action="reviews">Reviews</g:link></li>
			<sec:ifAllGranted roles="ROLE_ADMIN">
				<li><g:link controller="event">Edit Events</g:link></li>
				<li><g:link controller="message">Comments</g:link></li>
				<li><g:link controller="review">Review</g:link></li>
			</sec:ifAllGranted>
		</ul>
		<g:layoutBody/>
		<div class="footer">
			All content © 2015 Melanie M Zwegers, Email <a href="mailto:contact@melaniemzwegers.com">contact@melaniemzwegers.com</a>
		</div>
		<r:layoutResources />
	</body>
</html>
