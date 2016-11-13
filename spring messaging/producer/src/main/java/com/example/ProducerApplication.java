package com.example;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(ProducerChannel.class)
@SpringBootApplication
public class ProducerApplication {
	
	private final MessageChannel consumer;
	
	@Bean
	@Scope("prototype")
	Logger logger(InjectionPoint ip){
		return Logger.getLogger(ip.getDeclaredType().getName());
	}
	@Autowired
	private Logger log;
	@Autowired
	public ProducerApplication(ProducerChannel producer) {
		this.consumer=producer.consumer();
	}

	@GetMapping("/message/{body}")
	public void publish(@PathVariable String body){
		String message="Got message "+body;
		log.info("Sending message "+message);
		Message<String> msg=MessageBuilder.withPayload(message).build();
		consumer.send(msg);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
	
}
interface ProducerChannel{
	@Output MessageChannel consumer();
}
