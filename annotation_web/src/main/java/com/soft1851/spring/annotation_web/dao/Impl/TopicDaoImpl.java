package com.soft1851.spring.annotation_web.dao.Impl;

import com.soft1851.spring.annotation_web.dao.TopicDao;
import com.soft1851.spring.annotation_web.entity.Topic;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName TopicDaoImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/26 9:33 上午
 * @Version 1.0
 **/
@Repository
public class TopicDaoImpl implements TopicDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Topic> selectAll() {
        String sql = "SELECT * FROM t_topic";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Topic.class));
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        final List<Topic> topicList = topics;
        String sql = "INSERT INTO t_topic VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, topicList.get(i).getId());
                preparedStatement.setString(2, topicList.get(i).getTopicName());
                preparedStatement.setString(3, topicList.get(i).getTopicIcon());
                preparedStatement.setString(4, topicList.get(i).getDescription());
                preparedStatement.setInt(5, topicList.get(i).getFollowsCount());
                preparedStatement.setInt(6, topicList.get(i).getMsgCount());
                preparedStatement.setInt(6, topicList.get(i).getMsgCount());
                preparedStatement.setBoolean(7, topicList.get(i).getFollowed());
            }

            @Override
            public int getBatchSize() {
                return topicList.size();
            }
        });
    }

    @Override
    public int insert(Topic topic) {
        String sql = "INSERT INTO t_topic VALUES (?,?,?,?,?,?,?)";
        Object[] params = {topic.getId(), topic.getTopicName(), topic.getTopicIcon(), topic.getDescription(),
                topic.getMsgCount(), topic.getFollowsCount(), topic.getFollowed()};
        return jdbcTemplate.update(sql, params);
    }
}
