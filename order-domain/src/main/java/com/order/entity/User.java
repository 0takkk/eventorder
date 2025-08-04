package com.order.entity;

import com.order.vo.Nickname;
import com.order.vo.UserId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private UserId id;

    private Nickname nickname;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
