package liangyongqi.iam.pojo.RequestBody;

public class ActiveUserRequest {
    private String token;

    private String id;
    private String code;

    public String getAdminToken() {
        return token;
    }

    public void setAdminToken(String adminToken) {
        this.token = adminToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
