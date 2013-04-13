<html>
<head>
    <title>LinkedIn Profile</title>
    <meta name='layout' content='linkedinLayout'/>
</head>

<body>
<h3>Your LinkedIn Profile</h3>

<p>Hello, ${profile.getFirstName()} + ${profile.getLastName() }</p>
<img src="${profile.getProfilePictureUrl()}"/>
<dl>
    <dt>LinkedIn ID:</dt>
    <dd>${profile.getId()}</dd>
    <dt>Headline:</dt>
    <dd>${profile.getHeadline()}</dd>
    <dt>Summary:</dt>
    <dd>${profile.getSummary()}</dd>
    <dt>URL:</dt>
    <dd><a href="${profile.getPublicProfileUrl()}">${profile.getPublicProfileUrl()}</a></dd>
</dl>

<g:form method="DELETE" mapping="springSocialConnect" params="[providerId:'linkedin']">
    <button type="submit">Disconnect from Linkedin</button>
</g:form>


</body>
</html>
