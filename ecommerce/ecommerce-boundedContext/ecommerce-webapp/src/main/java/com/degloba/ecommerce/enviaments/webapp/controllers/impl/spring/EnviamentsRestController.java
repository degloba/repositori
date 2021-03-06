package com.degloba.ecommerce.enviaments.webapp.controllers.impl.spring;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

////import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.Enviament;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.EnviamentTemplateOperations;
import com.degloba.ecommerce.enviaments.domain.persistence.nosql.mongo.IEnviamentReactiveRepository;
import com.degloba.ecommerce.enviaments.facade.dtos.EnviamentDto;
import com.degloba.ecommerce.enviaments.webapp.services.UserrService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@RestController
//@CrossOrigin(origins = "http://localhost:8083")    // port intern (No Docker)
@CrossOrigin(origins = "http://webAngularHost:8887")    // port extern (Docker)
public class EnviamentsRestController {
	
	 @Autowired
	 IEnviamentReactiveRepository enviamentRepository;
	 
	 
	 @Autowired
	 EnviamentTemplateOperations enviamentTemplate;
			
	  //////EnviamentRepository enviamentRepository = new EnviamentRepository();
		
		 @RequestMapping("/")
		    @ResponseBody
		    public String home() {
		        return "Hola Web";
		    }
		
		
		/////@GetMapping("")
		@RequestMapping("/enviaments/")
		@ResponseBody
		public Flux<EnviamentDto> getEnviaments(@RequestParam(required = false) String queryParam) {
////			log.debug("Received request at getExample:" + queryParam);
			
			
			return enviamentTemplate.findAll().flatMap(UserrService::covertUserDAOToBUserBO);
			
			////////return enviamentTemplate.findAll();   // si retorna Flux<Entity>
			
			//////return enviamentRepository.findAllEnviaments();
			
			
			/*
			 * if (queryParam == null || "NULL".equals(queryParam)) throw new
			 * RuntimeException("Give me a Param!"); if (queryParam.equals("STOP")) { try {
			 * Thread.sleep(5000); } catch (Exception k) {k.printStackTrace();} }
			 * 
			 * return ResponseEntity.ok().body(queryParam);
			 */
			 
		}
		
		@PostMapping("post")
		public ResponseEntity<String> postEnviament(@RequestBody Map<String,String> body,ServerHttpRequest  request) {
			
			String s="the server said: "+body+"\n";
			for (Entry<String, List<String>> map : request.getHeaders().entrySet())
			{
				//log.debug("Headers -> "+map.getKey()+ ":"+map.getValue().get(0));
				//s+="Headers: "+map.getKey()+ ":"+map.getValue().get(0)+"\n";			
			}		
			return ResponseEntity.ok().body(s);
		}

}
