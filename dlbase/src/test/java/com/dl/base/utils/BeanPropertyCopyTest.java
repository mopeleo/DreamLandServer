package com.dl.base.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BeanPropertyCopyTest {
    UserDTO dto = new UserDTO();
    UserEntity user2 = new UserEntity();
    UserEntity user1;

    @Before
    public void before() {
        dto.setAction("login");
        dto.setUsername("leo");
        dto.setAge(23);
        
        user2.setUsername("test");
        user2.setAge(26);
    }
    
    @Test
    public void convert(){
        System.out.println("test convert begin : ");
        user1 = BeanPropertyCopy.convert(dto, UserEntity.class);
        System.out.println(user1);
        System.out.println("test convert end !");
    }
    
    @Test
    public void copy(){
        System.out.println("test copy begin : ");
        BeanPropertyCopy.copy(dto, user2);
        System.out.println(user2);
        System.out.println("test copy end !");
    }
    
    @Test
    public void convertList(){
        System.out.println("test convertList begin : ");
        List<UserEntity> entityList = new ArrayList<UserEntity>();
        entityList.add(user2);
        entityList.add(user2);
        List<UserDTO> dtoList = BeanPropertyCopy.convertList(entityList,UserDTO.class);
        for(UserDTO d : dtoList){
            System.out.println(d);
        }
        System.out.println("test convertList end !");
    }
}
