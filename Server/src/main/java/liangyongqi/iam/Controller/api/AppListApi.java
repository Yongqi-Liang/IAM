package liangyongqi.iam.Controller.api;

import liangyongqi.iam.Ability.AppList;
import liangyongqi.iam.Util.LogTool;
import liangyongqi.iam.Util.PermissionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppListApi {
    @Autowired
    private AppList appList;
    @Autowired
    private PermissionManager permissionManager;
    /**
     * 获取应用列表
     * @return
     */
    @GetMapping("/api/appList")
    public ResponseEntity<Map<String, Object>> appList(@RequestParam String token) {
        LogTool.writelog("liangyongqi.iam.Controller.api.AppListApi.appList", "appList", "/api/appList");
        Map<String, Object> responseMap = new HashMap<>();
        try {
            // 先验证管理员token
            String tokenAuthResult = permissionManager.checkAdminPermission(token);
            if (tokenAuthResult != "0"){
                responseMap.put("code", "failed");
                responseMap.put("message", "管理员权限验证失败:" + tokenAuthResult);
                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put("code", "success");
                responseMap.put("message", "应用列表获取成功");
                responseMap.put("data", appList.getAppList());
            }
        } catch (Exception e) {
            responseMap.put("code", "failed");
            responseMap.put("message", "应用列表获取失败:" + e.getMessage());
            return ResponseEntity.ok(responseMap);
        }
        return ResponseEntity.ok(appList.getAppList());
    }

}
