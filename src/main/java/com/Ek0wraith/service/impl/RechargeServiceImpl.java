package com.Ek0wraith.service.impl;

import com.Ek0wraith.mapper.CourseMapper;
import com.Ek0wraith.mapper.MemberMapper;
import com.Ek0wraith.mapper.RegisterMapper;
import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import com.Ek0wraith.pojo.Register;
import com.Ek0wraith.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: RechargeServiceImple
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/17 9:07
 * @Version 1.0
 */
@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Register> getAllRegister(int page, int size) {
        return registerMapper.getAllRegister(page,size);
    }

    @Override
    public List<Register> getRegisterByMemberNo(int memberNo) {
        return registerMapper.getRegisterByMemberNo(memberNo);
    }

    @Override
    public Map<String, Object> addRegister(Register register) {
        Map<String,Object> resultMap = new HashMap<>();

        String memberPhone = register.getMemberPhone();

        Member memberByPhone = registerMapper.getMemberByPhone(memberPhone);

        Register checkRegister = registerMapper.checkRegister(register.getCourseNo(), memberByPhone.getMemberNo());



        if (memberByPhone == null ) {
            resultMap.put("code",400);
            resultMap.put("message","会员不存在");
        }else {
            if (checkRegister !=null) {
                resultMap.put("code",400);
                resultMap.put("message","已购买同期课程，请勿重复购买");
            }else {
                register.setMemberNo(memberByPhone.getMemberNo());
                double coursePriceByCourseNo = courseMapper.getCoursePriceByCourseNo(register.getCourseNo());
                double memberChange = memberMapper.getMemberChange(register.getMemberNo());
                //余额不足问题
                if (memberChange > coursePriceByCourseNo){
                    int result =  registerMapper.addRegister(register);

                    if(result>0){
                        resultMap.put("code",200);
                        resultMap.put("message","购买成功");
                    }else{
                        resultMap.put("code",400);
                        resultMap.put("message","购买失败");
                    }
                }
                else{
                    resultMap.put("code",400);
                    resultMap.put("message","购买失败,余额不足请充值余额后再试");
                }
            }

        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateRegister(Register register) {
        Map<String,Object> resultMap = new HashMap<>();
        int result =  registerMapper.updateRegister(register);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","修改成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","修改失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteRegister(int registerNo) {
        Map<String,Object> resultMap = new HashMap<>();
        int result =  registerMapper.deleteRegister(registerNo);

        if(result>0){
            resultMap.put("code",200);
            resultMap.put("message","删除成功");
        }else{
            resultMap.put("code",400);
            resultMap.put("message","删除失败");
        }

        return resultMap;
    }

    @Override
    public Common totalRegister() {
        return registerMapper.totalRegister();
    }

    @Override
    public List<Register> getByKeywordRegister(String keyWord, int page, int size) {
        return  registerMapper.getByKeywordRegister(keyWord,page,size);
    }

    @Override
    public Common totalRegisterFuzzy(String keyWord) {
        return registerMapper.totalRegisterFuzzy(keyWord);
    }
}
