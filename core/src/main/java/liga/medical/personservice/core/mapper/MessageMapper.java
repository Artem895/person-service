package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MessageMapper {

    @Insert("insert into #{table_name} (message,patient,age) values (#{message},#{patient},#{age})")
    int insertMessage(Message message,@Param("table_name") String tablename);

    @Select("Select * from #{table_name}")
    List<Message>  getAll(@Param("table_name") String tablename);
}
