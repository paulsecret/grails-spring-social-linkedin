/* Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugins.springsocial.config.linkedin

import grails.plugins.springsocial.linkedin.SpringSocialLinkedInUtils;

import javax.inject.Inject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.connect.ConnectionFactory
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.linkedin.api.LinkedIn
import org.springframework.social.linkedin.api.impl.LinkedInTemplate
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory
import org.springframework.util.Assert

@Configuration
class LinkedInConfig {
  @Inject
  ConnectionRepository connectionRepository

  @Bean
  ConnectionFactory linkedinConnectionFactory() {
    println "Configuring SpringSocial LinkedIn"
    def linkedInConfig = SpringSocialLinkedInUtils.config.get("linkedin")
    String consumerKey = linkedInConfig.consumerKey ?: ""
    String consumerSecret = linkedInConfig.consumerSecret ?: ""
    Assert.hasText(consumerKey, "The LinkedIn consumerKey is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.linkedin.consumerKey='yourConsumerKey'")
    Assert.hasText(consumerSecret, "The LinkedIn consumerSecret is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.linkedin.consumerSecret='yourConsumerSecret'")
    new LinkedInConnectionFactory(consumerKey, consumerSecret)
  }

  @Bean
  @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
  LinkedIn linkedin() {
    def linkedIn = connectionRepository.findPrimaryConnection(LinkedIn)
    linkedin != null ? linkedin.getApi() : new LinkedInTemplate()
  }
}
