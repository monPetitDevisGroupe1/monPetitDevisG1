/*
 * Copyright 2012-2015 the original author or authors.
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

package sample.tomcat.jsp;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping({"/signIn"})
	public String welcome(Map<String, Object> model) {

		return "welcome";
	}

	@RequestMapping({"/index"})
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}



	@RequestMapping("/private/dash")
	public String dash(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "Yeah!!!!");
		return "dash";
	}


	@Secured("ROLE_YEAH")
	@RequestMapping(value = "/private/admin", method = RequestMethod.GET)
	public ModelAndView admin(){
		ModelAndView model = new ModelAndView("admin");
		model.addObject("message","Hello admin !!");
		return model;
	}

	@RequestMapping("/fail")
	public String fail() {
		throw new MyException("Oh dear!");
	}

	@RequestMapping("/fail2")
	public String fail2() {
		throw new IllegalStateException();
	}



	@ExceptionHandler(MyException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody MyRestResponse handleMyRuntimeException(MyException exception) {
		return new MyRestResponse("Some data I want to send back to the client -> " + exception.getMessage());
	}

}
