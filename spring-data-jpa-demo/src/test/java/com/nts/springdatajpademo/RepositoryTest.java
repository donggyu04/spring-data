package com.nts.springdatajpademo;

import com.nts.springdatajpademo.entity.ChildrenEntity;
import com.nts.springdatajpademo.entity.NotEntity;
import com.nts.springdatajpademo.entity.TestEntity;
import com.nts.springdatajpademo.repository.ChildrenEntityRepository;
import com.nts.springdatajpademo.repository.CreateFailCaseRepository;
import com.nts.springdatajpademo.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    TestRepository testRepository;

    @Autowired
    ChildrenEntityRepository childrenEntityRepository;

    @Test
    public void repositoryCreationTest() {
        System.out.println("---------------------------------Test start--------------------------------------------");
        TestEntity testEntity = TestEntity.builder().text("테스트").build();
        System.out.println(testEntity.getId());
        testRepository.save(testEntity);
        System.out.println(testEntity.getId());
        System.out.println("---------------------------------Test end--------------------------------------------");
    }

    @Test
    public void repositoryCreationTest2() {
        System.out.println("---------------------------------Test start--------------------------------------------");
        ChildrenEntity childrenEntity = new ChildrenEntity();
        System.out.println(childrenEntity.getId());
        System.out.println(childrenEntity.isNew());
        childrenEntityRepository.save(childrenEntity);
        System.out.println(childrenEntity.getId());
        System.out.println(childrenEntity.isNew());
        System.out.println("---------------------------------Test end--------------------------------------------");
    }


//    //BootstrapMode 변경 후 주석제거

//    @Autowired
//    CreateFailCaseRepository createFailCaseRepository;
//
//    @Test
//    public void repositoryCreationFail() {
//        System.out.println("---------------------------------Test start--------------------------------------------");
//        NotEntity notEntity = new NotEntity();
//        createFailCaseRepository.save(notEntity);
//        System.out.println("---------------------------------Test end--------------------------------------------");
//    }

}
