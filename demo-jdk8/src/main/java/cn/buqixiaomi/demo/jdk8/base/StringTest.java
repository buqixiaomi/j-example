package cn.buqixiaomi.demo.jdk8.base;

/**
 * description
 *
 * @author lishengkai
 * @date 2018-07-19 15:33
 */
public class StringTest {

    private String ss ;

    private Integer ssd;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }


    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringTest that = (StringTest) o;

        if (ss != null ? !ss.equals(that.ss) : that.ss != null) return false;
        return ssd != null ? ssd.equals(that.ssd) : that.ssd == null;
    }

    @Override
    public int hashCode() {
        int result = ss != null ? ss.hashCode() : 0;
        result = 31 * result + (ssd != null ? ssd.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
//        String a = "a";
//        String b = new String("a");
//        String c = "a";
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());
//        System.out.println(c.hashCode());
//        System.out.println(a==b);
        StringTest t = new StringTest();
//        int y = t.aaa();
        System.out.println(t.aaa());

    }

    @Override
    public String toString() {
        return "StringTest{" +
                "ss='" + ss + '\'' +
                ", ssd=" + ssd +
                '}';
    }

    public StringTest aaa() {
        StringTest t = new StringTest();
        t.setSs("sdfsdf");

        try {
            return t;
        } catch (Exception e) {

        } finally {
            t.setSs("etetet");;
        }
        return t;
    }


}
