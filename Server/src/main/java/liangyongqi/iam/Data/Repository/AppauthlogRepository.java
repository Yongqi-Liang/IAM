package liangyongqi.iam.Data.Repository;

import liangyongqi.iam.Data.Entity.Appauthlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppauthlogRepository extends JpaRepository<Appauthlog, String> {
    // 根据用户 ID 查询应用授权日志
    List<Appauthlog> findByUid(String uid);

    // 根据应用 ID 查询应用授权日志
    List<Appauthlog> findByAppid(String appid);

    // 根据用户 ID 和应用 ID 查询应用授权日志
    List<Appauthlog> findByUidAndAppid(String uid, String appid);

    // 根据日期查询应用授权日志（年月日）
    @Query("SELECT a FROM Appauthlog a WHERE DATE(a.authdatetime) = :date")
    List<Appauthlog> findByAuthDate(String date);
}
