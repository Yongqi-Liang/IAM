package liangyongqi.iam.Ability;

import liangyongqi.iam.Data.Entity.Appauthlog;
import liangyongqi.iam.Data.Repository.AppauthlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppauthlogList {
    @Autowired
    private AppauthlogRepository appauthlogRepository;
    /**
     * 获取应用授权日志列表
     * @return 应用授权日志列表
     * 格式；{id: {appid: xxx, userid: xxx, auth_time: xxx}}
     */
    public Map<String, Object> getAppauthlogList() {
        // 获取所有应用授权日志数据
        List<Appauthlog> appauthlogs = appauthlogRepository.findAll();
        // 创建结果 Map
        Map<String, Object> result = new HashMap<>();
        // 遍历应用授权日志列表，组织数据
        for (Appauthlog appauthlog : appauthlogs) {
            Map<String, Object> appauthlogInfo = new HashMap<>();
            appauthlogInfo.put("appid", appauthlog.getAppid());
            appauthlogInfo.put("userid", appauthlog.getUid());
            appauthlogInfo.put("auth_time", appauthlog.getAuthdatetime());
            result.put(appauthlog.getId().toString(), appauthlogInfo);
        }
        return result;
    }
    /**
     * 根据用户 ID 获取应用授权日志列表
     * @param uid 用户 ID
     * @return 应用授权日志列表
     * 格式；{id: {appid: xxx, userid: xxx, auth_time: xxx}}
     */
    public Map<String, Object> getAppauthlogListByUid(String uid) {
        // 获取所有应用授权日志数据
        List<Appauthlog> appauthlogs = appauthlogRepository.findByUid(uid);
        // 创建结果 Map
        Map<String, Object> result = new HashMap<>();
        // 遍历应用授权日志列表，组织数据
        for (Appauthlog appauthlog : appauthlogs) {
            Map<String, Object> appauthlogInfo = new HashMap<>();
            appauthlogInfo.put("appid", appauthlog.getAppid());
            appauthlogInfo.put("userid", appauthlog.getUid());
            appauthlogInfo.put("auth_time", appauthlog.getAuthdatetime());
            result.put(appauthlog.getId().toString(), appauthlogInfo);
        }
        return result;
    }

    /**
     * 根据应用 ID 获取应用授权日志列表
     * @param appid 应用 ID
     * @return 应用授权日志列表
     * 格式；{id: {appid: xxx, userid: xxx, auth_time: xxx}}
     */
    public Map<String, Object> getAppauthlogListByAppid(String appid) {
        // 获取所有应用授权日志数据
        List<Appauthlog> appauthlogs = appauthlogRepository.findByAppid(appid);
        // 创建结果 Map
        Map<String, Object> result = new HashMap<>();
        // 遍历应用授权日志列表，组织数据
        for (Appauthlog appauthlog : appauthlogs) {
            Map<String, Object> appauthlogInfo = new HashMap<>();
            appauthlogInfo.put("appid", appauthlog.getAppid());
            appauthlogInfo.put("userid", appauthlog.getUid());
            appauthlogInfo.put("auth_time", appauthlog.getAuthdatetime());
            result.put(appauthlog.getId().toString(), appauthlogInfo);
        }
        return result;
    }

    /**
     * 根据用户 ID 和应用 ID 获取应用授权日志列表
     * @param uid 用户 ID
     * @param appid 应用 ID
     * @return 应用授权日志列表
     * 格式；{id: {appid: xxx, userid: xxx, auth_time: xxx}}
     */
    public Map<String, Object> getAppauthlogListByUidAndAppid(String uid, String appid) {
        // 获取所有应用授权日志数据
        List<Appauthlog> appauthlogs = appauthlogRepository.findByUidAndAppid(uid, appid);
        // 创建结果 Map
        Map<String, Object> result = new HashMap<>();
        // 遍历应用授权日志列表，组织数据
        for (Appauthlog appauthlog : appauthlogs) {
            Map<String, Object> appauthlogInfo = new HashMap<>();
            appauthlogInfo.put("appid", appauthlog.getAppid());
            appauthlogInfo.put("userid", appauthlog.getUid());
            appauthlogInfo.put("auth_time", appauthlog.getAuthdatetime());
            result.put(appauthlog.getId().toString(), appauthlogInfo);
        }
        return result;
    }

    /**
     * 根据指定日期获取应用授权日志列表
     * @param date 指定的日期（格式：yyyy-MM-dd）
     * @return 应用授权日志列表
     * 格式：{id: {appid: xxx, userid: xxx, auth_time: xxx}}
     */
    public Map<String, Object> getAppauthlogListByDate(String date) {
        // 获取指定日期的所有日志
        List<Appauthlog> appauthlogs = appauthlogRepository.findByAuthDate(date);
        // 创建结果 Map
        Map<String, Object> result = new HashMap<>();
        try {
            // 遍历应用授权日志列表，组织数据
            for (Appauthlog appauthlog : appauthlogs) {
                Map<String, Object> appauthlogInfo = new HashMap<>();
                appauthlogInfo.put("appid", appauthlog.getAppid());
                appauthlogInfo.put("userid", appauthlog.getUid());
                appauthlogInfo.put("auth_time", appauthlog.getAuthdatetime());
                result.put(appauthlog.getId().toString(), appauthlogInfo);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
