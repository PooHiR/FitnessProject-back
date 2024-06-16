package com.Ek0wraith.service;

import com.Ek0wraith.pojo.Register;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: RegisterService
 * Package: com.Ek0wraith.service
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/16 16:59
 * @Version 1.0
 */
@Service
public interface RegisterService {
    public List<Register> getAllRegister(int page, int size);
    public List<Register> getRegisterByMemberNo(int memberNo);
    public Map<String,Object> addRegister(Register register);
    public Map<String,Object>  updateRegister(Register register);
    public Map<String,Object>  deleteRegister(int registerNo);


}
