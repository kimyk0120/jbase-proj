package admin.domain;


import db.test.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/api")
public class ApiController {

    private final TestRepository testRepository;

    @GetMapping("/me")
    public Object me(){
        return testRepository.findFirstByOrderByCreatedAtDesc().toString();
    }
}
