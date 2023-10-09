package com.myapp.examinator;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/exam")
    public Exam getExam(@RequestBody Map<String,Integer> spec) {
        List<Section> sections = spec.entrySet().stream()
                .map(entry -> {
                    String title = entry.getKey();
                    String url = getUrl(title, entry.getValue());
                    Question[] questions = restTemplate.getForObject(url, Question[].class);
                    return Section.builder().questions(Arrays.asList(questions)).title(title).build();
                }).collect(Collectors.toList());

        return Exam.builder().sections(sections).title("Exam #1").build();
    }

    private String getUrl(String service, int amount) {
        return "http://" + service + "/exercise/random?amount=" + amount;
    }
}
