package liangyongqi.iam.Controller.api;

import liangyongqi.iam.Ability.DeleteApp;
import liangyongqi.iam.Util.LogTool;
import liangyongqi.iam.pojo.RequestBody.DeleteAppRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeleteAppApi {

    @Autowired
    private DeleteApp deleteApp;
    /**
     * 删除应用
     * @param deleteAppRequest
     * @return
     */
    @PostMapping("/api/deleteApp")
    public ResponseEntity<Map<String, Object>> deleteApp(@RequestBody DeleteAppRequest deleteAppRequest) {
        LogTool.writelog("liangyongqi.iam.Controller.api.DeleteAppApi", "deleteApp", "/api/deleteApp");
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Boolean value = deleteApp.deleteApp(deleteAppRequest.getId());
            if (value) {
                responseMap.put("status", "success");
                responseMap.put("message", "App删除成功");
                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put("status", "failed");
                responseMap.put("message", "App删除失败");
                return ResponseEntity.ok(responseMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("status", "error");
            responseMap.put("message", "App删除错误");
            return ResponseEntity.ok(responseMap);
        }
    }
}
