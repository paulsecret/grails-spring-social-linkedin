<html>
<head>
    <title>Connect to LinkedIn</title>
    <meta name='layout' content='linkedinLayout'/>
</head>

<body>
<h1>Connect to LinkedIn</h1>


<g:form mapping="springSocialConnect" params="[providerId: 'linkedin']" method="POST">
    <div class="formInfo">
        <p>
            You haven't created any connections with LinkedIn yet. Click the button to connect Spring Social Showcase with your LinkedIn account.
            (You'll be redirected to LinkedIn where you'll be asked to authorize the connection.)
        </p>
    </div>

    <p><button type="submit"><img
            src="${createLinkTo(dir: 'images/springsocial/linkedin', file: 'connect-with-linkedin.png')}"/></button></p>
</g:form>

</body>
</html>
