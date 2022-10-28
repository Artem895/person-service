package liga.medical.personservice.core.mapping;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonMapper {
    @Update("update patients set status=#{helth_status} where p_id=#{id}")
    void setpersonhelthstatus(@Param("id") int id,@Param("helth_status") String hs);
}
