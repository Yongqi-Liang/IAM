package liangyongqi.iam.Data.Repository;

import liangyongqi.iam.Data.Entity.UserGroupApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupApplicationRepository extends JpaRepository<UserGroupApplication, String> {

    /**
     * 根据应用 ID 查询关联的用户组应用记录
     *
     * @param applicationId 应用的唯一标识
     * @return 与该应用关联的用户组应用记录列表
     */
    List<UserGroupApplication> findByApplicationId(String applicationId);
}
