package org.school.classeapi.web;

import org.school.classeapi.shared.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/classes")
@RefreshScope
public class ConfigTestController {

   @Value("${global.params.p1}")
   int x;

   @Value("${global.params.p2}")
   int y;

   @Value("${global.params.c1}")
   int z;

   @GetMapping(path = "/test")
   Map<String,Integer> getParamsTest() {
      return Map.of("p1",x,"p2",y,"p3",z);
   }

}
