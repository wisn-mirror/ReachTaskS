package com.wisn.dao;

import com.wisn.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
    Message queryMessageByMessageId(long messageid);

    List<Message> queryMessageByTargetId();

    List<Message> queryAllMessage(long targetid, @Param("offset") int offset, @Param("limit") int limit);

    int insertMessage(Message message);

    int updateMessage(Message message);

    int deleteMessageByMessageId(int messageid);

    int deleteMessageByTargetId(int targetid);
}
