package flab.project.domain.follow;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FollowMapper {

    List<Long> findAllFollowerIds(@Param("userId") Long userId);
}