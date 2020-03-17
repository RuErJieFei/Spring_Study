package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName PostDaoImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/3/17 3:24 下午
 * @Version 1.0
 **/
@Repository
public class PostDaoImpl implements PostDao {
    private final JdbcTemplate jdbcTemplate;

    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_Post VALUES (NULL,?,?,?,?,?)";
        Object[] args = {post.getForumId(), post.getTitle(), post.getContent(), post.getThumbnail(), Timestamp.valueOf(post.getPostTime())};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_Post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postList.get(i).getForumId());
                preparedStatement.setString(2, postList.get(i).getTitle());
                preparedStatement.setString(3, postList.get(i).getContent());
                preparedStatement.setString(4, postList.get(i).getThumbnail());
                preparedStatement.setTimestamp(5, Timestamp.valueOf(postList.get(i).getPostTime()));
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int PostId) {
        String sql = "DELETE FROM t_Post WHERE post_id = ?";
        Object[] args = {PostId};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(Post post) {
        String sql = "UPDATE t_post SET forum_id = ? , title = ? , content = ? , thumbnail = ? , post_time = ? WHERE post_id = ?";
        Object[] args = {post.getForumId(),post.getTitle(), post.getContent(), post.getThumbnail(), post.getPostTime(), post.getPostId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> selectAll() {
        String sql = "SELECT * FROM t_post";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }
}
