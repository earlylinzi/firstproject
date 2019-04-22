package myannotations;


@TypeAnno  // 作用在类上的注解
public class AnnoBean {


    @FiledAnnoName("嘿嘿")
    String name = "Lucy";
    @FiledAnnoAge(age = 12)
    int age = 20;

    //value可不需要写成key=value的样式,直接写value,但是必须是value的属性.
    @MethodAnno(setAnnoName = @FiledAnnoName("方法"), setAnnoAge = @FiledAnnoAge(age = 18))
    public void testAnno() {

    }


}
