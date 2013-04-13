<html>
<head>
    <title>Connected to LinkedIn</title>
    <meta name='layout' content='linkedinLayout' />
</head>
<body>
<h1>Connected to LinkedIn</h1>

<form action="${createLink(controller: 'connect', params: [providerId: 'linkedin'])}" id="disconnect" method="post">
    <input type="hidden" name="_method" value="delete"/>
    <div class="formInfo">
        <p>The Grails Social Showcase sample application is already connected to your LinkedIn account.
        Click the button if you wish to disconnect.
    </div>

    <button type="submit">Disconnect</button>
</form>

<p><g:link controller="home">Return to home page</g:link></p>

</body>
</html>
