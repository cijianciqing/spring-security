package cj.springboot.security.template.util.jwt;

import cj.springboot.security.template.security.CJUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.lang.Maps;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

public class CJJWTUtil {

    private static final String secretString = "7kDKwQVzgvLZyrTA6H3if6R14ROHPSHWAyHQoGECGYU";
    private static final SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

    /**
     * 生成jtw
     *
     * @param subject token中要存放的数据（json格式）
     * @return
     */
    public static String createJWT(String subject) {


        JwtBuilder builder = Jwts.builder()
//                定义使用的JSON序列化工具，对应有deserializeJsonWith
                .setSubject(subject)
                .signWith(key);

        return builder.compact();
    }

    /**
     * 解析
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String token) {

        JwtParser builder = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        return builder.parseClaimsJws(token).getBody();

    }

    public static void main(String[] args) {

        /*
        * 最终测试
        * */
        String subject = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2NjYifQ.fjR3tHaXNTA6rHZ6W2bCWnWQ8daCtYTp5US_F5YqkhI").getSubject();
        System.out.println(subject);


     /*   String u2 = Jwts.builder()
//                定义使用的JSON序列化工具，对应有deserializeJsonWith
                .setSubject("u2")
                .signWith(key).compact();
        System.out.println(u2);
*/
        /*
         * 获取一个复合要求的Key,并获取Key的String
         * 可以保存这个String,以后获取固定的Key
         * */
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);//获取一个满足要求的随机的Key
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println(secretString);


        /*
         * 通过String创建Key
         * */
//        String secretString ="cjkey";//长度不够
//        String secretString = "7kDKwQVzgvLZyrTA6H3if6R14ROHPSHWAyHQoGECGYU";
//        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));

        /*
         * 创建JWT
         * */
//        eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.cM8AYK0DRp8e2_UKpOCqpOGkNPvfnIR0gmOyXFNopwk
//        CJUser cjUser = new CJUser();
//        cjUser.setUsername("wqn");
//        cjUser.setId(222L);
//        cjUser.setEmail("4254@qq.com");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jws = Jwts.builder()
//                定义使用的JSON序列化工具，对应有deserializeJsonWith
//                .serializeToJsonWith(new JacksonSerializer(objectMapper))
//                .setSubject("Joe").claim("cjUser", cjUser)
//                .signWith(key)
//              .setExpiration()
//                .compact();

//        System.out.println(jws);



        /*
         * 将jwt解码
         * */
        //String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.cM8AYK0DRp8e2_UKpOCqpOGkNPvfnIR0gmOyXFNopwk";
//        JwtParserBuilder jwtParserBuilder = Jwts.parserBuilder();
//        jwtParserBuilder.setSigningKey(key);
////        jwtParserBuilder.deserializeJsonWith(new JacksonDeserializer(Maps.of("cjUser", CJUser.class).build()));
//
//        JwtParser build = jwtParserBuilder.build();
//
//
//        Jws<Claims> claimsJws = build.parseClaimsJws(jws);
//        String subject1 = claimsJws.getBody().getSubject();
//
//        CJUser cjUser1 = claimsJws.getBody().get("cjUser", CJUser.class);
//        System.out.println(subject1);
//        System.out.println(cjUser1.getClass());

    }


}
