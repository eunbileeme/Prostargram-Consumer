package flab.project.domain.follow;

import java.util.List;

import flab.project.utils.FollowerRedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowMapper followMapper;
    private final FollowerRedisUtil followerRedisUtil;

    public List<Long> getFollowerIds(Long userId) {
        List<Long> followerIds = followerRedisUtil.getFollowerIds(userId);
        if (followerIds.isEmpty()) {
            followerIds = followMapper.findAllFollowerIds(userId);
        }

        return followerIds;
    }
}