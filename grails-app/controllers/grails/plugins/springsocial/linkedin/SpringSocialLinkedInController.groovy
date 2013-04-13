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
package grails.plugins.springsocial.linkedin

import grails.plugins.springsocial.linkedin.SpringSocialLinkedInUtils;

import org.springframework.social.linkedin.api.LinkedIn

class SpringSocialLinkedInController {

  def linkedin
  def connectionRepository

  def beforeInterceptor = [action: this.&auth, except: 'login']

  def index = {
    def model = ["profile": linkedin.getUserProfile()]
    render(view: "/springsocial/linkedin/index", model: model)
  }

  def profiles = {
    def id = params.id ?: "friends"
    def profiles
    profiles = linkedin.getConnections();
    render view: SpringSocialLinkedInUtils.config.linkedin.page.profiles, model: ['profiles': profiles]
  }
  

  def login = {
    render(view: SpringSocialLinkedInUtils.config.linkedin.page.connect)
  }

  def auth() {
    if (!isConnected()) {
      redirect(action: 'login')
      return false
    }
  }

  Boolean isConnected() {
    connectionRepository.findPrimaryConnection(LinkedIn)
  }

}
