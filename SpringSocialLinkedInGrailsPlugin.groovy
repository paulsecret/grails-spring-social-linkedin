class SpringSocialLinkedInGrailsPlugin {
  // the plugin version
  String version = "0.2.0-SNAPSHOT"
  // the version or versions of Grails the plugin is designed for
  String grailsVersion = "2.3.9 > *"
  // the other plugins this plugin depends on
  Map dependsOn = ['springSocialCore': '0.1.31 > *']
  // resources that are excluded from plugin packaging
  List pluginExcludes = [
      "grails-app/views/error.gsp"
  ]

  String author = "Ethan Gordon"
  String authorEmail = "ekgordon2@gmail.com"
  String title = "Spring Social LinkedIn"
  String description = 'Spring Social LinkedIn plugin.'

  String documentation = "http://grails.org/plugin/spring-social-linkedin"

  def doWithSpring = {
    xmlns context: "http://www.springframework.org/schema/context"
    context.'component-scan'('base-package': "grails.plugins.springsocial.config.linkedin")
  }

}
