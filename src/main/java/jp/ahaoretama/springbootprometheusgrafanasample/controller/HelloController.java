package jp.ahaoretama.springbootprometheusgrafanasample.controller;

import io.prometheus.client.spring.web.PrometheusTimeMethod;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sekineyasufumi on 2018/02/21.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    @PrometheusTimeMethod(name = "hello_controller_say_hello_duration_seconds", help = "Some helpful info here")
    public String sayHello() {
        Random rand = new Random(); 
        int waitingTime = rand.nextInt(50); 
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "hello";
    }
    @GetMapping("/hello_wait")
    @PrometheusTimeMethod(name = "hello_wait_controller_say_hello_duration_seconds", help = "Some helpful info here")
    public String sayHelloWait() {
        Random rand = new Random(); 
        int waitingTime = rand.nextInt(5000); 
        try {
            Thread.sleep(waitingTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "hello with waiting time of "+ waitingTime;
    }
}
