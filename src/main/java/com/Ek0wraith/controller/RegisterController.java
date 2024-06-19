package com.Ek0wraith.controller;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Register;
import com.Ek0wraith.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


/**
 * ClassName: RegisterController
 * Package: com.Ek0wraith.controller
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:58
 * @Version 1.0
 */
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(path= "/getAllRegister")
    public List<Register> getAllRegister(int page, int size){
        return registerService.getAllRegister(page,size);
    }

    @RequestMapping(path= "/getRegisterByMemberNo")
    public List<Register> getRegisterByMemberNo(int memberNo){
        return registerService.getRegisterByMemberNo(memberNo);
    }

    @RequestMapping(path= "/addRegister")
    public Map<String,Object> addRegister(Register register){
        return registerService.addRegister(register);
    }

    @RequestMapping(path ="/updateRegister")
    public Map<String,Object> updateRegister(Register register){
        return registerService.updateRegister(register);
    }

    @RequestMapping(path ="/deleteRegister")
    public Map<String,Object> deleteRegister(int registerNo){
        return registerService.deleteRegister(registerNo);
    }

    @RequestMapping(path = "/totalRegister")
    public Common totalRegister() {
        return registerService.totalRegister();
    }
    @RequestMapping(path = "/getByKeywordRegister")
    public List<Register> getByKeywordRegister(String keyWord, int page, int size){
        return registerService.getByKeywordRegister(keyWord,page,size);
    }
    @RequestMapping(path = "/totalRegisterFuzzy")
    public Common totalRegisterFuzzy(String keyWord) {
        return registerService.totalRegisterFuzzy(keyWord);
    }
}
