package cn.buqixiaomi.demo.mapper;

import cn.buqixiaomi.demo.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogMapper {

    @Insert("insert into log (id, memo) values (#{id,jdbcType=BIGINT}, #{memo,jdbcType=VARCHAR})")
    int insert(Log record);

}