package com.Ek0wraith.service.impl;

import com.Ek0wraith.pojo.Common;
import com.Ek0wraith.pojo.Member;
import com.Ek0wraith.mapper.MemberMapper;
import com.Ek0wraith.mapper.RegisterMapper;
import com.Ek0wraith.service.MemberService;
import com.Ek0wraith.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * ClassName: MemberServiceImpl
 * Package: com.Ek0wraith.service.impl
 * Description：TODO
 *
 * @Author Ek0wraith
 * @Create 2024/6/13 17:49
 * @Version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<Member> getMemberMapper(int page, int size) {
        return memberMapper.getAllMember(page,size);
    }

    @Override
    public List<Member> getAllMemberNoPage() {
        return memberMapper.getAllMemberNoPage();
    }

    @Override
    public Map<String, Object> saveMemberBatch(List<Member> list) {
        Map<String, Object> resultMap = new HashMap<>();
        int result = memberMapper.saveMemberBatch(list);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "导入成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "导入失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> addMember(Member member) {
        Map<String, Object> resultMap = new HashMap<>();


        /*随机生成用户名*/
        int Username = java.util.UUID.randomUUID().toString().hashCode();
        if (Username < 0) {
            Username = -Username;
        }
        // 0 代表前面补充0
        // 10 代表长度为10
        // d 代表参数为正数型
        String format = String.format("%010d", Username).substring(0, 10);
        member.setMemberUsername(format);

        /*默认密码*/
        member.setMemberPassword("123456");
        member.setCardTime(LocalDateTime.now());

        /*新增用户时将购买时间=剩余时间*/
        member.setCardNextClass(member.getCardClass());

        int result = memberMapper.addMember(member);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "创建成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "创建失败");
        }

        return resultMap;
    }

    @Override
    public Map<String, Object> deleteMember(int memberNo) {
        Map<String, Object> resultMap = new HashMap<>();
        int result = memberMapper.deleteMember(memberNo);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "删除成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "删除失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateMember(Member member) {
        Map<String, Object> resultMap = new HashMap<>();

        int result = memberMapper.updateMember(member);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "修改成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "修改失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateMemberByMemberNo(Member member) {
        Map<String, Object> resultMap = new HashMap<>();

        int result = memberMapper.updateMemberByMemberNo(member);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "修改成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "修改失败");
        }
        return resultMap;
    }

    @Override
    public Common totalMember() {
        return memberMapper.totalMember();
    }

    @Override
    public List<Member> getByKeywordMember(String keyWord, int page, int size) {
        return memberMapper.getByKeywordMember(keyWord, page, size);
    }

    @Override
    public Common totalMemberFuzzy(String keyWord) {
        return memberMapper.totalMemberFuzzy(keyWord);
    }

    @Override
    public Map<String, Object> getMemberPassword(String memberPhone, String memberPassword) {
        Map<String, Object> resultMap = new HashMap<>();
        Member result = memberMapper.getMemberPassword(memberPhone, memberPassword);

        if (result != null) {
            result.setToken(JwtUtil.createTokenToMember());
            resultMap.put("token", result.getToken());
            resultMap.put("memberUsername", result.getMemberUsername());
            resultMap.put("memberNo", result.getMemberNo());
            resultMap.put("memberPhone", result.getMemberPhone());
            resultMap.put("code", 200);
            resultMap.put("message", "登录成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "登录失败");
        }
        return resultMap;
    }

    @Override
    public Member getMemberByMemberNo(int memberNo) {
        return memberMapper.getMemberByMemberNo(memberNo);
    }

    @Override
    public double getMemberIntegral(int memberNo) {
        return memberMapper.getMemberIntegral(memberNo);
    }

    @Override
    public double getMemberPower(int memberNo) {
        return memberMapper.getMemberPower(memberNo);
    }

    @Override
    public Double getMemberChange(int memberNo) {
        return memberMapper.getMemberChange(memberNo);
    }

    @Override
    public Double getTotalMoney(int memberNo) {
        Double totalMoney = memberMapper.getTotalMoney(memberNo);
        if (totalMoney == null) {
            totalMoney = (double) 0;
        }
        return totalMoney;
    }

    @Override
    public int updateMemberChange(int memberNo) {
        //获取购物总额
        Double totalBuy = registerMapper.getTotalBuyByMemberNo(memberNo);
        if (totalBuy == null) {
            totalBuy = Double.valueOf(0);
        }
        return memberMapper.updateMemberChange(memberNo, totalBuy);
    }

    @Override
    public Map<String, Object> updateMemberChangeByMemberNo(int memberNo, double coursePrice) {
        Map<String, Object> resultMap = new HashMap<>();
        if (memberMapper.updateMemberChangeByMemberNo(memberNo, coursePrice) > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "余额不足");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateMemberIntegral(double price, int memberNo) {
        Map<String, Object> resultMap = new HashMap<>();
        if (memberMapper.updateMemberIntegral(price, memberNo) > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "积分不足");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateMemberPassword(String memberPhone, String memberPassword) {
        Map<String, Object> resultMap = new HashMap<>();

        int result = memberMapper.updateMemberPassword(memberPhone, memberPassword);

        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "密码修改成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "密码修改失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> updateMemberPower(int memberPower, int memberNo) {
        Map<String, Object> resultMap = new HashMap<>();
        int result = memberMapper.updateMemberPower(memberPower, memberNo);
        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "兑换成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "兑换失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getMemberBySeason(Integer year) {
        // 判空
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        Map<String, Object> resultMap = new HashMap<>();
        ArrayList<String> season = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        int currentYear = year;

        String[] quarterNames = {"一季度", "二季度", "三季度", "四季度"};
        for (int i = 1; i <= 4; i++) {
            int startMonth = (i - 1) * 3 + 1; // 计算季度起始月份
            int endMonth = Math.min(startMonth + 2, 12); // 防止结束月份超出12月

            // 开始时间
            LocalDateTime s = LocalDateTime.of(currentYear, startMonth, 1, 0, 0, 0);
            Date startTime = Date.from(s.atZone(ZoneId.systemDefault()).toInstant());

            // 结束时间
            LocalDateTime e;
            if (i == 4 && endMonth == 12) { // 如果是最后一个季度且结束月份为12月，结束时间为本年度最后一天
                e = LocalDateTime.of(currentYear, 12, 31, 23, 59, 59);
            } else { // 否则，为下一季度开始前一日
                e = LocalDateTime.of(currentYear, endMonth + 1, 1, 0, 0, 0).minusDays(1);
            }
            Date endTime = Date.from(e.atZone(ZoneId.systemDefault()).toInstant());

            Integer memberBySeason = memberMapper.getMemberBySeason(startTime, endTime);
            season.add(quarterNames[i - 1]);
            count.add(memberBySeason);
        }
        resultMap.put("season", season);
        resultMap.put("count", count);
        resultMap.put("code", 200);
        resultMap.put("message", "成功");
        return resultMap;
    }

    @Override
    public Map<String, Object> getMemberSexByYear(Integer year) {
        // 判空
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String,Object>> sexCount = new ArrayList<>();
        Map<String, Object> mMap = new HashMap<>();
        // 获取该年男性人数
        Integer m = memberMapper.getSexByYear("M",year);
        mMap.put("value", m);
        mMap.put("name", "男");
        sexCount.add(mMap);
        // 获取该年女性人数
        Map<String, Object> fMap = new HashMap<>();
        Integer f = memberMapper.getSexByYear("F",year);
        fMap.put("value", f);
        fMap.put("name", "女");
        sexCount.add(fMap);
        resultMap.put("sexCount", sexCount);
        resultMap.put("code", 200);
        resultMap.put("message", "成功");
        return resultMap;
    }

    @Override
    public Map<String, Object> register(Member member) {
        Map<String, Object> resultMap = new HashMap<>();
        // 判断手机号是否已经注册
        Member memberByPhone = memberMapper.getMemberByPhone(member.getMemberPhone());
        if (memberByPhone != null) {
            resultMap.put("code", 400);
            resultMap.put("message", "手机号已注册");
            return resultMap;
        }
        // 随机生成用户名
        int Username = java.util.UUID.randomUUID().toString().hashCode();
        if (Username < 0) {
            Username = -Username;
        }
        // 0 代表前面补充0
        // 10 代表长度为10
        // d 代表参数为正数型
        String format = String.format("%010d", Username).substring(0, 10);
        member.setMemberUsername(format);
        // 默认密码
        if (member.getMemberPassword() == null || "".equals(member.getMemberPassword())) {
            member.setMemberPassword("123456");
        };
        member.setCardTime(LocalDateTime.now());
        // 新增用户时将购买时间=剩余时间
        member.setCardNextClass(member.getCardClass());
        member.setMemberIntegral(0);
        member.setMemberChange(0);
        int result = memberMapper.addMember(member);
        if (result > 0) {
            resultMap.put("code", 200);
            resultMap.put("message", "注册成功");
        } else {
            resultMap.put("code", 400);
            resultMap.put("message", "注册失败");
        }
        return resultMap;
    }
}
