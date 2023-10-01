package api.test;

import db.test.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestRepository testRepository;
    @GetMapping("/me")
    public String me() throws Exception {
        log.info(testRepository.findById(1L).orElseThrow(()->new Exception()).toString());
        return "me";
    }
}
