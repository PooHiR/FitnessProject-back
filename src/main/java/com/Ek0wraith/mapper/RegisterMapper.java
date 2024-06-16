package com.Ek0wraith.mapper;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import com.Ek0wraith.pojo.Register;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: RegisterMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 18:09
 * @Version 1.0
 */
@Mapper
@Repository
public interface RegisterMapper {
    List<Register> getAllRegister(int page,int size);
    List<Register> getRegisterByMemberNo(int memberNo);
    Member getMemberByPhone(String memberPhone);

    int addRegister(Register register);

    int updateRegister(Register register);

    int deleteRegister(int registerNo);

    Common totalRegister();

    List<Register> getByKeywordRegister(String keyWord,int page,int size);

    Common totalRegisterFuzzy(String keyWord);

    Register checkRegister(int courseNo ,int memberNo);

    Double getTotalBuyByMemberNo(int memberNo);
}
