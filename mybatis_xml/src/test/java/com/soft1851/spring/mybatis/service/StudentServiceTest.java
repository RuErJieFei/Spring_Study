package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentServiceTest {
    @Resource
    private StudentService studentService;

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000, 04, 28))
                .build();
        studentService.insert(student);
        System.out.println(student.getClazzId());
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(3000 + i)
                    .studentName("测试数据")
                    .clazzId(3)
                    .hometown("LA")
                    .birthday(LocalDate.of(2000, 01, 01)).build();
            students.add(student);
        }
        studentService.batchInsert(students);
    }

    @Test
    public void delete() {
        studentService.delete(2010);
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>(3);
        idList.add(3007);
        idList.add(3008);
        idList.add(3009);
        studentService.batchDelete(idList);
    }

    @Test
    public void update() {
        Student student = Student.builder().studentId(2010).studentName("新同学").build();
        studentService.update(student);
    }

    @Test
    public void batchUpdate() {
        List<Student> students = new ArrayList<>();
        students.add(Student.builder().studentId(3004).studentName("新改的名字").build());
        students.add(Student.builder().studentId(3005).studentName("新改的名字").build());
        students.add(Student.builder().studentId(3006).studentName("新改的名字").build());
        studentService.batchUpdate(students);
    }

    @Test
    public void selectLimit() {
        studentService.selectLimit().forEach(System.out::println);
    }

    @Test
    public void selectLimitByDynamicSql() {
        Student student = Student.builder().hometown("江苏").build();
        studentService.selectLimitByDynamicSql(student).forEach(System.out::println);
    }

    @Test
    public void selectLimitFromTeacherInClassByDynamicSql() {
        MatterDto matterDto = MatterDto.builder().teacherName("许老师").
                clazzName("软件1851").student(new Student("张")).build();
        studentService.selectLimitFromTeacherInClassByDynamicSql(matterDto)
                .forEach(System.out::println);
    }

    @Test
    public void selectAll() {
        studentMapper.selectAll().forEach(System.out::println);
    }

}