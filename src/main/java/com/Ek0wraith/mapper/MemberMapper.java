package com.Ek0wraith.mapper;


import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * ClassName: MemberMapper
 * Package: com.Ek0wraith.mapper
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:50
 * @Version 1.0
 */
@Mapper
@Repository
public interface MemberMapper {
    List<Member> getAllMember(int page, int size);

    /*不分页*/
    List<Member> getAllMemberNoPage();

    int saveMemberBatch(@Param("list") List<Member> list);

    int addMember(Member member);

    int deleteMember(int memberNo);

    int updateMember(Member member);

    int updateMemberByMemberNo(Member member);

    Common totalMember();

    List<Member> getByKeywordMember(String keyWord,int page,int size);

    Common totalMemberFuzzy(String keyWord);

    Member getMemberPassword(String memberPhone,String memberPassword);

    Member getMemberByMemberNo(int memberNo);

    double getMemberIntegral(int memberNo);

    double getMemberChange(int memberNo);

    Double getTotalMoney(int memberNo);

    int updateMemberChange(int memberNo,double totalBuy);

    int updateMemberIntegral(double price,int memberNo);

    int updateMemberPassword(String memberPhone,String memberPassword);

    int updateMemberPower(int memberPower ,int memberNo);

    int getMemberPower(int memberNo);

    int updateMemberChangeByMemberNo(int memberNo,double coursePrice);


    Integer getMemberBySeason(Date startTime, Date endTime);

    Integer getSexByYear(String sex, Integer year);

    Member getMemberByPhone(String memberPhone);
}
