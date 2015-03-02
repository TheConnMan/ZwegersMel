<!DOCTYPE html>
<html>
	<head>
		<title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
		<meta name="layout" content="basic">
		<g:if env="development"><link rel="stylesheet" href="${resource(dir: 'css', file: 'errors.css')}" type="text/css"></g:if>
	</head>
	<body>
		<div class="content">
			<g:if env="development">
				<div style="text-align: left;">
					<g:renderException exception="${exception}" />
				</div>
			</g:if>
			<g:else>
				<h1>An error has occurred</h1>
				<p>
					Take me back <a href="/">home</a>
				</p>
			</g:else>
		</div>
	</body>
</html>
