package com.example.calc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.beans.BeanProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
@SpringBootApplication
@Slf4j
public class CalcApplication {


	public static void main(String[] args) {
		SpringApplication.run(CalcApplication.class, args);
	}


	@GetMapping(value = "/")
	public String index(@RequestParam(name="from", required = false, defaultValue="złoty polski") String from,
						@RequestParam(name="to", required = false, defaultValue = "złoty polski") String to,
						@RequestParam(name="amount", required = false, defaultValue = "1") String amount,
						Model model) {

		log.info(from + " " + to);

		model.addAttribute("name", "Dupa");

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Table[]> response =
				restTemplate.getForEntity(
						"http://api.nbp.pl/api/exchangerates/tables/a/?format=json", Table[].class);


		Rate[] rates = response.getBody()[0].rates;


		Rate plnRate = new Rate();
		plnRate.setCurrency("złoty polski");
		plnRate.setNode("PLN");
		plnRate.setMid(BigDecimal.ONE);

		ArrayList<Rate> myRates = new ArrayList<>();
		myRates.add(plnRate);
		myRates.addAll(Arrays.asList(rates));

		Rate rateFrom = myRates.stream().filter(x -> {return x.currency.equals(from);}).collect(Collectors.toList()).get(0);
		Rate rateTo = myRates.stream().filter(x -> {return x.currency.equals(to);}).collect(Collectors.toList()).get(0);

		log.info("rateFrom: {}, {}, {}", rateFrom.currency, rateFrom.mid, rateFrom.node);
		log.info("rateTo: {}, {}, {}", rateTo.currency, rateTo.mid, rateTo.node);

		BigDecimal a = BigDecimal.valueOf(Long.valueOf(amount));
		BigDecimal r = a.multiply(rateFrom.mid).multiply(rateTo.mid); // TODO: raczej niepoprawna formuła

		model.addAttribute("from", myRates);
		model.addAttribute("to", myRates);
		model.addAttribute("amount", amount);
		model.addAttribute("result", r);

		return "index";
	}

}

