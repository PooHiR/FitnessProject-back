package com.Ek0wraith.controller;

import com.Ek0wraith.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ClassName: EchartsController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/14 15:08
 * @Version 1.0
 */
@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Resource
    private MemberService memberService;
    @GetMapping("/getMemberBySeason")
    public Map<String,Object> getMemberBySeason(@RequestParam("year") Integer year) {
        return memberService.getMemberBySeason(year);
    }

    @GetMapping("/getMemberSexByYear")
    public Map<String,Object> getMemberSexByYear(@RequestParam("year") Integer year){
        return memberService.getMemberSexByYear(year);
    }
}
