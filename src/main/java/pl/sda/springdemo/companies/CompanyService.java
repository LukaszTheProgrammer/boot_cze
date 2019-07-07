package pl.sda.springdemo.companies;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private static final Map<Long, Company> companies = new HashMap<>();

    static {
        Address address1 = new Address("NMP", 56, "Czestochowa");
        long nip1 = 9491002040L;
        companies.put(nip1, new Company(nip1, "ACME", 263101400, address1));

        Address address2 = new Address("Al. Jerozolimskie", 12, "Warszawa");
        long nip2 = 7534561178L;
        companies.put(nip2, new Company(nip2, "LG", 100291001, address2));
    }

    public List<Company> find(String nip, String nazwa) {
        if (nip != null) {
            long convertedNip = Long.parseLong(nip.replaceAll("[\\s\\-]", ""));

            if (companies.containsKey(convertedNip)) {
                Company found = companies.get(convertedNip);
                return nazwa == null || found.getNazwa().equals(nazwa) ?
                    Collections.singletonList(found) : Collections.emptyList();
            } else {
                return Collections.emptyList();
            }
        } else {
            if (nazwa == null) {
                return new ArrayList<>(companies.values());
            } else {
                return companies.values().stream()
                    .filter(c -> c.getNazwa().equals(nazwa))
                    .collect(toList());
            }
        }
    }
}
