package com.example.movielist.mapper;

import com.example.movielist.models.Movie;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface MovieMapper{

    @Select("select * from movie")
    List<Movie> listAllMovie();

    @Select("select * from movie where id = #{id}")
    Movie findMovieById(@Param("id") Integer id);

    @Select("select * from movie where title = #{title}")
    List<Movie> findByName(@Param("name") String name);

    @Insert("insert into movie ( title, director, main_actor, tag, status ) values (#{title},#{director}, #{main_actor}, #{tag}, #{status})")
    int insert(@Param("title") String title, @Param("director") String director, @Param("main_actor") String mainActor, @Param("tag") String tag, @Param("status") Integer status);

    @Delete("delete from movie where id = #{id}")
    int delete(@Param("id") Integer id);

    @Update("update movie set status = #{status} where id = #{id}")
    int update(@Param("id") Integer id,@Param("status") Integer status);
}
