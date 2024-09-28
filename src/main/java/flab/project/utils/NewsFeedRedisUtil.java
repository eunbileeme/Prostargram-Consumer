package flab.project.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NewsFeedRedisUtil {

    private final RedisTemplate<Long, Long> newsFeedRedisTemplate;

    public void addForMultipleUsers(List<Long> userIds, long postId) {
        newsFeedRedisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (long userId : userIds) {
                newsFeedRedisTemplate.opsForList().leftPush(userId, postId);
            }
            return null;
        });
    }
}