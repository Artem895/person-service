package liga.medical.personservice.core.mapping;

import liga.medical.personservice.core.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("insert into daily_message (message,patient,helthstatus) values (#{message},#{patient},#{helthstatus})")
    int insertMessageDaily(@Param("message") String mes,@Param("patient") int idP,@Param("helthstatus") String h);

    @Insert("insert into allert_message (message,patient,helthstatus) values (#{message},#{patient},#{helthstatus})")
    int insertMessageAlert(@Param("message") String mes,@Param("patient") int idP,@Param("helthstatus") String h);

    @Insert("insert into error_message (message,patient,helthstatus) values (#{message},#{patient},#{helthstatus})")
    int insertMessageError(@Param("message") String mes,@Param("patient") int idP,@Param("helthstatus") String h);

    @Select("Select * from #{table_name}")
    List<Message>  getAll(@Param("table_name") String tablename);
}
