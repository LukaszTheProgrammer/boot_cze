package pl.sda.springdemo.flights;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kong.unirest.HttpResponse;
import kong.unirest.JacksonObjectMapper;
import kong.unirest.Unirest;

@Controller("/flights")
class FlightsController {

    @GetMapping
    public String getFlights(@RequestParam String from, @RequestParam String to, Model model) {
        Unirest.config().setObjectMapper(new JacksonObjectMapper());

        HttpResponse<FlightResponse> flightResponse = Unirest.get("http://localhost:9090/flights")
            .header("accept", "application/json")
            .queryString("from", from)
            .queryString("to", to)
            .asObject(FlightResponse.class);

        model.addAttribute("flights", flightResponse.getBody().getFlights());

        return "flight/result";
    }
}
