package cn.buqixiaomi.demo.mapper;

import cn.buqixiaomi.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int insert(User record);
}