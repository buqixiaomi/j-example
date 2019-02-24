package cn.buqixiaomi.demo.jdk8.jvm;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-09-11 16:17
 */
public class JvmDemo {

    public static void main(String[] args) {

        /**
         * 无限加载类，验证空间情况
         * -Xmx10m -Xms10m -XX:-UseGCOverheadLimit -XX:MetaspaceSize=5m -XX:MaxMetaspaceSize=5m
         * 堆内存无限增大，matespace 保持不变，
         * 说明，类型信息只会加载一次
         */
        try{
            //准备url
            URL url = ClassLoader.getSystemResource("");
            URL[] urls = {url};
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while(true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("jvm.TargetBean");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total: "+ loadingBean.getTotalLoadedClassCount());
                System.out.println("active: "+ loadingBean.getLoadedClassCount());
                System.out.println("unloaded: "+ loadingBean.getUnloadedClassCount());
                Thread.sleep(2);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
