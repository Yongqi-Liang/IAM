package liangyongqi.iam.Controller.api;

import liangyongqi.iam.Ability.AppauthlogList;
import liangyongqi.iam.Util.PermissionManager;
import liangyongqi.iam.pojo.RequestBody.AppauthlogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class AppauthlogListApi {
    @Autowired
    private AppauthlogList appauthlogList;
    @Autowired
    private PermissionManager permissionManager;

    /**
     * 获取应用授权日志列表
     *
     * @param appauthlogRequest 应用授权日志请求
     * @return 应用授权日志列表
     */
    @PostMapping("/api/appauthlog/list")
    public ResponseEntity<Map<String, Object>> getAppauthlogList(@RequestBody AppauthlogRequest appauthlogRequest) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Map<String, Object> data = new HashMap<>();
            // 先验证管理员token
            String tokenAuthResult = permissionManager.checkAdminPermission(appauthlogRequest.getToken());
            String uid = appauthlogRequest.getUid();
            String appid = appauthlogRequest.getAppid();
            String authdatetime = appauthlogRequest.getAuthdatetime();
            if (tokenAuthResult != "0"){
                responseMap.put("code", "failed");
                responseMap.put("message", "管理员权限验证失败:" + tokenAuthResult);
                return ResponseEntity.ok(responseMap);
            }
            if (!uid.isEmpty() && !appid.isEmpty() && authdatetime.isEmpty()) {
                // 根据用户 ID 和应用 ID 获取应用授权日志列表
                data = appauthlogList.getAppauthlogListByUidAndAppid(uid, appid);
            } else if (!uid.isEmpty() && appid.isEmpty() && authdatetime.isEmpty()) {
                // 根据用户 ID 获取应用授权日志列表
                data = appauthlogList.getAppauthlogListByUid(uid);
            } else if (uid.isEmpty() && !appid.isEmpty() && authdatetime.isEmpty()) {
                // 根据应用 ID 获取应用授权日志列表
                data = appauthlogList.getAppauthlogListByAppid(appid);
            } else if (uid.isEmpty() && appid.isEmpty() && !authdatetime.isEmpty()) {
                // 根据授权时间获取应用授权日志列表
                data = appauthlogList.getAppauthlogListByDate(authdatetime);
            } else if (uid.isEmpty() && appid.isEmpty() && authdatetime.isEmpty()) {
                // 获取所有应用授权日志列表
                data = appauthlogList.getAppauthlogList();
            }
            responseMap.put("code", "success");
            responseMap.put("message", "获取应用授权日志列表成功");
            responseMap.put("data", data);
        } catch (Exception e) {
            responseMap.put("code", "error");
            responseMap.put("message", "获取应用授权日志列表失败");
        }
        // 使用 ResponseEntity 包装返回值
        return ResponseEntity.ok(responseMap);
    }
}
