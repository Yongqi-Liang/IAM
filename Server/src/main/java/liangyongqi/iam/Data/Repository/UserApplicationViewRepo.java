package liangyongqi.iam.Data.Repository;

import liangyongqi.iam.Data.Entity.UserApplicationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserApplicationViewRepo extends JpaRepository<UserApplicationView, String> {

    /**
     * 根据用户ID和应用ID查询用户应用视图
     *
     * @param userId 用户ID
     * @param applicationId 应用ID
     * @return 包含用户应用视图的Optional对象
     */
    Optional<UserApplicationView> findByUserIdAndApplicationId(String userId, String applicationId);
}