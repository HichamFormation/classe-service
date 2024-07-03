package org.school.classeapi.web;

import org.school.classeapi.shared.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestController {

   @Value("${global.params.a}")
   int x;

   @Value("${global.params.b}")
   int y;

   @Value("${eureka.client.service-url.defaultZone}")
   String url;

   @Autowired
   ConfigUtils configUtils;

   @GetMapping("/config")
   ConfigUtils getParams() {
       return configUtils;
   }

   @GetMapping(path = "/test")
   String getParamsTest() {
      return String.valueOf(x).concat(String.valueOf(y)).concat(url);
   }

}
