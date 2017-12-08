package com.dl.server.service.test.server;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dl.server.common.redis.RedisCache;
import com.dl.server.entity.server.ServerPlayerActor;
import com.google.gson.Gson;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/dlserver-app-redis-single.xml")
public class ServerPlayerActorRedisTest {
    
    /**
     * redis 读写测试
     */
    @Test
    public void testSpringRedis() {

        // String读写
        RedisCache.delete("myStr");
        RedisCache.getStringRedis().opsForValue().set("myStr", "http://yjmyzz.cnblogs.com/");
        System.out.println(RedisCache.getStringRedis().opsForValue().get("myStr"));
        System.out.println("---------------");

        // List读写
        RedisCache.getStringRedis().delete("myList");
        RedisCache.getStringRedis().opsForList().rightPush("myList", "A");
        RedisCache.getStringRedis().opsForList().rightPush("myList", "B");
        RedisCache.getStringRedis().opsForList().leftPush("myList", "0");
        List<String> listCache = RedisCache.getStringRedis().opsForList().range("myList", 0, -1);
        for (String s : listCache) {
            System.out.println(s);
        }
        System.out.println("---------------");

        // Set读写
        RedisCache.getStringRedis().delete("mySet");
        RedisCache.getStringRedis().opsForSet().add("mySet", "A");
        RedisCache.getStringRedis().opsForSet().add("mySet", "B");
        RedisCache.getStringRedis().opsForSet().add("mySet", "C");
        Set<String> setCache = RedisCache.getStringRedis().opsForSet().members("mySet");
        for (String s : setCache) {
            System.out.println(s);
        }
        System.out.println("---------------");

        // Hash读写
        RedisCache.getStringRedis().delete("myHash");
        RedisCache.getStringRedis().opsForHash().put("myHash", "PEK", "北京");
        RedisCache.getStringRedis().opsForHash().put("myHash", "SHA", "上海虹桥");
        RedisCache.getStringRedis().opsForHash().put("myHash", "PVG", "浦东");
        Map<Object, Object> hashCache = RedisCache.getStringRedis().opsForHash().entries("myHash");
        for (Map.Entry<Object, Object> entry : hashCache.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("---------------");
    }

    /**
     * redis 得到所有的master and slave 信息
     */
//    @Test
    public void testGetAllMasterAndSlave() {

        RedisSentinelConnection conn = RedisCache.getStringRedis().getConnectionFactory()
            .getSentinelConnection();

        for (RedisServer master : conn.masters()) {
            System.out.println("master => " + master);// 打印master信息
            Collection<RedisServer> slaves = conn.slaves(master);
            // 打印该master下的所有slave信息
            for (RedisServer slave : slaves) {
                System.out.println("slaves of " + master + " => " + slave);
            }
            System.out.println("--------------");
        }
    }

    /*
     * 测试redis 缓存object 和 list 类型数据(方案：用json将object和list序列化)
     */
    @Test
    public void testRedisCacheObjectAndList() {

        ServerPlayerActor user1 = new ServerPlayerActor();
        user1.setActorid("a001");
        user1.setPlayerid("p001");
        RedisCache.delete(user1.getEntityKey());
        // 将object 用 json 序列化后保存redis
        Gson gson = new Gson();
        RedisCache.cache(user1);

        user1 = RedisCache.get(user1.getEntityKey(), ServerPlayerActor.class);
        System.out.println("-----------------------" + gson.toJson(user1));
    }

    /**测试redis集群方案*/
//    @Test
    public void testCluster(){

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        //Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.12.90", 7001));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");

        System.out.println(value);
        try {
            jc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
