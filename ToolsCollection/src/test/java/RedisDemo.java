import redis.clients.jedis.Jedis;



public class RedisDemo {
    public static void main(String[] args) {
        // 创建一个Jedis对象，用于连接Redis服务器
        Jedis jedis = new Jedis("13.236.186.20", 6379);

        // 如果Redis服务器设置了密码，使用auth()方法进行身份验证
        jedis.auth("111111");

        // 使用set()方法将"name"键的值设置为"yxq"
        String val = jedis.set("name", "yxq");

        // 操作完成后关闭Jedis连接
        jedis.close();
    }
}
