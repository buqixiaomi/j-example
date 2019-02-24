package cn.buqixiaomi.demo.mapper;

/**
 * description
 *
 * @author lishengkai
 * @date 2019-01-14 12:15
 */
public interface BaseMapper<T> {
    //如果子类重写了该方法，则该方法为桥接方法，在mybatis 中是不会解析的
    int insert(T t);
}
