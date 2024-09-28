package flab.project.domain.feed;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FanOutMessage {

    private long userId;
    private long postId;
}
