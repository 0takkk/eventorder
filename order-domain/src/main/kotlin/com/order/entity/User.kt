package com.order.entity

import com.order.vo.Nickname
import com.order.vo.UserId
import java.time.LocalDateTime

data class User(
    val id: UserId,
    val nickname: Nickname,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
