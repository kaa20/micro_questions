package com.myapp.examinator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ExamController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String,Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(entry -> {
                    String title = entry.getKey();
                    String url = getUrl(title, entry.getValue());
                    Question[] questions = restTemplate.getForObject(url, Question[].class);
                    System.out.println(Arrays.toString(questions));
                    return Section.builder().questions(Arrays.asList(questions)).title(title).build();
                }).collect(Collectors.toList());
        System.out.println(sections);

        return Exam.builder().sections(sections).title("Exam #1").build();
    }

    private String getUrl(String service, int amount) {
        String url = "";
        if (service.equals("K8S")) {
            url = "http://" + service + "/api/questions?amount=" + amount;
        } else if (service.equals("JAVAQUIZ")) {
            url = "http://" + service + "/api/quizzes?amount=" + amount;
        }
        System.out.println(url);
        return url;
    }
}
