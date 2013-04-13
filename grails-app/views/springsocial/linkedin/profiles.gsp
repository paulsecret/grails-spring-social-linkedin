<html>
<head>
    <title>LinkedIn Profiles</title>
    <meta name='layout' content='linkedinLayout'/>
</head>

<body>

<h3>Your LinkedIn Connections</h3>

<ul class="imagedList">
    <g:each in="${profiles}" var="profile">
        <li class="imagedItem">
            <div class="image">
                <g:if test="${profile.getProfilePictureUrl()}">
                    <img src="${profile.getProfilePictureUrl()}" alt="" width="48" height="48" align="left" />
                </g:if>
            </div>

            <div class="content">
                <p><a href="${profile.getPublicProfileUrl()}">${profile.getFirstName()} ${profile.getLastName()}</a></p>
            </div>
        </li>
    </g:each>

</ul>

</body>
</html>
