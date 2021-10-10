package org.example.rest;

import com.vo.SandeepCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloEndpointImpl {

    @Autowired
    private  RestTemplate restTemplate;

    @GetMapping(value = "/api/hello", produces="application/x-protobuf")
    public SandeepCar.Car sayHello(){
        SandeepCar.Car.Builder builder = SandeepCar.Car.newBuilder();

        return builder.setModel("Alto").setYear(2015).setPrice(221000).setRcNumber("HR03T7201").
        setProfit("Profit").setOwnerName("sanhoo-hooda").build();
    }

    @GetMapping(value = "/api/getproto")
    public String getproto(){
        SandeepCar.Car car = restTemplate.getForObject("http://localhost:8080/api/hello", SandeepCar.Car.class);
        return car.getOwnerName();
    }
}
