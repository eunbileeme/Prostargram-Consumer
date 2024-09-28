package flab.project.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowerRedisUtil {

    private final RedisTemplate<Long, Long> followRedisTemplate;

    public List<Long> getFollowerIds(Long key) {
        ListOperations<Long, Long> listOperations = followRedisTemplate.opsForList();
        Long size = listOperations.size(key);
        // todo: size 테스트.
        return listOperations.leftPop(key, size);
    }
}